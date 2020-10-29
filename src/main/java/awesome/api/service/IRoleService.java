package awesome.api.service;

import awesome.api.dto.RoleDto;
import awesome.api.entity.Role;
import awesome.response.ResponseCommonData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yu
 * @since 2020-01-23
 */
public interface IRoleService extends IService<Role> {
    public ResponseCommonData<HashMap> rolelist(Integer pag, Integer pagesize);
    public ResponseCommonData addRole(RoleDto role);
    public ResponseCommonData editRole(RoleDto role);
    public ResponseCommonData delRole(Integer roleId);

}
