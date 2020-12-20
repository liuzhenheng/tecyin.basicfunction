package com.tecyin.basiclassify.repository.dao.person;


import com.tecyin.basiclassify.pojo.basic.person.Basic_person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 是否补贴到人到企业名称 一级
 */
public interface Basic_personRepository extends JpaRepository<Basic_person, Integer> {
    /**
     * 根据外键查询
     *
     * @param basic_function_class2_func_id
     * @return
     */
    @Query(value = "select * from basic_person b where b.basic_function_data_id=?1", nativeQuery = true)
    List<Basic_person> findByDataid(int id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_person b where b.basic_function_code=?1 and b.basic_function_name=?2", nativeQuery = true)
    List<Basic_person> findCodeAndName(String code,String name);
}
