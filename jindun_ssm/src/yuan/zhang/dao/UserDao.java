package yuan.zhang.dao;

import org.apache.ibatis.annotations.Param;

import yuan.zhang.entity.User;

public interface UserDao {

	// 根据用户名查找用户
	public User findUserByusername(String username);

	// 修改用户信息(多个参数映射到配置文件使用注解的方式)
	//public boolean updateUser(@Param("user")User user, @Param("username")String username);
	public void updateUser(@Param("user")User user, @Param("username")String username);

	// 注册用户信息
	//public boolean addUser(User user);
	public void addUser(User user);
}
