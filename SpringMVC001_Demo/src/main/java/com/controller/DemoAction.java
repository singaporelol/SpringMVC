package com.controller;

import com.controller.vo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class DemoAction {
    /**
     * Action中所有的功能实现都是由方法来完成的。
     * action方法的规范：
     * 1、访问权限是public
     * 2、方法返回值任意
     * 3、方法名称任意
     * 4、方法可以没有参数，如果有可以是任意类型
     * 5、要使用@RequestMapping注解来声明一个访问的路径
     */
    @RequestMapping("/demo")
    public String demo() {
        System.out.println("服务器被访问到了");
        return "main";
    }

//    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
//    public String Login(String username, String password, int age) {
//        System.out.println("username:" + username + "," + "age:" + age + ",password:" + password);
//        return "main";
//    }

    @RequestMapping(value = "/req1", method = {RequestMethod.POST, RequestMethod.GET})
    public String Req1(User user) {
        System.out.println(user);
        return "main";
    }

    @RequestMapping("/req2/{uname}/{uage}")
    public String Req2(
            @PathVariable("uname")
            String name,
            @PathVariable("uage")
            int age
    ) {
        System.out.println(name + "," + age);
        return "main";
    }

    @RequestMapping(value = "/req3", method = {RequestMethod.POST, RequestMethod.GET})
    public String Req3(
            @RequestParam("username")
            String uname,
            @RequestParam("age")
            int uage
    ) {
        System.out.println("name" + uname + "age: " + uage);
        return "main";
    }

    @RequestMapping(value = "/req4", method = {RequestMethod.POST, RequestMethod.GET})
    public String Req4(HttpServletRequest request) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("name: " + name + "age: " + age);
        return "main";
    }

    @RequestMapping("/req5")
    @ResponseBody
    public List<User> Req5() {
        List<User> userList = new ArrayList<User>();
        User user1 = new User("张三", "password1", 18);
        User user2 = new User("李四", "password2", 19);
        User user3 = new User("王五", "password3", 20);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }

    @RequestMapping("/req6")
    public String Req6() {
        System.out.println("这是请求转发的页面");
        return "main";
    }

    @RequestMapping("/req7")
    public String Req7() {
        System.out.println("这是请求转发的action");
        return "forward:/req6.action";
    }

    @RequestMapping("/req8")
    public String Req8() {
        System.out.println("这是重定向页面");
        return "redirect:/admin/main.jsp";
    }

    @RequestMapping("/req9")
    public String Req9() {
        System.out.println("这是重定向action");
        return "redirect:/req6.action";
    }

    @RequestMapping("/req10")
    public String Req10(HttpServletRequest request,
                        HttpServletResponse response,
                        HttpSession session,
                        Model model,
                        Map map,
                        ModelMap modelMap) {

        User u = new User("张三", "password123", 18);
        request.setAttribute("requestUsers", u);
        session.setAttribute("sessionUsers", u);
        model.addAttribute("modelUsers", u);
        map.put("mapUsers", u);
        modelMap.addAttribute("modelMapUsers", u);
        return "redirect:/admin/login.jsp";
//        return "login";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("/req11")
    public String Req11(Date date) {
        System.out.println(date);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sf.format(date));
        return "login";
    }

    //    @RequestMapping("/req11")
//    public String Req11(
//            @DateTimeFormat(pattern = "yyyy-MM-dd")
//            Date date
//    ){
//        System.out.println(date);
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sf.format(date));
//        return "login";
//    }
    @RequestMapping("/login")
    public String Login(String name, String pwd,HttpServletRequest request) {
        if("xueqian".equalsIgnoreCase(name) && "123".equalsIgnoreCase(pwd)){
            //在session中存储用户信息，用于进行权限验证
            request.getSession().setAttribute("users",name);
            return "main";
        }else {

        }
        return "login";
    }
    @RequestMapping("/main")
    public String Main(){
        return "main";
    }



}
