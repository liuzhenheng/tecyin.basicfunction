package com.tecyin.basiclassify.repository.dao.person;

import com.tecyin.basiclassify.pojo.basic.person.Basic_person_class3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 是否补贴到人到企业名称 三级
 */
public interface Basic_person_class3Repository extends JpaRepository<Basic_person_class3, Integer> {

    /**
     * 根据Basic_function_class2的外键查询
     *
     * @param basic_function_class2_func_id
     * @return
     */
    @Query(value = "select * from basic_person_class3 b where b.basic_function_class3_func2_id = ?1 ", nativeQuery = true)
    List<Basic_person_class3> findFuncClass3FuncId(int basic_function_class3_func2_id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_person_class3 b where b.basic_function_class3_code = ?1 and b.basic_function_class3_name=?2", nativeQuery = true)
    List<Basic_person_class3> findClass3CodeAndName(String code,String name);
}
