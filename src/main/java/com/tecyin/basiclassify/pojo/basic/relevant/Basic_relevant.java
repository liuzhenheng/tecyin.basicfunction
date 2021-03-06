package com.tecyin.basiclassify.pojo.basic.relevant;

import lombok.Data;

import javax.persistence.*;

/**
 * 归口科室 一级
 */
@Entity
@Data
@Table(name = "basic_relevant")
public class Basic_relevant {
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
