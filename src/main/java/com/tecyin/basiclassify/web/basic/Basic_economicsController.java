package com.tecyin.basiclassify.web.basic;

import com.tecyin.basiclassify.pojo.basic.economics.Basic_economics;
import com.tecyin.basiclassify.pojo.basic.economics.Basic_economics_class2;
import com.tecyin.basiclassify.pojo.basic.economics.Basic_economics_class3;
import com.tecyin.basiclassify.repository.dao.economics.Basic_economicsRepository;
import com.tecyin.basiclassify.repository.dao.economics.Basic_economics_class2Repository;
import com.tecyin.basiclassify.repository.dao.economics.Basic_economics_class3Repository;
import com.tecyin.basiclassify.utils.Result;
import com.tecyin.basiclassify.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门经济科目
 */
@RestController
@RequestMapping("/economics")
public class Basic_economicsController {
    @Autowired
    private Basic_economicsRepository br1;
    @Autowired
    private Basic_economics_class2Repository br2;
    @Autowired
    private Basic_economics_class3Repository br3;

    @PostMapping("/economics")
    public ModelAndView classify(
            @RequestParam(value = "type", defaultValue = "1") int type,
//            1 根据id查询Basic_function表
            @RequestParam(value = "basic_function_id", defaultValue = "1") int basic_function_id,
//            2 分页查询Basic_function表
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "5") int limit,
//            3 根据外键查询Basic_function 表
            @RequestParam(value = "findBasicFuncDataId", defaultValue = "1") int findBasicFuncDataId,
//            5 根据ID查询Basic_function_class2 表
            @RequestParam(value = "basic_function_class2_id", defaultValue = "1") int basic_function_class2_id,
//            6 根据外键查询Basic_function_class2 表外键
            @RequestParam(value = "basic_function_class2_func_id", defaultValue = "1") int basic_function_class2_func_id,
//            8 根据ID查询Basic_function_class3 表
            @RequestParam(value = "basic_function_class3_id", defaultValue = "1") int basic_function_class3_id,
//            9 根据外键查询Basic_function_class3 表
            @RequestParam(value = "basic_function_class3_func2_id", defaultValue = "1") int basic_function_class3_func2_id,
//            11 增加Basic_function表的对象
            @RequestParam(value = "basic_function_code", defaultValue = "0") String basic_function_code,
            @RequestParam(value = "basic_function_name", defaultValue = "null") String basic_function_name,
            @RequestParam(value = "basic_function_data_id", defaultValue = "0") int basic_function_data_id,
//            12 增加basic_function_class2表的对象,公用6的ID
            @RequestParam(value = "basic_function_class2_code", defaultValue = "0") String basic_function_class2_code,
            @RequestParam(value = "basic_function_class2_name", defaultValue = "null") String basic_function_class2_name,
//            13 增加basic_function_class3表的对象 公用9 ID
            @RequestParam(value = "basic_function_class3_code", defaultValue = "0") String basic_function_class3_code,
            @RequestParam(value = "basic_function_class3_name", defaultValue = "null") String basic_function_class3_name,
            //            22 根据编码和名称查询basic_function表以及级下所有的对象
            @RequestParam(value = "basic_code", defaultValue = "null") String basic_code,
            @RequestParam(value = "basic_name", defaultValue = "null") String basic_name
    ) {
        ModelAndView m = null;
        if (type == 1) {
//            1 根据id查询Basic_function表
            m = new ModelAndView("forward:/economics/findOneBasicFunc");
            m.addObject("basic_function_id", basic_function_id);
        } else if (type == 2) {
//            2 分页查询Basic_function表
            m = new ModelAndView("forward:/economics/findPage");
            m.addObject("page", page);
            m.addObject("limit", limit);
        } else if (type == 3) {
//            3 根据外键查询Basic_function 表
            m = new ModelAndView("forward:/economics/findBasicFuncDataId");
            m.addObject("findBasicFuncDataId", findBasicFuncDataId);
        } else if (type == 4) {
//            4 查询Basic_function 表的所有
            m = new ModelAndView("forward:/economics/findBasicFunctionAll");
        } else if (type == 5) {
//            5 根据ID查询Basic_function_class2 表
            m = new ModelAndView("forward:/economics/findOneBasicFuncCla2");
            m.addObject("basic_function_class2_id", basic_function_class2_id);
        } else if (type == 6) {
//            6 根据外键查询Basic_function_class2 表外键
            m = new ModelAndView("forward:/economics/findBasicFuncCla2FuncId");
            m.addObject("basic_function_class2_func_id", basic_function_class2_func_id);
        } else if (type == 7) {
//            7 查询Basic_function_class2表的所有 findBasicFuncClass2All
            m = new ModelAndView("forward:/economics/findBasicFuncClass2All");

        } else if (type == 8) {
//            8 根据ID查询Basic_function_class3 表
            m = new ModelAndView("forward:/economics/findOneBasicFuncCla3");
            m.addObject("basic_function_class3_id", basic_function_class3_id);
        } else if (type == 9) {
//            9 根据外键查询Basic_function_class3 表
            m = new ModelAndView("forward:/economics/findBasicFuncCla3FuncId");
            m.addObject("basic_function_class3_func2_id", basic_function_class3_func2_id);
        } else if (type == 10) {
//            10 查询Basic_function_class3表的所有
            m = new ModelAndView("forward:/economics/findBasicFuncClass3All");
        } else if (type == 11) {
//            11 增加Basic_function表的对象
            m = new ModelAndView("forward:/economics/addBasicFunc");
            m.addObject("basic_function_code", basic_function_code);
            m.addObject("basic_function_name", basic_function_name);
            m.addObject("basic_function_data_id", basic_function_data_id);
        } else if (type == 12) {
//            12 增加basic_function_class2表的对象
            m = new ModelAndView("forward:/economics/addBasicFuncCla2");
            m.addObject("basic_function_class2_code", basic_function_class2_code);
            m.addObject("basic_function_class2_name", basic_function_class2_name);
            m.addObject("basic_function_class2_func_id", basic_function_class2_func_id);
        } else if (type == 13) {
//            13 增加basic_function_class3表的对象
            m = new ModelAndView("forward:/economics/addBasicFuncCla3");
            m.addObject("basic_function_class3_code", basic_function_class3_code);
            m.addObject("basic_function_class3_name", basic_function_class3_name);
            m.addObject("basic_function_class3_func2_id", basic_function_class3_func2_id);
        } else if (type == 14) {
//            14 修改Basic_function表的数据
            m = new ModelAndView("forward:/economics/updateBasicFunc");
            m.addObject("basic_function_id", basic_function_id);
            m.addObject("basic_function_code", basic_function_code);
            m.addObject("basic_function_name", basic_function_name);
            m.addObject("basic_function_data_id", basic_function_data_id);
        } else if (type == 15) {
//            15 修改basic_function_class2表的数据
            m = new ModelAndView("forward:/economics/updateBasicFunClass2");
            m.addObject("basic_function_class2_id", basic_function_class2_id);
            m.addObject("basic_function_class2_code", basic_function_class2_code);
            m.addObject("basic_function_class2_name", basic_function_class2_name);
            m.addObject("basic_function_class2_func_id", basic_function_class2_func_id);
        } else if (type == 16) {
//          16 修改basic_function_class3表的数据
            m = new ModelAndView("forward:/economics/updateBasicFunClass3");
            m.addObject("basic_function_class3_id", basic_function_class3_id);
            m.addObject("basic_function_class3_code", basic_function_class3_code);
            m.addObject("basic_function_class3_name", basic_function_class3_name);
            m.addObject("basic_function_class3_func2_id", basic_function_class3_func2_id);

        } else if (type == 17) {
//          17 第一次请求查看 Basic_function 表下级有没有数据，没有就删除
            m = new ModelAndView("forward:/economics/deleteFunSure");
            m.addObject("basic_function_id", basic_function_id);
        } else if (type == 18) {
//          18 删除 basic_function 表级下所有的数据
            m = new ModelAndView("forward:/economics/deleteBasicFunc");
            m.addObject("basic_function_id", basic_function_id);
        } else if (type == 19) {
//          19 第一次请求查看basic_function_class2 表下级有没有数据，没有就删除
            m = new ModelAndView("forward:/economics/deleteBasicFunClass2");
            m.addObject("basic_function_class2_id",basic_function_class2_id);
        } else if (type == 20) {
//          20 确定删除Basic_function_class2下所有的数据
            m = new ModelAndView("forward:/economics/delete2Sure");
            m.addObject("basic_function_class2_id", basic_function_class2_id);
        } else if (type == 21) {
//          21 根据id删除basic_function_class3表的数据
            m = new ModelAndView("forward:/economics/deleteBasicFunClass3");
            m.addObject("basic_function_class3_id", basic_function_class3_id);
        }else if (type == 22) {
//          22 根据编码和名称查询Basic_function 表级下所有的用户
            m = new ModelAndView("forward:/economics/findFuncCodeName");
            m.addObject("basic_code", basic_code);
            m.addObject("basic_name", basic_name);
        }
        return m;
    }

    /**
     * 1 根据id查询Basic_function表
     *
     * @param id
     * @return
     */
    @PostMapping("/findOneBasicFunc")
    public Result findOneBasicFunc(@RequestParam("basic_function_id") int id) {
        Basic_economics byId = null;
        try {
            byId = br1.findById(id).get();
            //判断获取的数据是否为空
            if (byId.equals("") && byId == null) {
                return new Result(ResultCode.FAIL);
            } else {
                return new Result(ResultCode.SUCCESS, byId);
            }
        } catch (Exception e) {
            return new Result(ResultCode.FAIL);
        }

    }

    /**
     * 2 分页查询Basic_function表
     *
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/findPage")
    public Result findPage(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "5") int limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        Page<Basic_economics> all = br1.findAll(pageable);
        return new Result(ResultCode.SUCCESS, all);

    }

    /**
     * 3 根据外键查询Basic_function 表
     *
     * @param id
     * @return
     */
    @PostMapping("/findBasicFuncDataId")
    public Result findBasicFuncDataId(@RequestParam("findBasicFuncDataId") int findBasicFuncDataId) {
        List<Basic_economics> funcDataId = br1.findByDataid(findBasicFuncDataId);
        //判断获取的数据是否为空
        if (funcDataId.size() == 0) {
            return new Result(ResultCode.FAIL);
        } else {
            return new Result(ResultCode.SUCCESS, funcDataId);
        }
    }

    /**
     * 4 查询Basic_function 表的所有
     *
     * @return
     */
    @PostMapping("/findBasicFunctionAll")
    public Result findBasicFunctionAll() {
        List<Basic_economics> all = br1.findAll();
        //判断获取的数据是否为空
        if (all.size() != 0) {
            return new Result(ResultCode.SUCCESS, all);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }


    /**
     * 5 根据ID查询Basic_function_class2 表
     *
     * @param id
     * @return
     */
    @PostMapping("/findOneBasicFuncCla2")
    public Result findOneBasicFuncCla2(@RequestParam("basic_function_class2_id") int basic_function_class2_id) {
        Basic_economics_class2 byId = null;
        try {
            byId = br2.findById(basic_function_class2_id).get();
            //判断获取的数据是否为空
            if (byId.equals("") && byId == null) {
                return new Result(ResultCode.FAIL);
            } else {
                return new Result(ResultCode.SUCCESS, byId);
            }
        } catch (Exception e) {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 6 根据外键查询Basic_function_class2 表外键
     *
     * @param id
     * @return
     */
    @PostMapping("/findBasicFuncCla2FuncId")
    public Result findBasicFuncCla2FuncId(
            @RequestParam(value = "basic_function_class2_func_id", defaultValue = "1") int basic_function_class2_func_id) {
        List<Basic_economics_class2> funcClass2FuncId = br2.findFuncClass2FuncId(basic_function_class2_func_id);
        //判断获取的数据是否为空
        if (funcClass2FuncId.size() == 0) {
            return new Result(ResultCode.FAIL);
        } else {
            return new Result(ResultCode.SUCCESS, funcClass2FuncId);
        }
    }

    /**
     * 7 查询Basic_function_class2表的所有
     *
     * @return
     */
    @PostMapping("/findBasicFuncClass2All")
    public Result findBasicFuncClass2All() {
        List<Basic_economics_class2> all = br2.findAll();
        //判断获取的数据是否为空
        if (all.size() != 0) {
            return new Result(ResultCode.SUCCESS, all);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 8 根据ID查询Basic_function_class3 表
     *
     * @param id
     * @return
     */
    @PostMapping("/findOneBasicFuncCla3")
    public Result findOneBasicFuncCla3(@RequestParam(value = "basic_function_class3_id", defaultValue = "1") int basic_function_class3_id) {
        Basic_economics_class3 byId = br3.findById(basic_function_class3_id).get();
        //判断获取的数据是否为空
        if (byId == null && byId.equals("")) {
            return new Result(ResultCode.FAIL);
        } else {
            return new Result(ResultCode.SUCCESS, byId);
        }
    }

    /**
     * 9 根据外键查询Basic_function_class3 表
     *
     * @param id
     * @return
     */
    @PostMapping("/findBasicFuncCla3FuncId")
    public Result findBasicFuncCla3FuncId(
            @RequestParam(value = "basic_function_class3_func2_id", defaultValue = "1") int basic_function_class3_func2_id) {
        List<Basic_economics_class3> funcClass3FuncId =
                br3.findFuncClass3FuncId(basic_function_class3_func2_id);
        //判断获取的数据是否为空
        if (funcClass3FuncId.size() != 0) {
            return new Result(ResultCode.SUCCESS, funcClass3FuncId);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 10 查询Basic_function_class3表的所有
     *
     * @return
     */
    @PostMapping("/findBasicFuncClass3All")
    public Result findBasicFuncClass3All() {
        List<Basic_economics_class3> all = br3.findAll();
        //判断获取的数据是否为空
        if (all.size() != 0) {
            return new Result(ResultCode.SUCCESS, all);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 11 增加Basic_function表的对象
     *
     * @param basic_function
     * @return
     */
    @PostMapping("/addBasicFunc")
    public Result addBasicFunc(
            @RequestParam(value = "basic_function_code", defaultValue = "0") String basic_function_code,
            @RequestParam(value = "basic_function_name", defaultValue = "null") String basic_function_name,
            @RequestParam(value = "basic_function_data_id", defaultValue = "0") int basic_function_data_id) {

        Basic_economics b = new Basic_economics();
        b.setBasic_function_code(basic_function_code);
        b.setBasic_function_name(basic_function_name);
        b.setBasic_function_data_id(basic_function_data_id);
        Basic_economics saveResult = br1.save(b);
        //判断获取的数据是否为空
        if (saveResult.equals("") && saveResult == null) {
            return new Result(ResultCode.FAIL);
        } else {
            return new Result(ResultCode.SUCCESS, saveResult);
        }
    }

    /**
     * 12 增加basic_function_class2表的对象
     *
     * @param basic_function_class2
     * @return
     */
    @PostMapping("/addBasicFuncCla2")
    public Result addBasicFuncCla2(
            @RequestParam(value = "basic_function_class2_code", defaultValue = "0") String basic_function_class2_code,
            @RequestParam(value = "basic_function_class2_name", defaultValue = "null") String basic_function_class2_name,
            @RequestParam(value = "basic_function_class2_func_id", defaultValue = "0") int basic_function_class2_func_id) {
        Basic_economics_class2 bc = new Basic_economics_class2();
        bc.setBasic_function_class2_code(basic_function_class2_code);
        bc.setBasic_function_class2_name(basic_function_class2_name);
        bc.setBasic_function_class2_func_id(basic_function_class2_func_id);
        Basic_economics_class2 saveResult = br2.save(bc);
        //判断获取的数据是否为空
        if (saveResult.equals("") && saveResult == null) {
            return new Result(ResultCode.FAIL);
        } else {
            return new Result(ResultCode.SUCCESS, saveResult);
        }
    }

    /**
     * 13 增加basic_function_class3表的对象
     *
     * @param basic_function_class3
     * @return
     */
    @PostMapping("/addBasicFuncCla3")
    public Result addBasicFuncCla3(
            @RequestParam(value = "basic_function_class3_code", defaultValue = "0") String basic_function_class3_code,
            @RequestParam(value = "basic_function_class3_name", defaultValue = "null") String basic_function_class3_name,
            @RequestParam(value = "basic_function_class3_func2_id", defaultValue = "0") int basic_function_class3_func2_id) {
        Basic_economics_class3 bc3 = new Basic_economics_class3();
        bc3.setBasic_function_class3_code(basic_function_class3_code);
        bc3.setBasic_function_class3_name(basic_function_class3_name);
        bc3.setBasic_function_class3_func2_id(basic_function_class3_func2_id);
        Basic_economics_class3 saveResult = br3.save(bc3);
        //判断获取的数据是否为空
        if (saveResult.equals("") && saveResult == null) {
            return new Result(ResultCode.FAIL);
        } else {
            return new Result(ResultCode.SUCCESS, saveResult);
        }
    }


    /**
     * 14 修改Basic_function表的数据
     *
     * @param basic_function
     * @return
     */
    @PostMapping("/updateBasicFunc")
    public Result updateBasicFunc(
            @RequestParam(value = "basic_function_id", defaultValue = "0") int basic_function_id,
            @RequestParam(value = "basic_function_code", defaultValue = "0") String basic_function_code,
            @RequestParam(value = "basic_function_name", defaultValue = "null") String basic_function_name,
            @RequestParam(value = "basic_function_data_id", defaultValue = "0") int basic_function_data_id) {
        Result result = null;
        Basic_economics bu = null;
        try {
            bu = br1.findById(basic_function_id).get();
            bu.setBasic_function_id(basic_function_id);
            bu.setBasic_function_code(basic_function_code);
            bu.setBasic_function_name(basic_function_name);
            bu.setBasic_function_data_id(basic_function_data_id);
            br1.save(bu);
            result = new Result(ResultCode.SUCCESS, bu);
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 15 修改basic_function_class2表的数据
     *
     * @param basic_function
     * @return
     */
    @PostMapping("/updateBasicFunClass2")
    public Result updateBasicFunClass2(
            @RequestParam(value = "basic_function_class2_id", defaultValue = "0") int basic_function_class2_id,
            @RequestParam(value = "basic_function_class2_code", defaultValue = "0") String basic_function_class2_code,
            @RequestParam(value = "basic_function_class2_name", defaultValue = "null") String basic_function_class2_name,
            @RequestParam(value = "basic_function_class2_func_id", defaultValue = "0") int basic_function_class2_func_id) {
        Result result = null;
        Basic_economics_class2 bu = null;
        try {
            bu = br2.findById(basic_function_class2_id).get();
            bu.setBasic_function_class2_id(basic_function_class2_id);
            bu.setBasic_function_class2_code(basic_function_class2_code);
            bu.setBasic_function_class2_name(basic_function_class2_name);
            bu.setBasic_function_class2_func_id(basic_function_class2_func_id);
            bu = br2.save(bu);
            result = new Result(ResultCode.SUCCESS, bu);
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 16 修改basic_function_class3表的数据
     *
     * @param basic_function
     * @return
     */
    @PostMapping("/updateBasicFunClass3")
    public Result updateBasicFunClass3(
            @RequestParam(value = "basic_function_class3_id", defaultValue = "0") int basic_function_class3_id,
            @RequestParam(value = "basic_function_class3_code", defaultValue = "0") String basic_function_class3_code,
            @RequestParam(value = "basic_function_class3_name", defaultValue = "null") String basic_function_class3_name,
            @RequestParam(value = "basic_function_class3_func2_id", defaultValue = "0") int basic_function_class3_func2_id) {
        Result result = null;
        Basic_economics_class3 bu = null;
        try {
            bu = br3.findById(basic_function_class3_id).get();
            bu.setBasic_function_class3_id(basic_function_class3_id);
            bu.setBasic_function_class3_code(basic_function_class3_code);
            bu.setBasic_function_class3_name(basic_function_class3_name);
            bu.setBasic_function_class3_func2_id(basic_function_class3_func2_id);
            br3.save(bu);
            result = new Result(ResultCode.SUCCESS, bu);
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 17 第一次请求查看 Basic_function 表下级有没有数据，没有就删除
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteFunSure")
    public Result deleteFunSure(@RequestParam(value = "basic_function_id", defaultValue = "1") int id) {
        Result result = null;
        //传过来的ID，查询下一级是否有数据,此时是根据外键查询
        List<Basic_economics_class2> class2FuncId = br2.findFuncClass2FuncId(id);
        if (class2FuncId.size() != 0) {
            //如果有数据，就返回确定删除吗
            result = new Result(ResultCode.MAKESURE);
        } else {
            //如果没有数据就根据ID删除
            try {
                br1.deleteById(id);
                result = new Result(ResultCode.SUCCESS);
            } catch (Exception e) {
                result = new Result(ResultCode.FAIL);
            }
        }
        return result;
    }


    /**
     * 18 删除 basic_function 表级下所有的数据
     *
     * @param id
     * @param type
     * @return
     */
    @PostMapping("/deleteBasicFunc")
    public Result deleteBasicFunc(@RequestParam(value = "basic_function_id", defaultValue = "1") int id) {
        Result result = null;
        //确定删除所有数据
        //传过来的ID，查询下一级是否有数据
        List<Basic_economics_class2> class2FuncId = br2.findFuncClass2FuncId(id);
        if (class2FuncId.size() != 0) {
            //遍历数组得到每组2级的数据
            for (Basic_economics_class2 b : class2FuncId) {
                // 拿到二级的数据，再拿到二级的ID，
                int class2_id = b.getBasic_function_class2_id();
                // 根据2级的ID去查找3级的外键集合
                List<Basic_economics_class3> class3FuncId = br3.findFuncClass3FuncId(class2_id);
                // 去删除三级的数据
                if (class3FuncId.size() != 0) {
                    for (Basic_economics_class3 b3 : class3FuncId) {
                        br3.delete(b3);
                    }
                }
                //根据2级的ID删除
                br2.deleteById(class2_id);
            }
        }
        //说明二级已经全部删除，现在删除一级
        try {
            br1.deleteById(id);
            result = new Result(ResultCode.SUCCESS);
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 19 第一次请求查看basic_function_class2 表下级有没有数据，没有就删除
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteBasicFunClass2")
    public Result deleteBasicFunClass2(
            @RequestParam(value = "basic_function_class2_id", defaultValue = "1") int id) {
        Result result = null;
        //传过来的ID，查询下一级是否有数据,此时是根据外键查询
        List<Basic_economics_class3> class3FuncId = br3.findFuncClass3FuncId(id);
        if (class3FuncId.size() != 0) {
            //如果有数据，就返回确定删除吗
            result = new Result(ResultCode.MAKESURE);
        } else {
            //如果没有数据就根据ID删除
            try {
                br2.deleteById(id);
                result = new Result(ResultCode.SUCCESS);
            } catch (Exception e) {
                result = new Result(ResultCode.FAIL);
            }
        }
        return result;
    }

    /**
     * 20 确定删除Basic_function_class2下所有的数据
     */
    @PostMapping("/delete2Sure")
    public Result delete2Sure(
            @RequestParam(value = "basic_function_class2_id", defaultValue = "1") int id) {
        Result result = null;
        //确定删除所有数据
        //传过来的ID，查询下一级是否有数据
        List<Basic_economics_class3> class3FuncId = br3.findFuncClass3FuncId(id);
        if (class3FuncId.size() != 0) {
            //遍历数组得到每组2级的数据
            for (Basic_economics_class3 b : class3FuncId) {
                // 拿到3 级的数据，再删除3 级的数据
                br3.delete(b);
            }
        }
        try {
            //说明3 级已经全部删除，现在删除2 级
            br2.deleteById(id);
            result = new Result(ResultCode.SUCCESS);
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }


    /**
     * 21 根据id删除basic_function_class3表的数据
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteBasicFunClass3")
    public Result deleteBasicFunClass3(@RequestParam(value = "basic_function_class3_id", defaultValue = "1") int basic_function_class3_id) {
        Result result = null;
        List<Basic_economics_class3> all = null;
        // 1，删除之后，查询所有的数据，再得到所有的主键，如果有主键等于ID，就删除失败，如果没有主键等于ID就上次成功，
        try {
            br3.deleteById(basic_function_class3_id);
            all = br3.findAll();
            if (all.size() != 0) {
                //判断获取的数据是否为空
                for (Basic_economics_class3 b : all) {
                    if (b.getBasic_function_class3_id() == basic_function_class3_id) {
                        result = new Result(ResultCode.FAIL);
                    } else {
                        result = new Result(ResultCode.SUCCESS);
                    }
                }
            } else {
                        result = new Result(ResultCode.SUCCESS);
            }
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 22 根据编码和名称查询Basic_function 表级下所有的用户
     *
     * @param
     * @return
     */
    @PostMapping("/findFuncCodeName")
    public Result findFuncCodeName(
            @RequestParam(value = "basic_code", defaultValue = "null") String code,
            @RequestParam(value = "basic_name", defaultValue = "null") String name
    ) {
        Result result = null;
        Map<String, Object> map = new HashMap<>();
        //先根据一级表查询，查到了就返回，没查到就去二级表查询，
        List<Basic_economics> codeAndName = br1.findCodeAndName(code, name);
        if (codeAndName.size() != 0) {
            map.put("codeAndName", codeAndName);
            map.put("basic_lv", "1");
            result = new Result(ResultCode.SUCCESS, map);
        } else {
            List<Basic_economics_class2> class2CodeAndName = br2.findClass2CodeAndName(code, name);
            if (class2CodeAndName.size() != 0) {
                map.put("class2CodeAndName", class2CodeAndName);
                map.put("basic_lv", "2");
                result = new Result(ResultCode.SUCCESS, map);
            } else {
                List<Basic_economics_class3> class3CodeAndName = br3.findClass3CodeAndName(code, name);
                if (class3CodeAndName.size() != 0) {
                    map.put("class3CodeAndName", class3CodeAndName);
                    map.put("basic_lv", "3");
                    result = new Result(ResultCode.SUCCESS, map);
                } else {
                    result = new Result(ResultCode.FAIL);
                }
            }
        }
        return result;
    }
}
