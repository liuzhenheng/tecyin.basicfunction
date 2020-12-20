package com.tecyin.basiclassify.repository.dao.pay;


import com.tecyin.basiclassify.pojo.basic.pay.Basic_pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 支付方式 一级
 */
public interface Basic_payRepository extends JpaRepository<Basic_pay, Integer> {
    /**
     * 根据外键查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_pay b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_pay> findByDataid(int id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_pay b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_pay> findCodeAndName(String code,String name);
}
