package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.chatbot;
import chatbot.view.chatbotView;

public class chatbotappController {

	private chatbotView appView;
	private chatbot notSoCleverBot;
	/**
	 * Creates a chatbotAppController and initializes the associated View and Model objects.
	 */
	public chatbotappController()
	{
		appView = new chatbotView(this);
		notSoCleverBot = new chatbot("Mr. not so clever");
	}
	
	/**
	 * starts the Chatbot application
	 */
	public void start() 
	
	{
		String message = JOptionPane.showInputDialog(null, "would you like to continure");
	if(notSoCleverBot.quitChecker(message))
	{
		quit();
		
	}
		JOptionPane.showMessageDialog(null,  " we are not done yet");
		
		
	}
	
	
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "bye");
		System.exit(0);
	}

}
