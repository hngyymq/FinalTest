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
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bean.User;

/**
 * 本方法为登录方法
 * 访问的路径应为/LoginServlet
 * 就可以调用该方法
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

    //处理get请求(通过浏览器路径去访问)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	//处理get请求(通过表单提交去访问)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//浏览器所携带的信息都在request中
		//所以从request获取 参数(英文名Parameter) 中的user和password
		//getParameter("user") 方法中的user 是表单中input的name值
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		//获取session 为以后将用户信息放入session做准备
		HttpSession session = request.getSession();

//		动态查询(将user和password传入 数据库中进行查询，如果找到记录并返回【就是说明有账号密码正确】)
//		定义数据库的地址 其中jdbc:mysql://localhost:3306是固定写法 ，/demo是mysql中的哪个数据库  我新建的库叫demo
		String url="jdbc:mysql://localhost:3306/test";
//		定义mysql账号和密码
    	String dbuser="root";
    	String dbpassword="root";
//    	定义查询语句 其中？是匹配符 后面去加参数的时候替代这个？
    	String sql="select * from user where  user=? and password=? and role=?";
    	
//    	定义连接
    	Connection con=null;
//    	定义执行平台
    	PreparedStatement st=null;
//    	定义查询出来的结果集
    	ResultSet resultSet =null;
    	
    	
    	try {
//    		获取驱动文件
			Class.forName("com.mysql.jdbc.Driver");
//			建立连接
			con=(Connection) DriverManager.getConnection(url, dbuser, dbpassword);
//			建立好连接后预备执行语句
			st=(PreparedStatement) con.prepareStatement(sql);
//			设置参数 替代查询语句中的 ？  方法的第一个参数是 索引值（从1开始） ,第二个参数是你想查询的内容
			st.setString(1, user);
			st.setString(2, password);
			st.setString(3, role);
//			进行查询 --》并返回结果到resultSet 至此数据就已经查询出来了
			resultSet = st.executeQuery();
			
//			将查询出来的数据进行遍历 -->这里用while循环  resultSet.next()是看下一个元素是不是空，如果不是空就遍历下一个
//			如果是空就返回false 就跳出循环
//			这里的resultSet就是当前的结果
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String preuser = resultSet.getString("user");
				String prepassword = resultSet.getString("password");
				String prerole =resultSet.getString("role");
				System.out.println(preuser+"登录成功");
				User sessionUser = new User();
				sessionUser.setId(id);
				sessionUser.setUser(preuser);
				sessionUser.setPassword(prepassword);
				sessionUser.setRole(prerole);
				//将用户放入session中
				session.setAttribute("user", sessionUser);
				
				if("0".equals(role)) {
					response.sendRedirect("index.jsp");
					return;
				}else {
					response.sendRedirect("web.jsp");
					return;
				}
			}
			
//				没找到用户 --》设置错误信息
				request.setAttribute("message", "账号密码不匹配登录失败！");
//				转发到登录页面【因为要携带错误数据，所以用转发】
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			
	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}    
		}
 
	}

}
