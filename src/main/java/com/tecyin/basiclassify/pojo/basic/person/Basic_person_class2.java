package com.tecyin.basiclassify.pojo.basic.person;

import lombok.Data;

import javax.persistence.*;

/**
 * 是否补贴到人到企业名称 二级
 */
@Entity
@Data
@Table(name = "basic_person_class2")
public class Basic_person_class2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basic_function_class2_id;
    @Column
    private String basic_function_class2_code;
    @Column
    private String basic_function_class2_name;
    @Column
    private int basic_function_class2_func_id;
}
