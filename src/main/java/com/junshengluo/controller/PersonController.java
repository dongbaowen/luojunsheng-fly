package com.junshengluo.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.junshengluo.domain.Person;
import com.junshengluo.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author DongBaoWen
 * @create 2018-01-24 23:42
 */
@Controller
@RequestMapping("/person")      // todo 同理，“奥，这个接口装的都是第一层路由是 /person 的接口，处理的都是 /person 的请求”
public class PersonController {

    /**
     * 用法为注入，可以理解为：
     *      spring 自动创建了一个 [PersonService 的实现类（PersonServiceImpl）] 的对象，注入到 PersonController 的实例中
     * 将“A” 注入到“B”中去 ：
     *      spring 创建 A、B 两个实例，并将A 作为B的一个成员，实现B 依赖A，目的是为了B可以调用A中的方法。
     *      在这里，A 是Spring 帮你创建的 PersonServiceImpl 的实例；B 是 Spring 帮你创建的 PersonController 的实例
     */
    @Resource
    private PersonService personService;

    /**
     * 添加人员
     * @param person
     * @return
     */
    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public JSONObject test(
            @RequestBody Person person  /**如果使用@RequestBody注解，接口的参数就可以配置复杂类型（Person， Map， JSONObject（阿里巴巴提供的json API）...）*/
    ) {
        JSONObject jsonObject = new JSONObject();
        if (personService.addPerson(person) > 0) {
            jsonObject.putAll(ImmutableMap.<String, Object>of(
                    "success", true,
                    "mes", "添加成功")
            );
        } else {
            jsonObject.putAll(ImmutableMap.<String, Object>of(
                    "success", false,
                    "mes", "添加失败")
            );
        }
        return jsonObject;
    }
}
