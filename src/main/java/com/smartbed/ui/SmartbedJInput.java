package com.smartbed.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * SmartbedJInput Class - a class that groups together a JLabel and an Input (e.g. JComboBox)
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class SmartbedJInput extends JPanel {
	
	// SmartbedJInputType enum - used to specify input types
	public enum SmartbedJInputType {
	    INPUT_TYPE_TEXT(0),
	    INPUT_TYPE_COMBO(1),
	    INPUT_TYPE_FILE(2);

	    private int type;

	    SmartbedJInputType(int type) {
	        this.type = type;
	    }

	    public int getType() {
	        return type;
	    }
	}

	// declare instance variables
	
	// attributes of the panel
	String strLabel;
	Object[] values;
	SmartbedJInputType inputType;

	// panel components
	JLabel label;
	JComboBox combo;
	JTextField textField;
	JButton fileButton;
	JLabel fileLabel;

	// fonts
	Font fileLabelFont = SmartbedJSettings.FONT_SMALL_PLAIN;
	Font labelFont = SmartbedJSettings.FONT_SMALL_BOLD;
	Color labelColor = SmartbedJSettings.FONT_COLOR;
	Font comboFont = SmartbedJSettings.FONT_SMALL_PLAIN;

	/**
	 * constructor to initialise Smartbed Java Input panel
	 * 
	 * @param strId the panel id
	 * @param strLabel the Label Text
	 * @param inputType the input type
	 * @param isCompulsory is the panel compulsory
	 * @param values the values (e.g. values in the combo box)
	 */
	public SmartbedJInput(String strId,String strLabel, SmartbedJInputType inputType,boolean isCompulsory, Object[] values) {

		this.strLabel = strLabel;
		this.inputType = inputType;
		this.values = values;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setOpaque(false);

		label = new JLabel(strLabel + ": ");
		label.setPreferredSize(new Dimension(150, 25));
		label.setMaximumSize(new Dimension(150, 20));
		label.setFont(labelFont);
		label.setForeground(labelColor);
		
		add(label);

		if (inputType == SmartbedJInputType.INPUT_TYPE_COMBO) {
			
			combo = new JComboBox(values);
			combo .setRenderer(new IndentedRenderer());
			combo.setPreferredSize(new Dimension(150, 25));
			combo.setMaximumSize(new Dimension(150, 25));
			combo.setFont(comboFont);
			combo.setForeground(labelColor);
			combo.setFocusable(false);
			add(combo);

		} else if (inputType == SmartbedJInputType.INPUT_TYPE_TEXT) {

			textField = new JTextField();
			textField.setText(values[0].toString());
			textField.setPreferredSize(new Dimension(150, 25));
			textField.setMaximumSize(new Dimension(150, 25));
			textField.setFont(comboFont);
			textField.setForeground(labelColor);
			textField.setMargin(new Insets(0,7,0,7));
			add(textField);
			
		}else if (inputType == SmartbedJInputType.INPUT_TYPE_FILE) {
			
			fileButton = new JButton();
			fileButton.setText("Browse..");
			fileButton.setHorizontalAlignment(SwingConstants.LEFT);
			fileButton.setPreferredSize(new Dimension(150, 25));
			fileButton.setMaximumSize(new Dimension(150, 25));
			fileButton.setFont(comboFont);
			fileButton.setForeground(labelColor);
			fileButton.setFocusable(false);
			fileButton.setMargin(new Insets(0,7,0,7));
			add(fileButton);

		
		}

	}

	/**
	 * @return the strLabel
	 */
	public String getStrLabel() {
		return strLabel;
	}

	/**
	 * @return the values
	 */
	public Object[] getValues() {
		return values;
	}

	/**
	 * @return the inputType
	 */
	public SmartbedJInputType getInputType() {
		return inputType;
	}
	
	/**
	 * @return the label
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * @return the combo
	 */
	public JComboBox getCombo() {
		return combo;
	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @return the fileButton
	 */
	public JButton getFileButton() {
		return fileButton;
	}
	
	/**
	 * @return the fileLabel
	 */
	public JLabel getFileLabel() {
		return fileLabel;
	}

	/**
	 * @return the selected value
	 */
	public String getValue() {
		
		if (values.length > 1) {
		return (String) combo.getSelectedItem();
		}else{
			return textField.getText();
		}
		
	}

	
	  class OpenFile implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      JFileChooser c = new JFileChooser();
		      int rVal = c.showOpenDialog(SmartbedJInput.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		    	 // fileLabel.setText(c.getSelectedFile().getAbsolutePath());
		    	  //fileLabel.setText(c.getCurrentDirectory().toString());
		      }

		    }
		  }


	  /**
	   * IndentedRenderer Class - a class that indents the labels in a JComboBox
	   *
	   * @author Tim Winwood - x20213638
	   * @version 1.0
	   */
	  class IndentedRenderer extends DefaultListCellRenderer
	  {
	    public Component getListCellRendererComponent(JList list,Object value,
	                        int index,boolean isSelected,boolean cellHasFocus)
	    {
	      JLabel lbl = (JLabel)super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
	      lbl.setBorder(BorderFactory.createEmptyBorder(0,7,0,0));
	      return lbl;
	    }
	  }

}
