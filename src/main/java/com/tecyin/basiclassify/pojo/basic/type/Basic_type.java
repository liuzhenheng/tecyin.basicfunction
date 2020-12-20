package com.tecyin.basiclassify.pojo.basic.type;

import lombok.Data;

import javax.persistence.*;

/**
 * 支付类型一级
 */
@Entity
@Data
@Table(name = "basic_type")
public class Basic_type {
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
