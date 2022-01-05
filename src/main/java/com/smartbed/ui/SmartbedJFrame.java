package com.smartbed.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import com.smartbed.ui.SmartbedJGradientPanel.SmartbedJGradientOrientation;

/**
 * SmartbedJGradientPanel Class - a class to Create a Smartbed JFrame
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedJFrame extends JFrame implements ActionListener {

	// declare instance variables
	
	// Properties File
	private Properties propFile;

	// Header Components
	private JPanel headerPanel;
	private String title = "";

	// Left Panel Components
	private JPanel leftPanel;

	// Right Panel  Components
	private JPanel rightPanel;

	// Footer Components
	private JPanel footerPanel;
	private SmartbedJButton btnExit;

	/**
	 * Used to initialise a SmartbedJFrame
	 * 
	 * @param title the title
	 * @param propFile the properties file
	 */
	public SmartbedJFrame(String title, Properties propFile) {

		this.propFile = propFile;
		this.title = title;
		
		// Must Be the first thing called as It Sets Log File Location etc.
		SmartbedJSettings.readPropFile(propFile);
		
		// Set the Look and Feel
		setLookAndFeel();

		// Get Container
		Container c = getContentPane();
		c.setBackground(Color.WHITE);

		// Initialise SmartbedJFrame Components
		headerPanel = createHeaderPanel();
		leftPanel = createLeftPanel();
		rightPanel = createRightPanel();
		footerPanel = createFooterPanel();

		// Add Panels to SmartbedJFrame Container
		c.add(headerPanel, BorderLayout.NORTH);
		c.add(leftPanel, BorderLayout.WEST);
		c.add(rightPanel, BorderLayout.CENTER);
		c.add(footerPanel, BorderLayout.SOUTH);

	}

	/**
	 * sets the default look and feel
	 */
	public static void setLookAndFeel() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Creates the headerPanel
	 * 
	 * @return the headerPanel
	 */
	private JPanel createHeaderPanel() {

		JPanel headerPanel = new SmartbedJGradientPanel(SmartbedJSettings.HEADER_PANEL_LITE_COLOR,
				SmartbedJSettings.HEADER_PANEL_DARK_COLOR, SmartbedJGradientOrientation.GRADIENT_ORIENTATION_VERTICAL);
		headerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, SmartbedJSettings.HEADER_PANEL_BORDER_COLOR));
		headerPanel.setPreferredSize(new Dimension(this.getWidth(), SmartbedJSettings.HEADER_PANEL_HEIGHT));

		JLabel headerLabel = new JLabel(title);
		headerLabel.setFont(SmartbedJSettings.FONT_SMALL_BOLD);
		headerLabel.setForeground(SmartbedJSettings.FONT_COLOR);
		headerPanel.add(headerLabel);

		return headerPanel;

	}

	/**
	 * Creates the leftPanel
	 * 
	 * @return the leftPanel
	 */
	private JPanel createLeftPanel() {

		JPanel leftPanel= new JPanel(new CardLayout());
		leftPanel.setBackground(SmartbedJSettings.LEFT_PANEL_COLOR);
		leftPanel.setPreferredSize(
		new Dimension(SmartbedJSettings.LEFT_PANEL_WIDTH, leftPanel.getMaximumSize().height));

		return leftPanel;

	}

	/**
	 * Creates the rightPanel
	 * 
	 * @return the rightPanel
	 */
	private JPanel createRightPanel() {

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setBackground(SmartbedJSettings.RIGHT_PANEL_COLOR);

		return rightPanel;

	}

	/**
	 * Creates the footerPanel
	 * 
	 * @return the footerPanel
	 */
	private JPanel createFooterPanel() {

		JPanel footerPanel = new JPanel(new BorderLayout());
		footerPanel.setBackground(SmartbedJSettings.FOOTER_COLOR);
		footerPanel.setPreferredSize(new Dimension(this.getWidth(), SmartbedJSettings.FOOTER_HEIGHT));
		footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, SmartbedJSettings.FOOTER_BORDER_COLOR));

		JPanel footerBtnPanel = new JPanel();
		footerBtnPanel.setLayout(new BoxLayout(footerBtnPanel, BoxLayout.X_AXIS));
		footerBtnPanel.setOpaque(false);

		btnExit = new SmartbedJButton("Exit", SmartbedJSettings.FONT_SMALL_BOLD, SmartbedJSettings.FONT_COLOR);
		btnExit.addActionListener(this);

		footerBtnPanel.add(btnExit);
		footerBtnPanel.add(Box.createRigidArea(new Dimension(5, 0)));

		footerPanel.add(footerBtnPanel, BorderLayout.EAST);

		return footerPanel;

	}

	/**
	 * Called when a component Fires an ActionEvent
	 * 
	 * @param e the Action Event
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnExit) {
			System.exit(0);

		}

	}

	/**
	 * @return the btnExit
	 */
	public SmartbedJButton getBtnExit() {
		return btnExit;
	}
	
	/**
	 * @return the headerPanel
	 */
	public JPanel getHeaderPanel() {
		return headerPanel;
	}
	
	/**
	 * @return the leftPane
	 */
	public JPanel getLeftPanel() {
		return leftPanel;
	}
	
	/**
	 * @return the rightPanel
	 */
	public JPanel getRightPanel() {
		return rightPanel;
	}

	/**
	 * @return the footerPanel
	 */
	public JPanel getFooterPanel() {
		return footerPanel;
	}

}
