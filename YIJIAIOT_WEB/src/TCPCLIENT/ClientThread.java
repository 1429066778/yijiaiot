package TCPCLIENT;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * 
 * @author 田培贤
 *客户端线程类，监听数据
 */


public class ClientThread extends Thread {
	String line=null;
	BufferedReader br =null;
	public ClientThread(BufferedReader br){
		this.br=br;
	}
	public void run(){
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
				break;
			}
			try {
				ClientThread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
	}
}
