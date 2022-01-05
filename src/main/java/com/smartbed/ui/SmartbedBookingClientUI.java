package com.smartbed.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.smartbed.ui.SmartbedJInput.SmartbedJInputType;

/**
 * SmartbedBookingClientUI - a class to create and show the SmartbedBookingClientUI UI
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedBookingClientUI{

	// declare constants
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 475;
	private static final String TITLE_MAIN = "SmartBed";
	private static final String TITLE_SUB = "Bed Booking Client";

	// declare instance variables
	
	// Properties File
	Properties propFile;

	// SmartbedJFrame
	private SmartbedJFrame smartbedJFrame;

	// Left Panel Components
	private JPanel leftPanel;
	private JButton btnPhoto;

	private JTextField fieldFirst;
	private JTextField fieldLast;
	private JTextField fieldPps;
	private JComboBox comboGender;

	private JTextArea areaChat;
	private JTextField fieldChatMessage;

	// Right Panel Components
	private JPanel rightPanel;

	private JButton btnBook;
	private JButton btnSend;

	/**
	 * Create the GUI and show it.
	 * 
	 */
	public void createAndShowGUI() {

		// Read Properties File
		propFile = loadPropFile();

		// Create Components
		smartbedJFrame = createSmartbedJFrame();
		leftPanel = createLeftPanel();
		rightPanel = createRightPanel();

		// Show the SmartbedJFrame
		smartbedJFrame.setVisible(true);

	}

	/**
	 * Loads the properties file
	 * 
	 * @return the properties file
	 */
	private Properties loadPropFile() {

		Properties propFile = new Properties();
		FileInputStream fs=null;
		try  {
			fs = new FileInputStream("src/main/resources/SmartbedJSettings.properties");
			propFile.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fs!= null) {
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return propFile;

	}

	/**
	 * Creates the SmartbedJFrame
	 * 
	 * @return the SmartbedJFrame
	 */
	private SmartbedJFrame createSmartbedJFrame() {

		SmartbedJFrame smartbedJFrame = new SmartbedJFrame(TITLE_MAIN, propFile);
		smartbedJFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		smartbedJFrame.setLocationRelativeTo(null);
		smartbedJFrame.setIconImage(getImageFromResource("src/main/resources/smartbed.gif"));
		smartbedJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		smartbedJFrame.setResizable(false);

		return smartbedJFrame;

	}

	/**
	 * Creates the leftPanel
	 * 
	 * @return the leftPanel
	 */
	private JPanel createLeftPanel() {

		JPanel leftPanel = smartbedJFrame.getLeftPanel();
		JPanel leftPanelInner = new SmartbedJPanel(TITLE_SUB, SmartbedJSettings.LEFT_PANEL_COLOR, SmartbedJSettings.RIGHT_PANEL_PADDING, SmartbedJSettings.FONT_LARGE_PLAIN, SmartbedJSettings.FONT_COLOR);
		leftPanel.add(leftPanelInner);
		
		leftPanelInner.add(Box.createRigidArea(new Dimension(0,15)));

		String[] firstNameValue = { "" };
		SmartbedJInput firstNameInput = new SmartbedJInput("firstname", "First Name", SmartbedJInputType.INPUT_TYPE_TEXT, true, firstNameValue);
		leftPanelInner.add(firstNameInput);
		fieldFirst = firstNameInput.getTextField();

		leftPanelInner.add(Box.createRigidArea(new Dimension(0, 20)));

		String[] lastNameValue = { "" };
		SmartbedJInput lastNameInput = new SmartbedJInput("lastname", "Last Name", SmartbedJInputType.INPUT_TYPE_TEXT, true, lastNameValue);
		leftPanelInner.add(lastNameInput);
		fieldLast= lastNameInput.getTextField();

		leftPanelInner.add(Box.createRigidArea(new Dimension(0, 20)));

		String[] ppsNoValue = { "" };
		SmartbedJInput ppsNoInput = new SmartbedJInput("ppsnumber", "PPS Number", SmartbedJInputType.INPUT_TYPE_TEXT, true, ppsNoValue);
		leftPanelInner.add(ppsNoInput);
		fieldPps = ppsNoInput.getTextField();

		leftPanelInner.add(Box.createRigidArea(new Dimension(0, 20)));

		String[] genderValue = { "Male", "Female", "Prefer not to Say" };
		SmartbedJInput genderInput = new SmartbedJInput("gender", "Gender", SmartbedJInputType.INPUT_TYPE_COMBO, true, genderValue);
		leftPanelInner.add(genderInput);
		comboGender = genderInput.getCombo();

		leftPanelInner.add(Box.createRigidArea(new Dimension(0, 20)));

		String[] photoValue = { "1", "2" };
		SmartbedJInput photoInput = new SmartbedJInput("photo", "Photo", SmartbedJInputType.INPUT_TYPE_FILE, true, photoValue);
		leftPanelInner.add(photoInput);
		btnPhoto = photoInput.getFileButton();

		leftPanelInner.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel bookButtonPanel = createBookButtonPanel();
		leftPanelInner.add(bookButtonPanel);

		return leftPanel;

	}
	
	/**
	 * Creates the rightPanel
	 * 
	 * @return the rightPanel
	 */
	private JPanel createRightPanel() {

		JPanel rightPanel = smartbedJFrame.getRightPanel();

		Color panelColor = SmartbedJSettings.LEFT_PANEL_COLOR;
		int padding = SmartbedJSettings.RIGHT_PANEL_PADDING;
		Color labelColor = SmartbedJSettings.FONT_COLOR;
		Font comboFont = SmartbedJSettings.FONT_SMALL_PLAIN;

		JPanel rightPanelInner = new JPanel();
		rightPanelInner.setBackground(panelColor);
		rightPanelInner.setBorder(new EmptyBorder(padding, padding, padding, padding));
		rightPanelInner.setLayout(new BoxLayout(rightPanelInner, BoxLayout.Y_AXIS));
		rightPanelInner.setAlignmentX(JPanel.LEFT_ALIGNMENT);

		rightPanelInner.add(Box.createRigidArea(new Dimension(0, 70)));

		JTextField helperField = new JTextField();
		areaChat = new JTextArea("chat");
		areaChat.setBorder(helperField.getBorder());
		areaChat.setPreferredSize(new Dimension(300, 160));
		areaChat.setMaximumSize(new Dimension(300, 160));
		areaChat.setFont(comboFont);
		areaChat.setForeground(labelColor);
		areaChat.setBounds(0, 0, 200, 10);
		areaChat.setFocusable(false);
		areaChat.setMargin(new Insets(3, 7, 3, 7));
		areaChat.setLineWrap(true);
		areaChat.setWrapStyleWord(true);
		rightPanelInner.add(areaChat);

		rightPanelInner.add(Box.createRigidArea(new Dimension(0, 20)));

		fieldChatMessage = new JTextField();
		fieldChatMessage.setText("message");
		fieldChatMessage.setPreferredSize(new Dimension(300, 25));
		fieldChatMessage.setMaximumSize(new Dimension(300, 25));
		fieldChatMessage.setFont(comboFont);
		fieldChatMessage.setForeground(labelColor);
		fieldChatMessage.setMargin(new Insets(0, 7, 0, 7));
		rightPanelInner.add(fieldChatMessage);

		rightPanelInner.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel sendButtonPanel = createSendButtonPanel();
		rightPanelInner.add(sendButtonPanel);

		rightPanel.add(rightPanelInner);

		return rightPanel;

	}

	/**
	 * Creates the bookButtonPanel
	 * 
	 * @return the bookButtonPanel
	 */
	private JPanel createBookButtonPanel() {

		JPanel bookButtonPanel = new JPanel(new BorderLayout());
		bookButtonPanel.setBackground(SmartbedJSettings.FOOTER_COLOR);
		bookButtonPanel.setPreferredSize(new Dimension(bookButtonPanel.getMaximumSize().width, SmartbedJSettings.FOOTER_HEIGHT));
		bookButtonPanel.setMaximumSize(new Dimension(bookButtonPanel.getMaximumSize().width, SmartbedJSettings.FOOTER_HEIGHT));
		bookButtonPanel.setOpaque(false);

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		btnPanel.setOpaque(false);

		btnBook = new SmartbedJButton("Book", SmartbedJSettings.FONT_SMALL_BOLD, SmartbedJSettings.FONT_COLOR);

		btnPanel.add(btnBook);
		btnPanel.add(Box.createRigidArea(new Dimension(31, 0)));

		bookButtonPanel.add(btnPanel, BorderLayout.EAST);

		return bookButtonPanel;

	}

	/**
	 * Creates the sendButtonPanel
	 * 
	 * @return the sendButtonPanel
	 */
	private JPanel createSendButtonPanel() {

		JPanel sendButtonPanel = new JPanel(new BorderLayout());
		sendButtonPanel.setBackground(SmartbedJSettings.FOOTER_COLOR);
		sendButtonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, SmartbedJSettings.FOOTER_HEIGHT));
		sendButtonPanel.setOpaque(false);

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		btnPanel.setOpaque(false);

		btnSend = new SmartbedJButton("Send", SmartbedJSettings.FONT_SMALL_BOLD, SmartbedJSettings.FONT_COLOR);

		btnPanel.add(btnSend);
		btnPanel.add(Box.createRigidArea(new Dimension(38, 0)));

		sendButtonPanel.add(btnPanel, BorderLayout.EAST);

		return sendButtonPanel;

	}

	/**
	 * Retrieves Image from resources package
	 * 
	 * @param name Name of Image
	 * @return the image
	 */
	private static Image getImageFromResource(String name) {

		try {
			ImageIcon icon = new ImageIcon(name);
			return icon.getImage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} // End try/catch

	}

	public JTextField getFieldFirst() {
		return fieldFirst;
	}

	public JTextField getFieldLast() {
		return fieldLast;
	}

	public JTextField getFieldPps() {
		return fieldPps;
	}

	public JComboBox getComboGender() {
		return comboGender;
	}


	public JButton getBtnPhoto() {
		return btnPhoto;
	}

	public JButton getBtnBook() {
		return btnBook;
	}

	public JButton getBtnSend() {
		return btnSend;
	}

	
	public JTextArea getAreaChat() {
		return areaChat;
	}

	public JTextField getFieldChatMessage() {
		return fieldChatMessage;
	}




}
