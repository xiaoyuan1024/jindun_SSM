package yuan.zhang.service.imp;

import yuan.zhang.dao.UserDao;
import yuan.zhang.entity.User;
import yuan.zhang.service.UserService;

public class UserServiceImp implements UserService {

	// setter方式注入
	private UserDao userDao;// 成员变量名对应Spring配置文件bean中的name

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;// 参数名对应Spring配置文件bean中的ref
	}

	// 根据用户名查找用户
	@Override
	public User findUserByusername(String username) {
		return userDao.findUserByusername(username);
	}

	// 修改用户信息
	@Override
	public void updateUser(User user, String username) {
		userDao.updateUser(user, username);
	}

	// 添加用户信息
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

}
