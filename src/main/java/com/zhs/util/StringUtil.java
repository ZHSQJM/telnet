package com.zhs.util;

/**
 * Created with IDEA
 * author:zhouhuasheng
 * Date:2018/8/78:17
 * 描述:判断字符串是否为空
 **/
public class StringUtil {

    /*    */   public StringUtil() {}
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */   public static boolean isEmpty(String str)
    /*    */   {
        /* 34 */     if ((str == null) || (str.length() == 0)) {
            /* 35 */       return true;
            /*    */     }
        /* 37 */     return false;
        /*    */   }
    /*    */
    /*    */   public static boolean isNotEmpty(String str) {
        /* 41 */     return !isEmpty(str);
        /*    */   }
}
