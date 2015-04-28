package home.lestory.model;

public class UserInfo
{

	private String userName;
	private int age;
	
	
	public UserInfo()
	{
		
	}
	
	public UserInfo(String name, int age)
	{
		this.userName = name;
		this.setAge(age);
	}
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	
	
}
