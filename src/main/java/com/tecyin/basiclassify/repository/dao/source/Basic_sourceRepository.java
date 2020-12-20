package com.tecyin.basiclassify.repository.dao.source;


import com.tecyin.basiclassify.pojo.basic.source.Basic_source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 指标来源名称 一级
 */
public interface Basic_sourceRepository extends JpaRepository<Basic_source, Integer> {
    /**
     * 根据外键查询
     *
     * @param basic_function_class2_func_id
     * @return
     */
    @Query(value = "select * from basic_source b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_source> findByDataid(int id);/**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_source b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_source> findCodeAndName(String code,String name);
}
