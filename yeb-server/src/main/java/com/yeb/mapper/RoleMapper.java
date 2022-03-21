package com.yeb.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeb.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MicroShan
 * @since 2022-03-05
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户ID查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);
}
