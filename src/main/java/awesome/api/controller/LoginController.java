package awesome.api.controller;

import awesome.api.entity.User;
import awesome.api.service.impl.LoginServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class LoginController {
    @Resource
    LoginServiceImpl loginService;
//    @Autowired
//    private HttpServletRequest request;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(User user){
//        System.out.println(user.getUserId());
//        System.out.println(user.getName());
//        System.out.println(user.getPassword());
        String result=loginService.checkUser(user);
        return result;

    }



}


