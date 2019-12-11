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
 * ������Ϊע�᷽��
 * ���ʵ�·��ӦΪ/RegisterServlet
 * �Ϳ��Ե��ø÷���
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
				//�������Я������Ϣ����request��
				//���Դ�request��ȡ ����(Ӣ����Parameter) �е�user��password
				//getParameter("user") �����е�user �Ǳ���input��nameֵ
				String user = request.getParameter("user");
				String password = request.getParameter("password");
				
				
//				��̬��ѯ(��user��password���� ���ݿ��н��в�ѯ������ҵ���¼�����ء�����˵�����˺�������ȷ��)
//				�������ݿ�ĵ�ַ ����jdbc:mysql://localhost:3306�ǹ̶�д�� ��/demo��mysql�е��ĸ����ݿ�  ���½��Ŀ��demo
				String url="jdbc:mysql://localhost:3306/test";
//				����mysql�˺ź�����
		    	String dbuser="root";
		    	String dbpassword="root";
//		    	�����ѯ��� ���У���ƥ��� ����ȥ�Ӳ�����ʱ����������
//		    	��ѯ�û��Ƿ����
		    	String sql1="select * from user where  user=? and password=?";
//		    	����û�����������û�
		    	String sql2="insert into user(user,password) values(?,?)";
//		    	��������
		    	Connection con=null;
//		    	����ִ��ƽ̨
		    	PreparedStatement st1=null;//�����ж��Ƿ����
		    	PreparedStatement st2=null;//��������û�
//		    	�����ѯ�����Ľ����
		    	ResultSet resultSet =null; //�����û������뷵�ش��ڵ��û� ���������Ϊnull �����������Ϊnull
		    	
		    	
		    	try {
//		    		��ȡ�����ļ�
					Class.forName("com.mysql.jdbc.Driver");
//					��������
					con=(Connection) DriverManager.getConnection(url, dbuser, dbpassword);
//					���������Ӻ�Ԥ��ִ�����
					st1=(PreparedStatement) con.prepareStatement(sql1);
//					���ò��� �����ѯ����е� ��  �����ĵ�һ�������� ����ֵ����1��ʼ�� ,�ڶ��������������ѯ������
					st1.setString(1, user);
					st1.setString(2, password);
//					���в�ѯ --�������ؽ����resultSet �������ݾ��Ѿ���ѯ������
					resultSet = st1.executeQuery();
					
//					����ѯ���������ݽ��б��� -->������whileѭ��  resultSet.next()�ǿ���һ��Ԫ���ǲ��ǿգ�������ǿվͱ�����һ��
//					����ǿվͷ���false ������ѭ��
//					�����resultSet���ǵ�ǰ�Ľ��
					while(resultSet.next()) {
						//����ѭ��˵���û�����
						request.setAttribute("message", "�û��Ѵ���,�����ԣ�");
						request.getRequestDispatcher("/register.jsp").forward(request, response);;
						return;
					}
					
//					���������Ӻ�Ԥ��ִ�����
					st2=(PreparedStatement) con.prepareStatement(sql2);
//					���ò��� �����ѯ����е� ��  �����ĵ�һ�������� ����ֵ����1��ʼ�� ,�ڶ��������ǲ��������
					st2.setString(1, user);
					st2.setString(2, password);
					st2.execute();
					
					//ע��ɹ��ض���loginҳ��
//					response.sendRedirect("login.jsp");
					
					//ע��ɹ�ת������¼ҳ��
					request.setAttribute("message", "����ע��ɹ�������е�¼����");
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
