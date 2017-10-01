/**
 * 版权声明 springcity 版权所有,违者必究
 * <p>
 * <br> Copyright：Copyright (c)  2017
 * <br> Company: springcity
 * <br> Author: lincc(l85520949@163.com)
 * <br> Date：2017-09-25
 * <br> Version： 1.0
 */
package com.spc.mvctest.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * <br>
 * <b>功能描述:</b>
 * <p/>
 * <pre>
 *  //TODO
 * </pre>
 *
 * @author lincc(l85520949@163.com)
 * @since 1.0
 */
public class FastJsonUtil {
    public FastJsonUtil() {
        throw new UnsupportedOperationException("不能被实例化");
    }

    /**
     * TODO 转换成 json 格式的字符串
     *
     * @param object 要转换的对象
     * @return
     */
    public static String createJsonString(Object object) {
        String jsonString = JSON.toJSONString(object);
        return jsonString;
    }

    /**
     * 将 json 字符串转换为指定的 bean 对象
     *
     * @param jsonString
     * @param cls        要转换为对象的类型
     * @return
     */
    public static <T> T createJsonBean(String jsonString, Class<T> cls) {
        T t = JSON.parseObject(jsonString, cls);
        return t;
    }

    /**
     * 将 json 字符串转换为 List<T>
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> List<T> createJsonToListBean(String jsonString, Class<T> cls) {
        List<T> list = null;
        list = JSON.parseArray(jsonString, cls);
        return list;
    }

    /**
     * 将 json 字符串转换为 List<Map<String,Object>>
     *
     * @param jsonString
     * @return
     */
    public static List<Map<String, Object>> createJsonToListMap(String jsonString) {
        List<Map<String, Object>> list2 = JSON.parseObject(jsonString, new TypeReference<List<Map<String, Object>>>() {
        });
        return list2;
    }

    /* 将 json 字符串转换为 List<String>
    @param jsonString
    @return
    */
    public static List<String> createJsonToListString(String jsonString) {
        List<String> list2 = JSON.parseObject(jsonString, new TypeReference<List<String>>() {
        });
        return list2;
    }
}