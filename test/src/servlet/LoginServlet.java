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
 * ������Ϊ��¼����
 * ���ʵ�·��ӦΪ/LoginServlet
 * �Ϳ��Ե��ø÷���
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

    //����get����(ͨ�������·��ȥ����)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	//����get����(ͨ�����ύȥ����)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//�������Я������Ϣ����request��
		//���Դ�request��ȡ ����(Ӣ����Parameter) �е�user��password
		//getParameter("user") �����е�user �Ǳ���input��nameֵ
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		//��ȡsession Ϊ�Ժ��û���Ϣ����session��׼��
		HttpSession session = request.getSession();

//		��̬��ѯ(��user��password���� ���ݿ��н��в�ѯ������ҵ���¼�����ء�����˵�����˺�������ȷ��)
//		�������ݿ�ĵ�ַ ����jdbc:mysql://localhost:3306�ǹ̶�д�� ��/demo��mysql�е��ĸ����ݿ�  ���½��Ŀ��demo
		String url="jdbc:mysql://localhost:3306/test";
//		����mysql�˺ź�����
    	String dbuser="root";
    	String dbpassword="root";
//    	�����ѯ��� ���У���ƥ��� ����ȥ�Ӳ�����ʱ����������
    	String sql="select * from user where  user=? and password=? and role=?";
    	
//    	��������
    	Connection con=null;
//    	����ִ��ƽ̨
    	PreparedStatement st=null;
//    	�����ѯ�����Ľ����
    	ResultSet resultSet =null;
    	
    	
    	try {
//    		��ȡ�����ļ�
			Class.forName("com.mysql.jdbc.Driver");
//			��������
			con=(Connection) DriverManager.getConnection(url, dbuser, dbpassword);
//			���������Ӻ�Ԥ��ִ�����
			st=(PreparedStatement) con.prepareStatement(sql);
//			���ò��� �����ѯ����е� ��  �����ĵ�һ�������� ����ֵ����1��ʼ�� ,�ڶ��������������ѯ������
			st.setString(1, user);
			st.setString(2, password);
			st.setString(3, role);
//			���в�ѯ --�������ؽ����resultSet �������ݾ��Ѿ���ѯ������
			resultSet = st.executeQuery();
			
//			����ѯ���������ݽ��б��� -->������whileѭ��  resultSet.next()�ǿ���һ��Ԫ���ǲ��ǿգ�������ǿվͱ�����һ��
//			����ǿվͷ���false ������ѭ��
//			�����resultSet���ǵ�ǰ�Ľ��
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String preuser = resultSet.getString("user");
				String prepassword = resultSet.getString("password");
				String prerole =resultSet.getString("role");
				System.out.println(preuser+"��¼�ɹ�");
				User sessionUser = new User();
				sessionUser.setId(id);
				sessionUser.setUser(preuser);
				sessionUser.setPassword(prepassword);
				sessionUser.setRole(prerole);
				//���û�����session��
				session.setAttribute("user", sessionUser);
				
				if("0".equals(role)) {
					response.sendRedirect("index.jsp");
					return;
				}else {
					response.sendRedirect("web.jsp");
					return;
				}
			}
			
//				û�ҵ��û� --�����ô�����Ϣ
				request.setAttribute("message", "�˺����벻ƥ���¼ʧ�ܣ�");
//				ת������¼ҳ�桾��ΪҪЯ���������ݣ�������ת����
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
