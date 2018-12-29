package com.xjtu.mapper;

import com.xjtu.pojo.Department;
import org.apache.ibatis.annotations.*;

/**
 * @auther coraljiao
 * @date 2018/12/27 21:37
 * @description
 */
//@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
