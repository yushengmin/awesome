package awesome.api.controller;

import awesome.api.entity.User;
import awesome.api.service.impl.LoginServiceImpl;
import awesome.response.ResponseCommonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
public class LoginController {
    @Resource
    LoginServiceImpl loginService;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value="/api/login", method = RequestMethod.GET)
    public ResponseCommonData login(User user){
        ResponseCommonData responseCommonData=loginService.checkUser(user);
        if (responseCommonData.getStatus()==0){
            HttpSession session=request.getSession();
            session.setAttribute("loginUserId",user.getAccount());
            System.out.println("++++++++++++++++");
            System.out.println(user.getAccount());
            redisTemplate.opsForValue().set("loginUser:"+"admin1",session.getId());
        }
        return responseCommonData;
    }

//    @RequestMapping(value="/hello", method = RequestMethod.GET)
//    public String hello(){
//        return "hello";
//    }



}


