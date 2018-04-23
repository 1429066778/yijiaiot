package Server;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.GetConnection;

public class addcheckid extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String checkid=request.getParameter("checkid");
		int n=0;
		GetConnection con = null;
		try {
			con = new GetConnection();
			if(checkid==null){
				response.sendRedirect("addcheckid.jsp?use="+"1");//杈撳叆鐨勮澶囧彿涓嶅瓨鍦�
			}else{
				n=con.addcheckid(Login.user.Get_username(),checkid);
			}
		} catch (SQLException e) {
			System.out.println("错误发生在addcheckid.java_41行");
		}finally{
			con.close();
		}
		if(n!=0){
			response.sendRedirect("login.jsp?use="+"6");//娣诲姞璁惧鎴愬姛锛�
		}
		
	}

}
