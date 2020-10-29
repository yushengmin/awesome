package awesome.api.service.impl;

import awesome.api.dto.ModuleDto;
import awesome.api.dto.RoleDto;
import awesome.api.entity.Module;
import awesome.api.entity.Role;
import awesome.api.mapper.ModuleMapper;
import awesome.api.mapper.RoleMapper;
import awesome.api.service.IModuleService;
import awesome.response.ResponseCommonData;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yu
 * @since 2020-01-23
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {
    @Autowired
    ModuleMapper moduleMapper;

    public ResponseCommonData<HashMap> modulelist(Integer page, Integer pagesize){
        PageHelper.startPage(page, pagesize);
        List<Module> modulelist=this.list();
        PageInfo<Module> pageInfo = new PageInfo<Module>(modulelist);
        HashMap<String,Object> map =new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("list",pageInfo.getList());
        ResponseCommonData<HashMap> responseCommonData=new ResponseCommonData<HashMap>(map);
        return responseCommonData;
    }

    public ResponseCommonData addmodule(ModuleDto module){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        Long time=System.currentTimeMillis();
        module.setCreateTime(time);
        module.setModifyTime(time);
        if(this.save(module)){
            responseCommonData.setMsg("添加成功");
        }
        else {
            responseCommonData.setStatus(-200);
            responseCommonData.setMsg("添加失败");
        }
        return responseCommonData;
    }

    public ResponseCommonData editmodule(ModuleDto module){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        Long time=System.currentTimeMillis();
        module.setModifyTime(time);
        if(this.updateById(module)){
            responseCommonData.setMsg("更新成功");
        }
        else {
            responseCommonData.setStatus(-1);
            responseCommonData.setMsg("更新失败");
        }
        return responseCommonData;
    }


    public ResponseCommonData delmodule(Integer moduleId){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        if(this.removeById(moduleId)){
            responseCommonData.setMsg("删除成功");
        }else {
            responseCommonData.setStatus(-1);
            responseCommonData.setMsg("删除失败");

        }
        return responseCommonData;

    }

}
