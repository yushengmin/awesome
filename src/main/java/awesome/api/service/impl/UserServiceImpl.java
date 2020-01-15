package awesome.api.service.impl;

import awesome.api.entity.User;
import awesome.api.mapper.UserMapper;
import awesome.api.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 特殊用户角色：财务-处理充值、提现任务；客户-处理余额不足提醒任务；交易员-处理买入卖出任务 服务实现类
 * </p>
 *
 * @author yu
 * @since 2020-01-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
