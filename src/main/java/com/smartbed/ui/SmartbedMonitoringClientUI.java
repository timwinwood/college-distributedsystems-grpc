package com.smartbed.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.embed.swing.JFXPanel;

/**
 * SmartbedMonitoringClientUI - a class to create and show the SmartbedMonitoringClient UI
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedMonitoringClientUI{

	// declare constants
	private final static int FRAME_WIDTH = 800;
	private final static int FRAME_HEIGHT = 475;
	private final static String TITLE_MAIN = "SmartBed";
	private final static String TITLE_SUB = "Bed Monitoring Client";

	// declare instance variables

	// Line Chart Components
	private LineChart lineChart;

	// Properties File
	private Properties propFile;

	// SmartbedJFrame
	private SmartbedJFrame smartbedJFrame;

	// Left Panel Components
	private JPanel leftPanel;

	// Right Panel Components
	private JPanel rightPanel;
	
	private JTextArea areaChat;
	private JTextField fieldChatMessage;

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

		JFXPanel fxPanel = new JFXPanel();

		// Defining X axis
		NumberAxis xAxis = new NumberAxis(-24, 0, 3);
		xAxis.setLabel("Time");

		// Defining y axis
		NumberAxis yAxis = new NumberAxis(0, 80, 10);
		yAxis.setLabel("No. of Beds");

		int chartWidth = FRAME_WIDTH - SmartbedJSettings.LEFT_PANEL_WIDTH - (SmartbedJSettings.RIGHT_PANEL_PADDING * 4);
		int chartHeight = FRAME_HEIGHT - SmartbedJSettings.HEADER_PANEL_HEIGHT - SmartbedJSettings.FOOTER_HEIGHT - SmartbedJSettings.FONT_LARGE_PLAIN.getSize() - 25 - (SmartbedJSettings.RIGHT_PANEL_PADDING * 6);

		lineChart = new LineChart(xAxis, yAxis);
		lineChart.setLegendVisible(false);
		lineChart.setMaxSize(chartWidth, chartHeight);
		lineChart.setPrefSize(chartWidth, chartHeight);
		lineChart.setMinSize(chartWidth, chartHeight);

		XYChart.Series series = new XYChart.Series();
		lineChart.getData().add(series);
	
		lineChart.getStylesheets().add(getClass().getResource("colored-chart.css").toString());

		Group root = new Group(lineChart);
		Scene scene = new Scene(root, chartWidth, chartHeight);
		fxPanel.setScene(scene);

		leftPanelInner.add(fxPanel);

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
		Font labelFont = SmartbedJSettings.FONT_SMALL_BOLD;
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


	public JButton getBtnSend() {
		return btnSend;
	}
	
	
	
	public JTextArea getAreaChat() {
		return areaChat;
	}

	public JTextField getFieldChatMessage() {
		return fieldChatMessage;
	}

	/**
	 * updates the line chart in the Monitoring client
	 * 
	 * @param y the y value for the line chart
	 */
	public void updateLineChart(int y) {

		XYChart.Series series = (XYChart.Series) lineChart.getData().get(0);
		int x = 0;

		// Shift all points 1 to the left
		for (int i = 0; i < series.getData().size(); i++) {

			XYChart.Data data = (XYChart.Data) series.getData().get(i);
			int curX = (int) data.getXValue();
			data.setXValue(curX - 3);

		}

		// Add new point on the right
		series.getData().add(new XYChart.Data(x, y));

	}

}
