package TCPCLIENT;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread {
	public static String line=null;
	BufferedReader br =null;
	public ClientThread(BufferedReader br){
		this.br=br;
	}
	public void run(){
		//String line = null;
		try {
			while((line=br.readLine())!=null){
				System.out.println(line);
				if(line.equals("noonline")){
					Client.flag_1=3;
					
				}
				if(line.equals("yes"))
					Client.flag_1=9;
				if(line.length()>=9)
				{
					Client.flag_1=4;
				}
				System.out.println(Client.flag_1);
				Client client=new  Client();
				client.closeRs();
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
