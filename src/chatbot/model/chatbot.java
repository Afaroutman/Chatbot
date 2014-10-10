package chatbot.model;

import java.util.ArrayList;

public class Chatbot
{
	
	private String name;
	private int numberOfChats;
	private ArrayList<String> memeList;
	private String contentArea;
	
	/**
	 * Creates a Chatbot object with a specified name. Initializes the total
	 * chats to 0
	 * 
	 * @param name
	 *            The name of the chatbot.
	 */
	public Chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;

		memeList = new ArrayList<String>();
		fillTheMemeList();
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
	 * 
	 * @returnThe current number of chats.
	 */
	public int getnumberOfChats()
	{
		return numberOfChats;
	}

	/**
	 * Fills the contents of the memeList with Internet memes.
	 */
	private void fillTheMemeList()
	{
		memeList.add("y u mad bro");
		memeList.add("doh!");
		memeList.add("one does not simply");
		memeList.add("Alrighty then");
		memeList.add("Y U no");
		memeList.add("I don't always");
	}
	/**
	 * Checks if you say a meme
	 * @param currentText sees if the current text equals a meme
	 * @return shows the meme to the user
	 */
	private boolean memeChecker(String currentText)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (currentMeme.equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}

		for (int loopCount = 0; loopCount < memeList.size(); loopCount++)
		{
			if (memeList.get(loopCount).equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	/**
	 * finds the name and changes the format
	 * 
	 * @param name
	 *            THe new name for the Chatbot
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
	 * Processed the supplied text from the user to provide a message from
	 * chatbot
	 * 
	 * @param userText
	 *            The user supplied text.
	 * @return What the chatbot says because of the supplied input.
	 */
	public String processText(String userText)
	{
		String processedText = "";

		int randomChoice = (int) (Math.random() * 3);
		contentArea = "games";
		if (userText != null)
		{
			if (randomChoice == 0)
			{
				if (stringLengthChecker(userText))
				{
					processedText = "welcome back";
				} else
				{
					processedText = "Oh wow!";
				}
			} else if (randomChoice == 1)
			{
				if (contentChecker(userText))
				{
					processedText = "Games oh I love to play games, would you like to play one now?";
				} else
				{
					processedText = " Why dont you play games";
				}
			} else
			{
				if (memeChecker(userText))
				{
					processedText = "hey, you found a meme: " + userText;
					processedText += ", isn't that cool.";
				} else
				{
					processedText = "boring that wasn't a meme.";
				}
			}

		}
		return processedText;

	}
	private boolean contentChecker(String userText)
	{
		boolean hasMyContent = false;

		if (userText.contains(contentArea))
		{
			hasMyContent = true;
		}

		return hasMyContent;
	}

	private boolean stringLengthChecker(String userText)
	{
		boolean isTooLong = false;
		if (userText.length() >= 20)
		{
			isTooLong = true;
		}
		return isTooLong;
	}

	/**
	 * make sure that it is OK to quit
	 * 
	 * @param input
	 * @return
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input.equals("good bye"))
		{
			okToQuit = true;
		}
		return okToQuit;
	}
}
