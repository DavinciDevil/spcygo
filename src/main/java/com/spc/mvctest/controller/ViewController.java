/**
 * 版权声明 网宿科技 版权所有,违者必究
 * <p>
 * <br> Copyright：Copyright (c)  2017
 * <br> Company: 网宿科技
 * <br> Author: lincc(lincc1@chinanetcenter.com)
 * <br> Date：2017-09-23
 * <br> Version： 1.0
 */
package com.spc.mvctest.controller;

import com.spc.mvctest.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <br>
 * <b>功能描述:</b>
 * <p/>
 * <pre>
 *  //TODO
 * </pre>
 *
 * @author lincc(lincc1@chinanetcenter.com)
 * @since 1.0
 */
@Controller
@RequestMapping("/viewcontroller")
public class ViewController {
    private Logger logger = Logger.getLogger(ViewController.class);

    @Autowired
    private UserService userService ;

    @RequestMapping("/index")
    public String index(String param, HttpServletRequest request, HttpServletResponse response, Model model){
        userService.print("我在service被调用了");
        logger.info("我打一个日志1111222");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("page1");
//        mv.addObject("name","lcc");
        model.addAttribute("name","lcc");
        return "page1";
    }

    /**Freemarker模板的Controller*/
    @RequestMapping(value="/welcome",method={RequestMethod.GET})
    public ModelAndView getFirstPage(HttpServletRequest request) {
        //welcom就是视图的名称（welcom.ftl）
        ModelAndView mv = new ModelAndView("page1");
        mv.addObject("name", "My First Spring Mvc and Freemarker !");
        return mv;
    }


    /**jsp模板的Controller*/
    @RequestMapping(value="/jsp",method={RequestMethod.GET})
    public ModelAndView getJsp(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView("page2");
        mv.addObject("message1", "切换到jsp模板、");
        mv.addObject("message2", "My First Spring Mvc");
        mv.setViewName("page/page2");
        return mv;
    }
}
