package com.lly.demo.controller;

import com.google.common.collect.Sets;
import com.lly.demo.config.TestBean;
import com.lly.demo.service.AopService;
import com.lly.demo.service.AsyncService;
import com.lly.demo.service.ThreadPoolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;
import java.util.UUID;

@RestController
public class TestController {

//    @Resource
//    TestBean testBean;
//
//    @Resource
//    private AopService aopService;
//
//    @Autowired
//    ThreadPoolService threadPoolService;
//
//    @Autowired
//    AsyncService asyncService;
//
//    @RequestMapping("/")
//    public String t1() {
//        System.out.println(testBean);
//        return "hello luolinyi";
//    }
//
//
//    @RequestMapping(value = "/t2")
//    public String t2() {
//        return "t2";
//    }
//
//    @RequestMapping(value = "/aop")
//    public String aop() {
//        int rs = aopService.div(1, 2);
//        return rs+"";
//    }
//
//    @RequestMapping(value = "/threadPool")
//    public String threadPool() {
//        Set<String> ids = Sets.newHashSet();
//        for (int i = 0; i < 3; i++) {
//            ids.add(UUID.randomUUID().toString());
//        }
//        threadPoolService.sendWarningEmail(ids);
//        return "success";
//    }
//
//    @RequestMapping(value = "/async")
//    public String async() {
//        asyncService.test1("aaaa");
//        return "success";
//    }
//
//    @RequestMapping(value = "/async2")
//    public String async2() {
//        asyncService.test2("bbbb");
//        return "success";
//    }
//
//    @RequestMapping(value = "/async3")
//    public String async3() {
//        asyncService.test3("cccc");
//        return "success";
//    }

    @Operation(summary = "测试swagger")
    @RequestMapping(value = "/swagger_test1", method = RequestMethod.GET)
    public String swagger_test1(@Parameter(description = "用户名") @RequestParam("name") String name) {
        return name;
    }

}
