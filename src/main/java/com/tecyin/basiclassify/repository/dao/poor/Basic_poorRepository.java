package com.tecyin.basiclassify.repository.dao.poor;


import com.tecyin.basiclassify.pojo.basic.poor.Basic_poor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 扶贫标识名称 一级
 */
public interface Basic_poorRepository extends JpaRepository<Basic_poor, Integer> {
    /**
     * 根据外键查询
     *
     * @param basic_function_class2_func_id
     * @return
     */
    @Query(value = "select * from basic_poor b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_poor> findByDataid(int id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_poor b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_poor> findCodeAndName(String code,String name);
}
