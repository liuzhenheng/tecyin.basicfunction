package com.tecyin.basiclassify.pojo.basic.reference;

import lombok.Data;

import javax.persistence.*;

/**
 * 指标文号 二级
 */
@Entity
@Data
@Table(name = "basic_reference_class2")
public class Basic_reference_class2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basic_function_class2_id;
    @Column
    private String basic_function_class2_code;
    @Column
    private String basic_function_class2_name;
    @Column
    private int basic_function_class2_func_id;
}
