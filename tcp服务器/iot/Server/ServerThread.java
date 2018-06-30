package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
/*
 * 服务器线程处理类
 */
public class ServerThread extends Thread {
   Socket socket;
   BufferedReader br = null;
   PrintStream ps = null;
   int count=0;
   int u=0;
   public ServerThread(Socket socket){
	   count++;
	   this.socket=socket;
	   System.out.println(count+"个客户端已经连接上");
   }
   
   public void run(){
	   int deciveflag =0;
	   try {
		br=new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取socket对应的输入流
		ps=new PrintStream(socket.getOutputStream());//获取socket对应的输出流
		String line=null;
		while((line=br.readLine())!=null){
			System.out.println(line);
			if(line.startsWith(CrazyitProtocol.USER_ROUND)&&line.endsWith(CrazyitProtocol.USER_ROUND)){
				String userName = getRealMsg(line);
				for(int i = 0;i<Server.umlist.size();i++)
				{
					if(Server.umlist.get(i).getname().equals(userName)) {
						Server.umlist.remove(i).Destroy();
						if(Server.umlist.size()>0)
							Server.umlist.remove(i);
					}
				}
				UserMap um = new UserMap(userName,socket,br,ps); //创建一个连接用户对象将名称\socket\br\装入到用户对象
				Server.umlist.add(um); //把用户连接对象放入到一个集合
				System.out.println("成功！");
				ps.println(CrazyitProtocol.LOGIN_SUCCESS);
			}
			else if(line.length()>6)
			{
				String userAndMsg =getRealMsg(line); //将客户端信息还原成有效信息
				String user_sb = userAndMsg.substring(0,3);//截取出设备名称
				String msg = userAndMsg.substring(3,4);//截取出库户端发送给设备的信息
				String user=userAndMsg.substring(4);//截取出客户端名称
				System.out.println("客户端:"+user+" 发送 "+msg+" 给设备:"+user_sb);
				//寻找要发送的设备是否存在
				for(int i = 0;i<Server.umlist.size();i++)
				{
					if(Server.umlist.get(i).getname().equals(user_sb)) {
						Server.umlist.get(i).getps().println(msg+"\n");
						deciveflag=1;
					}
				}
				if(deciveflag==1)
					ps.println("yes");
				else 
					ps.println("noonline");
				System.out.println("当前在线客户端与设备总数为:"+Server.umlist.size()+"个");
			}
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		try
		{
			if(br!=null)
				br.close();
			if(ps!=null)
				ps.close();
			if(socket!=null)
				socket.close();	
		}
		catch(IOException ex)
		{
			
		}
	}
	   
   }
//将读到的内容去掉前后的协议字符，恢复成真实数据
private String getRealMsg(String line) {
	// TODO Auto-generated method stub
	//System.out.println(line.substring(CrazyitProtocol.PROTOCOL_LEN,line.length()-CrazyitProtocol.PROTOCOL_LEN));
	return line.substring(CrazyitProtocol.PROTOCOL_LEN,line.length()-CrazyitProtocol.PROTOCOL_LEN);
}
}