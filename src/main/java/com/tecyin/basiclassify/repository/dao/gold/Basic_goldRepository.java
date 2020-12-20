package com.tecyin.basiclassify.repository.dao.gold;


import com.tecyin.basiclassify.pojo.basic.gold.Basic_gold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 直达资金标识名称 一级
 */
public interface Basic_goldRepository extends JpaRepository<Basic_gold, Integer> {
    /**
     * 根据外键查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_gold b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_gold> findByDataid(int id);

    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_gold b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_gold> findCodeAndName(String code, String name);
}
