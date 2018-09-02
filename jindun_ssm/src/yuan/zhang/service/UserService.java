package yuan.zhang.service;

import yuan.zhang.entity.User;

public interface UserService {
	// 根据用户名查找用户
	public User findUserByusername(String username);

	// 修改用户信息
	// public boolean updateUser(User user, String username);
	public void updateUser(User user, String username);

	// 注册用户信息
	// public boolean addUser(User user);
	public void addUser(User user);
}
