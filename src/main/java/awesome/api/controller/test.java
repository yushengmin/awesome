package awesome.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class test {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/redis", method = RequestMethod.GET)
    public String admin(){
        String a=redisTemplate.opsForValue().get("liwenwen");
        redisTemplate.opsForValue().set("admin","admin");
        System.out.println(a);

        return "Hello admin";
    }
    @RequestMapping(value="/hello1", method = RequestMethod.GET)
    public String user(){
        HttpSession httpSession=request.getSession();
        String a =(String) httpSession.getAttribute("loginUserId");
        System.out.println(a);
        return "1234";
    }
    @RequestMapping(value="/api/hello", method = RequestMethod.GET)
    public String dba(){

        return "Hello dba";
    }
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String hello(){

        return "Hello dba";
    }




}


