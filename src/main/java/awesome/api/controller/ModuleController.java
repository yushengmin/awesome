package awesome.api.controller;


import awesome.api.dto.ModuleDto;
import awesome.api.dto.RoleDto;
import awesome.api.service.IModuleService;
import awesome.api.service.IRoleModuleService;
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
@RequestMapping("/module")
@Api(tags = "模块接口",description="说明",hidden=true)
public class ModuleController {
    @Resource(name = "moduleServiceImpl")
    IModuleService iModuleService;

    //角色列表接口
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ApiOperation(value="模块列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="显示的页",dataType="Integer", paramType = "query"),
            @ApiImplicitParam(name="pagesize",value="每页的数量",dataType="Integer", paramType = "query"),
    })
    @ApiResponse(response= ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData<HashMap> roleList(@RequestParam(value = "page", required = false,defaultValue="1") Integer page,
                                                @RequestParam(value = "pagesize", required = false,defaultValue="2") Integer pagesize){
        return iModuleService.modulelist(page,pagesize);
    }

    //添加模块接口
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ApiOperation(value="/添加模块接口")
    @ApiImplicitParams({

    })
    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData addModule(@Valid  ModuleDto moduleDtos){
        return iModuleService.addmodule(moduleDtos);
    }
//
    //修改用户接口
    @RequestMapping(value="/edit", method = RequestMethod.POST)
    @ApiOperation(value="/修改模块接口")
    @ApiImplicitParams({

    })
    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    //moduleId参数可以不写  swagger问题导致接口文档不展示 后续解决
    public ResponseCommonData editRole(@Valid ModuleDto moduledto, Integer moduleId){
        return iModuleService.editmodule(moduledto);
    }


    //删除模块
    @RequestMapping(value="/del", method = RequestMethod.POST)
    @ApiOperation(value="/删除模块接口")

    @ApiResponse(response=ResponseCommonData.class, code = 200, message = "接口返回对象参数")
    public ResponseCommonData delUser(@RequestParam(value = "moduleId", required = true) Integer moduleId){
        return iModuleService.delmodule(moduleId);
    }





}
