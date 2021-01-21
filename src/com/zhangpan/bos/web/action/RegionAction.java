package com.zhangpan.bos.web.action;

import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Region;
import com.zhangpan.bos.service.IRegionService;
import com.zhangpan.bos.utils.PinYin4jUtils;
import com.zhangpan.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegionAction extends BaseAction<Region> {

    private File excelFile;

    @Autowired
    private IRegionService regionService;

    public void setExcelFile(File excelFile) {
        this.excelFile = excelFile;
    }

    public String importExcel() throws Exception {

        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(excelFile));

        HSSFSheet sheet = workbook.getSheetAt(0);

        List<Region> regions = new ArrayList<Region>();

        for (Row row:sheet){
            System.out.println(row.getRowNum());
            if (row.getRowNum() ==0){
                continue;
            }
            String id = row.getCell(0).getStringCellValue();
            String provice = row.getCell(1).getStringCellValue();
            String city = row.getCell(2).getStringCellValue();
            String district = row.getCell(3).getStringCellValue();
            String postcode = row.getCell(4).getStringCellValue();


            String cityCode = StringUtils.join(PinYin4jUtils.stringToPinyin(city),"");
            String proviceTemp = provice.substring(0,provice.length()-1);
            String distictTemp = district.substring(0,district.length()-1);

            String totalName = proviceTemp + city + distictTemp;

            String[] tmps = PinYin4jUtils.getHeadByString(totalName);

            String shortCode = StringUtils.join(tmps,"");

            Region rg = new Region(id,provice,city,district,postcode,shortCode,cityCode,null);

            System.out.println(rg);

            regions.add(rg);

        }

        regionService.saveAll(regions);

        return NONE;

    }

    //==========================数据分页
    public void pageQuery() throws IOException {

        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);

        DetachedCriteria dc = DetachedCriteria.forClass(Region.class);
        pageBean.setDetachedCriteria(dc);
        regionService.pageQuery(pageBean);

        responseJson(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","subareas"});

    }


    public void listJson() throws IOException {

        List<Region> regions = regionService.findAll();

        System.out.println(regions);

        responseJson(regions,new String[]{"subareas"});

    }



}
