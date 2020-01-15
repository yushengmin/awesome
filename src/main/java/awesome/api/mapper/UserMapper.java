package awesome.api.mapper;

import awesome.api.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 特殊用户角色：财务-处理充值、提现任务；客户-处理余额不足提醒任务；交易员-处理买入卖出任务 Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2020-01-13
 */
public interface UserMapper extends BaseMapper<User> {

}
