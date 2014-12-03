package chatbot.model;

public class User
{

	private String Hello;
	private String Username;
	private int  Cool;
	public boolean Happy;
	private int age;
	private String FavoriteGame;
	
	public String getFavoriteGame()
	{
		return FavoriteGame;
	}

	public void setFavoriteGame(String input)
	{
		FavoriteGame = input;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isHappy()
	{
		return Happy;
	}

	public String getHello()
	{
		return Hello;
	}
	
	public String getUsername()
	{
		return Username;
	}
	
	public int getCool()
	{
		return Cool;
	}
	
	public boolean getHappy()
	{
		return Happy;
	}
	
	public void setHello(String input)
	{
		Hello = input;
	}
	
	public void setUsername(String input)
	{
		Username = input;
	}
	
	public void setCool(int cool)
	{
		Cool = cool;
	}
	
	public void setHappy(boolean happy)
	{
		Happy = happy;
	}

	
	
	
	
}
