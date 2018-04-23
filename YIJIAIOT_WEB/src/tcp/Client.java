package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Server.Login;
import TCPCLIENT.CrazyitProtocol;

import java.net.*;  
import java.io.*;  
  
public class Client {  
	private static final int SERVER_PORT=5009;
	private Socket socket=null;;
	private PrintStream ps;
	private BufferedReader brServer;
    public  void main() {  
        // TODO Auto-generated method stub  
    	try {
			socket = new Socket("47.95.114.213",SERVER_PORT);
			ps=new PrintStream(socket.getOutputStream());
			brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){	
				String username=Login.user.Get_username(); 
				ps.println(CrazyitProtocol.USER_ROUND+username+CrazyitProtocol.USER_ROUND);
				String result = brServer.readLine();
				if(result.equals(CrazyitProtocol.LOGIN_SUCCESS)){
					System.out.println("TCP服务器连接成功！");
					break;
				}
			}
			ps.println(CrazyitProtocol.MES_ROUND+Login.user.Get_instructions()+CrazyitProtocol.MES_ROUND);
			String result = brServer.readLine();
			System.out.println(result);	
			ps.close();
			brServer.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
  
    }  
  public void send(){
	  
  }
}
/*public class Client {
	public static  PrintStream ps;
	public  static BufferedReader br;
	public  Socket socket;
	private int count=0;
	public void main() throws UnknownHostException, IOException{
		System.out.println(count);
		socket = new Socket("47.95.114.213",5009);
		ps = new PrintStream(socket.getOutputStream());
		br = new BufferedReader(new  InputStreamReader(socket.getInputStream()));
		String line = br.readLine();
		while(true){
			System.out.println("here");
			String username=Login.user.Get_username(); 
			ps.println(CrazyitProtocol.USER_ROUND+username+CrazyitProtocol.USER_ROUND);
			String result = br.readLine();
			if(result.equals(CrazyitProtocol.LOGIN_SUCCESS)){
				System.out.println("TCP服务器连接成功！");
				break;
			}
		}
		//send(ps,br);
		System.out.println("fuwuqi:"+line);
		
	}
	public String send(PrintStream ps,BufferedReader br) throws IOException{
		String result="";
		while(true){
			String line=Login.user.Get_instructions();
			ps.println(CrazyitProtocol.MES_ROUND+line+CrazyitProtocol.MES_ROUND);
			result = br.readLine();
			if(result!="")
				break;

		}
		return result;
	}
	public void clorse() throws IOException{
		br.close();
		ps.close();
		socket.close();
	}
}*/
