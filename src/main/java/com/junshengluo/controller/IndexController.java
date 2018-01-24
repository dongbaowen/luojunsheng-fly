package com.junshengluo.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author DongBaoWen
 * @create 2018-01-24 22:30
 */
@Controller                 //todo 添加这个注解，SpringMVC会明白，“奥，这是个接口类，里面装的都是接口”
@RequestMapping("/api")     //todo 这里是url的第一层路由，“奥，这个接口装的都是第一层路由是 /api 的接口，处理的都是 /api的请求”
public class IndexController {

    /**
     * 最简化的接口
     * 对应的访问的url为：{host}:{port}/api/firstBlood
     *
     * @return
     * @RequestMapping : 括号中的字符串配置url的第二层路由
     * @ResponseBody : 可以实现将返回值变成json结构，至于为什么，先不用管
     * <p>
     * ps：这个请求可以支持任何请求方式 : get/post/put/delete ...
     */
    @RequestMapping("/firstBlood")
    @ResponseBody
    public Map<String, Object> test() {
        Map<String, Object> rtnValue = Maps.newHashMap();
        rtnValue.put("success", true);
        rtnValue.put("msg", "first blood!");
        return rtnValue;
    }

    /**
     * 一个get请求
     *
     * @return
     */
    @RequestMapping(
            value = "/get",                     /**配置url的第二层路由*/
            method = RequestMethod.GET,         /**配置请求的方式*/
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE /**设置这个接口的返回值格式为json (可以先不用理会)*/
    )
    @ResponseBody
    public Map<String, String> test1() {
        Map<String, String> rtnValue = Maps.newHashMap();
        rtnValue.put("success", "true");
        return rtnValue;
    }

    /**
     * 一个带参数的get请求
     * @param personId
     * @return
     */
    @RequestMapping(
            value = "/getGoWithParam",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public JSONObject test(
            @RequestParam("id") String personId  /**给这个接口设置入参，这种用法支持参数为八中基本数据类型以及对应的包装类（int Integer String），复杂类型的参数不支持（Person Map List）*/
    ) {
        System.out.println(personId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(ImmutableMap.<String, Object>of("success", true));
        return jsonObject;
    }
}
