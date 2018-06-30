package Server;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;

public class Server{
	private static final int SERVER_PORT = 5009;
	public static volatile boolean running=false;
	public static  long receiveTimeDelay=3000;
	private Thread connWatchDog;
	//public static CrazyitMap<String , PrintStream> clients = new CrazyitMap<String, PrintStream>(); 
	public static List<UserMap> umlist = new ArrayList<>();
	public static iscon is = new iscon();
	public void init(){
		try {
			ServerSocket ss = new ServerSocket(5009);
			System.out.println("������������,�˿ں�"+SERVER_PORT+"�ȴ��ͻ�������......");
			Timer t=new Timer();
			t.schedule(new task(),0, 300000);
			while(true){
				Socket socket = ss.accept();	
				new ServerThread(socket).start(); //�����߳�
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("����������ʧ��"+SERVER_PORT+"�Ƿ�ռ��?");
		}
	}
	public static void main(String[] args){
		Server server = new Server();
		server.init();
	}
}
