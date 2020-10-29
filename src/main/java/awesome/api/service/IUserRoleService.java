package awesome.api.service;

import awesome.api.dto.UserRoleDto;
import awesome.api.entity.Role;
import awesome.api.entity.UserRole;
import awesome.response.ResponseCommonData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yu
 * @since 2020-01-23
 */
public interface IUserRoleService extends IService<UserRole> {
    public ResponseCommonData<List<UserRoleDto>> userRoleList(Integer userId);


}
