package awesome.api.mapper;

import awesome.api.dto.UserRoleDto;
import awesome.api.entity.UserRole;
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
public interface UserRoleMapper extends BaseMapper<UserRole> {
    @Select("SELECT c.role_name,c.role_id from users as a  left join user_role as b on a.user_id=b.user_id\n" +
            "left join role as c on b.role_id=c.role_id where a.user_id=#{id};")
    List<UserRoleDto> getRoleById(@Param("id") Integer id);

    @Select("SELECT * from role")
    List<UserRoleDto> getRoleList();

}
