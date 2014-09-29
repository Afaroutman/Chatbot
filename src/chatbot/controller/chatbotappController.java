package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.chatbot;
import chatbot.view.chatbotView;

public class chatbotappController<appView> {

	private chatbotView appView;
	private chatbot notSoCleverBot;
	/**
	 * Creates a chatbotAppController and initializes the associated View and Model objects.
	 */
	public chatbotappController()
	{
		appView = new chatbotView();
		notSoCleverBot = new chatbot("Mr. not so clever");
	}
	/**
	 * Allows other objects access to the notSoCleverBot.
	 * @return The Chatbot for this app
	 */
	public chatbot getNotSoCleverBot()
	{
		return getNotSoCleverBot();
	}
	
	/**
	 * starts the Chatbot application
	 */
	public void start() 
	
	{
		String message = JOptionPane.showInputDialog(null, "Welcome to chatbot, type in your name");
	
		while(!notSoCleverBot.quitChecker(message))
		{
			message = appView.displayChatbotConversations(message);
			
		
		}
			
		
	}
	/**
	 * Says Bye and quits 
	 */
	
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "bye");
		System.exit(0);
	}

}
