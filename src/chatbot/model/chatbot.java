package chatbot.model;


import java.util.ArrayList;

public class Chatbot
{
	/**
	 * The name of chatbotn
	 */
	private String name;
	/**
	 * the current number of chats the Chatbot has participated in.
	 */
	private String introduceUser;
	
	private int numberOfChats;
	/**
	 * The list of memes that are used in the chatbot
	 */
	private ArrayList<String> memeList;
	/**
	 * A list of input  
	 */
	private ArrayList<String> userInputList;
	/**
	 * The programmer specified content area
	 */
	private String contentArea;
	
	private User myUser;
	/**
	 * Creates a Chatbot object with a specified name. Initializes the total
	 * chats to 0
	 * 
	 * @param name
	 *            The name of the chatbot.
	 */
	private String randomChatTopic;
	
	public Chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;
		userInputList = new ArrayList<String>();
		memeList = new ArrayList<String>();
		fillTheMemeList();
		myUser = new User();
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
	 * 
	 * @param currentText
	 *            sees if the current text equals a meme
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
	 *            The new name for the Chatbot
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
	 * @param userText The user supplied text.
	 * @return What the chatbot says because of the supplied input.
	 */
	/*public String processText(String userText)
	{
		String processedText = "";

		int randomChoice = (int) (Math.random() * 6);
		contentArea = "games";
		if (userText != null)
		{
			if(numberOfChats < 5)
			{
				
			}
			User myUser = null;
			if (numberOfChats == 0)
				{
					myUser.setUsername(userText);
					processedText ="Hello" + myUser.getUsername() + " what is your age?";
				}
				else if (numberOfChats == 1)
			{
				int age = Integer.parseInt(userText);
				myUser.setAge(age);
				processedText = myUser.getUsername() + ", you are really " + myUser.getAge() +"years old?";
				processedText += "\nAre you Happy?";
							
			}
			else if (numberOfChats == 2)
			{
				if (memeChecker(userText))
				{
					processedText = "hey, you found a meme: " + userText;
					processedText += ", isn't that cool.";
				} 
				else
				{
					processedText = "boring that wasn't a meme.";
				}
			}
			else if (numberOfChats == 3)
			{
				//User based talking
			}
			else if (numberOfChats == 4)
			{
				//userInput list add
				userInputList.add(0, userText);
				processedText = "Thanks for the Input, "+ myUser.getUsername();
			}
			else
			{
				//userInputChecker
			}

		}
		return processedText;

	}
	*/
	public String processText(String userText)
	{
		String processedText = "";
		
		if (userText != null && userText.length() > 0)
		{
			if (numberOfChats < 5)
			{
				processedText = introduceUser(userText);
			}
			else
			{
				processedText = randomChatTopic(userText);
			}
		}
		else
		{
			numberOfChats--;
			processedText = "Tell me! Please!";
		}
		incrementChats();
		return processedText;
	}
	private String introduceUser(String input)
	{
		String userInfoText = "";
		
		if(numberOfChats == 0)
		{
			myUser.setUsername(input);
			userInfoText = "Hello " + myUser.getUsername() + " what is your age?";
		}
		else if(numberOfChats == 1)
		{
			int age = Integer.parseInt(userInfoText, 5);
			myUser.setAge(age);
			userInfoText = myUser.getUsername() + ", you are really " + myUser.getAge() +" years old?";
			userInfoText += "\nwhat is your favorite game?";
		}
		else if(numberOfChats == 2)
		{
			myUser.setFavoriteGame(input);
			userInfoText = myUser.getUsername() + ", you really liked " + myUser.getFavoriteGame();
			userInfoText +="Wow really?\n Are you happy?";
		}
		else if(numberOfChats == 3)
		{
			boolean Happy = Boolean.parseBoolean(input);
			myUser.setHappy(Happy);
			userInfoText = "Woah calm down geez";
		}
		return introduceUser;
	}
	private String randomChatTopic(String userInput)
	{
		String randomTopic = "";
		int randomChoice = (int) (Math.random() * 7);
		if (randomChoice == 0)
		{
			if (stringLengthChecker(userInput))
			{
				randomTopic = "Seriously you want me to read that?";
			}
			else
			{
				randomTopic = "Finally thats easy to read!";
			}
		}
		else if (randomChoice == 1)
		{
			if (contentChecker(userInput))
			{
				randomTopic = "Just because you said " + userInput + "Im not talking to you";
			}
			else
			{
				randomTopic = "";
			}
		}
		else if (numberOfChats == 2)
		{
			if (memeChecker(userInput))
			{
				randomTopic = "hey, you found a meme: " + userInput;
				randomTopic += ", isn't that cool.";
			} 
			else
			{
				randomTopic = "boring that wasn't a meme.";
			}
		}
		return randomChatTopic;
	}
	/**
	 * An array to see if the user says anything 
	 * @param input
	 * @return
	 */
	private boolean userInputChecker(String input)
	{
		boolean matchesInput = false;
		
		if(userInputList.size() > 0)
		{
			 for(int loopCount = 0; loopCount < userInputList.size(); loopCount++)
			 {
				 if(input.equalsIgnoreCase(userInputList.get(loopCount)))
				 {
					 matchesInput = true;
					 userInputList.remove(loopCount);
					 loopCount--;
				 }
			 }
		}
		
		return matchesInput;
	}
/**
 	* Checks if the supplied String contains the content area of the chatbot	
 * @param userText
 * @return
 */
	private boolean contentChecker(String userText)
	{
		boolean hasMyContent = false;

		if (userText.contains(contentArea))
		{
			hasMyContent = true;
		}

		return hasMyContent;
	}
	/**
	 * Checker the length of a String for a long String.
	 * @param userText
	 * @return
	 */
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
	/**
	 * Checks to see if the name of the Chatbot is contained within the string supplied by the user.
	 * @param currentInput The user supplied String
	 * @return Wheter the name is inside or not
	 */
	private boolean chatbotNameChecker(String currentInput)
	{
		boolean hasNameInString = false;
		
		if(currentInput.indexOf(this.getName()) > -1)
		{
			hasNameInString = true;
		}
		
		return hasNameInString;
	}
/**
 	* What happens when you say the chatbots name
 * @param currentInput what the user puts into the input
 * @return what the user said
 */
	private String chatbotNameConversation(String currentInput)
	{
		String nameConversation = "This is what you typed after my name:";
		
		nameConversation += currentInput.substring(currentInput.indexOf(this.getName()) + this.getName().length(), - 1);
		
				
		return nameConversation;
	}
	/**
	 * What happens when no one says its name
	 * @param currentInput what the user said instead of the name of chatbot
	 * @return A simple phrase
	 */
	private String noNameConversation(String currentInput)
	{
		String notNamed = "";
		
		int smallRandom = (int)(Math.random() * currentInput.length() / 2);
		int largerRandom = (int)((Math.random() * smallRandom) + (Math.random() * currentInput.length() / 2));
		
		notNamed = "You didn't say my name so here is a special phrase: " + currentInput.substring(smallRandom, largerRandom);
		
		return notNamed;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

