package com.smartbed.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Point;
import javax.swing.JPanel;

/**
 * SmartbedJGradientPanel Class - a class to Create a Java Gradient Panel
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedJGradientPanel extends JPanel{

	// SmartbedJGradientOrientation enum - used to specify gradient orientations
	public enum SmartbedJGradientOrientation {
	    GRADIENT_ORIENTATION_HORIZONTAL(0),
	    GRADIENT_ORIENTATION_VERTICAL(1);

	    private int orientation;

	    SmartbedJGradientOrientation(int orientation) {
	        this.orientation = orientation;
	    }

	    public int getOrientation() {
	        return orientation;
	    }
	}

	// declare instance variables
	Color gradientLightColor;
	Color gradientDarkColor;
	SmartbedJGradientOrientation orientation;

	/**
	 * constructor used to initialise a SmartbedJGradientPanel
	 * 
	 * @param gradientLightColor Gradient Light Color
	 * @param gradientDarkColor Gradient Dark Color
	 * @param orientation Orientation (0 - Horizontal, 1 - Vertical)
	 */
	public SmartbedJGradientPanel(Color gradientLightColor,Color gradientDarkColor, SmartbedJGradientOrientation orientation){
		
		this.gradientLightColor = gradientLightColor;
		this.gradientDarkColor = gradientDarkColor;
		this.orientation = orientation;
		
		this.setLayout(new GridBagLayout());

	}

	/**
	 * override paintComponent() method - used to paint the SmartbedJGradientPanel to the screen
	 *
	 * @param g the Graphics used to paint the panel
	 */
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();

		if(orientation == SmartbedJGradientOrientation.GRADIENT_ORIENTATION_VERTICAL){

		g2.setPaint(new GradientPaint(new Point(0, 0),gradientLightColor , new Point(0, getHeight()),gradientDarkColor ));
		
		}else if(orientation == SmartbedJGradientOrientation.GRADIENT_ORIENTATION_HORIZONTAL){
			
		g2.setPaint(new GradientPaint(new Point(0, 0),gradientLightColor , new Point(getWidth(), 0),gradientDarkColor ));	
		
		}
	
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.dispose();		
		
	}

}
