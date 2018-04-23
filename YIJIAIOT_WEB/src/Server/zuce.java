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

public class zuce extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.doPost(request,response);
	}
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
		request.setCharacterEncoding("UTF-8");
		int flag_ok=0;
		 Boolean flag_has=true;
		Bean user=new Bean();
		ResultSet rs=null;
		user.Set_username(request.getParameter("username"));
		user.Set_password(request.getParameter("password"));
		user.Set_phone_number(request.getParameter("phone_number"));
		user.Set_name(request.getParameter("name"));
		user.Set_mail(request.getParameter("mail"));
		System.out.println(request.getParameter("username")+","+request.getParameter("password")+","+request.getParameter("phone_number")+","+request.getParameter("name")+","+request.getParameter("mail"));
		String id="111";
		GetConnection con=null;
		try {
			con = new GetConnection();
			rs=con.checkuser(user.Get_username());
			while(rs.next()){
				if(rs.getString("username").equals(user.Get_username())){
					
					flag_has=false;
					break;
				}
			}
			if(flag_has){
				flag_ok=con.zuce(user.Get_username(),user.Get_password(),user.Get_phone_number(),user.Get_name(),user.Get_mail(),id);
				if(flag_ok!=0){
					response.getWriter().write("[{\"message\" : \"yes\"}]");
					System.out.println("here1");
				}else{
					response.getWriter().write("[{\"message\" : \"no\"}]");
					System.out.println("here2");
				}
			}else{
				response.getWriter().write("[{\"message\" : \"error\"}]");
				System.out.println("here3");
			}
		} catch (SQLException e) {
			System.out.println("错误发生在zuce.java 66行");
		}
		finally
		{
			con.close();
		}
	}
}
