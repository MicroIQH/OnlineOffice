package com.yeb.config;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yeb.pojo.MailConstants;
import com.yeb.pojo.MailLog;
import com.yeb.service.IMailLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 * @author 旋木頵頵
 * @date 2021/10/26 14:38
 * @email 1020626977@qq.com
 */
@Configuration
public class RabbitMqConfig {

    public static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqConfig.class);

    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;
    @Autowired
    private IMailLogService mailLogService;
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        /**
         *  消息确认回调，确认消息是否到达broker
         *  @param data: 消息唯一标识;
         *  @param ack: 确认结果;
         *  @param cause: 失败原因
         *
         */
        rabbitTemplate.setConfirmCallback((data,ack,cause)->{
            String msgId = data.getId();
            if (ack){
                LOGGER.info("{}===========>消息发送成功!",msgId);
                mailLogService.update(new UpdateWrapper<MailLog>().set("status",1).eq("msgId",msgId));
            }else {
                LOGGER.error("{}===========>消息发送失败!",msgId);
            }
        });

        /**
         * 消息失败回调，比如router不到queue时回调
         * msg:消息主题
         * repCode:响应码
         * repText:响应描述
         * exchange:交换机
         * routingKey:路由键
         */
        rabbitTemplate.setReturnCallback((msg,repCode,repText,exchange,routingKey)->{
            LOGGER.error("{}===========>消息发送至queue时失败!",msg.getBody());
        });
        return rabbitTemplate;
    }


    @Bean
    public Queue queue() {
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(MailConstants.MAIL_EXCHANGE_NAME);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(MailConstants.MAIL_ROUTING_KEY_NAME);
    }
}

