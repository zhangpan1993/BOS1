package com.zhangpan.bos.web.action;

import com.zhangpan.bos.domain.Noticebill;
import com.zhangpan.bos.web.action.base.BaseAction;
import com.zhangpan.crm.domain.Customer;

import java.io.IOException;

public class NoticebillAction extends BaseAction<Noticebill> {

    private String tel;
    public void setTel(String tel) {
        this.tel = tel;
    }

    public void findCustomerByTelephone() throws IOException {

        Customer c = customerService.findCustomerByTelephone(tel);
        responseJson(c,new String[]{});
    }



}
