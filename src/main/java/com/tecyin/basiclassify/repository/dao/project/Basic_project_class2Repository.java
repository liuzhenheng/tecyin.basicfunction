package com.tecyin.basiclassify.repository.dao.project;


import com.tecyin.basiclassify.pojo.basic.project.Basic_project_class2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 基础数据项目名称 二级
 */
public interface Basic_project_class2Repository extends JpaRepository<Basic_project_class2, Integer> {

    /**
     * 根据外键查询
     *
     * @param basic_function_class2_func_id
     * @return
     */
    @Query(value = "select * from basic_project_class2 b where b.basic_function_class2_func_id = ?1 ", nativeQuery = true)
    List<Basic_project_class2> findFuncClass2FuncId(int basic_function_class2_func_id);
    /**
     * 根据编码和名称查询
     *
     * @param
     * @return
     */
    @Query(value = "select * from basic_project_class2 b where b.basic_function_class2_code = ?1 and b.basic_function_class2_name=?2", nativeQuery = true)
    List<Basic_project_class2> findClass2CodeAndName(String code, String name);

}
