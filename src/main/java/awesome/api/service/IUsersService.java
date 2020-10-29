package awesome.api.service;

import awesome.api.dto.AddUserDto;
import awesome.api.dto.UpdateUserDto;
import awesome.api.entity.Users;
import awesome.response.ResponseCommonData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 特殊用户角色：财务-处理充值、提现任务；客户-处理余额不足提醒任务；交易员-处理买入卖出任务 服务类
 * </p>
 *
 * @author yu
 * @since 2020-01-22
 */
public interface IUsersService extends IService<Users> {
    public ResponseCommonData<HashMap> userlist(Integer pag, Integer pagesize);
    public ResponseCommonData addUser(AddUserDto users);
    public ResponseCommonData editUser(UpdateUserDto users);
    public ResponseCommonData changePassword(Integer userId,String password);
    public ResponseCommonData delUser(Integer userId);



}
