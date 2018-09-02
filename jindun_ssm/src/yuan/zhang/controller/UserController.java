package yuan.zhang.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import yuan.zhang.entity.User;
import yuan.zhang.service.UserService;

@SessionAttributes(value = "user") // 将User对象都加入session范围
@Controller
@RequestMapping("user")
public class UserController {
	// 指定@Autowired标识的属性，按“属性名”自动装配
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	// 根据用户名查找用户
	@RequestMapping("login")
	public String findUserByusername(@RequestParam("username") String username,
			@RequestParam("password") String password, Map<String, Object> map) {
		User user = userService.findUserByusername(username);
		// 用户存在
		if (user != null) {
			// 密码正确
			if (password.equals(user.getPassword())) {
				map.put("user", user);
				return "forward:/views/index.jsp"; // 登录到网站主页
			} else {
				map.put("passWordError", "passWorderror");
				return "redirect:/views/login.jsp";
			}
		} else {
			map.put("userError", "usererror");
			return "redirect:/views/login.jsp";
		}
	}

	// 修改用户信息
	@RequestMapping("updateUser")
	public String updateUser(@RequestParam("username") String username, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("newPassword2") String newPassword2,
			Map<String, Object> map) {
		// boolean flag = false;//标志旧密码是否正确
		User user = userService.findUserByusername(username);
		// 用户存在
		if (user != null) {
			// 密码正确
			if (oldPassword.equals(user.getPassword())) {
				User newUser = new User(username, newPassword);
				userService.updateUser(newUser, username);
				// flag=true;//密码正确
			} else {
				// flag=false;//旧密码不对
				map.put("passwordError", "原始密码错误，请重新输入！");
				return "forward:/views/record_3.jsp";
			}
		} else {
			map.put("userError", "用户不存在！");
			return "forward:/views/record_3.jsp";
		}
		// 新密码验证正确
		if (newPassword.equals(newPassword2)) {
			map.put("success", "修改成功！请重新登录！");
			return "redirect:/views/login.jsp";
		} else {
			map.put("failing", "修改失败！");
			return "forward:/views/record_3.jsp";
		}
	}

	// 注册用户信息
	@RequestMapping("register")
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception, Exception {
		//编码方式
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
		// 验证码
		String piccode = (String) request.getSession().getAttribute("piccode");
		String checkcode = request.getParameter("checkcode");
		// 将验证码转换为大写
		checkcode = checkcode.toUpperCase();
		PrintWriter out = response.getWriter();

		// 接收客户输入的数据
		String userName = request.getParameter("username");
		User user1 = userService.findUserByusername(userName);
		int LTID = Integer.parseInt(request.getParameter("LTID"));
		String passWord = request.getParameter("password");
		String passWord2 = request.getParameter("password2");
		User user = new User(userName, passWord, LTID);

		// * 用户名为空跳转至enroll.jsp 否则注册成功

		if (userName != null && passWord.equals(passWord2)) {
			// 用户不存在
			if (user1 == null) {
				// 正确登陆
				// boolean result = false;
				if (checkcode.equals(piccode)) {
					userService.addUser(user);
					request.setAttribute("error", "注册成功");
					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
				} else {
					request.setAttribute("a", "用户已存在");
					response.sendRedirect("/views/enroll.jsp");
				}
			} else {
				request.setAttribute("a", "用户已存在");
				request.getRequestDispatcher("/views/enroll.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("a", "输入错误");
			request.getRequestDispatcher("/views/enroll.jsp").forward(request, response);
		}
		out.flush();
		out.close();
	}

	// 绘画验证码
	@RequestMapping("imageCheck")
	public void imageCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BufferedImage b = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics g = b.getGraphics();
		Color c = new Color(200, 150, 255);
		g.setColor(c);
		g.fillRect(0, 0, 68, 22);

		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r = new Random();
		int len = ch.length, index;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			g.drawString(ch[index] + "", (i * 15) + 3, 18);
			sb.append(ch[index]);
		}
		request.getSession().setAttribute("piccode", sb.toString());
		ImageIO.write(b, "JPG", response.getOutputStream());
	}
	
	//忘记密码
	@RequestMapping("forgetPwd")
	public void forgetPwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("uname");
		int LTID = Integer.parseInt(request.getParameter("LTID"));
		//UserService service = new UserService();
		User user = userService.findUserByusername(username);
		if(user!=null){
			if(user.getLTID()==LTID) {
				        request.setAttribute("error", "您的密码是："+user.getPassword());
						request.getRequestDispatcher("/views/login.jsp").forward(request, response);
					}else {
						request.setAttribute("error", "卡号错误，请重新输入！");
						request.getRequestDispatcher("/views/forgetpwd.jsp").forward(request, response);
					}
			}else{
				request.setAttribute("error", "用户名错误或用户不存在，请重新输入！");
				request.getRequestDispatcher("/views/forgetpwd.jsp").forward(request, response);
			}
	}
}
