package com.zhangpan.bos.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import sun.reflect.Reflection;

public class Log4jUtils {

    private static Logger logger = null;

    public static Logger getLogger(){

        PropertyConfigurator.configure("log4j.properties");
        if (null == logger){
            logger = Logger.getLogger(Reflection.getCallerClass().getName());

        }

        return logger;
    }
}
