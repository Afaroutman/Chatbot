package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;

/**
 * Application Controller for the Chat robot String manipulation project.
 * Responsible for controlling the VIew and model packages.
 * 
 * @author Alan Hite
 * @version 1.4 11/4/14
 */
public class ChatbotAppController {

	private ChatbotView AppView;

	private Chatbot notSoCleverBot;
	/**
	 * The startup message for our chat robot application.
	 */
	private String startMessage;

	private ChatbotFrame baseFrame;
	/**
	 * Creates a chatbotAppController and initializes the associated View and
	 * Model objects.
	 */
	public ChatbotAppController()
	{
		AppView = new ChatbotView(this);
		baseFrame = new ChatbotFrame(this);
		notSoCleverBot = new Chatbot("CoolerBot");
		startMessage = "Welcome! Welcome, type in your name";
	}

	/**
	 * Allows other objects access to the notSoCleverBot.
	 * @return The Chatbot for this application
	 */
	public Chatbot getnotSoCleverBot() {
		return notSoCleverBot;
	}

	/**
	 * starts the Chatbot application
	 */
	public void start()

	{
			ChatbotPanel myAppPanel = (ChatbotPanel) baseFrame.getContentPane();
			myAppPanel.displayTextToUser(startMessage);
			
			// this could work as the line of code above, ((Chatbot) baseFrame.getContentPane()).displayTextToUser(startMessage);
	}
	
	public String sendTextToChatBot(String userInput)
	{
		String respondText = "";
		
		respondText = notSoCleverBot.processText(userInput);
		return respondText;
	}
	
	/**
	 * Says Bye and quits
	 */
	
	private void quit() {
		AppView.displayInformation("goodbye cruel user :(");
		System.exit(0);
	}
	
}
