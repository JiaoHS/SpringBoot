package com.xjtu.repository;

import com.xjtu.entities.TestJPA;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther coraljiao
 * @date 2018/12/28 14:44
 * @description
 */
//继承JpaRepository来完成对数据库的操作
public interface TestJpaRepository extends JpaRepository<TestJPA,Integer> {

}
