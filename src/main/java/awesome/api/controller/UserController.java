package awesome.api.controller;


import awesome.api.entity.User;
import awesome.api.service.impl.UserServiceImpl;
import awesome.response.ResponseCommonData2;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 特殊用户角色：财务-处理充值、提现任务；客户-处理余额不足提醒任务；交易员-处理买入卖出任务 前端控制器
 * </p>
 *
 * @author yu
 * @since 2020-01-13
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    UserServiceImpl userService;

    @RequestMapping(value="/userlist", method = RequestMethod.GET)
    public ResponseCommonData2<List<User>> userList(){
        List<User> list=userService.list();
        return new ResponseCommonData2<List<User>>(list);
    }
}
