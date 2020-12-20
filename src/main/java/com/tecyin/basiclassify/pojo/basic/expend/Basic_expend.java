package com.tecyin.basiclassify.pojo.basic.expend;

import lombok.Data;

import javax.persistence.*;

/**
 * 支出经济科目一级
 */
@Entity
@Data
@Table(name = "basic_expend")
public class Basic_expend {
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
