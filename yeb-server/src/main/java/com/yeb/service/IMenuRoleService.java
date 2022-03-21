package com.yeb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.common.RespBean;
import com.yeb.pojo.MenuRole;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MicroShan
 * @since 2022-03-05
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
