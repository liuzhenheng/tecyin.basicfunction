package com.tecyin.basiclassify.pojo.basic.direct;

import lombok.Data;

import javax.persistence.*;

/**
 * 是否直达资金的地方对应安排名称 一级
 */
@Entity
@Data
@Table(name = "basic_direct")
public class Basic_direct {
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
