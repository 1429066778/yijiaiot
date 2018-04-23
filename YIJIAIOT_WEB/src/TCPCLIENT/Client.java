package TCPCLIENT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Server.Login;

public class Client {
	int loginflag=0;
	public static int flag_1=0;
	private static final int SERVER_PORT=5009;
	private Socket socket;
	private PrintStream ps;
	private BufferedReader brServer;
	String line="";
	public void init(){
		try {
			if(Client.flag_1==1){
				Client.flag_1=0;
			}
			
			socket = new Socket("47.95.114.213",SERVER_PORT);
			ps=new PrintStream(socket.getOutputStream());
			brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
			if(loginflag==0){	
				String username=Login.user.Get_username(); 
				ps.println(CrazyitProtocol.USER_ROUND+username+CrazyitProtocol.USER_ROUND);
			}
				String result = brServer.readLine();
				if(result.equals(CrazyitProtocol.LOGIN_SUCCESS)){
					System.out.println("TCP服务器连接成功！");
					loginflag=1;
					break;
				}
			}			
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
	private void readAndsend(){
		String line=null;
		while((line=Login.user.Get_instructions())!=null){
			ps.println(CrazyitProtocol.MES_ROUND+line+CrazyitProtocol.MES_ROUND);
			break;
		}
	}
	public void closeRs(){	
			try {
				if(brServer!=null)
					ps.close();
				if(ps!=null)
					ps.close();
				if(socket!=null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public void main(){
		Client client = new Client();
		client.init();
		if(Client.flag_1!=1&&Client.flag_1!=2){
			client.readAndsend();
		}
		//client.closeRs();
	}
}
