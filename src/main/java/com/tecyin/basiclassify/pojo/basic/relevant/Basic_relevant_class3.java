package com.tecyin.basiclassify.pojo.basic.relevant;

import lombok.Data;

import javax.persistence.*;

/**
 * 归口科室 三级
 */
@Entity
@Data
@Table(name = "basic_relevant_class3")
public class Basic_relevant_class3 {
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
