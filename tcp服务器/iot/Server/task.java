package Server;

import java.util.TimerTask;

public class task extends TimerTask{
	private int count=0;
	@Override
	public void run() {
		if(!iscon.shebei[0].equals("")){
			for(int i=0;i<iscon.shebei.length;i++)
			{
				if(iscon.shebei[i].equals(iscon.shebei_flag[i])){
					//Server.clients.removeByValues(iscon.shebei[i].substring(0, 3));
				}
			}
			iscon.shebei_flag=iscon.shebei;
			count++;
		}//ͨ��count���Լ����豸����ʱ��
		System.out.println("����ɾ����ʧ���ӵ��û�!");
	}
	
}