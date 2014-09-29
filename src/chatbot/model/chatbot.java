package chatbot.model;

public class chatbot {
	private String name;
	private int numberOfChats;

	/**
	 * Creates a Chatbot object with a specified name. Initializes the total chats to 0
	 * @param name The name of the chatbot.
	 */
	public chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;
	}
	/**
	 * @return returns name
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 * returns the amount you chat
	 * @returnThe current number of chats.
	 */
	public int getnumberOfChats()
	{
		return numberOfChats;
	}
	/**
	 * finds the name and changes the format 
	 * @param name THe new name for the Chatbot
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * counts by one by inputs and responses 
	 */
	public void incrementChats()
	{
		numberOfChats++;
	}
	/**
	 * make sure that it is OK to quit
	 * @param input
	 * @return
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input.equals("good bye"))
		{
			 okToQuit = true;
		}
		return okToQuit;
	}
}

