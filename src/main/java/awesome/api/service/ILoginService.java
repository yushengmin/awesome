package awesome.api.service;

import awesome.api.entity.User;
import awesome.response.ResponseCommonData;
import awesome.response.ResponseCommonData2;

public interface ILoginService {

//	public String checkUser(HttpServletRequest request, User user);
	public ResponseCommonData checkUser(User user);

//	public void setsession(User user);

//	public void loginout(HttpServletRequest request);


//	public List<Function> menu(HttpServletRequest request);


	//public Map<String,List<Function>> munes(HttpServletRequest request);

}
