package Bean;

public class Bean {
	private String username;
	private String password;
	private String confirm_password;
	private String mail;
	private String check_id;
	private String name;
	private String instructions;
	private String phone_number;
	private String online;
	
	public void Set_online(String online){
		this.online = online;
	}
	public String Get_online(){
		return online;
	}
	
	public void Set_phone_number(String num){
		this.phone_number=num;
	}
	public String Get_phone_number(){
		return phone_number;
	}
	
	public void Set_username(String username){
		this.username=username;
	}
	public String Get_username(){
		return username;
	}
	
	public void Set_zuce_password(String password){
		this.confirm_password=password;
	}
	public String Get_zuce_password(){
		return confirm_password;
	}
	
	public void Set_password(String password){
		this.password = password;
	}
	public String Get_password(){
		return password;
	}
	
	public void Set_mail(String mail){
		this.mail=mail;
	}
	public String Get_mail(){
		return mail;
	}
	
	public void Set_check_id(String check_id){
		this.check_id=check_id;
	}
	public String Get_check_id(){
		return check_id;
	}
	
	public void Set_name(String name){
		this.name=name;
	}
	public String Get_name(){
		return name;
	}
	
	public void Set_instructions(String instructions){
		this.instructions=this.check_id+instructions+this.username;
	}
	public String Get_instructions(){
		return instructions;
	}
	public void setLoginStatus(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
