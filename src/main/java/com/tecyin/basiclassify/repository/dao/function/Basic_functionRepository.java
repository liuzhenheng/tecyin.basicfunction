package com.tecyin.basiclassify.repository.dao.function;


import com.tecyin.basiclassify.pojo.basic.function.Basic_function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 指标文号 一级
 */
public interface Basic_functionRepository extends JpaRepository<Basic_function, Integer> {
    /**
     * 根据外键查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_function b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_function> findByDataid(int id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_function b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_function> findCodeAndName(String code,String name);
}
