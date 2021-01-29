package com.zhangpan.bos.web.action;

import com.zhangpan.bos.dao.INoticebillDao;
import com.zhangpan.bos.domain.Noticebill;
import com.zhangpan.bos.service.INoticebillService;
import com.zhangpan.bos.utils.Log4jUtils;
import com.zhangpan.bos.web.action.base.BaseAction;
import com.zhangpan.crm.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class NoticebillAction extends BaseAction<Noticebill> {

    private String tel;

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Autowired
    private INoticebillService noticebillService;

    public void findCustomerByTelephone() throws IOException {

        Customer c = customerService.findCustomerByTelephone(tel);
        responseJson(c,new String[]{});
    }

    private String decidedzoneId;

    public void setDecidedzoneId(String decidedzoneId) {
        this.decidedzoneId = decidedzoneId;
    }



    public String save(){

        noticebillService.save(getModel(),decidedzoneId);
        Log4jUtils.getLogger().info("数据保存成功");

        return SUCCESS;
    }



}
