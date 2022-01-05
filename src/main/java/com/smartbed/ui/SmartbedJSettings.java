package com.smartbed.ui;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

/**
 * SmartbedJSettings - a class used to Read the SmartbedJSettings.properties file containing UI Fonts/colors/Sizes
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedJSettings {
	
	public static String LOG_FILE_PATH;
	
	public static Color FONT_COLOR;
	public static Font FONT_SMALL_PLAIN;
	public static Font FONT_SMALL_BOLD;
	public static Font FONT_LARGE_PLAIN;

	public static Color HEADER_PANEL_LITE_COLOR;
	public static Color HEADER_PANEL_DARK_COLOR;
	public static Color HEADER_PANEL_BORDER_COLOR;
	public static int HEADER_PANEL_HEIGHT;
	
	public static Color LEFT_PANEL_COLOR;
	public static int LEFT_PANEL_WIDTH;
	public static Color UNDERLINE_LITE_COLOR;
	public static Color UNDERLINE_DARK_COLOR;

	public static Color RIGHT_PANEL_COLOR;
	public static int RIGHT_PANEL_PADDING;

	public static Color FOOTER_COLOR;
	public static Color FOOTER_BORDER_COLOR;
	public static int FOOTER_HEIGHT;

	public static Color BTN_BORDER_LITE_COLOR;
	public static Color BTN_BORDER_DARK_COLOR;
	public static Color BTN_BG_DARK_COLOR;
	public static Color BTN_BG_LITE_COLOR;
	public static Color BTN_ROLLOVER_DARK_COLOR;
	public static Color BTN_ROLLOVER_LITE_COLOR;
	public static Color BTN_ARROW_COLOR;

	/**
	 * Used to Read SmartbedJSettings.properties and Populate relevant Properties.
	 * SmartbedJSettings.properties must be placed in the src folder of the project
	 * 
	 * @param propFile the properties file
	 */
	public static void readPropFile(Properties propFile) {

		try {

			//Must Be the first Property set
			LOG_FILE_PATH= getString(propFile,"LOG_FILE_PATH");
			
			FONT_COLOR = getColor(propFile, "FONT_COLOR");
			FONT_SMALL_BOLD = getFont(propFile, "FONT_SMALL_PLAIN");
			FONT_SMALL_BOLD = getFont(propFile, "FONT_SMALL_BOLD");
			FONT_LARGE_PLAIN = getFont(propFile, "FONT_LARGE_PLAIN");

			HEADER_PANEL_DARK_COLOR = getColor(propFile, "HEADER_PANEL_DARK_COLOR");
			HEADER_PANEL_LITE_COLOR = getColor(propFile, "HEADER_PANEL_LITE_COLOR");
			HEADER_PANEL_BORDER_COLOR = getColor(propFile, "HEADER_PANEL_BORDER_COLOR");
			HEADER_PANEL_HEIGHT = getInteger(propFile, "HEADER_PANEL_HEIGHT");

			
			LEFT_PANEL_COLOR = getColor(propFile, "LEFT_PANEL_COLOR");
			LEFT_PANEL_WIDTH = getInteger(propFile, "LEFT_PANEL_WIDTH");
			UNDERLINE_LITE_COLOR = getColor(propFile, "UNDERLINE_LITE_COLOR");
			UNDERLINE_DARK_COLOR = getColor(propFile, "UNDERLINE_DARK_COLOR");
			
			RIGHT_PANEL_COLOR = getColor(propFile, "RIGHT_PANEL_COLOR");
			RIGHT_PANEL_PADDING = getInteger(propFile, "RIGHT_PANEL_PADDING");

			FOOTER_COLOR = getColor(propFile, "FOOTER_COLOR");
			FOOTER_BORDER_COLOR = getColor(propFile, "FOOTER_BORDER_COLOR");
			FOOTER_HEIGHT = getInteger(propFile, "FOOTER_HEIGHT");

			BTN_BORDER_LITE_COLOR = getColor(propFile, "BTN_BORDER_LITE_COLOR");
			BTN_BORDER_DARK_COLOR = getColor(propFile, "BTN_BORDER_DARK_COLOR");
			BTN_BG_DARK_COLOR = getColor(propFile, "BTN_BG_DARK_COLOR");
			BTN_BG_LITE_COLOR = getColor(propFile, "BTN_BG_LITE_COLOR");
			BTN_ROLLOVER_DARK_COLOR = getColor(propFile, "BTN_ROLLOVER_DARK_COLOR");
			BTN_ROLLOVER_LITE_COLOR = getColor(propFile, "BTN_ROLLOVER_LITE_COLOR");
			BTN_ARROW_COLOR = getColor(propFile, "BTN_ARROW_COLOR");


		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * Used to Created a Color from RGB values contained within the .properties file
	 * 
	 * @param propFile the Properties File
	 * @param key the key e.g. HEADER_PANEL_LITE_COLOR would look for HEADER_PANEL_LITE_COLOR.R,HEADER_PANEL_LITE_COLOR.G,HEADER_PANEL_LITE_COLOR.B
	 * @return the new Color
	 */
	private static Color getColor(Properties propFile, String key) {

		Color color = null;

		try {
			Integer R = Integer.parseInt(propFile.getProperty(key + ".R"));
			Integer G = Integer.parseInt(propFile.getProperty(key + ".G"));
			Integer B = Integer.parseInt(propFile.getProperty(key + ".B"));

			color = new Color(R, G, B);

		} catch (Exception e) {

			e.printStackTrace();
			color = Color.BLACK;

		}// End try/catch

		return color;
	}
	
	/**
	 * Used to Created a Font from Name,Style and Size values contained within the .properties file
	 * 
	 * @param propFile the Properties File
	 * @param key the key e.g. FONT_SMALL_BOLD would look for FONT_SMALL_BOLD.NAME,FONT_SMALL_BOLD.STYLE,FONT_SMALL_BOLD.SIZE
	 * @return the Font
	 */
	public static Font getFont(Properties propFile, String key) {

		Font font = null;

		try {

			String fontName = propFile.getProperty(key + ".NAME");
			Integer fontStyle = Integer.parseInt(propFile.getProperty(key + ".STYLE"));
			Integer fontSize = Integer.parseInt(propFile.getProperty(key + ".SIZE"));
			
			font = new Font(fontName, fontStyle, fontSize);

		} catch (Exception e) {

			e.printStackTrace();
			font = new Font("Tahoma", Font.PLAIN, 11);

		}

		return font;

	}

	/**
	 * get a string from a properties file
	 * 
	 * @param propFile the properties file
	 * @param key the key
	 * @return the string
	 */
	private static String getString(Properties propFile, String key) {

		return propFile.getProperty(key);

	}

	/**
	 * get an int from a properties file
	 * 
	 * @param propFile the properties file
	 * @param key the key
	 * @return the int
	 */
	private static int getInteger(Properties propFile, String key) {

		return Integer.parseInt(propFile.getProperty(key));

	}

	/**
	 * get a double from a properties file
	 * 
	 * @param propFile the properties file
	 * @param key the key
	 * @return the double
	 */
	private static double getDouble(Properties propFile, String key) {

		return Double.parseDouble(propFile.getProperty(key));

	}

}
