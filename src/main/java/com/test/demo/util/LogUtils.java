/**
 * 文件名：LogUtils.java
 * 版权：Copyright by www.bjleisen.com
 * 描述：
 * 修改人：zhangziqi
 * 修改时间：2016年3月23日
 * 修改内容：
 */

package com.test.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils 
{
    
    static Logger logger = LoggerFactory.getLogger("");    
    
    public static void info(String str)
    {
        logger.info(str);
    }
    
    public static void error(String str,Exception e)
    {
        logger.error(str,e);
    }
}
