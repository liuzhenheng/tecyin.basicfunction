package com.tecyin.basiclassify.pojo.basic.money;

import lombok.Data;

import javax.persistence.*;

/**
 * 资金性质一级
 */
@Entity
@Data
@Table(name = "basic_money")
public class Basic_money {
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
