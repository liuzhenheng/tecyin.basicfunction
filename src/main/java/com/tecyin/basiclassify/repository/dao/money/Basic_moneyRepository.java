package com.tecyin.basiclassify.repository.dao.money;


import com.tecyin.basiclassify.pojo.basic.money.Basic_money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 资金性质 一级
 */
public interface Basic_moneyRepository extends JpaRepository<Basic_money, Integer> {
    /**
     * 根据外键查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_money b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_money> findByDataid(int id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_money b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_money> findCodeAndName(String code,String name);
}
