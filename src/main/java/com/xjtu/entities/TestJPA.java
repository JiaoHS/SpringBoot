package com.xjtu.entities;

import javax.persistence.*;

/**
 * @auther coraljiao
 * @date 2018/12/28 14:35
 * @description
 */
//使用jpa注解配置映射关系

@Entity   //告诉jpa这是一个实体类（和数据表映射的类）
@Table(name = "tbl_testJpa")
public class TestJPA {
    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column(name = "user_name",length = 50) //和数据表对应的列
    private String userName;
    @Column //默认不写列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
