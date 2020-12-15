package com.tecyin.basiclassify.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Basic_function_class2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basic_function_class2_id;
    private String basic_function_class2_code;
    private String basic_function_class2_name;
    private int basic_function_class2_func_id;
}
