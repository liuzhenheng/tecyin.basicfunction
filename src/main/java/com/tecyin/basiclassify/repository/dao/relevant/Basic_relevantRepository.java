package com.tecyin.basiclassify.repository.dao.relevant;

import com.tecyin.basiclassify.pojo.basic.relevant.Basic_relevant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 归口科室 一级
 */
public interface Basic_relevantRepository extends JpaRepository<Basic_relevant,Integer> {
    /**
     * 根据外键查询
     * @param id
     * @return
     */
    @Query(value = "select * from basic_relevant b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_relevant> findByDataid(int id);/**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_relevant b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_relevant> findCodeAndName(String code,String name);
}
