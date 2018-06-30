 package Connection;
import java.sql.Connection;
/**
 * @author 田培贤
 * 数据库连接类
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class GetConnection {
	private final String driverName="com.mysql.jdbc.Driver";
    private final String user="root";
    private final String password="admin";
    //private final String password="NYZn7HxLJB";
    private final String url1="jdbc:mysql://localhost:3306/users?characterEncoding=utf-8&useSSL=false";
    Connection conn; 
    Statement stmt;
    ResultSet rs; 
    

    public GetConnection() throws SQLException{
	
    	try {
    		Class.forName(driverName);
    		conn = DriverManager.getConnection(url1, user, password);
    		stmt = conn.createStatement();
    	} catch (ClassNotFoundException e) {		
    		e.printStackTrace();
    	}		 	
    } 

	public ResultSet checkuser(String username){
		String sql=	"SELECT * FROM users WHERE username='"+username+"'";
		try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int delete(String username){
		int n=0;
		String sql1="delete from users where username='"+username+"'";
		try {
			n=stmt.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return n;
	}
	
	public int zuce(String username,String password,String phone_number,String name,String mail,String id){
		int n=0;
		String sql1="insert into users (username,password,phone_number,name,mail,check_id) values ('"+username+"','"+password+"','"+phone_number+"','"+name+"','"+mail+"','"+id+"')";
		try {
			n=stmt.executeUpdate(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return n;
	}
	
	public int addcheckid(String username, String checkid){
		int n=0;
		String sql1="update users set check_id = '"+checkid+"' where username='"+username+"'";
		try {
			n=stmt.executeUpdate(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return n;
	}
	public void close(){
		try {
			if(conn!=null)
			conn.close();
			if(stmt!=null)
			stmt.close();
			if(rs!=null)
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接关闭错误");
		}
		
	}
}
