package com.tecyin.basiclassify.pojo.basic.type;

import lombok.Data;

import javax.persistence.*;

/**
 * 支付类型 三级
 */
@Entity
@Data
@Table(name = "basic_type_class3")
public class Basic_type_class3 {
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
