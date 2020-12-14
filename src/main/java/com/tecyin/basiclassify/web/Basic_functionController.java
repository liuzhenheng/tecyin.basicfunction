package com.tecyin.basiclassify.web;

import com.tecyin.basiclassify.pojo.Basic_function;
import com.tecyin.basiclassify.pojo.Basic_function_class2;
import com.tecyin.basiclassify.pojo.Basic_function_class3;
import com.tecyin.basiclassify.repository.Basic_functionRepository;
import com.tecyin.basiclassify.repository.Basic_function_class2Repository;
import com.tecyin.basiclassify.repository.Basic_function_class3Repository;
import com.tecyin.basiclassify.utils.Result;
import com.tecyin.basiclassify.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/function")
public class Basic_functionController {
    @Autowired
    private Basic_functionRepository basic_functionRepository;
    @Autowired
    private Basic_function_class2Repository basic_function_class2Repository;
    @Autowired
    private Basic_function_class3Repository basic_function_class3Repository;

    /**
     * 根据id查询Basic_function表
     *
     * @param id
     * @return
     */
    @PostMapping("/findOneBasicFunc")
    public Result findOneBasicFunc(@RequestParam("basic_function_id") int id) {
        Basic_function byId = basic_functionRepository.findById(id).get();
        //判断获取的数据是否为空
        if (byId != null) {
            return new Result(ResultCode.SUCCESS, byId);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 分页查询Basic_function表
     *
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/findPage")
    public Page<Basic_function> findPage(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return basic_functionRepository.findAll(pageable);

    }

    /**
     * 根据外键查询Basic_function 表外键
     *
     * @param id
     * @return
     */
    @PostMapping("/findBasicFuncDataId")
    public Result findBasicFuncDataId(@RequestParam("basic_function_data_id") int id) {
        List<Basic_function> funcDataId = basic_functionRepository.findByDataid(id);
        //判断获取的数据是否为空
        if (funcDataId != null) {
            return new Result(ResultCode.SUCCESS, funcDataId);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 查询Basic_function 表的所有
     *
     * @return
     */
    @PostMapping("/findBasicFunctionAll")
    public Result findBasicFunctionAll() {
        List<Basic_function> all = basic_functionRepository.findAll();
        Map<String, Object> map = new HashMap<>();
        //判断获取的数据是否为空
        if (all != null) {
            return new Result(ResultCode.SUCCESS, all);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }


    /**
     * 根据ID查询Basic_function_class2 表
     *
     * @param id
     * @return
     */
    @PostMapping("/findOneBasicFuncCla2")
    public Result findOneBasicFuncCla2(@RequestParam("basic_function_class2_id") int id) {
        Basic_function_class2 byId = basic_function_class2Repository.findById(id).get();
        //判断获取的数据是否为空
        if (byId != null) {
            return new Result(ResultCode.SUCCESS, byId);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 根据外键查询Basic_function_class2 表外键
     *
     * @param id
     * @return
     */
    @PostMapping("/findBasicFuncCla2FuncId")
    public Result findBasicFuncCla2FuncId(@RequestParam("basic_function_class2_func_id") int id) {
        List<Basic_function_class2> funcClass2FuncId = basic_function_class2Repository.findFuncClass2FuncId(id);
        //判断获取的数据是否为空
        if (funcClass2FuncId != null) {
            return new Result(ResultCode.SUCCESS, funcClass2FuncId);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 查询根据外键查询Basic_function_class2表的所有
     *
     * @return
     */
    @PostMapping("/findBasicFuncClass2All")
    public Result findBasicFuncClass2All() {
        List<Basic_function_class2> all = basic_function_class2Repository.findAll();
        //判断获取的数据是否为空
        if (all != null) {
            return new Result(ResultCode.SUCCESS, all);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 根据ID查询Basic_function_class3 表
     *
     * @param id
     * @return
     */
    @PostMapping("/findOneBasicFuncCla3")
    public Result findOneBasicFuncCla3(@RequestParam("basic_function_class3_id") int id) {
        Basic_function_class3 byId = basic_function_class3Repository.findById(id).get();
        //判断获取的数据是否为空
        if (byId != null) {
            return new Result(ResultCode.SUCCESS, byId);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 根据外键查询Basic_function_class3 表外键
     *
     * @param id
     * @return
     */
    @PostMapping("/findBasicFuncCla3FuncId")
    public Result findBasicFuncCla3FuncId(@RequestParam("basic_function_class3_func2_id") int id) {
        List<Basic_function_class3> funcClass3FuncId = basic_function_class3Repository.findFuncClass3FuncId(id);
        //判断获取的数据是否为空
        if (funcClass3FuncId != null) {
            return new Result(ResultCode.SUCCESS, funcClass3FuncId);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 查询根据外键查询Basic_function_class2表的所有
     *
     * @return
     */
    @PostMapping("/findBasicFuncClass3All")
    public Result findBasicFuncClass3All() {
        List<Basic_function_class3> all = basic_function_class3Repository.findAll();
        //判断获取的数据是否为空
        if (all != null) {
            return new Result(ResultCode.SUCCESS, all);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 增加Basic_function表的对象
     *
     * @param basic_function
     * @return
     * @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "5") int size
     */
    @PostMapping("/addBasicFunc")
    public Result addBasicFunc(@RequestParam(value = "basic_function_code", defaultValue = "0") String basic_function_code,
                               @RequestParam(value = "basic_function_name", defaultValue = "null") String basic_function_name,
                               @RequestParam(value = "basic_function_data_id", defaultValue = "0") int basic_function_data_id) {

        Basic_function b = new Basic_function();
        b.setBasic_function_code(basic_function_code);
        b.setBasic_function_name(basic_function_name);
        b.setBasic_function_data_id(basic_function_data_id);
        Basic_function saveResult = basic_functionRepository.save(b);
        //判断获取的数据是否为空
        if (saveResult != null) {
            return new Result(ResultCode.SUCCESS, saveResult);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 增加basic_function_class2表的对象
     *
     * @param basic_function_class2
     * @return
     */
    @PostMapping("/addBasicFuncCla2")
    public Result addBasicFuncCla2(@RequestParam(value = "basic_function_class2_code", defaultValue = "0") String basic_function_class2_code,
                                   @RequestParam(value = "basic_function_class2_name", defaultValue = "null") String basic_function_class2_name,
                                   @RequestParam(value = "basic_function_class2_func_id", defaultValue = "0") int basic_function_class2_func_id) {
        Basic_function_class2 bc = new Basic_function_class2();
        bc.setBasic_function_class2_code(basic_function_class2_code);
        bc.setBasic_function_class2_name(basic_function_class2_name);
        bc.setBasic_function_class2_func_id(basic_function_class2_func_id);
        Basic_function_class2 saveResult = basic_function_class2Repository.save(bc);
        //判断获取的数据是否为空
        if (saveResult != null) {
            return new Result(ResultCode.SUCCESS, saveResult);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 增加basic_function_class3表的对象
     *
     * @param basic_function_class3
     * @return
     */
    @PostMapping("/addBasicFuncCla3")
    public Result addBasicFuncCla3(@RequestParam(value = "basic_function_class3_code", defaultValue = "0") String basic_function_class3_code,
                                   @RequestParam(value = "basic_function_class3_name", defaultValue = "null") String basic_function_class3_name,
                                   @RequestParam(value = "basic_function_class3_func2_id", defaultValue = "0") int basic_function_class3_func2_id) {
        Basic_function_class3 bc3 = new Basic_function_class3();
        bc3.setBasic_function_class3_code(basic_function_class3_code);
        bc3.setBasic_function_class3_name(basic_function_class3_name);
        bc3.setBasic_function_class3_func2_id(basic_function_class3_func2_id);
        Basic_function_class3 saveResult = basic_function_class3Repository.save(bc3);
        //判断获取的数据是否为空
        if (saveResult != null) {
            return new Result(ResultCode.SUCCESS, saveResult);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }


    /**
     * 修改Basic_function表的数据
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
        Basic_function bu = new Basic_function();
        bu.setBasic_function_id(basic_function_id);
        bu.setBasic_function_code(basic_function_code);
        bu.setBasic_function_name(basic_function_name);
        bu.setBasic_function_data_id(basic_function_data_id);
        Basic_function updateResult = basic_functionRepository.save(bu);
        //判断获取的数据是否为空
        if (updateResult != null) {
            return new Result(ResultCode.SUCCESS, updateResult);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 修改basic_function_class2表的数据
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
        Basic_function_class2 bu = new Basic_function_class2();
        bu.setBasic_function_class2_id(basic_function_class2_id);
        bu.setBasic_function_class2_code(basic_function_class2_code);
        bu.setBasic_function_class2_name(basic_function_class2_name);
        bu.setBasic_function_class2_func_id(basic_function_class2_func_id);
        Basic_function_class2 updateResult = basic_function_class2Repository.save(bu);
        //判断获取的数据是否为空
        if (updateResult != null) {
            return new Result(ResultCode.SUCCESS, updateResult);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 修改basic_function_class3表的数据
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
        Basic_function_class3 bu = new Basic_function_class3();
        bu.setBasic_function_class3_id(basic_function_class3_id);
        bu.setBasic_function_class3_code(basic_function_class3_code);
        bu.setBasic_function_class3_name(basic_function_class3_name);
        bu.setBasic_function_class3_func2_id(basic_function_class3_func2_id);
        Basic_function_class3 updateResult = basic_function_class3Repository.save(bu);
        //判断获取的数据是否为空
        if (updateResult != null) {
            return new Result(ResultCode.SUCCESS, updateResult);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    /**
     * 删除 basic_function 表级下所有的数据
     * * 确定删除所有数据 type=0
     * * 不删除所有数据 type=1
     *
     * @param id
     * @param type
     * @return
     */
    @PostMapping("/deleteFuncSure")
    public Result deleteFuncSure(@RequestParam("basic_function_id") int id, @RequestParam("type") int type) {
        Result result = null;
        if (type == 0) {
            //确定删除所有数据
            //传过来的ID，查询下一级是否有数据
            List<Basic_function_class2> class2FuncId = basic_function_class2Repository.findFuncClass2FuncId(id);
            //遍历数组得到每组2级的数据
            for (Basic_function_class2 b : class2FuncId) {
                // 拿到二级的数据，再拿到二级的ID，
                int class2_id = b.getBasic_function_class2_id();
                // 根据2级的ID去查找3级的外键集合
                List<Basic_function_class3> class3FuncId = basic_function_class3Repository.findFuncClass3FuncId(class2_id);
                // 去删除三级的数据
                for (Basic_function_class3 b3 : class3FuncId) {
                    basic_function_class3Repository.delete(b3);
                }
                //根据2级的ID删除
                basic_function_class2Repository.deleteById(class2_id);
            }
            //说明二级已经全部删除，现在删除一级
            basic_functionRepository.deleteById(id);
            result = new Result(ResultCode.SUCCESS);
        } else if (type == 1) {
            //不删除所有数据
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }


    /**
     * 问是否要删除 Basic_function 吗？
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteFunSure")
    public Result deleteFunSure(@RequestParam("basic_function_id") int id) {
        //传过来的ID，查询下一级是否有数据,此时是根据外键查询
        List<Basic_function_class2> class2FuncId = basic_function_class2Repository.findFuncClass2FuncId(id);
        if (class2FuncId.size() != 0) {
            //如果有数据，就返回确定删除吗
            return new Result(ResultCode.MAKESURE);
        } else {
            //如果没有数据就根据ID删除
            basic_functionRepository.deleteById(id);
            return new Result(ResultCode.SUCCESS);
        }
    }


    /**
     * 问是否要删除Basic_function_class2
     *  type=0  确定删除所有数据
     *  type=1  不删除所有数据
     */
    @PostMapping("/delete2Sure")
    public Result delete2Sure(
            @RequestParam("basic_function_class2_id") int id,
            @RequestParam("type") int type) {
        Result result = null;
        if (type == 0) {
            //确定删除所有数据
            //传过来的ID，查询下一级是否有数据
            List<Basic_function_class3> class3FuncId = basic_function_class3Repository.findFuncClass3FuncId(id);
            //遍历数组得到每组2级的数据
            for (Basic_function_class3 b : class3FuncId) {
                // 拿到3 级的数据，再删除3 级的数据
                basic_function_class3Repository.delete(b);
            }
            //说明3 级已经全部删除，现在删除2 级
            basic_function_class2Repository.deleteById(id);
            result = new Result(ResultCode.SUCCESS);
        } else if (type == 1) {
            //不删除所有数据
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 删除basic_function_class2 表下所有的数据
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteBasicFunClass2")
    public Result deleteBasicFunClass2(@RequestParam("basic_function_class2_id") int id) {
        //传过来的ID，查询下一级是否有数据,此时是根据外键查询
        List<Basic_function_class3> class3FuncId = basic_function_class3Repository.findFuncClass3FuncId(id);
        if (class3FuncId.size() != 0) {
            //如果有数据，就返回确定删除吗
            return new Result(ResultCode.MAKESURE);
        } else {
            //如果没有数据就根据ID删除
            basic_functionRepository.deleteById(id);
            return new Result(ResultCode.SUCCESS);
        }
    }


    /**
     * 根据id删除basic_function_class3表的数据
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteBasicFunClass3")
    public Result deleteBasicFunClass3(@RequestParam("basic_function_class3_id") int id) {
        Result resultId = null;
        // 1，删除之后，查询所有的数据，再得到所有的主键，如果有主键等于ID，就删除失败，如果没有主键等于ID就上次成功，
        basic_function_class3Repository.deleteById(id);
        List<Basic_function_class3> all = basic_function_class3Repository.findAll();
        //判断获取的数据是否为空
        for (Basic_function_class3 b : all) {
            if (b.getBasic_function_class3_id() == id) {
                resultId = new Result(ResultCode.FAIL);
            } else {
                resultId = new Result(ResultCode.SUCCESS);
            }
        }
        return resultId;
    }
}
