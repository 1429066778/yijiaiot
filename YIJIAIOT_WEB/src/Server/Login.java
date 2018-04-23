package Server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tcp.Client;
import utils.CatchIP;
import Bean.Bean;
import Bean.USE;
import Connection.GetConnection;

public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Bean user = new Bean();
	public static GetConnection con = null;
	public static int flag=0;
	public static Client cli = new Client();
	public static String wendu="0";
	public static String shidu="0";
	public static String guangqiang="0";
	public static String PM25="0";
	public static String PM10="0";
	public static String jiaquan="0";
	static USE usem = new USE();
	List<USE> use= new ArrayList<USE>();
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			//super.doGet(request, response);
			this.doPost(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String psw="";
		user.Set_username(request.getParameter("username"));
		psw=request.getParameter("password");		
		CatchIP ip = new CatchIP();
		ip.getIp(request); //获得访问者的IP地址、归属地、运营商。
		try {
			con=new GetConnection();
			ResultSet rs=con.checkuser(user.Get_username());
			if(rs.next()){
				user.Set_password(rs.getString("password"));
				user.Set_check_id(rs.getString("check_id"));
				
				user.Set_phone_number(rs.getString("phone_number"));
				user.Set_name(rs.getString("name").toString());
				user.Set_mail(rs.getString("mail").toString());
				user.Set_online(rs.getString("online"));
			}
		} catch (SQLException e) {
			System.out.println("错误发生在Login.java_63行");
		}finally
		{
			con.close();
		}	
		HttpSession hs = request.getSession();//返回当前request相关联的session，如果没有则在服务器端创建一个
		user.setLoginStatus(true);
  		hs.setAttribute("user",user);
  		System.out.println(hs.getId());
		if(psw.equals(user.Get_password())){	
			System.out.println("用户："+user.Get_username()+"登录成功!");
			usem.setwendu(wendu);
			usem.setshidu(shidu);
			usem.setguangqiang(guangqiang);
			usem.setpm25(PM25);
			usem.setpm10(PM10);
			usem.setjiaquan(jiaquan);
			usem.setname(user.Get_name());
			if(user.Get_check_id()==null)
				usem.setmessage("无设备");
			use.add(Login.usem);
			//response.getWriter().write("[{\"message\" : \"yes\"}]");
			response.getWriter().write("[{\"message\" : \"yes\",\"usernameI\":\""+user.Get_username()+"\",\"phonenumberI\":\""+user.Get_phone_number()+"\",\"mailI\":\""+user.Get_mail()+"\",\"Id\":\""+user.Get_check_id()+"\",\"nameI\":\""+user.Get_name()+"\"}]");
			use.clear();
			return;
		}else{
			System.out.println("用户名或密码错误");
			response.getWriter().write("[{\"message\" : \"no\"}]");
		}	
	}
	
}
