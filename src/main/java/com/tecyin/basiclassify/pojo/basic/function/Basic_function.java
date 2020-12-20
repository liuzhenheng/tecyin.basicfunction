package com.tecyin.basiclassify.pojo.basic.function;

import lombok.Data;

import javax.persistence.*;

/**
 * 功能分类
 */
@Entity
@Data
@Table(name = "basic_function")
public class Basic_function {
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
