package com.smartbed.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.smartbed.ui.SmartbedJGradientPanel.SmartbedJGradientOrientation;

/**
 * SmartbedJPanel Class - a class that represents a Smartbed Java Panel
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedJPanel extends JPanel {
	
	String title;
	
	private Color panelColor;
	private int padding;

	private Font titleFont;
	private Color titleColor;

	/**
	 * constructor used to initialise a SmartbedJPanel
	 * 
	 * @param title the title
	 * @param panelColor the panel colour
	 * @param padding the padding
	 * @param titleFont the title font
	 * @param titleColor the title font colour
	 */
	public SmartbedJPanel(String title,Color panelColor,int padding,Font titleFont,Color titleColor){

		this.title = title;
		this.panelColor = panelColor;
		this.padding = padding;
		this.titleFont = titleFont;
		this.titleColor = titleColor;

		setBackground(panelColor);
		setBorder(new EmptyBorder(padding,padding, padding, padding));		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		//Set Title
		JLabel titleLabel = new JLabel(this.title);
		titleLabel.setForeground(titleColor);
		titleLabel.setFont(titleFont);
		
		//Create Underline
		SmartbedJGradientPanel underline = new SmartbedJGradientPanel(SmartbedJSettings.UNDERLINE_LITE_COLOR,SmartbedJSettings.UNDERLINE_DARK_COLOR,SmartbedJGradientOrientation.GRADIENT_ORIENTATION_HORIZONTAL);		
		underline.setAlignmentX(Component.CENTER_ALIGNMENT);
		underline.setPreferredSize(new Dimension (underline.getMaximumSize().width,2));
		underline.setMaximumSize(new Dimension (underline.getMaximumSize().width,2));
		
		//Add Components to Panel
		JPanel holderPanel = new JPanel();
		holderPanel.setOpaque(false);
		holderPanel.setLayout(new BoxLayout(holderPanel,BoxLayout.Y_AXIS));
		holderPanel.add(titleLabel);
		holderPanel.add(underline);
		holderPanel.add(Box.createRigidArea(new Dimension(0,5)));
		
		this.add(holderPanel,BorderLayout.NORTH);

	}

}
