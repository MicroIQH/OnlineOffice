package com.yeb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.yeb.pojo.Department;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MicroShan
 * @since 2022-03-05
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     * @param department
     */
    void addDepartment(Department department);

    /**
     * 删除部门
     * @param dep
     */
    void deleteDep(Department dep);
}
