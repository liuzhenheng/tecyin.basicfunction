package com.tecyin.basiclassify.web.target;

import com.tecyin.basiclassify.pojo.target.Allot;
import com.tecyin.basiclassify.repository.target.AllotRepository;
import com.tecyin.basiclassify.service.target.AllotService;
import com.tecyin.basiclassify.utils.FormatTime;
import com.tecyin.basiclassify.utils.Result;
import com.tecyin.basiclassify.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/allot")
public class AllotController {
    @Autowired
    private AllotService allotService;
    @Autowired
    private AllotRepository allotRepository;

    /*
    审核
     */
    @PostMapping("/audits")
    public Result audits(
            @RequestParam(value = "id", defaultValue = "id") int id,//主键
            @RequestParam(value = "state") int state//状态，1，待审核2，已审核3，已终审4，分配中5，已完成
    ) {
        //默认是0, 添加成功就设置为1，待审核，点击审核就返回去，
       /* int state = allot.getState();
        if (state == 1) {
            // 修改状态为6,审核中
            allot.setState(6);
        }*/

        // 去发送到管理员的账号上去，
        //审核，根据state 的状态，如果是1，点击审核，就显示审核中，


        return new Result(ResultCode.SUCCESS);
    }

    /*
     * 分页查询
     */
    @PostMapping("/sort")
    public Result findPage(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "5") int limit
    ) {
        Page<Allot> pageAllot = allotService.findPage(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("pageAllot", pageAllot);
        map.put("con", "0");
        return new Result(ResultCode.SUCCESS, map);
    }

    /*
     * 根据ID查询
     */
    @PostMapping("/findByid")
    public Result findByid(int id) {
        Allot byId = allotService.findById(id);
        if (byId == null) {
            return new Result(ResultCode.FAIL);
        } else {
            return new Result(ResultCode.SUCCESS, byId);
        }
    }

    /*
     * 根据ID删除
     */
    @PostMapping("/deleteById")
    public Result deleteById(int id) {
        Result result = null;
        allotService.deleteById(id);
        List<Allot> all = allotService.findAll();
        for (Allot a : all) {
            if (a.getId() == id) {
                result = new Result(ResultCode.FAIL);
            } else {
                result = new Result(ResultCode.SUCCESS);
            }
        }
        return result;
    }


    /*
     * 增加未分配指标
     */
    @PostMapping("/add")
    public Result addAllot(
            @RequestParam(value = "set_year",required = false) String set_year,//录入日期
            @RequestParam(value = "create_date",defaultValue = "2020-12-20") String create_date,//录入日期
            @RequestParam(value = "sm_name",defaultValue = "null") String sm_name,//摘要
            @RequestParam(value = "pay_money",defaultValue = "null") String pay_money,//金额
            @RequestParam(value = "allotgold", defaultValue = "0") String allotgold,//已分配金额
            @RequestParam(value = "unallotgold", defaultValue = "0") String unallotgold,//未分配金额
            @RequestParam(value = "file_id", required = false) String file_id,//指标文号id
            @RequestParam(value = "file_code", required = false) String file_code,//指标文号代码
            @RequestParam(value = "file_name", required = false) String file_name,//指标文号名称
            @RequestParam(value = "file_lv", required = false) String file_lv,//指标文号lv
            @RequestParam(value = "mb_id", required = false) String mb_id,//归口科室id
            @RequestParam(value = "mb_code", required = false) String mb_code,//归口科室代码
            @RequestParam(value = "mb_name", required = false) String mb_name,//归口科室名称
            @RequestParam(value = "mb_lv", required = false) String mb_lv,//归口科室lv
            @RequestParam(value = "en_id", required = false) String en_id,//预算单位id
            @RequestParam(value = "en_code", required = false) String en_code,//预算单位代码
            @RequestParam(value = "en_name", required = false) String en_name,//预算单位名称
            @RequestParam(value = "en_lv", required = false) String en_lv,//预算单位lv
            @RequestParam(value = "bs_id", required = false) String bs_id,//功能分类id
            @RequestParam(value = "bs_code", required = false) String bs_code,//功能分类代码
            @RequestParam(value = "bs_name", required = false) String bs_name,//功能分类名称
            @RequestParam(value = "bs_lv", required = false) String bs_lv,//功能分类lv
            @RequestParam(value = "bsi_id", required = false) String bsi_id,//部门经济科目id
            @RequestParam(value = "bsi_code", required = false) String bsi_code,//部门经济科目代码
            @RequestParam(value = "bsi_name", required = false) String bsi_name,//部门经济科目名称
            @RequestParam(value = "bsi_lv", required = false) String bsi_lv,//部门经济科目id
            @RequestParam(value = "gov_bsi_id", required = false) String gov_bsi_id,//支出经济科目id
            @RequestParam(value = "gov_bsi_code", required = false) String gov_bsi_code,//支出经济科目代码
            @RequestParam(value = "gov_bsi_name", required = false) String gov_bsi_name,//支出经济科目名称
            @RequestParam(value = "gov_bsi_lv", required = false) String gov_bsi_lv,//支出经济科目lv
            @RequestParam(value = "bo_id", required = false) String bo_id,//指标来源id
            @RequestParam(value = "bo_code", required = false) String bo_code,//指标来源代码
            @RequestParam(value = "bo_name", required = false) String bo_name,//指标来源名称
            @RequestParam(value = "bo_lv", required = false) String bo_lv,//指标来源lv
            @RequestParam(value = "mk_id", required = false) String mk_id,//资金性质id
            @RequestParam(value = "mk_code", required = false) String mk_code,//资金性质代码
            @RequestParam(value = "mk_name", required = false) String mk_name,//资金性质名称
            @RequestParam(value = "mk_lv", required = false) String mk_lv,//资金性质lv
            @RequestParam(value = "bis_id", required = false) String bis_id,//项目id
            @RequestParam(value = "bis_code", required = false) String bis_code,//项目代码
            @RequestParam(value = "bis_name", required = false) String bis_name,//项目名称
            @RequestParam(value = "bis_lv", required = false) String bis_lv,//项目lv
            @RequestParam(value = "hold1_id", required = false) String hold1_id,//支出结构id
            @RequestParam(value = "hold1_code", required = false) String hold1_code,//支出结构代码
            @RequestParam(value = "hold1_name", required = false) String hold1_name,//支出结构名称
            @RequestParam(value = "hold1_lv", required = false) String hold1_lv,//支出结构lv
            @RequestParam(value = "pk_id", required = false) String pk_id,//支付方式id
            @RequestParam(value = "pk_code", required = false) String pk_code,//支付方式代码
            @RequestParam(value = "pk_name", required = false) String pk_name,//支付方式名称
            @RequestParam(value = "pk_lv", required = false) String pk_lv,//支付方式lv
            @RequestParam(value = "qksfbs_id", required = false) String qksfbs_id,//扶贫标识id
            @RequestParam(value = "qksfbs_code", required = false) String qksfbs_code,//扶贫标识编码
            @RequestParam(value = "qksfbs_name", required = false) String qksfbs_name,//扶贫标识名称
            @RequestParam(value = "qksfbs_lv", required = false) String qksfbs_lv,//扶贫标识lv
            @RequestParam(value = "zdzjjqpt_id", required = false) String zdzjjqpt_id,//是否直达资金的地方对应安排id
            @RequestParam(value = "zdzjjqpt_code", required = false) String zdzjjqpt_code,//是否直达资金的地方对应安排编码
            @RequestParam(value = "zdzjjqpt_name", required = false) String zdzjjqpt_name,//是否直达资金的地方对应安排名称
            @RequestParam(value = "zdzjjqpt_lv", required = false) String zdzjjqpt_lv,//是否直达资金的地方对应安排lv
            @RequestParam(value = "directfunds_id", required = false) String directfunds_id,//直达资金标识id
            @RequestParam(value = "directfunds_code", required = false) String directfunds_code,//直达资金标识编码
            @RequestParam(value = "directfunds_name", required = false) String directfunds_name,//直达资金标识名称
            @RequestParam(value = "directfunds_lv", required = false) String directfunds_lv,//直达资金标识lv
            @RequestParam(value = "subsidy_id", required = false) String subsidy_id,//是否补贴到人到企业id
            @RequestParam(value = "subsidy_code", required = false) String subsidy_code,//是否补贴到人到企业编码
            @RequestParam(value = "subsidy_name", required = false) String subsidy_name,//是否补贴到人到企业名称
            @RequestParam(value = "subsidy_lv", required = false) String subsidy_lv,//是否补贴到人到企业lv
            @RequestParam(value = "export", defaultValue = "0") String export,//是否已经从数据库导出
            @RequestParam(value = "state", defaultValue = "0") String state//状态，1，待审核2，已审核3，已终审4，分配中5，已完成
    ) {
        //根据得到的参数，调用增加功能，
        //根据得到的指标文号的定义到了那个接口，就定义到了/reference/reference这个控制层，然后根据lv的等级就访问不同的表
        Allot a = new Allot();
        int create_dateInt = FormatTime.transForMilliSecondByTim(create_date);//年度的字符串转成int类型的时间戳 create_date
        a.setCreate_date(create_dateInt);
        a.setSm_name(sm_name);
        a.setPay_money(pay_money);
        a.setAllotgold(allotgold);
        int pay = Integer.parseInt(pay_money);
        int allot = Integer.parseInt(allotgold);
        int unallot = pay - allot;
        String unallotString = String.valueOf(unallot);
        a.setUnallotgold(unallotString);
        a.setFile_id(file_id);
        a.setFile_code(file_code);
        a.setFile_name(file_name);
        a.setFile_lv(file_lv);
        a.setMb_id(mb_id);//归口科室id
        a.setMb_code(mb_code);
        a.setMb_name(mb_name);
        a.setMb_lv(mb_lv);
        a.setEn_id(en_id);//预算单位id}
        a.setEn_code(en_code);
        a.setEn_name(en_name);
        a.setEn_lv(en_lv);
        a.setBs_id(bs_id);//功能分类id
        a.setBs_code(bs_code);
        a.setBs_name(bs_name);
        a.setBs_lv(bs_lv);
        a.setBsi_id(bsi_id);//部门经济科目id
        a.setBsi_code(bsi_code);
        a.setBsi_name(bsi_name);
        a.setBsi_lv(bsi_lv);
        a.setGov_bsi_id(gov_bsi_id);//支出经济科目id
        a.setGov_bsi_code(gov_bsi_code);
        a.setGov_bsi_name(gov_bsi_name);
        a.setGov_bsi_lv(gov_bsi_lv);
        a.setBo_id(bo_id);//指标来源id
        a.setBo_code(bo_code);
        a.setBo_name(bo_name);
        a.setBo_lv(bo_lv);
        a.setMk_id(mk_id);//资金性质id
        a.setMk_code(mk_code);
        a.setMk_name(mk_name);
        a.setMk_lv(mk_lv);
        a.setBis_id(bis_id);//项目id
        a.setBis_code(bis_code);
        a.setBis_name(bis_name);
        a.setBis_lv(bis_lv);
        a.setHold1_id(hold1_id);//支出结构id
        a.setHold1_code(hold1_code);
        a.setHold1_name(hold1_name);
        a.setHold1_lv(hold1_lv);
        a.setPk_id(pk_id);//支付方式id
        a.setPk_code(pk_code);
        a.setPk_name(pk_name);
        a.setPk_lv(pk_lv);
        a.setQksfbs_id(qksfbs_id);//扶贫标识id
        a.setQksfbs_code(qksfbs_code);
        a.setQksfbs_name(qksfbs_name);
        a.setQksfbs_lv(qksfbs_lv);
        a.setZdzjjqpt_id(zdzjjqpt_id);//是否直达资金的地方对应安排id
        a.setZdzjjqpt_code(zdzjjqpt_code);
        a.setZdzjjqpt_name(zdzjjqpt_name);
        a.setZdzjjqpt_lv(zdzjjqpt_lv);
        a.setDirectfunds_id(directfunds_id);//直达资金标识id
        a.setDirectfunds_code(directfunds_code);
        a.setDirectfunds_name(directfunds_name);
        a.setDirectfunds_lv(directfunds_lv);
        a.setSubsidy_id(subsidy_id);//是否补贴到人到企业id
        a.setSubsidy_code(subsidy_code);
        a.setSubsidy_name(subsidy_name);
        a.setSubsidy_lv(subsidy_lv);
        a.setExport(export);//是否已经从数据库导出,0是没有导出，1是已经导出过
        a.setState("1");
        allotRepository.save(a);
        return new Result(ResultCode.SUCCESS, a);
    }
    
    
    /*@PostMapping("/add")
    public Result addAllot(
            @RequestParam(value = "create_date") String create_date,//录入日期
            @RequestParam(value = "sm_name") String sm_name,//摘要
            @RequestParam(value = "pay_money") String pay_money,//金额
            @RequestParam(value = "allotgold",defaultValue = "0") String allotgold,//已分配金额
            @RequestParam(value = "unallotgold",defaultValue = "0") String unallotgold,//未分配金额
            @RequestParam(value = "entry") String entry,//录入者
            @RequestParam(value = "audit") String audit,//审核者
            @RequestParam(value = "auditday") String auditday,//审核日期
            @RequestParam(value = "last") String last,//终审者
            @RequestParam(value = "lastday") String lastday,//终审日期
            @RequestParam(value = "file_id") String file_id,//指标文号id
            @RequestParam(value = "file_code") String file_code,//指标文号代码
            @RequestParam(value = "file_name") String file_name,//指标文号名称
            @RequestParam(value = "file_lv") String file_lv,//指标文号lv
            @RequestParam(value = "mb_id") String mb_id,//归口科室id
            @RequestParam(value = "mb_code") String mb_code,//归口科室代码
            @RequestParam(value = "mb_name") String mb_name,//归口科室名称
            @RequestParam(value = "mb_lv") String mb_lv,//归口科室lv
            @RequestParam(value = "en_id") String en_id,//预算单位id
            @RequestParam(value = "en_code") String en_code,//预算单位代码
            @RequestParam(value = "en_name") String en_name,//预算单位名称
            @RequestParam(value = "en_lv") String en_lv,//预算单位lv
            @RequestParam(value = "bs_id") String bs_id,//功能分类id
            @RequestParam(value = "bs_code") String bs_code,//功能分类代码
            @RequestParam(value = "bs_name") String bs_name,//功能分类名称
            @RequestParam(value = "bs_lv") String bs_lv,//功能分类lv
            @RequestParam(value = "bsi_id") String bsi_id,//部门经济科目id
            @RequestParam(value = "bsi_code") String bsi_code,//部门经济科目代码
            @RequestParam(value = "bsi_name") String bsi_name,//部门经济科目名称
            @RequestParam(value = "bsi_lv") String bsi_lv,//部门经济科目id
            @RequestParam(value = "gov_bsi_id") String gov_bsi_id,//支出经济科目id
            @RequestParam(value = "gov_bsi_code") String gov_bsi_code,//支出经济科目代码
            @RequestParam(value = "gov_bsi_name") String gov_bsi_name,//支出经济科目名称
            @RequestParam(value = "gov_bsi_lv") String gov_bsi_lv,//支出经济科目lv
            @RequestParam(value = "bo_id") String bo_id,//指标来源id
            @RequestParam(value = "bo_code") String bo_code,//指标来源代码
            @RequestParam(value = "bo_name") String bo_name,//指标来源名称
            @RequestParam(value = "bo_lv") String bo_lv,//指标来源lv
            @RequestParam(value = "mk_id") String mk_id,//资金性质id
            @RequestParam(value = "mk_code") String mk_code,//资金性质代码
            @RequestParam(value = "mk_name") String mk_name,//资金性质名称
            @RequestParam(value = "mk_lv") String mk_lv,//资金性质lv
            @RequestParam(value = "bis_id") String bis_id,//项目id
            @RequestParam(value = "bis_code") String bis_code,//项目代码
            @RequestParam(value = "bis_name") String bis_name,//项目名称
            @RequestParam(value = "bis_lv") String bis_lv,//项目lv
            @RequestParam(value = "hold1_id") String hold1_id,//支出结构id
            @RequestParam(value = "hold1_code") String hold1_code,//支出结构代码
            @RequestParam(value = "hold1_name") String hold1_name,//支出结构名称
            @RequestParam(value = "hold1_lv") String hold1_lv,//支出结构lv
            @RequestParam(value = "pk_id") String pk_id,//支付方式id
            @RequestParam(value = "pk_code") String pk_code,//支付方式代码
            @RequestParam(value = "pk_name") String pk_name,//支付方式名称
            @RequestParam(value = "pk_lv" ) String pk_lv,//支付方式lv
            @RequestParam(value = "qksfbs_id") String qksfbs_id,//扶贫标识id
            @RequestParam(value = "qksfbs_code") String qksfbs_code,//扶贫标识编码
            @RequestParam(value = "qksfbs_name") String qksfbs_name,//扶贫标识名称
            @RequestParam(value = "qksfbs_lv") String qksfbs_lv,//扶贫标识lv
            @RequestParam(value = "zdzjjqpt_id") String zdzjjqpt_id,//是否直达资金的地方对应安排id
            @RequestParam(value = "zdzjjqpt_code") String zdzjjqpt_code,//是否直达资金的地方对应安排编码
            @RequestParam(value = "zdzjjqpt_name") String zdzjjqpt_name,//是否直达资金的地方对应安排名称
            @RequestParam(value = "zdzjjqpt_lv") String zdzjjqpt_lv,//是否直达资金的地方对应安排lv
            @RequestParam(value = "directfunds_id") String directfunds_id,//直达资金标识id
            @RequestParam(value = "directfunds_code") String directfunds_code,//直达资金标识编码
            @RequestParam(value = "directfunds_name") String directfunds_name,//直达资金标识名称
            @RequestParam(value = "directfunds_lv") String directfunds_lv,//直达资金标识lv
            @RequestParam(value = "subsidy_id") String subsidy_id,//是否补贴到人到企业id
            @RequestParam(value = "subsidy_code") String subsidy_code,//是否补贴到人到企业编码
            @RequestParam(value = "subsidy_name") String subsidy_name,//是否补贴到人到企业名称
            @RequestParam(value = "subsidy_lv") String subsidy_lv,//是否补贴到人到企业lv
            @RequestParam(value = "export",defaultValue = "0") String export,//是否已经从数据库导出
            @RequestParam(value = "state",defaultValue = "0") String state//状态，1，待审核2，已审核3，已终审4，分配中5，已完成
    ) {
        //根据得到的参数，调用增加功能，
        //根据得到的指标文号的定义到了那个接口，就定义到了/reference/reference这个控制层，然后根据lv的等级就访问不同的表
        Allot allot = allotService.addService(create_date, sm_name, pay_money, allotgold, unallotgold,entry,audit,auditday,last,lastday,
                file_id, file_code, file_name, file_lv, mb_id, mb_code, mb_name, mb_lv, en_id,
                en_code, en_name, en_lv, bs_id, bs_code, bs_name, bs_lv, bsi_id, bsi_code, bsi_name, bsi_lv, gov_bsi_id,
                gov_bsi_code, gov_bsi_name, gov_bsi_lv, bo_id, bo_code, bo_name, bo_lv, mk_id, mk_code, mk_name, mk_lv, bis_id,
                bis_code, bis_name, bis_lv, hold1_id, hold1_code, hold1_name, hold1_lv, pk_id, pk_code, pk_name, pk_lv, qksfbs_id,
                qksfbs_code, qksfbs_name, qksfbs_lv, zdzjjqpt_id, zdzjjqpt_code, zdzjjqpt_name, zdzjjqpt_lv, directfunds_id,
                directfunds_code, directfunds_name, directfunds_lv, subsidy_id, subsidy_code, subsidy_name, subsidy_lv, export, state
        );
        return new Result(ResultCode.SUCCESS, allot);
    }*/

    /*
     * 修改指标根据ID
     */
    /*@PostMapping("/update")
    public Result updateAllot(
            @RequestParam(value = "id") int id,//主键
//            @RequestParam(value = "set_year") String set_year,//年度
//            @RequestParam(value = "currentime") String currentime,//获取系统当前时间
            @RequestParam(value = "create_date") String create_date,//录入日期
            @RequestParam(value = "sm_name") String sm_name,//摘要
            @RequestParam(value = "pay_money") int pay_money,//金额
            @RequestParam(value = "allotgold",defaultValue = "0") int allotgold,//已分配金额
            @RequestParam(value = "unallotgold",defaultValue = "0") int unallotgold,//未分配金额
            @RequestParam(value = "entry") String entry,//录入者
            @RequestParam(value = "audit") String audit,//审核者
            @RequestParam(value = "auditday") String auditday,//审核日期
            @RequestParam(value = "last") String last,//终审者
            @RequestParam(value = "lastday") String lastday,//终审日期
            @RequestParam(value = "file_id") int file_id,//指标文号id
            @RequestParam(value = "file_code") String file_code,//指标文号代码
            @RequestParam(value = "file_name") String file_name,//指标文号名称
            @RequestParam(value = "file_lv") int file_lv,//指标文号lv
            @RequestParam(value = "mb_id") int mb_id,//归口科室id
            @RequestParam(value = "mb_code") String mb_code,//归口科室代码
            @RequestParam(value = "mb_name") String mb_name,//归口科室名称
            @RequestParam(value = "mb_lv") int mb_lv,//归口科室lv
            @RequestParam(value = "en_id") int en_id,//预算单位id
            @RequestParam(value = "en_code") String en_code,//预算单位代码
            @RequestParam(value = "en_name") String en_name,//预算单位名称
            @RequestParam(value = "en_lv") int en_lv,//预算单位lv
            @RequestParam(value = "bs_id") int bs_id,//功能分类id
            @RequestParam(value = "bs_code") String bs_code,//功能分类代码
            @RequestParam(value = "bs_name") String bs_name,//功能分类名称
            @RequestParam(value = "bs_lv") int bs_lv,//功能分类lv
            @RequestParam(value = "bsi_id") int bsi_id,//部门经济科目id
            @RequestParam(value = "bsi_code") String bsi_code,//部门经济科目代码
            @RequestParam(value = "bsi_name") String bsi_name,//部门经济科目名称
            @RequestParam(value = "bsi_lv") int bsi_lv,//部门经济科目id
            @RequestParam(value = "gov_bsi_id") int gov_bsi_id,//支出经济科目id
            @RequestParam(value = "gov_bsi_code") String gov_bsi_code,//支出经济科目代码
            @RequestParam(value = "gov_bsi_name") String gov_bsi_name,//支出经济科目名称
            @RequestParam(value = "gov_bsi_lv") int gov_bsi_lv,//支出经济科目lv
            @RequestParam(value = "bo_id") int bo_id,//指标来源id
            @RequestParam(value = "bo_code") String bo_code,//指标来源代码
            @RequestParam(value = "bo_name") String bo_name,//指标来源名称
            @RequestParam(value = "bo_lv") int bo_lv,//指标来源lv
            @RequestParam(value = "mk_id") int mk_id,//资金性质id
            @RequestParam(value = "mk_code") String mk_code,//资金性质代码
            @RequestParam(value = "mk_name") String mk_name,//资金性质名称
            @RequestParam(value = "mk_lv") int mk_lv,//资金性质lv
            @RequestParam(value = "bis_id") int bis_id,//项目id
            @RequestParam(value = "bis_code") String bis_code,//项目代码
            @RequestParam(value = "bis_name") String bis_name,//项目名称
            @RequestParam(value = "bis_lv") int bis_lv,//项目lv
            @RequestParam(value = "hold1_id") int hold1_id,//支出结构id
            @RequestParam(value = "hold1_code") String hold1_code,//支出结构代码
            @RequestParam(value = "hold1_name") String hold1_name,//支出结构名称
            @RequestParam(value = "hold1_lv") int hold1_lv,//支出结构lv
            @RequestParam(value = "pk_id") int pk_id,//支付方式id
            @RequestParam(value = "pk_code") String pk_code,//支付方式代码
            @RequestParam(value = "pk_name") String pk_name,//支付方式名称
            @RequestParam(value = "pk_lv") int pk_lv,//支付方式lv
            @RequestParam(value = "qksfbs_id") int qksfbs_id,//扶贫标识id
            @RequestParam(value = "qksfbs_code") String qksfbs_code,//扶贫标识编码
            @RequestParam(value = "qksfbs_name") String qksfbs_name,//扶贫标识名称
            @RequestParam(value = "qksfbs_lv") int qksfbs_lv,//扶贫标识lv
            @RequestParam(value = "zdzjjqpt_id") int zdzjjqpt_id,//是否直达资金的地方对应安排id
            @RequestParam(value = "zdzjjqpt_code") String zdzjjqpt_code,//是否直达资金的地方对应安排编码
            @RequestParam(value = "zdzjjqpt_name") String zdzjjqpt_name,//是否直达资金的地方对应安排名称
            @RequestParam(value = "zdzjjqpt_lv") int zdzjjqpt_lv,//是否直达资金的地方对应安排lv
            @RequestParam(value = "directfunds_id") int directfunds_id,//直达资金标识id
            @RequestParam(value = "directfunds_code") String directfunds_code,//直达资金标识编码
            @RequestParam(value = "directfunds_name") String directfunds_name,//直达资金标识名称
            @RequestParam(value = "directfunds_lv") int directfunds_lv,//直达资金标识lv
            @RequestParam(value = "subsidy_id") int subsidy_id,//是否补贴到人到企业id
            @RequestParam(value = "subsidy_code") String subsidy_code,//是否补贴到人到企业编码
            @RequestParam(value = "subsidy_name") String subsidy_name,//是否补贴到人到企业名称
            @RequestParam(value = "subsidy_lv") int subsidy_lv,//是否补贴到人到企业lv
            @RequestParam(value = "export",defaultValue = "0") int export,//是否已经从数据库导出
            @RequestParam(value = "state",defaultValue = "0") int state//状态，1，待审核2，已审核3，已终审4，分配中5，已完成
    ) {
        //根据得到的参数，调用增加功能，
        //根据得到的指标文号的定义到了那个接口，就定义到了/reference/reference这个控制层，然后根据lv的等级就访问不同的表
        Allot allot = allotService.updateService(id, create_date, sm_name, pay_money, allotgold, unallotgold, entry,
                audit, auditday, last, lastday, file_id, file_code, file_name, file_lv, mb_id, mb_code, mb_name, mb_lv, en_id,
                en_code, en_name, en_lv, bs_id, bs_code, bs_name, bs_lv, bsi_id, bsi_code, bsi_name, bsi_lv, gov_bsi_id,
                gov_bsi_code, gov_bsi_name, gov_bsi_lv, bo_id, bo_code, bo_name, bo_lv, mk_id, mk_code, mk_name, mk_lv, bis_id,
                bis_code, bis_name, bis_lv, hold1_id, hold1_code, hold1_name, hold1_lv, pk_id, pk_code, pk_name, pk_lv, qksfbs_id,
                qksfbs_code, qksfbs_name, qksfbs_lv, zdzjjqpt_id, zdzjjqpt_code, zdzjjqpt_name, zdzjjqpt_lv, directfunds_id,
                directfunds_code, directfunds_name, directfunds_lv, subsidy_id, subsidy_code, subsidy_name, subsidy_lv, export, state
        );

        return new Result(ResultCode.SUCCESS, allot);
    }*/

}
