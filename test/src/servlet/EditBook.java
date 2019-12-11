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

import bean.Book;

/**
 * 添加图书方法
 */
@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		String url="jdbc:mysql://localhost:3306/test";
		String dbuser="root";
    	String dbpassword="root";
    	String sql="select * from book where id=?";
    	Connection con=null;
    	PreparedStatement st=null;
    	ResultSet resultSet =null;
		
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection(url, dbuser, dbpassword);
			st=(PreparedStatement) con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(id));
			resultSet = st.executeQuery();	
			
			Book prebook = new Book();
			while(resultSet.next()) {
				//获取数据
				String prebookname = resultSet.getString("bookname");
				String preauthor = resultSet.getString("author");
				double preprice = resultSet.getDouble("price");
				String predesca = resultSet.getString("desca");
				String pretype = resultSet.getString("type");
				
				//封装数据
				prebook.setId(Integer.parseInt(id));
				prebook.setBookname(prebookname);
				prebook.setAuthor(preauthor);
				prebook.setPrice(preprice);
				prebook.setDesca(predesca);
				prebook.setDesca(pretype);
			}
			request.setAttribute("book", prebook);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "修改失败");
			request.getRequestDispatcher("BookManager").forward(request, response);
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}    
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
