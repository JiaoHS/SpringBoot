package com.xjtu.mapper;


import com.xjtu.entities.Employee;

/**
 * @auther coraljiao
 * @date 2018/12/28 12:15
 * @description
 */
//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
