package TCPCLIENT;
/**
 * 
 * @author 田培贤
 *此类定义协议字符串
 */
public interface CrazyitProtocol {
	int PROTOCOL_LEN=2;
	String MES_ROUND="**";
	String USER_ROUND="//";
	String LOGIN_SUCCESS="1";
	String NAME_REP="-1";
	String PRIVATE_ROUND="@@";
	String SPLIT_SIGN="??";
}