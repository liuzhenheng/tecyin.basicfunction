package com.tecyin.basiclassify.pojo.target;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * 未分配指标
 */
@Entity
@Data
@Table(name = "allot")
//@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Allot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10)
    private int set_year;//年度
    @Column(length = 10)
    private int currentime;//计算机时间
    @Column(length = 10)
    private int create_date;//录入日期
    private String sm_name;//摘要
    private String pay_money;//金额
    private String allotgold;//已分配金额
    private String unallotgold;//未分配金额
    private String entry;//录入者
    private String audit;//审核者
    @Column(length = 10)
    private int auditday;//审核日期
    private String last;//终审者
    @Column(length = 10)
    private int lastday;//终审日期
    private String file_id;//指标文号id
    private String file_code;//指标文号代码
    private String file_name;//指标文号名称
    private String file_lv;//指标文号lv
    private String mb_id;//归口科室id
    private String mb_code;//归口科室代码
    private String mb_name;//归口科室名称
    private String mb_lv;//归口科室lv
    private String en_id;//预算单位id
    private String en_code;//预算单位代码
    private String en_name;//预算单位名称
    private String en_lv;//预算单位lv
    private String bs_id;//功能分类id
    private String bs_code;//功能分类代码
    private String bs_name;//功能分类名称
    private String bs_lv;//功能分类lv
    private String bsi_id;//部门经济科目id
    private String bsi_code;//部门经济科目代码
    private String bsi_name;//部门经济科目名称
    private String bsi_lv;//部门经济科目lv
    private String gov_bsi_id;//支出经济科目id
    private String gov_bsi_code;//支出经济科目代码
    private String gov_bsi_name;//支出经济科目名称
    private String gov_bsi_lv;//支出经济科目lv
    private String bo_id;//指标来源id
    private String bo_code;//指标来源代码
    private String bo_name;//指标来源名称
    private String bo_lv;//指标来源lv
    private String mk_id;//资金性质id
    private String mk_code;//资金性质代码
    private String mk_name;//资金性质名称
    private String mk_lv;//资金性质lv
    private String bis_id;//项目id
    private String bis_code;//项目代码
    private String bis_name;//项目名称
    private String bis_lv;//项目lv
    private String hold1_id;//支出结构id
    private String hold1_code;//支出结构代码
    private String hold1_name;//支出结构名称
    private String hold1_lv;//支出结构lv
    private String pk_id;//支付方式id
    private String pk_code;//支付方式代码
    private String pk_name;//支付方式名称
    private String pk_lv;//支付方式lv
    private String qksfbs_id;//扶贫标识id
    private String qksfbs_code;//扶贫标识编码
    private String qksfbs_name;//扶贫标识名称
    private String qksfbs_lv;//扶贫标识lv
    private String zdzjjqpt_id;//是否直达资金的地方对应安排id
    private String zdzjjqpt_code;//是否直达资金的地方对应安排编码
    private String zdzjjqpt_name;//是否直达资金的地方对应安排名称
    private String zdzjjqpt_lv;//是否直达资金的地方对应安排lv
    private String directfunds_id;//直达资金标识id
    private String directfunds_code;//直达资金标识编码
    private String directfunds_name;//直达资金标识名称
    private String directfunds_lv;//直达资金标识lv
    private String subsidy_id;//是否补贴到人到企业id
    private String subsidy_code;//是否补贴到人到企业编码
    private String subsidy_name;//是否补贴到人到企业名称
    private String subsidy_lv;//是否补贴到人到企业lv
    private String export;//是否已经从数据库导出,0是没有导出，1是已经导出过
    private String state;//状态，1，待审核2，已审核3，已终审4，分配中5，已完成

}
