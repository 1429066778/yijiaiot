package TCPCLIENT;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class tcp {

    /**
     * @param args
     * @throws IOException 
     * @throws UnknownHostException 
     */
	public static Socket s=null;
	public void conn()throws  IOException {
		s=new Socket("47.95.114.213",5009);
        OutputStream out=s.getOutputStream();
        out.write("Java".getBytes());
        InputStream is=s.getInputStream();
        byte buf[]=new byte[1024];
        int len=is.read(buf);
        System.out.println(new String(buf,0,len));        
	}
    public void main(String[] args) throws  IOException {
        OutputStream out=this.s.getOutputStream();
        out.write("Java".getBytes());
        InputStream is=s.getInputStream();
        byte buf[]=new byte[1024];
        int len=is.read(buf);
        System.out.println(new String(buf,0,len));
        s.close();
    }

}