package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class UserMap {
	private Socket socket;
	private BufferedReader br = null;
	private PrintStream ps = null;
	private String name = "";
	
	UserMap(String name,Socket socket,BufferedReader br,PrintStream ps){
		this.name = name;
		this.socket = socket;
		this.br = br;
		this.ps = ps;
	}
	
	public String getname() {
		return this.name;
	}
	
	public Socket getsocket() {
		return this.socket;
	}
	
	public BufferedReader getbr() {
		return this.br;
	}
	
	public PrintStream getps() {
		return this.ps;
	}
	
	public void Destroy(){
		try {
			this.socket.close();
			this.br.close();
			this.ps.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("UserMap Destroy·½·¨³ö´í");
		}	
	}
}
