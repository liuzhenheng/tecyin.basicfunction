package com.tecyin.basiclassify.pojo.basic.source;

import lombok.Data;

import javax.persistence.*;

/**
 * 指标来源名称二级
 */
@Entity
@Data
@Table(name = "basic_source_class2")
public class Basic_source_class2 {
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
