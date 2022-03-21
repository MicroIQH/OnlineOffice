package com.yeb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.controller.MailLogController;
import com.yeb.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MicroShan
 * @since 2022-03-05
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据用户ID查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取相关列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
