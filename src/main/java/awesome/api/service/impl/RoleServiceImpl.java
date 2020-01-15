package awesome.api.service.impl;

import awesome.api.entity.Role;
import awesome.api.mapper.RoleMapper;
import awesome.api.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
