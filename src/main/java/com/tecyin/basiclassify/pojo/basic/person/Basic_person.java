package com.tecyin.basiclassify.pojo.basic.person;

import lombok.Data;

import javax.persistence.*;

/**
 * 是否补贴到人到企业名称 一级
 */
@Entity
@Data
@Table(name = "Basic_person")
public class Basic_person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basic_function_id;
    @Column
    private String basic_function_code;
    @Column
    private String basic_function_name;
    @Column
    private int basic_function_data_id;


}
