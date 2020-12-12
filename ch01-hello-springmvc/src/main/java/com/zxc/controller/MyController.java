package com.zxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
* @Controller创建处理器对象，对象放在springmvc容器
* 位置：类上面
* 和spring中讲的@Component,@Service
* 能处理请求的控制器，我们称之为后端控制器
* */
@Controller
public class MyController {
    /*
    处理用户提交的请求，springmvc是使用方法来处理的
    方法是自定义的，可以有多种返回值，多种参数，方法名自定义
     */

    /*
    准备使用doSome方法处理some.do请求
    @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定在一起
    属性：1、value是一个String，表示请求的url地址的（some.do)。
    value的值必须是唯一的，不能重复，在使用时，推荐地址以“/”
    位置：1、在方法上面，常用的
    2、在类上面

    说明：使用RequestMapping修饰的方法叫做处理器方法或控制器方法
    使用RequestMapping修饰的方法可以处理请求，类似servlet中的doGet或者doPost

    返回值：ModelAndView
    Model：请求完成后，要显示给用户的数据
    View：视图，比如jsp等等


     */
    @RequestMapping(value = {"/some.do","/first.do"})
    public ModelAndView doSome(){//doGet---service请求处理
        //处理some.do的请求，调用service请求处理完成
        ModelAndView modelAndView = new ModelAndView();
        //添加数据，框架在请求的最后把数据放入到request域中
        //request.setAttribute("msg","欢迎使用springmvc做web开发")
        modelAndView.addObject("msg","欢迎使用springmvc做web开发");
        modelAndView.addObject("fun","执行的是dosome方法");

        //指定视图，指定视图的完整路径
        //框架对视图执行的forword操作，request.getRequestDispather("show.jsp").forward(...)
        //modelAndView.setViewName("/show.jsp");
        //modelAndView.setViewName("WEB-INF/view/show.jsp");

        //当配置了视图解析器，可以使用逻辑名称（文件名），指定视图
        //框架会使用视图解析器的前缀+逻辑名称+后缀 组成完成路径，这里就是字符连接操作
        // /WEB-INF/view/+show+jsp
        modelAndView.setViewName("show");
        return modelAndView;
    }

    @RequestMapping(value = {"/other.do","/second.do"})
    public ModelAndView doOther(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","欢迎使用springmvc做web开发");
        modelAndView.addObject("fun","执行的是doOther方法");
        modelAndView.setViewName("other");
        return modelAndView;
    }
}
