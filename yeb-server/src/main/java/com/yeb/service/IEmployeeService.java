package com.yeb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yeb.common.RespBean;
import com.yeb.common.RespPageBean;
import com.yeb.pojo.Employee;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MicroShan
 * @since 2022-03-05
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工(分页)
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取工号
     * @return
     */
    RespBean maxWorkID();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmployee(Employee employee);

    /**
     * 查询员工
     * @param id
     */
    List<Employee> getEmployee(Integer id);

    /**
     * 获取所有员工账套
     * @param currentPage
     * @param size
     * @return
     */
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
