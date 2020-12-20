package com.tecyin.basiclassify.pojo.basic.gold;

import lombok.Data;

import javax.persistence.*;

/**
 * 直达资金标识名称 一级
 */
@Entity
@Data
@Table(name = "basic_gold")
public class Basic_gold {
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
