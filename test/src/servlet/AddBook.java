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
 * ���ͼ�鷽��
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String type = request.getParameter("type");
		String desca = request.getParameter("desca");
		
		/**
		 * �������ݿⲢ�������
		 */
		String url="jdbc:mysql://localhost:3306/test";
		String dbuser="root";
    	String dbpassword="root";
    	String sql="insert into book(bookname,author,price,type,desca) values(?,?,?,?,?)";
    	Connection con=null;
    	PreparedStatement st=null;
    	ResultSet resultSet =null;
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection(url, dbuser, dbpassword);
			st=(PreparedStatement) con.prepareStatement(sql);
			st.setString(1, bookname);
			st.setString(2, author);
			st.setString(3, price);
			st.setString(4, type);
			st.setString(5, desca);
			st.execute();	
			request.setAttribute("message", "��ɹ����ͼ�飡");
			request.getRequestDispatcher("add.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "���ͼ��ʧ�ܣ�������ͼ�����Ƿ�ֻ�������֣�");
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}    
		}
    
		
	}

}
