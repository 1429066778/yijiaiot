package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bean;
import Connection.GetConnection;

public class infomodify extends HttpServlet {
	int count=0;
	 List<Bean> userlist= new ArrayList<Bean>();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		Bean user=new Bean();
		request.setCharacterEncoding("UTF-8");	
		GetConnection con = null;
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
				if(user.Get_check_id()==null)
					user.Set_check_id("无设备！");
				userlist.add(user);
				request.setAttribute("userlist",userlist);
				request.getRequestDispatcher("infomodify.jsp").forward(request, response);userlist.clear();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("错误发生在：Server/infomodify.java");
		}finally
		{
			con.close();
			userlist.clear();
		}
	}
}
