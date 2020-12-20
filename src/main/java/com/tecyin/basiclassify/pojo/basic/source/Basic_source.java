package com.tecyin.basiclassify.pojo.basic.source;

import lombok.Data;

import javax.persistence.*;

/**
 * 指标来源名称一级
 */
@Entity
@Data
@Table(name = "basic_source")
public class Basic_source {
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
