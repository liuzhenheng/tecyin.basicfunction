package com.tecyin.basiclassify.pojo.basic.reference;

import lombok.Data;

import javax.persistence.*;

/**
 * 指标文号 一级
 */
@Entity
@Data
@Table(name = "basic_reference")
public class Basic_reference {
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
