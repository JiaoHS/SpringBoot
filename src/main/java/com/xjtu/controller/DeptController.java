package com.xjtu.controller;

import com.xjtu.entities.Employee;
import com.xjtu.mapper.DepartmentMapper;
import com.xjtu.mapper.EmployeeMapper;
import com.xjtu.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther coraljiao
 * @date 2018/12/27 21:42
 * @description
 */
@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        System.out.println(departmentMapper.getDeptById(id));
        return departmentMapper.getDeptById(id);
    }
    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/TestEmp/{id}")
    public Employee getEmpInfo(@PathVariable("id") Integer id){

        return employeeMapper.getEmpById(id);
    }

//    @GetMapping("/emp/{id}")
//    public Employee getEmp(@PathVariable("id") Integer id){
//        return employeeMapper.getEmpById(id);
//    }
}
