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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;

/**
 * 
 * @author Alan Hite
 *
 */
public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;

	private JButton sampleButton;
	private JTextField sampleField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private SpringLayout baseLayout;
	private JToggleButton ToggleBtn;
	private JLabel background;

	public ChatbotPanel(ChatbotAppController baseController)
	{
		sampleButton = new JButton("Steven why?");
		sampleButton.setBackground(Color.GRAY);
		sampleButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sampleField = new JTextField(10);
		chatArea = new JTextArea(1, 10);
		chatPane = new JScrollPane(chatArea);
		ToggleBtn = new JToggleButton("Touch!");
		ToggleBtn.setSelected(true);
		background = new JLabel(new ImageIcon(ChatbotPanel.class.getResource("/chatbot/view/images/ChatbotBackground.png")));
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 100, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleField, 750, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 575, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, 750, SpringLayout.WEST, this);
		this.baseController = baseController;	
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupScrollPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEnabled(false);
	}

	/**
	 * Interactual pieces
	 */
	private void setupPanel()
	{
		// this.setBackground(Color.GREEN);
		this.add(sampleField);
		this.setLayout(baseLayout);
		this.add(chatPane);
		this.add(sampleButton);
		this.add(background);
		this.add(ToggleBtn);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 150, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 150, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, ToggleBtn, 78, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, ToggleBtn, 300, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, ToggleBtn, -68, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, ToggleBtn, -260, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, background, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 69, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleButton, 96, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, 107, SpringLayout.WEST, this);

	}

	/**
	 * What the design looks like.
	 */
	private void setupLayout()
	{

	}

	private void setupListeners()
	{
		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userTypedText = sampleField.getText();
				String chatbotResponse = baseController.sendTextToChatBot(userTypedText);
				displayTextToUser(userTypedText);
				displayTextToUser(chatbotResponse);
				sampleField.setText("");
			}
		});
	}

	public void displayTextToUser(String input)
	{
		chatArea.append("\n" + input);
	}

}
