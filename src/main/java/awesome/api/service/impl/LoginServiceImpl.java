package awesome.api.service.impl;

import awesome.api.entity.User;
import awesome.api.mapper.UserMapper;
import awesome.api.service.ILoginService;
import awesome.common.Err;
import awesome.response.ResponseCommonData;
import awesome.response.ResponseCommonData2;
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
	public ResponseCommonData<String> checkUser(User user) {
        String password= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
//        System.out.println(DigestUtils.md5DigestAsHex("123".getBytes()));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", user.getAccount());
        User dbUser = userMapper.selectOne(queryWrapper);
//        System.out.println(dbUser);
//        System.out.println(user);
        if (dbUser == null) {
            ResponseCommonData<String> responseCommonData= new ResponseCommonData<>(Err.LOGIN_ERR_ERR);
            responseCommonData.setIslogin(false);
            return responseCommonData;
        }
        else {
            if (dbUser.getPassword().equals(password)) {
                return new ResponseCommonData<>();
            } else {
                ResponseCommonData<String> responseCommonData= new ResponseCommonData<>(Err.MODIFI_PASSWORD_ERR);
                responseCommonData.setIslogin(false);
                return responseCommonData;
            }
        }

    }
//    @Override
//    public void setsession(User user){






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
