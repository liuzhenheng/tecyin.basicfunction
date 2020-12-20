package com.tecyin.basiclassify.pojo.basic.economics;

import lombok.Data;

import javax.persistence.*;

/**
 * 部门经济科目一级
 */
@Entity
@Data
@Table(name = "basic_economics")
public class Basic_economics {
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
