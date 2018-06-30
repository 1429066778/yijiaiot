package Server;

import java.util.TimerTask;

public class iscon {
	int count_0=0;
	int count_1=0;
	public static String[] shebei={""};
	public static String[] shebei_flag={""};
	public void con(String name){
		//shebei_flag=shebei;
		for(int i =0;i<shebei.length;i++)
			if(shebei[i].substring(0, 3).equals(name)){
				int count=Integer.parseInt(shebei[i].substring(3));
				count++;
				shebei[i]=name+ Integer.toString(count);
			}
	}
	
	//public void run(){
		/*
		for(int i=0;i<shebei.length;i++)
		{
			if(shebei[i].equals(shebei_flag[i])){
				 Server.clients.removeByValues(shebei[i].substring(0, 3));
			}
		}
		shebei_flag=shebei;*/

	//}
}
