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
 * @writer ������
 * ��ʼ������tcp��������socket�������û�����¼������ָ������̼߳���������Ϣ
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
					System.out.println("TCP���������ӳɹ���");
					Login.istcplogin=false;
				}
			}else System.out.println("�Ѿ�����tcp�������ɹ�,�����ظ���¼");
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
	 * @author ������
	 * �ر�socket ������ �����
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
