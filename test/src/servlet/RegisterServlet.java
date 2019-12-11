package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 本方法为注册方法
 * 访问的路径应为/RegisterServlet
 * 就可以调用该方法
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//浏览器所携带的信息都在request中
				//所以从request获取 参数(英文名Parameter) 中的user和password
				//getParameter("user") 方法中的user 是表单中input的name值
				String user = request.getParameter("user");
				String password = request.getParameter("password");
				
				
//				动态查询(将user和password传入 数据库中进行查询，如果找到记录并返回【就是说明有账号密码正确】)
//				定义数据库的地址 其中jdbc:mysql://localhost:3306是固定写法 ，/demo是mysql中的哪个数据库  我新建的库叫demo
				String url="jdbc:mysql://localhost:3306/test";
//				定义mysql账号和密码
		    	String dbuser="root";
		    	String dbpassword="root";
//		    	定义查询语句 其中？是匹配符 后面去加参数的时候替代这个？
//		    	查询用户是否存在
		    	String sql1="select * from user where  user=? and password=?";
//		    	如果用户不存在添加用户
		    	String sql2="insert into user(user,password) values(?,?)";
//		    	定义连接
		    	Connection con=null;
//		    	定义执行平台
		    	PreparedStatement st1=null;//用于判断是否存在
		    	PreparedStatement st2=null;//用于添加用户
//		    	定义查询出来的结果集
		    	ResultSet resultSet =null; //根据用户和密码返回存在的用户 如果存在则不为null 如果不存在则为null
		    	
		    	
		    	try {
//		    		获取驱动文件
					Class.forName("com.mysql.jdbc.Driver");
//					建立连接
					con=(Connection) DriverManager.getConnection(url, dbuser, dbpassword);
//					建立好连接后预备执行语句
					st1=(PreparedStatement) con.prepareStatement(sql1);
//					设置参数 替代查询语句中的 ？  方法的第一个参数是 索引值（从1开始） ,第二个参数是你想查询的内容
					st1.setString(1, user);
					st1.setString(2, password);
//					进行查询 --》并返回结果到resultSet 至此数据就已经查询出来了
					resultSet = st1.executeQuery();
					
//					将查询出来的数据进行遍历 -->这里用while循环  resultSet.next()是看下一个元素是不是空，如果不是空就遍历下一个
//					如果是空就返回false 就跳出循环
//					这里的resultSet就是当前的结果
					while(resultSet.next()) {
						//进入循环说明用户存在
						request.setAttribute("message", "用户已存在,请重试！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);;
						return;
					}
					
//					建立好连接后预备执行语句
					st2=(PreparedStatement) con.prepareStatement(sql2);
//					设置参数 替代查询语句中的 ？  方法的第一个参数是 索引值（从1开始） ,第二个参数是插入的内容
					st2.setString(1, user);
					st2.setString(2, password);
					st2.execute();
					
					//注册成功重定向到login页面
//					response.sendRedirect("login.jsp");
					
					//注册成功转发到登录页面
					request.setAttribute("message", "您已注册成功！请进行登录！！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);;
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						resultSet.close();
						st1.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}    
				}
		    	
	}

}
