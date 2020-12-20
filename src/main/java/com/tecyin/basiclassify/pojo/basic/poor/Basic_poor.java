package com.tecyin.basiclassify.pojo.basic.poor;

import lombok.Data;

import javax.persistence.*;

/**
 * 扶贫标识名称一级
 */
@Entity
@Data
@Table(name = "basic_poor")
public class Basic_poor {
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
