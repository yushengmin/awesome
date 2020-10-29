package awesome.api.controller;


import awesome.api.dto.RoleDto;
import awesome.api.service.IRoleService;
import awesome.response.ResponseCommonData;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;

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
@Api(tags = "角色接口",description="人员文档说明",hidden=true)

public class RoleController {
    @Resource(name = "roleServiceImpl")
    IRoleService iRoleService;

    //角色列表接口
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ApiOperation(value="查询所有的角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="显示的页",dataType="Integer", paramType = "query"),
            @ApiImplicitParam(name="pagesize",value="每页的数量",dataType="Integer", paramType = "query"),
    })
    @ApiResponse(response= ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData<HashMap> roleList(@RequestParam(value = "page", required = false,defaultValue="1") Integer page,
                                                @RequestParam(value = "pagesize", required = false,defaultValue="2") Integer pagesize){
        return iRoleService.rolelist(page,pagesize);
    }


    //添加角色接口
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ApiOperation(value="/添加角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="roleName",value="模块名称",dataType="String")
    })
    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData addUser(@Valid RoleDto role){
        return iRoleService.addRole(role);
    }

    //修改用户接口
    @RequestMapping(value="/edit", method = RequestMethod.POST)
    @ApiOperation(value="/修改角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="roleName",value="模块名称",dataType="String")
    })
    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    //roleId参数可以不写  swagger问题导致接口文档不展示 后续解决
    public ResponseCommonData editRole(@Valid RoleDto role, Integer roleId){

        return iRoleService.editRole(role);
    }

    //删除角色
    @RequestMapping(value="/del", method = RequestMethod.POST)
    @ApiOperation(value="/删除角色接口")

    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData delUser(@RequestParam(value = "roleId", required = true) Integer roleId){
        return iRoleService.delRole(roleId);
    }



}
