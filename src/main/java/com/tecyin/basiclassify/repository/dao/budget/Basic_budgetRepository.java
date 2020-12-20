package com.tecyin.basiclassify.repository.dao.budget;


import com.tecyin.basiclassify.pojo.basic.budget.Basic_budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 预算单位名称 一级
 */
public interface Basic_budgetRepository extends JpaRepository<Basic_budget, Integer> {
    /**
     * 根据外键查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_budget b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_budget> findByDataid(int id);

    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_budget b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_budget> findCodeAndName(String code,String name);


}
