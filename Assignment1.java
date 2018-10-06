/*
 * Name: Pragati Tanwar
 * E-mail: pt282@njit.edu*
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Assignment1 extends JFrame implements ActionListener
{	
	JTextField textField1, textField2, textField3;
	JFrame msgBox; ButtonGroup buttonGroup;
	
	private void display()
	{
		//sets the parameter of container
		setSize(500,500);
		Container obj = getContentPane();
		obj.setLayout(null);
		obj.setLocation(100,700); 
		setTitle("Calculator");
		
		//3 text field are taken
		textField1 = new JTextField();
		textField1.setBounds(80,200,60,20);
		
		textField2 = new JTextField();
		textField2.setBounds(220,200,60,20);
		
		textField3 = new JTextField();
		textField3.setBounds(340,200,60,20);
		
		JLabel label = new JLabel("=");
		label.setBounds(300,205,10,10);
		
		//4 radio buttons are taken
		JRadioButton radioButton1 = new JRadioButton("+");
		radioButton1.setBounds(165,150,40,20);
		radioButton1.setActionCommand("+");
		radioButton1.addActionListener(this);
		
		JRadioButton radioButton2 = new JRadioButton("-");
		radioButton2.setBounds(165,180,40,20);
		radioButton2.setActionCommand("-");
		radioButton2.addActionListener(this);
		
		JRadioButton radioButton3 = new JRadioButton("*");
		radioButton3.setBounds(165,210,40,20);
		radioButton3.setActionCommand("*");
		radioButton3.addActionListener(this);
		
		JRadioButton radioButton4 = new JRadioButton("/");
		radioButton4.setBounds(165,240,40,20);
		radioButton4.setActionCommand("/");
		radioButton4.addActionListener(this);
		
		//radio buttons are added to buttonGroup, so that only one can be selected at a time
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		buttonGroup.add(radioButton4);
		
		//Takes all the objects on container
		obj.add(textField1);
		obj.add(textField2);
		obj.add(textField3);
		obj.add(radioButton1);
		obj.add(radioButton2);
		obj.add(radioButton3);
		obj.add(radioButton4);
		obj.add(label);
		setVisible(true);
	}
	
	//Gets called when any radio button is (un)/selected.
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		float num_1 = 0f,num_2 = 0f,result=0f;		
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String resString=null;
		
		if(e.getActionCommand()=="+")
		{
			try
			{
				//Adds(a+b) input taken from TextFields, and puts result in another TextField
				num_1=Float.parseFloat(textField1.getText());
				num_2=Float.parseFloat(textField2.getText());
				result = num_1+num_2;
				resString = decimalFormat.format(result);
				textField3.setText(resString);
			}
			catch(NumberFormatException numberFormatException)
			{
				//dialog box is shown if given input is not numeric or null. And clears all the button selection and textfield as well  
				JOptionPane.showMessageDialog(this, "Please provide valid input", "Error!!", JOptionPane.ERROR_MESSAGE);
				textField3.setText("");
				buttonGroup.clearSelection();
			}			
		}
		else if(e.getActionCommand()=="-")
		{
			try
			{
				//Subtracts(a-b) input taken from TextFields, and puts result in another TextField
				num_1=Float.parseFloat(textField1.getText());
				num_2=Float.parseFloat(textField2.getText());
				result = num_1-num_2;
				resString = decimalFormat.format(result);
				textField3.setText(resString);
			}
			catch(NumberFormatException numberFormatException)
			{
				//dialog box of error is shown if given input is not numeric or null. And clears all the button selection and textfield as well
				JOptionPane.showMessageDialog(this, "Please provide valid input", "Error!!", JOptionPane.ERROR_MESSAGE);
				textField3.setText("");
				buttonGroup.clearSelection();
			}
		}
		else if(e.getActionCommand()=="*")
		{
			try
			{
				//Multiplies(a*b) input taken from TextFields, and puts result in another TextField
				num_1=Float.parseFloat(textField1.getText());
				num_2=Float.parseFloat(textField2.getText());
				result = num_1*num_2;
				resString = decimalFormat.format(result);
				textField3.setText(resString);
			}
			catch(NumberFormatException numberFormatException)
			{
				//dialog box of error is shown if given input is not numeric or null. And clears all the button selection and textfield as well
				JOptionPane.showMessageDialog(this, "Please provide valid input", "Error!!", JOptionPane.ERROR_MESSAGE);
				textField3.setText("");
				buttonGroup.clearSelection();
			}
		}
		else if(e.getActionCommand()=="/")
		{
			try
			{
				//Divides(a/b) input taken from TextFields, and puts result in another TextField
				num_1=Float.parseFloat(textField1.getText());
				num_2=Float.parseFloat(textField2.getText());				
				result = num_1/num_2;				
				if(num_2==0)
				{
					//dialog box of error is shown if divider is 0. And clears all the button selection and textfield as well
					JOptionPane.showMessageDialog(this, "Can't divide by zero", "Error!!", JOptionPane.ERROR_MESSAGE);
					textField3.setText("");
					buttonGroup.clearSelection();
					return;
				}
				resString = decimalFormat.format(result);
				textField3.setText(resString);	
			}
			catch(NumberFormatException numberFormatException)
			{
				//dialog box of error is shown if given input is not numeric or null. And clears all the button selection and textfield as well
				JOptionPane.showMessageDialog(this, "Please provide valid input", "Error!!", JOptionPane.ERROR_MESSAGE);
				textField3.setText("");
				buttonGroup.clearSelection();
			}		
		}		
	}
	
	public static void main(String[] args)
	{
		Assignment1 obj = new Assignment1();
		obj.display();
	}
}

