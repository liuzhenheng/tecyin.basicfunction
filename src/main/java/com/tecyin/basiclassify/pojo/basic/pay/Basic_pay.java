package com.tecyin.basiclassify.pojo.basic.pay;

import lombok.Data;

import javax.persistence.*;

/**
 * 支付方式 一级
 */
@Entity
@Data
@Table(name = "basic_pay")
public class Basic_pay {
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
