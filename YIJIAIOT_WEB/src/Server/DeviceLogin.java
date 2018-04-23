package Server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Device;
import Connection.GetConnection;

/**
 * Servlet implementation class DeviceLogin
 */
public class DeviceLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public  static Device device = new Device();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeviceLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		GetConnection con = null;
		String psw = null;
		int flaghas=0;
		device.Setdeviceid(request.getParameter("ID"));
		device.Setdevicepassword(request.getParameter("Pw"));
		try {
			con = new GetConnection();
			rs= con.devicelogin(device.Getdeviceid());
			while(rs.next()){
				if(rs.getString("id").equals(device.Getdeviceid())){
					if(rs.getString("pw").equals(device.Getdevicepassword())){
						flaghas=1;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flaghas==1){
			response.getWriter().write("yse");
		}else response.getWriter().write("no");
	}

}
