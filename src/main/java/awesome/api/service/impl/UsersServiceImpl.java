package awesome.api.service.impl;

import awesome.api.dto.AddUserDto;
import awesome.api.dto.UpdateUserDto;
import awesome.api.entity.RoleModule;
import awesome.api.entity.Users;
import awesome.api.mapper.UsersMapper;
import awesome.api.service.IUsersService;
import awesome.response.ResponseCommonData;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 特殊用户角色：财务-处理充值、提现任务；客户-处理余额不足提醒任务；交易员-处理买入卖出任务 服务实现类
 * </p>
 *
 * @author yu
 * @since 2020-01-22
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;


    public ResponseCommonData<HashMap> userlist(Integer page, Integer pagesize){
        PageHelper.startPage(page, pagesize);
        List<Users> userlist=this.list();
        PageInfo<Users> pageInfo = new PageInfo<Users>(userlist);
        HashMap<String,Object> map =new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("list",pageInfo.getList());
        ResponseCommonData<HashMap> responseCommonData=new ResponseCommonData<HashMap>(map);
        return responseCommonData;

    }

    public ResponseCommonData addUser(AddUserDto users){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        users.setPassword(bcryptPasswordEncoder.encode(users.getPassword()));
        Long time=System.currentTimeMillis();
        users.setCreateTime(time);
        users.setModifyTime(time);
        if(this.save(users)){
            responseCommonData.setMsg("添加成功");
        }
        else {
            responseCommonData.setStatus(-200);
            responseCommonData.setMsg("添加失败");
        }
        return responseCommonData;
    }

    public ResponseCommonData editUser(UpdateUserDto users){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        Long time=System.currentTimeMillis();
        System.out.println(users.getUserId());
        users.setModifyTime(time);
        if(this.updateById(users)){
            responseCommonData.setMsg("更新成功");
        }
        else {
            responseCommonData.setStatus(-1);
            responseCommonData.setMsg("更新失败");
        }
        return responseCommonData;
    }

    public ResponseCommonData changePassword(Integer userId,String password){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        Users users=new Users();
        users.setUserId(userId);
        users.setPassword(bcryptPasswordEncoder.encode(password));
        if(this.updateById(users)){
            responseCommonData.setMsg("更新成功");
        }
        else {
            responseCommonData.setStatus(-1);
            responseCommonData.setMsg("更新失败");
        }
        return responseCommonData;
    }


    public ResponseCommonData delUser(Integer userId){
        ResponseCommonData responseCommonData=new ResponseCommonData();
        if(this.removeById(userId)){
            responseCommonData.setMsg("删除成功");
        }else {
            responseCommonData.setStatus(-1);
            responseCommonData.setMsg("删除失败");

        }
        return responseCommonData;

    }



}
