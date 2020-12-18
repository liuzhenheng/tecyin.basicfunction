package com.tecyin.basiclassify.web.target;

import com.tecyin.basiclassify.pojo.target.Allot;
import com.tecyin.basiclassify.repository.target.AllotRepository;
import com.tecyin.basiclassify.utils.FormatTime;
import com.tecyin.basiclassify.utils.Result;
import com.tecyin.basiclassify.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allot")
public class AllotController {
    @Autowired
    private AllotRepository allotRepository;

    @PostMapping("/add")
    public Result addAllot(
            @RequestParam(value = "set_year", defaultValue = "2020-12-20") String set_year,//年度
            @RequestParam(value = "currentime", defaultValue = "2020-12-20") String currentime,//获取系统当前时间
            @RequestParam(value = "create_date", defaultValue = "2020-12-20") String create_date,//录入日期
            @RequestParam(value = "sm_name", defaultValue = "null") String sm_name,//摘要
            @RequestParam(value = "pay_money", defaultValue = "0") int pay_money,//金额
            @RequestParam(value = "allotgold", defaultValue = "0") int allotgold,//已分配金额
            @RequestParam(value = "unallotgold", defaultValue = "0") int unallotgold,//未分配金额
            @RequestParam(value = "entry", defaultValue = "null") String entry,//录入者
            @RequestParam(value = "audit", defaultValue = "null") String audit,//审核者
            @RequestParam(value = "auditday", defaultValue = "2020-12-20") String auditday,//审核日期
            @RequestParam(value = "last", defaultValue = "null") String last,//终审者
            @RequestParam(value = "lastday", defaultValue = "2020-12-20") String lastday,//终审日期
            @RequestParam(value = "file_id", defaultValue = "0") int file_id,//指标文号id
            @RequestParam(value = "file_code", defaultValue = "null") String file_code,//指标文号代码
            @RequestParam(value = "file_name", defaultValue = "null") String file_name,//指标文号名称
            @RequestParam(value = "file_lv", defaultValue = "0") int file_lv,//指标文号lv
            @RequestParam(value = "mb_id", defaultValue = "0") int mb_id,//归口科室id
            @RequestParam(value = "mb_code", defaultValue = "null") String mb_code,//归口科室代码
            @RequestParam(value = "mb_name", defaultValue = "null") String mb_name,//归口科室名称
            @RequestParam(value = "mb_lv", defaultValue = "0") int mb_lv,//归口科室lv
            @RequestParam(value = "en_id", defaultValue = "0") int en_id,//预算单位id
            @RequestParam(value = "en_code", defaultValue = "null") String en_code,//预算单位代码
            @RequestParam(value = "en_name", defaultValue = "null") String en_name,//预算单位名称
            @RequestParam(value = "en_lv", defaultValue = "0") int en_lv,//预算单位lv
            @RequestParam(value = "bs_id", defaultValue = "0") int bs_id,//功能分类id
            @RequestParam(value = "bs_code", defaultValue = "null") String bs_code,//功能分类代码
            @RequestParam(value = "bs_name", defaultValue = "null") String bs_name,//功能分类名称
            @RequestParam(value = "bs_lv", defaultValue = "0") int bs_lv,//功能分类lv
            @RequestParam(value = "bsi_id", defaultValue = "0") int bsi_id,//部门经济科目id
            @RequestParam(value = "bsi_code", defaultValue = "null") String bsi_code,//部门经济科目代码
            @RequestParam(value = "bsi_name", defaultValue = "null") String bsi_name,//部门经济科目名称
            @RequestParam(value = "bsi_lv", defaultValue = "0") int bsi_lv,//部门经济科目id
            @RequestParam(value = "gov_bsi_id", defaultValue = "0") int gov_bsi_id,//支出经济科目id
            @RequestParam(value = "gov_bsi_code", defaultValue = "null") String gov_bsi_code,//支出经济科目代码
            @RequestParam(value = "gov_bsi_name", defaultValue = "null") String gov_bsi_name,//支出经济科目名称
            @RequestParam(value = "gov_bsi_lv", defaultValue = "0") int gov_bsi_lv,//支出经济科目lv
            @RequestParam(value = "bo_id", defaultValue = "0") int bo_id,//指标来源id
            @RequestParam(value = "bo_code", defaultValue = "null") String bo_code,//指标来源代码
            @RequestParam(value = "bo_name", defaultValue = "null") String bo_name,//指标来源名称
            @RequestParam(value = "bo_lv", defaultValue = "0") int bo_lv,//指标来源lv
            @RequestParam(value = "mk_id", defaultValue = "0") int mk_id,//资金性质id
            @RequestParam(value = "mk_code", defaultValue = "null") String mk_code,//资金性质代码
            @RequestParam(value = "mk_name", defaultValue = "null") String mk_name,//资金性质名称
            @RequestParam(value = "mk_lv", defaultValue = "0") int mk_lv,//资金性质lv
            @RequestParam(value = "bis_id", defaultValue = "0") int bis_id,//项目id
            @RequestParam(value = "bis_code", defaultValue = "null") String bis_code,//项目代码
            @RequestParam(value = "bis_name", defaultValue = "null") String bis_name,//项目名称
            @RequestParam(value = "bis_lv", defaultValue = "0") int bis_lv,//项目lv
            @RequestParam(value = "hold1_id", defaultValue = "0") int hold1_id,//支出结构id
            @RequestParam(value = "hold1_code", defaultValue = "null") String hold1_code,//支出结构代码
            @RequestParam(value = "hold1_name", defaultValue = "null") String hold1_name,//支出结构名称
            @RequestParam(value = "hold1_lv", defaultValue = "0") int hold1_lv,//支出结构lv
            @RequestParam(value = "pk_id", defaultValue = "0") int pk_id,//支付方式id
            @RequestParam(value = "pk_code", defaultValue = "null") String pk_code,//支付方式代码
            @RequestParam(value = "pk_name", defaultValue = "null") String pk_name,//支付方式名称
            @RequestParam(value = "pk_lv", defaultValue = "0") int pk_lv,//支付方式lv
            @RequestParam(value = "qksfbs_id", defaultValue = "0") int qksfbs_id,//扶贫标识id
            @RequestParam(value = "qksfbs_code", defaultValue = "null") String qksfbs_code,//扶贫标识编码
            @RequestParam(value = "qksfbs_name", defaultValue = "null") String qksfbs_name,//扶贫标识名称
            @RequestParam(value = "qksfbs_lv", defaultValue = "0") int qksfbs_lv,//扶贫标识lv
            @RequestParam(value = "zdzjjqpt_id", defaultValue = "0") int zdzjjqpt_id,//是否直达资金的地方对应安排id
            @RequestParam(value = "zdzjjqpt_code", defaultValue = "null") String zdzjjqpt_code,//是否直达资金的地方对应安排编码
            @RequestParam(value = "zdzjjqpt_name", defaultValue = "null") String zdzjjqpt_name,//是否直达资金的地方对应安排名称
            @RequestParam(value = "zdzjjqpt_lv", defaultValue = "0") int zdzjjqpt_lv,//是否直达资金的地方对应安排lv
            @RequestParam(value = "directfunds_id", defaultValue = "0") int directfunds_id,//直达资金标识id
            @RequestParam(value = "directfunds_code", defaultValue = "null") String directfunds_code,//直达资金标识编码
            @RequestParam(value = "directfunds_name", defaultValue = "null") String directfunds_name,//直达资金标识名称
            @RequestParam(value = "directfunds_lv", defaultValue = "0") int directfunds_lv,//直达资金标识lv
            @RequestParam(value = "subsidy_id", defaultValue = "0") int subsidy_id,//是否补贴到人到企业id
            @RequestParam(value = "subsidy_code", defaultValue = "null") String subsidy_code,//是否补贴到人到企业编码
            @RequestParam(value = "subsidy_name", defaultValue = "null") String subsidy_name,//是否补贴到人到企业名称
            @RequestParam(value = "subsidy_lv", defaultValue = "0") int subsidy_lv,//是否补贴到人到企业lv
            @RequestParam(value = "export", defaultValue = "0") int export,//是否已经从数据库导出
            @RequestParam(value = "state", defaultValue = "0") int state//状态，1，待审核2，已审核3，已终审4，分配中5，已完成
    ) {
        //根据得到的参数，调用增加功能，
        //根据得到的指标文号的定义到了那个接口，就定义到了/reference/reference这个控制层，然后根据lv的等级就访问不同的表
        String set_timeStemp = null;
        Result result = null;
        Allot a = new Allot();
        int set_yearInt = FormatTime.dateToStampInt(set_year);//年度的字符串转成int类型的时间戳 set_year
        int currentimeInt = FormatTime.dateToStampInt(currentime);//计算机时间
        int create_dateInt = FormatTime.dateToStampInt(create_date);//年度的字符串转成int类型的时间戳 create_date
        int auditdayInt = FormatTime.dateToStampInt(auditday);//审核日期 的字符串转成int类型的时间戳 auditday
        int lastdayInt = FormatTime.dateToStampInt(lastday);//终审日期 的字符串转成int类型的时间戳 lastday
        a.setSet_year(set_yearInt);
        a.setCreate_date(create_dateInt);
        a.setCreate_date(create_dateInt);
        a.setSm_name(sm_name);
        a.setPay_money(pay_money);
        a.setAllotgold(allotgold);
        a.setUnallotgold(unallotgold);
        a.setEntry(entry);
        a.setAudit(audit);
        a.setAuditday(auditdayInt);
        a.setLast(last);
        a.setLastday(lastdayInt);
        a.setFile_id(file_id);//指标文号id
        a.setFile_code(file_code);
        a.setFile_name(file_name);
        a.setFile_lv(file_lv);
        a.setMb_id(mb_id);//归口科室id
        a.setMb_code(mb_code);
        a.setMb_name(mb_name);
        a.setMb_lv(mb_lv);
        a.setEn_id(en_id);//预算单位id
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
        Allot allot = allotRepository.save(a);
        return new Result(ResultCode.SUCCESS,allot);

    }

}
