package net.remote.remoteServer.vo;

public class LoginUser {
	private String api;
	private String userId;
	private String userPw;
	public LoginUser(String userId, String userPw) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		this.userPw = userPw;
	}
	public LoginUser(String api, String userId, String userPw){
		this.api = api;
		this.userId = userId;
		this.userPw = userPw;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String toString() {
		return "loginUser [userId=" + userId + ", userPw=" + userPw +"]";
	}
}
