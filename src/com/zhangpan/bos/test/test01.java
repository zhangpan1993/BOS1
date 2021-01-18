package com.zhangpan.bos.test;

import com.zhangpan.bos.dao.IUserDao;
import com.zhangpan.bos.domain.User;
import com.zhangpan.bos.utils.PinYin4jUtils;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test01 {


    @Autowired
    private IUserDao userDao;


    @Test
    public void test1(){

       User user = userDao.find("admin","123456");

        System.out.println(user.toString());

    }

    @Test
    public void test2(){

        String province = "山西省";
        String city = "太原市";
        String district = "清徐县";

        String[] strToPinyins = PinYin4jUtils.stringToPinyin(city);

        String strToPinyin = StringUtils.join(strToPinyins,"");

        System.out.println(strToPinyin);

        province = province.substring(0,province.length()-1);
        district = district.substring(0,district.length()-1);

        String totalName = province + city + district;
        String[] tmps =  PinYin4jUtils.getHeadByString(totalName);

        String shortName = StringUtils.join(tmps,"");

        System.out.println(shortName);
    }



    @Test
    public void test3(){

        String json = "[{'day1':'work','day2':26},{'day1':123,'day2':26}]";
        JSONArray jsonArray = JSONArray.fromObject(json);

        System.out.println(jsonArray.toString());
    }
}
