package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
/*
 * �������̴߳�����
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
	   System.out.println(count+"���ͻ����Ѿ�������");
   }
   
   public void run(){
	   int deciveflag =0;
	   try {
		br=new BufferedReader(new InputStreamReader(socket.getInputStream()));//��ȡsocket��Ӧ��������
		ps=new PrintStream(socket.getOutputStream());//��ȡsocket��Ӧ�������
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
				UserMap um = new UserMap(userName,socket,br,ps); //����һ�������û���������\socket\br\װ�뵽�û�����
				Server.umlist.add(um); //���û����Ӷ�����뵽һ������
				System.out.println("�ɹ���");
				ps.println(CrazyitProtocol.LOGIN_SUCCESS);
			}
			else if(line.length()>6)
			{
				String userAndMsg =getRealMsg(line); //���ͻ�����Ϣ��ԭ����Ч��Ϣ
				String user_sb = userAndMsg.substring(0,3);//��ȡ���豸����
				String msg = userAndMsg.substring(3,4);//��ȡ���⻧�˷��͸��豸����Ϣ
				String user=userAndMsg.substring(4);//��ȡ���ͻ�������
				System.out.println("�ͻ���:"+user+" ���� "+msg+" ���豸:"+user_sb);
				//Ѱ��Ҫ���͵��豸�Ƿ����
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
				System.out.println("��ǰ���߿ͻ������豸����Ϊ:"+Server.umlist.size()+"��");
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
//������������ȥ��ǰ���Э���ַ����ָ�����ʵ����
private String getRealMsg(String line) {
	// TODO Auto-generated method stub
	//System.out.println(line.substring(CrazyitProtocol.PROTOCOL_LEN,line.length()-CrazyitProtocol.PROTOCOL_LEN));
	return line.substring(CrazyitProtocol.PROTOCOL_LEN,line.length()-CrazyitProtocol.PROTOCOL_LEN);
}
}