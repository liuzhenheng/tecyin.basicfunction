package com.tecyin.basiclassify.repository.dao.economics;


import com.tecyin.basiclassify.pojo.basic.economics.Basic_economics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 部门经济科目 一级
 */
public interface Basic_economicsRepository extends JpaRepository<Basic_economics, Integer> {
    /**
     * 根据外键查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_economics b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_economics> findByDataid(int id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_economics b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_economics> findCodeAndName(String code,String name);
}
