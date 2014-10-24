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
	private JTextField sampleField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private SpringLayout baseLayout;
	private JToggleButton ToggleBtn;
	private JLabel background; 

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		sampleButton = new JButton("Steven why?");
		sampleField = new JTextField(25);
		chatArea = new JTextArea(5, 25);
		chatPane = new JScrollPane(chatArea);
		ToggleBtn = new JToggleButton("Touch!");
		background = new JLabel(new ImageIcon(getClass().getResource("/chatbot/view/images/ChatbotBackground.png")));
		baseLayout = new SpringLayout();

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
		this.add(sampleField);
		this.add(chatPane);
		this.add(background);
		sampleButton.setBackground(Color.cyan);

	}

	/**
	 * What the design looks like.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleField, -10,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleField, -10,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 10,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 10,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleButton, 30,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, 119,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 100,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 100,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, ToggleBtn, -1,
				SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.WEST, ToggleBtn, 6,
				SpringLayout.EAST, sampleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, ToggleBtn, -68,
				SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, ToggleBtn, -260,
				SpringLayout.EAST, this);
		add(ToggleBtn);

	}

	private void setupListeners()
	{
		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sampleField.setBackground(Color.CYAN);
			}
		});
		ToggleBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sampleField.setBackground(Color.BLUE);
			}
		});
	}

}
