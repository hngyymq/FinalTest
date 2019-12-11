package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

@WebFilter(filterName="/PemissionFilter",urlPatterns="/*")
public class PemissionFilter implements Filter {

    public PemissionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("������");
		// ����������Ӧ����ת��
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        // ��÷��ʽ����url�ļ���ַ
        String servletPath = req.getServletPath();
        HttpSession session = req.getSession();
        // ��ȡ��¼״̬
        User flag = (User) session.getAttribute("user");
        /* �ж��Ƿ��ǵ�¼ҳ����ҳ����¼servlet */
        if (servletPath != null && (servletPath.equals("login.jsp")  || servletPath.equals("/LoginServlet")|| servletPath.equals("/register.jsp") || servletPath.equals("/RegisterServlet"))) {
            // ����ֱ��ת������һ���
            chain.doFilter(request, response);
        } else {
            // ������֤��¼״̬
            if (flag != null) {
//                if (flag.equals("login_success")) {
//                    // ��¼�ɹ���ֱ��ת������һ���
//                    chain.doFilter(request, response);
//                } else {
//                    // ��¼ʧ�ܣ���ת����¼ҳ������֤��ǰ��ҳ��url�ļ�·��
//                    req.setAttribute("msg", "��¼ʧ��");
//                    req.setAttribute("return_uri", servletPath);
//                    RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//                    rd.forward(req, res);
//                }
            	chain.doFilter(request, response);
            } else {
                // δ��¼����ת����¼ҳ������֤��ǰ��ҳ��url�ļ�·��
                req.setAttribute("msg", "����δ��¼�����¼");
                req.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                rd.forward(req, res);
            }
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
