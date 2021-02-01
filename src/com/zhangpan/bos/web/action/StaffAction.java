package com.zhangpan.bos.web.action;

import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Staff;
import com.zhangpan.bos.service.IStaffService;
import com.zhangpan.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StaffAction extends BaseAction<Staff> {

    @Autowired
    private IStaffService staffService;

    @RequiresPermissions(value = "staff")
    public String save(){

        System.out.println(getModel());

        staffService.save(getModel());

        return SUCCESS;

    }

    //==========================数据分页
    private int page;
    private int rows;

    public void setPage(int page) {
        this.page = page;
    }


    public void setRows(int rows) {
        this.rows = rows;
    }

    public void pageQuery() throws IOException {



        PageBean<Staff> pageBean = new PageBean<Staff>();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);

        DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
        pageBean.setDetachedCriteria(dc);
        staffService.pageQuery(pageBean);
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("text/json;charset=UTF-8");
        JsonConfig jc = new JsonConfig();
        jc.setExcludes(new String[]{"currentPage","pageSize","datachedCriteria"});
        JSONObject jb = JSONObject.fromObject(pageBean,jc);
        response.getWriter().print(jb.toString());

    }


    private String ids;

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String delete() throws IOException {

        staffService.deleteBatch(ids);

        //3.响应
        HttpServletResponse response = ServletActionContext.getResponse();
        response.getWriter().write("success");

        return NONE;
    }

    public String edit() throws IOException {

        Staff staff = staffService.findById(getModel().getId());

        staff.setName(getModel().getName());
        staff.setTelephone(getModel().getTelephone());
        staff.setHaspda(getModel().getHaspda());
        staff.setStandard(getModel().getStandard());
        staff.setStation(getModel().getStation());

        staffService.update(staff);

        //3.响应
        HttpServletResponse response = ServletActionContext.getResponse();
        response.getWriter().write("success");

        return NONE;

    }


    public void listJson() throws IOException {

        List<Staff> staffList = staffService.findListNotDelete();

        responseJson(staffList,new String[]{"decidedZones"});
    }

}
