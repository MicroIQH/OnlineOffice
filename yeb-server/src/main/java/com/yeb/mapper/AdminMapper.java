package com.yeb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeb.pojo.Admin;
import com.yeb.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MicroShan
 * @since 2022-03-05
 */

public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
