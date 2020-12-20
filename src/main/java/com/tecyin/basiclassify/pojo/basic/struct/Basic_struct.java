package com.tecyin.basiclassify.pojo.basic.struct;

import lombok.Data;

import javax.persistence.*;

/**
 * 支出名称一级
 */
@Entity
@Data
@Table(name = "basic_struct")
public class Basic_struct {
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
