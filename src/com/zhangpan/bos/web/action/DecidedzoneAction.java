package com.zhangpan.bos.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhangpan.bos.domain.DecidedZone;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Region;
import com.zhangpan.bos.service.IDecidedzoneService;
import com.zhangpan.bos.web.action.base.BaseAction;
import com.zhangpan.crm.domain.Customer;
import com.zhangpan.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.awt.image.ImageDecoder;

import java.io.IOException;
import java.util.List;

public class DecidedzoneAction extends BaseAction<DecidedZone> {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private IDecidedzoneService decidedzoneService;
    private String[] subareaid;

    public void setSubareaid(String[] subareaid) {
        this.subareaid = subareaid;
    }

    public void findnoassociationCustimers() throws IOException {

        List<Customer> cus = customerService.findnoassociationCustomers();

        responseJson(cus,new String[]{});
    }

    public String save(){
        decidedzoneService.save(getModel(),subareaid);
        return "list";
    }

    public void pageQuery() throws IOException{

        PageBean<DecidedZone> pageBean = new PageBean<DecidedZone>();
        decidedzoneService.pageQuery(pageBean);
        /**
         * 注意事项：
         * 1.需要设置DecidedZone的staff为非懒加载
         * 2.排队DecidedZone中的detachedCriteria,decidedZones,subareas防止循环引用
         * */
        responseJson(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","decidedZones","subareas"});
    }



}
