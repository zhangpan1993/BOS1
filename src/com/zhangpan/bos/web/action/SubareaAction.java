package com.zhangpan.bos.web.action;

import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Subarea;
import com.zhangpan.bos.service.ISubareaService;
import com.zhangpan.bos.web.action.base.BaseAction;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class SubareaAction extends BaseAction<Subarea> {

    @Autowired
    private ISubareaService subareaService;

    public String save(){

        subareaService.save(getModel());

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

        pageBean.setPageSize(rows);
        pageBean.setCurrentPage(page);

        DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
        pageBean.setDetachedCriteria(dc);
        subareaService.pageQuery(pageBean);

        responseJson(pageBean,new String[]{"currentPage","pageSize","detachedCriteria","subareas"});
    }

    public void exportXls() throws IOException {

        List<Subarea> subareas = subareaService.findAll();

        //创建文档对象
        HSSFWorkbook wk = new HSSFWorkbook();

        //创建sheet
        HSSFSheet hssfSheet = wk.createSheet("分区数据");

        //创建标题行
        HSSFRow row =  hssfSheet.createRow(0);
        row.createCell(0).setCellValue("分区编号");
        row.createCell(1).setCellValue("区域编号");
        row.createCell(2).setCellValue("关键字");
        row.createCell(3).setCellValue("省市区");


        for (Subarea s:subareas){

            row = hssfSheet.createRow(hssfSheet.getLastRowNum()+1);
            row.createCell(0).setCellValue(s.getId());
            row.createCell(1).setCellValue(s.getRegion().getId());
            row.createCell(2).setCellValue(s.getAddresskey());
            row.createCell(3).setCellValue(s.getRegion().getName());

        }

        String fileName = URLEncoder.encode("分区数据.xls","UTF-8");

        ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        ServletActionContext.getResponse().setContentType(contentType);
        ServletActionContext.getResponse().setHeader("content-disposition", "attchment;filename="+fileName);

        wk.write(outputStream);

    }

    public void listJson() throws IOException {

        List<Subarea> list = subareaService.findListNoAssociation();
        responseJson(list,new String[]{"region","decidedZone"});

    }

}
