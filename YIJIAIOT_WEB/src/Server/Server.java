package Server;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import TCPCLIENT.Client;

public class Server extends HttpServlet {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String m=request.getParameter("m");
		if(Login.user.Get_check_id().equals("111")){
			response.getWriter().write("[{\"message\" : \"无设备,请先购买添加设备！！！\",\"wendu\":\""+Login.wendu+"\",\"shidu\":\""+Login.shidu+"\",\"guangqiang\":\""+Login.guangqiang+"\",\"PM25\":\""+Login.PM25+"\",\"PM10\":\""+Login.PM10+"\",\"jiaquan\":\""+Login.jiaquan+"\",\"user\":\""+Login.user.Get_name()+"\"}]");
		}else{
			if(m!=null){	
				Login.user.Set_instructions(m);
				Login.client.main(Login.user.Get_instructions());
			}
			if(Client.flag_1==3){
				response.getWriter().write("[{\"message\" : \"设备不在线！\",\"wendu\":\""+Login.wendu+"\",\"shidu\":\""+Login.shidu+"\",\"guangqiang\":\""+Login.guangqiang+"\",\"PM25\":\""+Login.PM25+"\",\"PM10\":\""+Login.PM10+"\",\"jiaquan\":\""+Login.jiaquan+"\",\"user\":\""+Login.user.Get_name()+"\"}]");
			}else if(Client.flag_1==1){
				response.getWriter().write("[{\"message\" : \"系统异常\",\"wendu\":\""+Login.wendu+"\",\"shidu\":\""+Login.shidu+"\",\"guangqiang\":\""+Login.guangqiang+"\",\"PM25\":\""+Login.PM25+"\",\"PM10\":\""+Login.PM10+"\",\"jiaquan\":\""+Login.jiaquan+"\",\"user\":\""+Login.user.Get_name()+"\"}]");
			}if(Client.flag_1==0){
				response.getWriter().write("[{\"message\" : \"系统异常\",\"wendu\":\""+Login.wendu+"\",\"shidu\":\""+Login.shidu+"\",\"guangqiang\":\""+Login.guangqiang+"\",\"PM25\":\""+Login.PM25+"\",\"PM10\":\""+Login.PM10+"\",\"jiaquan\":\""+Login.jiaquan+"\",\"user\":\""+Login.user.Get_name()+"\"}]");			
			}else if(Client.flag_1==2){
				response.getWriter().write("[{\"message\" : \"系统异常\",\"wendu\":\""+Login.wendu+"\",\"shidu\":\""+Login.shidu+"\",\"guangqiang\":\""+Login.guangqiang+"\",\"PM25\":\""+Login.PM25+"\",\"PM10\":\""+Login.PM10+"\",\"jiaquan\":\""+Login.jiaquan+"\",\"user\":\""+Login.user.Get_name()+"\"}]");
			}else if(Client.flag_1==4){
				response.getWriter().write("[{\"message\" : \"系统异常\",\"wendu\":\""+Login.wendu+"\",\"shidu\":\""+Login.shidu+"\",\"guangqiang\":\""+Login.guangqiang+"\",\"PM25\":\""+Login.PM25+"\",\"PM10\":\""+Login.PM10+"\",\"jiaquan\":\""+Login.jiaquan+"\",\"user\":\""+Login.user.Get_name()+"\"}]");
			}else if(Client.flag_1==9){
				response.getWriter().write("[{\"message\" : \"设备运行正常\",\"wendu\":\""+Login.wendu+"\",\"shidu\":\""+Login.shidu+"\",\"guangqiang\":\""+Login.guangqiang+"\",\"PM25\":\""+Login.PM25+"\",\"PM10\":\""+Login.PM10+"\",\"jiaquan\":\""+Login.jiaquan+"\",\"user\":\""+Login.user.Get_name()+"\"}]");
			}
		}
}
}
