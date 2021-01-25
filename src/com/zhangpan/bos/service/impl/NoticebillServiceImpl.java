package com.zhangpan.bos.service.impl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zhangpan.bos.dao.IDecidedZoneDao;
import com.zhangpan.bos.dao.INoticebillDao;
import com.zhangpan.bos.dao.IWorkbillDao;
import com.zhangpan.bos.domain.DecidedZone;
import com.zhangpan.bos.domain.Noticebill;
import com.zhangpan.bos.domain.Staff;
import com.zhangpan.bos.domain.Workbill;
import com.zhangpan.bos.service.INoticebillService;
import com.zhangpan.bos.service.base.BaseServiceImpl;
import com.zhangpan.crm.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional
public class NoticebillServiceImpl extends BaseServiceImpl<Noticebill> implements INoticebillService {

    @Autowired
    private INoticebillDao noticebillDao;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private IDecidedZoneDao decidedZoneDao;

    @Autowired
    private IWorkbillDao workbillDao;


    @Override
    public void save(Noticebill entity, String decidedzoneId) {

        noticebillDao.save(entity);
        //String address = entity.getPickaddress();
        //String decidedZondId = customerService.findDecidedZoneIdByAddress(address);
        if(!StringUtils.isEmpty(decidedzoneId)){

            DecidedZone zone = decidedZoneDao.findById(decidedzoneId);
            Staff staff = zone.getStaff();
            entity.setOrdertype("自动");
            entity.setStaff(staff);
            Workbill workbill = new Workbill();
            workbill.setPickstate("未取件");
            workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));
            workbill.setAttachbilltimes(0);
            workbill.setRemark(entity.getRemark());
            workbill.setStaff(staff);
            workbill.setNoticebill(entity);

            workbillDao.save(workbill);



        }else{

            entity.setOrdertype("人工");
        }

    }
}
