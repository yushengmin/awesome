package awesome.api.controller;


import awesome.api.service.IRoleService;
import awesome.api.service.IUserRoleService;
import awesome.api.service.IUsersService;
import awesome.response.ResponseCommonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yu
 * @since 2020-01-23
 */
@RestController
@RequestMapping("/role")
public class UserRoleController {
    @Resource(name = "userRoleServiceImpl")
    IUserRoleService iUserRoleService;

    //用户角色接口
    @RequestMapping(value="/rolelist", method = RequestMethod.POST)
    @ApiOperation(value="/用户角色接口")

    @ApiResponse(response= ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData urolelist(@RequestParam(value = "userId", required = true) Integer userId){
        return iUserRoleService.userRoleList(userId);
    }



}
