package awesome.api.service.impl;

import awesome.api.dto.UserRoleDto;
import awesome.api.entity.Role;
import awesome.api.entity.UserRole;
import awesome.api.mapper.RoleMapper;
import awesome.api.mapper.UserRoleMapper;
import awesome.api.service.IRoleService;
import awesome.api.service.IUserRoleService;
import awesome.response.ResponseCommonData;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleMapper roleMapper;

    @Resource(name = "roleServiceImpl")
    IRoleService iRoleService;


    public ResponseCommonData<List<UserRoleDto>> userRoleList(Integer userId){
        List<UserRoleDto> rolealllist=userRoleMapper.getRoleList();
        List<UserRoleDto> rolelist=userRoleMapper.getRoleById(userId);
        for (UserRoleDto userRoleDto : rolealllist) {
            for (UserRoleDto roleDto : rolelist) {
                if(userRoleDto.getRoleId()==roleDto.getRoleId()){
                    userRoleDto.setSelected(true);
                }
            }

        }

        ResponseCommonData<List<UserRoleDto>> responseCommonData=new  ResponseCommonData<List<UserRoleDto>>(rolealllist);
        return responseCommonData;




    }


}
