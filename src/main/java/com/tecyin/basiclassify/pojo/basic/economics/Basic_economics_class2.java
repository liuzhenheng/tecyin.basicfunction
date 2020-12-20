package com.tecyin.basiclassify.pojo.basic.economics;

import lombok.Data;

import javax.persistence.*;

/**
 * 部门经济科目二级
 */
@Entity
@Data
@Table(name = "basic_economics_class2")
public class Basic_economics_class2 {
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
