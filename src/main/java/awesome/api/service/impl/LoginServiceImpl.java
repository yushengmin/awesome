package awesome.api.service.impl;

import awesome.api.entity.User;
import awesome.api.mapper.UserMapper;
import awesome.api.service.ILoginService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private UserMapper userMapper;

//	@Autowired
//	private FunctionMapper funcMapper;
//
//	@Autowired
//	private FuncroleMapper funcroleMapper;
//
//	@Autowired
//	private RoleMapper roleMapper;
//

	@Override
	public String checkUser(User user) {
        String password= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", user.getAccount());
        User dbUser = userMapper.selectOne(queryWrapper);
        System.out.println(dbUser);
        System.out.println(user);
        if (dbUser == null) {
            return "用户不存在";
        }
        else {
            if (dbUser.getPassword().equals(password)) {
                return "登录成功";
            } else {
                return "密码错误";
            }
        }

    }

    public static void main(String[] args) {
        LoginServiceImpl loginService=new LoginServiceImpl();
        User user=new User();
        user.setName("admin1");
        user.setPassword("admin");
        loginService.checkUser(user);


    }
//	@Override
//	public void loginout(HttpServletRequest request) {
//		request.getSession().removeAttribute("user");
//	}


//	public List<Function> mune(HttpServletRequest request) {
//		List<Function> allRoleFuntionList = new ArrayList<Function>();
//		//当前用户有权限的菜单
//		User user=(User)request.getSession().getAttribute("user");
//		FuncroleCriteria example=new FuncroleCriteria();
//		example.createCriteria().andRoleidEqualTo(user.getRoleid());
//		List<Funcrole> objs1=funcroleMapper.selectByExample(example);
//		//所有菜单
//		FunctionCriteria example1=new FunctionCriteria();
//		example1.setOrderByClause("func_order");
//		List<Function> objs2 = funcMapper.selectByExample(example1);
//
//		//过滤该用户有权限的菜单
//		for(Function f:objs2){
//			for(Funcrole o:objs1){
//				if(o.getFuncid().equals(f.getFuncid())){
//					allRoleFuntionList.add(f);
//				}
//			}
//		}
//		return allRoleFuntionList;
//	}



}
