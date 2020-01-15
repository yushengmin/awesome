package awesome.api.service.impl;

import awesome.api.entity.UserRole;
import awesome.api.mapper.UserRoleMapper;
import awesome.api.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yu
 * @since 2020-01-15
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
