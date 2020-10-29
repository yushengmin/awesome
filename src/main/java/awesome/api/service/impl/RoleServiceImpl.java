package awesome.api.service.impl;

import awesome.api.dto.RoleDto;
import awesome.api.entity.Role;
import awesome.api.mapper.RoleMapper;
import awesome.api.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {


    @Autowired
    RoleMapper roleMapper;

    public ResponseCommonData<HashMap> rolelist(Integer page, Integer pagesize){
        PageHelper.startPage(page, pagesize);
        List<Role> rolelist=this.list();
        PageInfo<Role> pageInfo = new PageInfo<Role>(rolelist);
        HashMap<String,Object> map =new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("list",pageInfo.getList());
        ResponseCommonData<HashMap> responseCommonData=new ResponseCommonData<HashMap>(map);
        return responseCommonData;
    }


    public ResponseCommonData addRole(RoleDto role){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        Long time=System.currentTimeMillis();
        role.setCreateTime(time);
        role.setModifyTime(time);
        if(this.save(role)){
            responseCommonData.setMsg("添加成功");
        }
        else {
            responseCommonData.setStatus(-200);
            responseCommonData.setMsg("添加失败");
        }
        return responseCommonData;
    }

    public ResponseCommonData editRole(RoleDto role){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        Long time=System.currentTimeMillis();
        System.out.println(role.getRoleId());
        role.setModifyTime(time);
        if(this.updateById(role)){
            responseCommonData.setMsg("更新成功");
        }
        else {
            responseCommonData.setStatus(-1);
            responseCommonData.setMsg("更新失败");
        }
        return responseCommonData;
    }

    public ResponseCommonData delRole(Integer roleId){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        if(this.removeById(roleId)){
            responseCommonData.setMsg("删除成功");
        }else {
            responseCommonData.setStatus(-1);
            responseCommonData.setMsg("删除失败");

        }
        return responseCommonData;

    }


}
