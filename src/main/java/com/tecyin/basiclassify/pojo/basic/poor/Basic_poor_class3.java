package com.tecyin.basiclassify.pojo.basic.poor;

import lombok.Data;

import javax.persistence.*;

/**
 * 扶贫标识名称 三级
 */
@Entity
@Data
@Table(name = "basic_poor_class3")
public class Basic_poor_class3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basic_function_class3_id;
    @Column
    private String basic_function_class3_code;
    @Column
    private String basic_function_class3_name;
    @Column
    private int basic_function_class3_func2_id;
}
