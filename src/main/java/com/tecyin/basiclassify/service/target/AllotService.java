package com.tecyin.basiclassify.service.target;

import com.tecyin.basiclassify.pojo.target.Allot;
import com.tecyin.basiclassify.repository.target.AllotRepository;
import com.tecyin.basiclassify.utils.FormatTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllotService {

    @Autowired
    private AllotRepository allotRepository;

    /*
    分页查询
     */
    public Page<Allot> findPage(int page, int limit) {
        page = page < 0 ? 0 : page;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Allot> all = allotRepository.findAll(pageable);
        return all;
    }

    /*
      根据ID查询
     */
    public Allot findById(int id) {
        Allot allot = null;
        try {
            allot = allotRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allot;
    }

    /*
      根据ID删除
     */
    public void deleteById(int id) {
        try {
            allotRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
      查询所有
     */
    public List<Allot> findAll() {
        List<Allot> all = null;
        try {
            all = allotRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }


    /**
     * 增加一个allot对象
     *
     * @param allot
     * @return
     */
    public Allot insert(Allot allot) {
        return allotRepository.save(allot);
    }

    /*
     * 增加
     */
    public Allot addService(
            String create_date,//录入日期
            String sm_name,//摘要
            String pay_money,//金额
            String allotgold,//已分配金额
            String unallotgold,//未分配金额
            String entry,//录入者
            String audit,//审核者
            String auditday,//审核日期
            String last,//终审者
            String lastday,//终审日期
            String file_id,//指标文号id
            String file_code,//指标文号代码
            String file_name,//指标文号名称
            String file_lv,//指标文号lv
            String mb_id,//归口科室id
            String mb_code,//归口科室代码
            String mb_name,//归口科室名称
            String mb_lv,//归口科室lv
            String en_id,//预算单位id
            String en_code,//预算单位代码
            String en_name,//预算单位名称
            String en_lv,//预算单位lv
            String bs_id,//功能分类id
            String bs_code,//功能分类代码
            String bs_name,//功能分类名称
            String bs_lv,//功能分类lv
            String bsi_id,//部门经济科目id
            String bsi_code,//部门经济科目代码
            String bsi_name,//部门经济科目名称
            String bsi_lv,//部门经济科目id
            String gov_bsi_id,//支出经济科目id
            String gov_bsi_code,//支出经济科目代码
            String gov_bsi_name,//支出经济科目名称
            String gov_bsi_lv,//支出经济科目lv
            String bo_id,//指标来源id
            String bo_code,//指标来源代码
            String bo_name,//指标来源名称
            String bo_lv,//指标来源lv
            String mk_id,//资金性质id
            String mk_code,//资金性质代码
            String mk_name,//资金性质名称
            String mk_lv,//资金性质lv
            String bis_id,//项目id
            String bis_code,//项目代码
            String bis_name,//项目名称
            String bis_lv,//项目lv
            String hold1_id,//支出结构id
            String hold1_code,//支出结构代码
            String hold1_name,//支出结构名称
            String hold1_lv,//支出结构lv
            String pk_id,//支付方式id
            String pk_code,//支付方式代码
            String pk_name,//支付方式名称
            String pk_lv,//支付方式lv
            String qksfbs_id,//扶贫标识id
            String qksfbs_code,//扶贫标识编码
            String qksfbs_name,//扶贫标识名称
            String qksfbs_lv,//扶贫标识lv
            String zdzjjqpt_id,//是否直达资金的地方对应安排id
            String zdzjjqpt_code,//是否直达资金的地方对应安排编码
            String zdzjjqpt_name,//是否直达资金的地方对应安排名称
            String zdzjjqpt_lv,//是否直达资金的地方对应安排lv
            String directfunds_id,//直达资金标识id
            String directfunds_code,//直达资金标识编码
            String directfunds_name,//直达资金标识名称
            String directfunds_lv,//直达资金标识lv
            String subsidy_id,//是否补贴到人到企业id
            String subsidy_code,//是否补贴到人到企业编码
            String subsidy_name,//是否补贴到人到企业名称
            String subsidy_lv,//是否补贴到人到企业lv
            String export,//是否已经从数据库导出
            String state//状态，1，待审核2，已审核3，已终审4，分配中5，已完成
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
        a.setEntry(entry);
        a.setAudit(audit);
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
        a.setState(state);
        return allotRepository.save(a);
    }

    /*
     * 修改
     */
    /*public Allot updateService(
            int id,//id
            String create_date,//录入日期
            String sm_name,//摘要
            String pay_money,//金额
            String allotgold,//已分配金额
            String unallotgold,//未分配金额
            String file_id,//指标文号id
            String file_code,//指标文号代码
            String file_name,//指标文号名称
            String file_lv,//指标文号lv
            String mb_id,//归口科室id
            String mb_code,//归口科室代码
            String mb_name,//归口科室名称
            String mb_lv,//归口科室lv
            String en_id,//预算单位id
            String en_code,//预算单位代码
            String en_name,//预算单位名称
            String en_lv,//预算单位lv
            String bs_id,//功能分类id
            String bs_code,//功能分类代码
            String bs_name,//功能分类名称
            String bs_lv,//功能分类lv
            String bsi_id,//部门经济科目id
            String bsi_code,//部门经济科目代码
            String bsi_name,//部门经济科目名称
            String bsi_lv,//部门经济科目id
            String gov_bsi_id,//支出经济科目id
            String gov_bsi_code,//支出经济科目代码
            String gov_bsi_name,//支出经济科目名称
            String gov_bsi_lv,//支出经济科目lv
            String bo_id,//指标来源id
            String bo_code,//指标来源代码
            String bo_name,//指标来源名称
            String bo_lv,//指标来源lv
            String mk_id,//资金性质id
            String mk_code,//资金性质代码
            String mk_name,//资金性质名称
            String mk_lv,//资金性质lv
            String bis_id,//项目id
            String bis_code,//项目代码
            String bis_name,//项目名称
            String bis_lv,//项目lv
            String hold1_id,//支出结构id
            String hold1_code,//支出结构代码
            String hold1_name,//支出结构名称
            String hold1_lv,//支出结构lv
            String pk_id,//支付方式id
            String pk_code,//支付方式代码
            String pk_name,//支付方式名称
            String pk_lv,//支付方式lv
            String qksfbs_id,//扶贫标识id
            String qksfbs_code,//扶贫标识编码
            String qksfbs_name,//扶贫标识名称
            String qksfbs_lv,//扶贫标识lv
            String zdzjjqpt_id,//是否直达资金的地方对应安排id
            String zdzjjqpt_code,//是否直达资金的地方对应安排编码
            String zdzjjqpt_name,//是否直达资金的地方对应安排名称
            String zdzjjqpt_lv,//是否直达资金的地方对应安排lv
            String directfunds_id,//直达资金标识id
            String directfunds_code,//直达资金标识编码
            String directfunds_name,//直达资金标识名称
            String directfunds_lv,//直达资金标识lv
            String subsidy_id,//是否补贴到人到企业id
            String subsidy_code,//是否补贴到人到企业编码
            String subsidy_name,//是否补贴到人到企业名称
            String subsidy_lv,//是否补贴到人到企业lv
            int export,//是否已经从数据库导出
            int state//状态，1，待审核2，已审核3，已终审4，分配中5，已完成
    ) {
        //根据得到的参数，调用增加功能，
        //根据得到的指标文号的定义到了那个接口，就定义到了/reference/reference这个控制层，然后根据lv的等级就访问不同的表
        Allot a = new Allot();
        int create_dateInt = FormatTime.transForMilliSecondByTim(create_date);//录入日期的字符串转成int类型的时间戳 create_date
        a.setId(id);
        a.setCreate_date(create_dateInt);
        a.setSm_name(sm_name);
        a.setPay_money(pay_money);
        a.setAllotgold(allotgold);
        int pay = Integer.parseInt(pay_money);
        int allot = Integer.parseInt(allotgold);
        int unallot = pay - allot;
        String unallotString = String.valueOf(unallot);
        a.setUnallotgold(unallotString);
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
        a.setState(state);
        return allotRepository.save(a);

    }*/
}
