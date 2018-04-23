package Bean;

public class Device {
	private String devicid="";
	private String devicepassword="";
	public void Setdeviceid(String deviceid){
		this.devicid=deviceid;
	}
	public String Getdeviceid(){
		return this.devicid;
	}
	public void  Setdevicepassword(String password){
		this.devicepassword=password;
	}
	public String Getdevicepassword(){
		return this.devicepassword;
	}
}
