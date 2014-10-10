package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

/**
 * Application Controller for the Chat robot String manipulation project.
 * Responsible for controlling the VIew and model packages.
 * 
 * @author ahit0637
 * @version 1.3 10/1/14
 */
public class ChatbotAppController {

	private ChatbotView AppView;

	private Chatbot notSoCleverBot;
	/**
	 * The startup message for our chat robot application.
	 */
	private String startMessage;

	/**
	 * Creates a chatbotAppController and initializes the associated View and
	 * Model objects.
	 */
	public ChatbotAppController() {
		AppView = new ChatbotView(this);
		notSoCleverBot = new Chatbot("Mr. not so clever");
		startMessage = "Welcome to the " + notSoCleverBot.getName()
				+ " Chatbot, type in your name";
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
		String message = AppView.displayChatbotConversations(startMessage);

		while (!notSoCleverBot.quitChecker(message)) {
			message = notSoCleverBot.processText(message);
			message = AppView.displayChatbotConversations(message);
		}

		quit();

	}

	/**
	 * Says Bye and quits
	 */
	
	private void quit() {
		AppView.displayInformation("goodbye cruel user :(");
		System.exit(0);
	}
	
}
