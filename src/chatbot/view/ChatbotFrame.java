package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatbotAppController;
import java.awt.Canvas;
import javax.swing.SpringLayout;
import javax.swing.JPanel;

public class ChatbotFrame extends JFrame
{
	private ChatbotPanel basePanel;
	public ChatbotFrame(ChatbotAppController baseController)
	{
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(800, 600);
		//this.setResizable(false);
		this.setVisible(true);
		setMinimumSize(getPreferredSize());
	}
}
