package com.yeb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeb.pojo.AdminRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MicroShan
 * @since 2022-03-05
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

   /**
    * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
             */
    Integer updateAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
