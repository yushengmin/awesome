package awesome.api.controller;


import awesome.api.dto.AddUserDto;
import awesome.api.dto.UpdateUserDto;
import awesome.api.entity.Users;
import awesome.api.service.IRoleModuleService;
import awesome.api.service.IUsersService;
import awesome.response.ResponseCommonData;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * <p>
 * 特殊用户角色：财务-处理充值、提现任务；客户-处理余额不足提醒任务；交易员-处理买入卖出任务 前端控制器
 * </p>
 *
 * @author yu
 * @since 2020-01-22
 */
@RestController

@RequestMapping(value="/user")
@Api(tags = "用户接口",description="人员文档说明",hidden=true)
public class UsersController {
    @Resource(name = "usersServiceImpl")
    IUsersService iUsersService;

    //用户列表接口
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ApiOperation(value="查询所有的人员",notes="查询所有的人员接口说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="显示的页",dataType="Integer", paramType = "query"),
            @ApiImplicitParam(name="pagesize",value="每页的数量",dataType="Integer", paramType = "query"),
    })
    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData<HashMap> userList(@RequestParam(value = "page", required = false,defaultValue="1") Integer page,
                                                @RequestParam(value = "pagesize", required = false,defaultValue="2") Integer pagesize){
        return iUsersService.userlist(page,pagesize);
    }

    //添加用户接口
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ApiOperation(value="/添加用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value="登录账户",dataType="String"),
            @ApiImplicitParam(name="name",value="用户名",dataType="String")
    })
    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData addUser(@Valid AddUserDto users){
//        if(users.getUsername())

        return iUsersService.addUser(users);
    }
    
//    //修改用户接口
//    @RequestMapping(value="/edit", method = RequestMethod.POST)
//    @ApiOperation(value="/修改用户接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="name",value="用户名",dataType="String")
//    })
//    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
//    public ResponseCommonData editUser(@RequestParam(value = "id", required = true) Integer id,
//                                       @RequestParam(value = "name", required = true) String name,
//                                        @RequestParam(value = "email", required = true) String email,
//                                        @RequestParam(value = "phone", required = true) String phone){
//        System.out.println(id);
//        return iUsersService.editUser(id,name,email,phone);
//    }
    //修改用户接口
    @RequestMapping(value="/edit", method = RequestMethod.POST)
    @ApiOperation(value="/修改用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="用户名",dataType="String")
    })
    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData editUser(@Valid UpdateUserDto users){
        return iUsersService.editUser(users);
    }

    //重置用户密码
    @RequestMapping(value="/cpassword", method = RequestMethod.POST)
    @ApiOperation(value="/重置用户密码接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="newpassword",value="新密码",dataType="String")
    })
    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData editUser(@RequestParam(value = "userId", required = true) Integer userId,
                                       @RequestParam(value = "newpassword", required = true) String newpassword){
        return iUsersService.changePassword(userId,newpassword);
    }

    //删除用户
    @RequestMapping(value="/del", method = RequestMethod.POST)
    @ApiOperation(value="/删除用户接口")

    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData delUser(@RequestParam(value = "userId", required = true) Integer userId){
        return iUsersService.delUser(userId);
    }




    @ApiOperation(value="/")
    @ApiImplicitParams({
            @ApiImplicitParam(name="",value="",dataType="", paramType = "query"),
            @ApiImplicitParam(name="",value="",dataType="", paramType = "query"),
    })
    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public ResponseCommonData<String> test(String test){
        ResponseCommonData<String> data=new ResponseCommonData<>();
        data.setMsg(test);
        data.setData("测试");
        return data ;

    }

}
