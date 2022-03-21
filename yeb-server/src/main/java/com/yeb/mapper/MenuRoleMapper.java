package com.yeb.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeb.pojo.MenuRole;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MicroShan
 * @since 2022-03-05
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    Integer insertRecord(Integer rid, Integer[] mids);
}
