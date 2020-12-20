package com.tecyin.basiclassify.pojo.basic.gold;

import lombok.Data;

import javax.persistence.*;

/**
 * 直达资金标识名称 三级
 */
@Entity
@Data
@Table(name = "basic_gold_class3")
public class Basic_gold_class3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basic_function_class3_id;
    @Column
    private String basic_function_class3_code;
    @Column
    private String basic_function_class3_name;
    @Column
    private int basic_function_class3_func2_id;
}
