package Server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bean;
import Connection.GetConnection;

public class infomodify1 extends HttpServlet {

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
		int flag_ok=0,flag=0;
		String password=request.getParameter("old_password");
		String npassword=request.getParameter("password");
		String pnum=request.getParameter("phone_number");
		//String email=request.getParameter("email");
		GetConnection con = null;
		Bean user=new Bean();
		try {
			con=new GetConnection();			
			ResultSet rs=con.checkuser(Login.user.Get_username());
			if(rs.next()){
				user.Set_username(rs.getString("username"));
				user.Set_password(rs.getString("password"));
				user.Set_check_id(rs.getString("check_id"));
				user.Set_phone_number(rs.getString("phone_number"));
				user.Set_name(rs.getString("name").toString());
				user.Set_mail(rs.getString("mail").toString());
				user.Set_online(rs.getString("online"));
			}				
				if(password.equals(user.Get_password())){
					flag=con.delete(user.Get_username());
					flag_ok=con.zuce(user.Get_username(),npassword,pnum,user.Get_name(),user.Get_mail(),user.Get_check_id());
					if(flag_ok!=0&&flag!=0){
						response.sendRedirect("login.jsp?use="+"2");
					}else{
						response.sendRedirect("login.jsp?use="+"3");
					}
				}else{
					response.sendRedirect("login.jsp?use="+"4");
				}
		} catch (SQLException e) {
			System.out.println("错误发生在infomodify.java 65行");
		}finally
		{
			con.close();
		}	
	}
}
