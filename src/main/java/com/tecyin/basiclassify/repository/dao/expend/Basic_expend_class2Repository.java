package com.tecyin.basiclassify.repository.dao.expend;


import com.tecyin.basiclassify.pojo.basic.expend.Basic_expend_class2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 支出经济科目 二级
 */
public interface Basic_expend_class2Repository extends JpaRepository<Basic_expend_class2, Integer> {

    /**
     * 根据外键查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_expend_class2 b where b.basic_function_class2_func_id = ?1 ", nativeQuery = true)
    List<Basic_expend_class2> findFuncClass2FuncId(int basic_function_class2_func_id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_expend_class2 b where b.basic_function_class2_code = ?1 and b.basic_function_class2_name=?2", nativeQuery = true)
    List<Basic_expend_class2> findClass2CodeAndName(String code, String name);

}
