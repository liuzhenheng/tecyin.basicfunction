package com.tecyin.basiclassify.repository.dao.direct;


import com.tecyin.basiclassify.pojo.basic.direct.Basic_direct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 是否直达资金的地方对应安排名称 一级
 */
public interface Basic_directRepository extends JpaRepository<Basic_direct, Integer> {
    /**
     * 根据外键查询
     *
     * @param basic_function_class2_func_id
     * @return
     */
    @Query(value = "select * from basic_direct b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_direct> findByDataid(int id);

    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_budget b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_direct> findCodeAndName(String code,String name);
}
