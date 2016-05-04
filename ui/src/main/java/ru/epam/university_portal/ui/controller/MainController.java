package ru.epam.university_portal.ui.controller;
import org.springframework.beans.factory.annotation.Autowired;
import ru.epam.university_portal.core.dao.impl.UserDAOImpl;
import ru.epam.university_portal.core.service.IUserService;
import ru.epam.university_portal.core.service.impl.UserServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.epam.university_portal.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/welcome")
public class MainController {

 private   IUserService userService;
   // IUserService iUserService=new UserServiceImpl(new UserDAOImpl())
   //
    public MainController(){}

    public MainController(IUserService userService){this.userService=userService;}
    @Autowired
   public void setUserService(IUserService userService){
        this.userService=userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model,HttpServletRequest request, HttpServletResponse response) {

        User user= userService.getUser("admin");
        System.out.println(user.firstName);
String login=  request.getParameter("login");
        System.out.println("login:"+login);

       model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "hello";

    }
   /*/ @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

       User user= userService.getUser("admin");
       System.out.print(user.firstName);
        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "hello";

    }
/*/
}