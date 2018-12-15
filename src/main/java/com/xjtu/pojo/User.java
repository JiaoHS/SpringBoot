package com.xjtu.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name = "user")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String email;
    private String password;
    private String from_school_cn;
    @Transient   //是否显示 加上就不显示
    private String emc_user;


}
