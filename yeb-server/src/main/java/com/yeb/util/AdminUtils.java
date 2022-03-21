package com.yeb.util;

import com.yeb.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 操作员工具类
 */
public class AdminUtils {

    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
    }
}
