package com.tecyin.basiclassify.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页
 *      {
 *          “success”：“成功”，
 *          “code”：10000
 *          “message”：“ok”，
 *          ”data“：{
 *              total：//总条数
 *              rows ：//数据列表
 *          }
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;

}
/*@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/pageList")
    public Result getCompanies(@RequestParam("page") Long page,
                               @RequestParam("limit") Long limit) {
        //创建page对象，传递两个参数
        Page<Company> pageCompany = new Page<>(page,limit);
        //调用方法分页查询（基于mybatis-plus实现，这里不详述）
        companyService.page(pageCompany,null);
        //从pageCompany中获取分页数据
        long total = pageCompany.getTotal();//总记录数
        List<Company> records = pageCompany.getRecords();//当前页数据
        PageResult<Company> pr = new PageResult<>(total,records);
        return new Result(ResultCode.SUCCESS,pr);
    }
}
*/