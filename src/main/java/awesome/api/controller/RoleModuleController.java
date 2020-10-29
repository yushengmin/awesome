package awesome.api.controller;


import awesome.api.entity.RoleModule;
import awesome.api.service.IRoleModuleService;
import awesome.response.Data;
import awesome.response.Data2;
import awesome.response.ResponseCommonData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class RoleModuleController {
    @Resource(name = "roleModuleServiceImpl")
    IRoleModuleService iRoleModuleService;
    @RequestMapping(value="/rolemodule", method = RequestMethod.GET)
    public ResponseCommonData<HashMap> list(int pagefirst, int pagesize){
        System.out.println(pagefirst);
        System.out.println(pagesize);
        PageHelper.startPage(pagefirst, pagesize);
        List<RoleModule> rolelist=iRoleModuleService.list();
        PageInfo<RoleModule> pageInfo = new PageInfo<RoleModule>(rolelist);
        System.out.println("==================");
        System.out.println(pageInfo);
        System.out.println(pageInfo.getList().size());
        HashMap<String,Object> map =new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("list",pageInfo.getList());
        ResponseCommonData<HashMap> responseCommonData=new ResponseCommonData<HashMap>(map);
        responseCommonData.setMsg("ok");
        return responseCommonData;


    }


}
