package awesome;

import awesome.api.dto.UserRoleDto;
import awesome.api.entity.Role;
import awesome.api.mapper.RoleMapper;
import awesome.api.mapper.UserRoleMapper;
import awesome.api.service.IRoleService;
import awesome.response.ResponseCommonData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class AwesomeApplicationTests {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Resource(name = "roleServiceImpl")
    IRoleService iRoleService;


    @Test
    void contextLoads() {
//        List<Role> rolealllist=iRoleService.list();
//
//        List<UserRoleDto> rolealllist2=Arrays.asList(rolealllist.toArray(new UserRoleDto[rolealllist.size()]));
//        List<UserRoleDto> rolelist=userRoleMapper.getRoleById(1);
//        for (UserRoleDto userRoleDto : rolealllist2) {
//            for (UserRoleDto roleDto : rolelist) {
//                if(userRoleDto.getRoleId()==roleDto.getRoleId()){
//                    userRoleDto.setSelected(true);
//                }
//            }
//
//        }
//        ResponseCommonData<List<UserRoleDto>> responseCommonData=new  ResponseCommonData<List<UserRoleDto>>(rolealllist2);
//        System.out.println(responseCommonData);


        List<Object> listObect = new ArrayList<>();
        listObect.add("a");
        listObect.add("b");
        List<String> listString = Arrays.asList(listObect.toArray(new String[listObect.size()]));
        System.out.println(listString);

    }

}
