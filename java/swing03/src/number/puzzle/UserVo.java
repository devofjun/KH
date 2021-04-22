package number.puzzle;

public class UserVo {
	String uid;
	String upw;
	String uname;
	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVo(String uid, String upw, String uname) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	@Override
	public String toString() {
		return "UserVo [uid=" + uid + ", upw=" + upw + ", uname=" + uname + "]";
	}
}
