package com.yeb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeb.pojo.Menu;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MicroShan
 * @since 2022-03-05
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenusByAdminId(Integer id);
    /**
     * 根据角色获取相关列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     *  查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
