package com.smartbed.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.JButton;

/**
 * SmartbedJGradientPanel Class - a class to Create a Smartbed JButton, defines active/inactive/mouseover colours
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedJButton extends JButton {

	// declare constants
	private static final Color inactiveBorderLiteColor = SmartbedJSettings.BTN_BORDER_LITE_COLOR;
	private static final Color inactiveBorderDarkColor = SmartbedJSettings.BTN_BORDER_DARK_COLOR;

	private static final Color inactiveDarkColor = SmartbedJSettings.BTN_BG_DARK_COLOR;
	private static final Color inactiveLiteColor = SmartbedJSettings.BTN_BG_LITE_COLOR;
	private static final Color inactiveDownDarkColor = SmartbedJSettings.BTN_ROLLOVER_DARK_COLOR;
	private static final Color inactiveDownLiteColor = SmartbedJSettings.BTN_ROLLOVER_LITE_COLOR;
	
	
	/**
	 * constructor used to initialise a SmartbedJButton
	 * 
	 * @param text the button text
	 * @param textFont the button text Font
	 * @param textColor the button text Color
	 */
	public SmartbedJButton(String text, Font textFont, Color textColor) {
		super(text);

		setToolTipText(text);
		setFont(textFont);
		setForeground(textColor);
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setPreferredSize(new Dimension(75, 35));
		setMaximumSize(new Dimension(75, 35));
		setContentAreaFilled(false);
		setFocusPainted(false);

	}

	/**
	 * override paintComponent() method - used to paint the  SmartbedJButton to the screen
	 *
	 * @param g the Graphics used to paint the button
	 */
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g.create();

		// Set RenderingHints to smooth rounded rectangle
		RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(qualityHints);

			// Border Color
			g2.setPaint(new GradientPaint(new Point(0, 0), inactiveBorderLiteColor, new Point(0, getHeight()), inactiveBorderDarkColor));
			
			// Paint Border
			if (getModel().isRollover()) {
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
			}

			g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 10, 10);

			// Paint Button
			if (getModel().isPressed()) {
				g2.setPaint(new GradientPaint(new Point(0, 0), inactiveDownLiteColor, new Point(0, getHeight()), inactiveDownDarkColor));
			} else {
				g2.setPaint(new GradientPaint(new Point(0, 0), inactiveLiteColor, new Point(0, getHeight()), inactiveDarkColor));
			}

			g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 8, 8);

		g2.dispose();

		super.paintComponent(g);

	}


}

