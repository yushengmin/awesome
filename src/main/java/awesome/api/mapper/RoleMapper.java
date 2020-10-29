package awesome.api.mapper;

import awesome.api.dto.UserRoleDto;
import awesome.api.entity.Role;
import awesome.api.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2020-01-23
 */
public interface RoleMapper extends BaseMapper<Role> {


}
