package com.tecyin.basiclassify.repository.dao.expend;


import com.tecyin.basiclassify.pojo.basic.expend.Basic_expend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 支出经济科目 一级
 */
public interface Basic_expendRepository extends JpaRepository<Basic_expend, Integer> {
    /**
     * 根据外键查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_expend b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_expend> findByDataid(int id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_expend b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_expend> findCodeAndName(String code,String name);
}
