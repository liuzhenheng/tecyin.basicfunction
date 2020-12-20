package com.tecyin.basiclassify.pojo.basic.budget;

import lombok.Data;

import javax.persistence.*;

/**
 * 预算单位名称 一级
 */
@Entity
@Data
@Table(name = "basic_budget")
public class Basic_budget {
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
