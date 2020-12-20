package com.tecyin.basiclassify.repository.dao.reference;

import com.tecyin.basiclassify.pojo.basic.reference.Basic_reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 指标文化 一级
 */
public interface Basic_referenceRepository extends JpaRepository<Basic_reference,Integer> {
    /**
     * 根据外键查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_reference b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_reference> findByDataid(int id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_reference b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_reference> findCodeAndName(String code,String name);
}
