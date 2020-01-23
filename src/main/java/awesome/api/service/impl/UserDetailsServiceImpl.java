package awesome.api.service.impl;

import awesome.api.entity.Users;
import awesome.api.mapper.UsersMapper;
import awesome.api.service.IUsersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service(value = "userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier(value = "usersServiceImpl")
	private IUsersService userService;

	@Autowired
	private UsersMapper sysUserMapper;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", username);
		Users dbUser = sysUserMapper.selectOne(queryWrapper);
		if (Objects.nonNull(dbUser)) {
			return User.withUsername(username).password(dbUser.getPassword())
					.authorities(AuthorityUtils.NO_AUTHORITIES)
					.build();
		}
		else {
			return User.withUsername("yu").password("123456")
					.authorities(AuthorityUtils.NO_AUTHORITIES)
					.build();

		}

	}

}
