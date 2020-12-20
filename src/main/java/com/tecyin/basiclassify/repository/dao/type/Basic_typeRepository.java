package com.tecyin.basiclassify.repository.dao.type;


import com.tecyin.basiclassify.pojo.basic.type.Basic_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 支付类型 一级
 */
public interface Basic_typeRepository extends JpaRepository<Basic_type, Integer> {
    /**
     * 根据外键查询
     *
     * @param basic_function_class2_func_id
     * @return
     */
    @Query(value = "select * from basic_type b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_type> findByDataid(int id);/**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_type b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_type> findCodeAndName(String code,String name);
}
