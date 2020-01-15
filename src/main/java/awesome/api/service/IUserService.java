package awesome.api.service;

import awesome.api.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 特殊用户角色：财务-处理充值、提现任务；客户-处理余额不足提醒任务；交易员-处理买入卖出任务 服务类
 * </p>
 *
 * @author yu
 * @since 2020-01-13
 */
public interface IUserService extends IService<User> {

}
