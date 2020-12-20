package com.tecyin.basiclassify.pojo.basic.poor;

import lombok.Data;

import javax.persistence.*;

/**
 * 扶贫标识名称二级
 */
@Entity
@Data
@Table(name = "basic_poor_class2")
public class Basic_poor_class2 {
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
