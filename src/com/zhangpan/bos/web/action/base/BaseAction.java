package com.zhangpan.bos.web.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    private T t;

    public BaseAction(){
        //1.获得父类的参数化类型
        ParameterizedType pt= (ParameterizedType) this.getClass().getGenericSuperclass();

        //2.或的类的参数化类型数组
        Type[] types = pt.getActualTypeArguments();


        //3.获得泛型类的第一个参数类型

        Class<T> clz = (Class<T>)types[0];

        try {
            t = clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public T getModel() {
        return t;
    }

    protected void responseJson(Object obj,String[] excludes) throws IOException {

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/json;charset=UTF-8");

        //json过滤器
        JsonConfig jc = new JsonConfig();

        jc.setExcludes(excludes);

        if (obj instanceof Collection){
            JSONArray jb = JSONArray.fromObject(obj,jc);
            response.getWriter().print(jb.toString());
        }else{

            JSONObject jb = JSONObject.fromObject(obj,jc);
            response.getWriter().print(jb.toString());
        }
    }
}
