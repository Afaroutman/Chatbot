package chatbot.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotAppController;

import javax.swing.JToggleButton;

/**
 * 
 * @author Alan Hite
 *
 */
public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;

	private JButton sampleButton;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private SpringLayout baseLayout;
	private JToggleButton ToggleBtn;
	private JLabel background; 

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		sampleButton = new JButton("Steven why?");
		chatArea = new JTextArea(1, 10);
		chatPane = new JScrollPane(chatArea);
		background = new JLabel(new ImageIcon(ChatbotPanel.class.getResource("/chatbot/view/images/ChatbotBackground.png")));
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 64,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 133,
				SpringLayout.WEST, this);

		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupScrollPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}

	/**
	 * Interactual pieces
	 */
	private void setupPanel()
	{
		//this.setBackground(Color.GREEN);
		this.setLayout(baseLayout);
		this.add(sampleButton);
		ToggleBtn = new JToggleButton("Touch!");
		baseLayout.putConstraint(SpringLayout.NORTH, ToggleBtn, 74, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, ToggleBtn, 338, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, ToggleBtn, -68, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, ToggleBtn, -260, SpringLayout.EAST, this);
		add(ToggleBtn);
		this.add(chatPane);
		this.add(background);
		sampleButton.setBackground(Color.cyan);

	}

	/**
	 * What the design looks like.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 10,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 10,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleButton, 30,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, 119,
				SpringLayout.WEST, this);

	}

	private void setupListeners()
	{
		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sampleButton.setBackground(Color.CYAN);
			}
		});
		ToggleBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sampleButton.setBackground(Color.BLUE);
			}
		});
	}

}
