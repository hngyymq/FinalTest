package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bean.Book;

/**
 * ��ѯ����
 */
@WebServlet("/QueryAllBookServlet")
public class QueryAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryAllBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Book> booklist = new ArrayList<Book>();
		
		String url="jdbc:mysql://localhost:3306/test";
		String dbuser="root";
    	String dbpassword="root";
    	String sql="select * from book order by id asc";
    	Connection con=null;
    	PreparedStatement st=null;
    	ResultSet resultSet =null;
		
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection(url, dbuser, dbpassword);
			st=(PreparedStatement) con.prepareStatement(sql);
			resultSet = st.executeQuery();	
			
			while(resultSet.next()) {
				Book prebook = new Book();
				//��ȡ����
				int preid = resultSet.getInt("id");
				String prebookname = resultSet.getString("bookname");
				String preauthor = resultSet.getString("author");
				double preprice = resultSet.getDouble("price");
				String predesca = resultSet.getString("desca");
				
				//��װ����
				prebook.setId(preid);
				prebook.setBookname(prebookname);
				prebook.setAuthor(preauthor);
				prebook.setPrice(preprice);
				prebook.setDesca(predesca);
				//�ڼ��������book
				booklist.add(prebook);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "��ѯͼ��ʧ��");
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}    
		}
		
		request.setAttribute("booklist", booklist);
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
