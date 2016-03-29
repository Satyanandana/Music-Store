package cs636.music.presentation.web;

public class UserBean{
	
	private int userid = 1;
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	public UserBean(){}
	
	public int getUserId(){
		return userid;
	}
	
	public String getFirstName()
	{return firstName;}
	
	public String getLastName()
	{return lastName;}
	
	public String emailAddress()
	{return emailAddress;}
	
	public void setUserId(int userid){
		this.userid = userid;
	}
	
	public void setFirstName(String firstName)
	{this.firstName = firstName;}
	
	public void setLastName(String lastName)
	{this.lastName = lastName;}
	
	public void setEmailAddress(String emailAddress)
	{this.emailAddress = emailAddress;}
}