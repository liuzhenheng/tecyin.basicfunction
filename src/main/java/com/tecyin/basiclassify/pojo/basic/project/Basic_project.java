package com.tecyin.basiclassify.pojo.basic.project;

import lombok.Data;

import javax.persistence.*;

/**
 * 基础数据项目名称一级
 */
@Entity
@Data
@Table(name = "basic_project")
public class Basic_project {
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
