package TCPCLIENT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import Server.Login;
public class Client {
	public static int flag_1=0;
	private static final int SERVER_PORT=5009;
	private Socket socket;
	private PrintStream ps;
	private BufferedReader brServer;
/**
 * 
 * @writer 田培贤
 * 初始化建立tcp服务器的socket，发送用户名登录，发送指令，启动线程监听反馈信息
 */
	public void init(String m){
		try {		
			if(Login.istcplogin){	
				socket = new Socket("47.95.114.213",SERVER_PORT);
				ps=new PrintStream(socket.getOutputStream());
				brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String username=Login.user.Get_username(); 
				ps.println(CrazyitProtocol.USER_ROUND+username+CrazyitProtocol.USER_ROUND);
				String result = brServer.readLine();
				if(result.equals(CrazyitProtocol.LOGIN_SUCCESS)){
					System.out.println("TCP服务器连接成功！");
					Login.istcplogin=false;
				}
			}else System.out.println("已经连接tcp服务器成功,避免重复登录");
			ps.println(CrazyitProtocol.MES_ROUND+m+CrazyitProtocol.MES_ROUND);
		} catch (UnknownHostException e) {
			Client.flag_1=1;
			closeRs();			
		} catch (IOException e) {
			e.printStackTrace();
			Client.flag_1=1;
			closeRs();			
		} 
		new ClientThread(brServer).start();	
	}
	/**
	 * @author 田培贤
	 * 关闭socket 输入流 输出流
	 */
	public void closeRs(){	
			try {
				if(brServer!=null)
					brServer.close();
				if(ps!=null)
					ps.close();
				if(socket!=null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public void main(String m) {
		init(m);
	}
}
