/*  Name:  Jacob Schleith
     COP 3330 – Summer 2011
     Assignment title: Program  #5: An Advanced Java GUI Application
     Date:   August 1, 2011
*/

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TempConverter extends JFrame  {
	
	static final int WINDOW_WIDTH = 900;  												//Set  window width 900
	static final int WINDOW_HEIGHT = 400;												//Set window height 400
	
	private JTextField fTemp, kTemp, nTemp, converTemp;									//set JTextField variables
	private JSlider slider;																//set JSlider variable	
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, clear, quit;		//set JButtona variables
	protected double cel, fair, kelvin, newton, newtemp;								//set variables for input
	
	
	public TempConverter() 
	{	
		setLayout(new BorderLayout(10,10));
		
/*------North Panel-------------------------------------------------------------------------------------*/	
		//create JPanel p1
		JPanel p1 = new JPanel();
		//define  p1 as center GridLayout with 3 rows and 1 column 
		p1.setLayout(new GridLayout(3, 1, 0, 0));
		
		//create JPanel p1a to go inside p1
		JPanel p1a = new JPanel();
		//Set the text of the JLabel
		p1a.add(new JLabel(" Enter your temperature in the correct area on the left."));
		//Set the background to light gray
		p1a.setBackground(Color.LIGHT_GRAY);
		
		//create JPanel p1b to go inside p1
		JPanel p1b = new JPanel();
		//Set the text of the JLabel
		p1b.add(new JLabel(" Then click the conversion button of your choice in the center."));
		//Set the background to light gray
		p1b.setBackground(Color.LIGHT_GRAY);
		
		//create JPanel p1c to go inside p1
		JPanel p1c = new JPanel();
		//Set the text of the JLabel
		p1c.add(new JLabel(" The correctly converted tempurate will appear in the window on the right."));
		//Set the background to light gray
		p1c.setBackground(Color.LIGHT_GRAY);
		
		//add p1a to p1
		p1.add(p1a);
		//add p1b to p1
		p1.add(p1b);
		//add p1c to p1
		p1.add(p1c);
		
		//add p1 to north of BorderLayout
		add(p1, BorderLayout.NORTH);
		
/*------South Panel--------------------------------------------------------------------------------------*/		
		//create JPanel p2
		JPanel p2 = new JPanel();
		//define  p4 as center FlowLayout
		p2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
		p2.add(new JLabel(""));
		p2.setBackground(Color.LIGHT_GRAY);												//sets background to light gray
		//adds p2 to south BoraderLayout
		add(p2, BorderLayout.SOUTH);													

/*------East Panel---------------------------------------------------------------------------------------*/	
		//create JPanel p3
		JPanel p3 = new JPanel();
		//create JPanel p3a to go within p3
		JPanel p3a = new JPanel();
		//create JPanel p3b to go within p3a
		JPanel p3b = new JPanel();
		
		//define  p4 as center FlowLayout
		p3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		//define p3 and a GrindLayout with 4 rows 1 column
		p3a.setLayout(new GridLayout(4, 1, 0, 5));
		
		//Creates and adds JLabel to p3b
		p3b.add(new JLabel("Celsius Temperature"));
		//adds p3b to p3a
		p3a.add(p3b);
		
		//create new text field "converTemp" and add it to p3
		p3a.add(converTemp = new JTextField());											
		converTemp.setBackground(Color.BLACK);											//set background color to black
		converTemp.setForeground(Color.WHITE);											//set text color to white
		Font converter = new Font("verdana", Font.BOLD, 22);							//create new font class with size 22, font bold and style verdana
		converTemp.setFont(converter);													//set font for converTemp
		converTemp.setHorizontalAlignment(converTemp.CENTER);							//center test for converTemp
		converTemp.setPreferredSize(new Dimension(140, 40));							//set dimensions for converTemp
		
		//create JButton clear and ass it to p3
		p3a.add(clear = new JButton("CLEAR"));											
		//create JButton quit and add it to p3
		p3a.add(quit = new JButton("QUIT"));
		
		//add p3 to p4
		p3.add(p3a);
		//add p4 to east of BoarderLayout 
		add(p3, BorderLayout.EAST);
		
/*------West Panel---------------------------------------------------------------------------------------*/			
		//create JPanel p5
		JPanel p5 = new JPanel();
		//define  p5 as center GridLayout with 4 columns and 2 rows
		p5.setLayout(new GridLayout(4, 2, 0, 20));
		
		//add a JLable to the 1st row, 1st column.  "Celsius Temperature"
		p5.add(new JLabel("                    Celsius Temperature"));
		//add a JSlider to the 1st row, 2nd column
		p5.add(slider = new JSlider());
		slider.setMaximum(100);																//set max value to 100
		slider.setMinorTickSpacing(2);														//every spot has a tick mark
		slider.setPaintTicks(true);															//set the ticks to be visible
		slider.setPaintTrack(false);														//background for the slider set to invisible
		slider.setPaintLabels(true);														//make the number labels visible
		slider.setMajorTickSpacing(10); 													//add a number ever 10 spaces
		
		
		//add a JLavbel to the 2nd row, 1st column.  "Fehrenheit Temperature"
		p5.add(new JLabel("                 Fehrenheit Temperature"));
		//add a JTextField fTemp to the 2nd row, 2nd column
		p5.add(fTemp = new JTextField(5));
		
		//add a JLavbel to the 3rd row, 1st column.  "Kelvin Temperature"
		p5.add(new JLabel("                         Kelvin Temperature"));
		//add a JTextField  kTemp to the 3rd row, 2nd column
		p5.add(kTemp = new JTextField(5)); 
		
		//add a JLavbel to the 4th row, 1st column.  "Newton Temperature"
		p5.add(new JLabel("                      Newton Temperature"));
		//add a JTextField nTemp to the 4th row, 2nd column
		p5.add(nTemp = new JTextField(5));
		
		//add p5 to west of BoarderLayout 
		add(p5, BorderLayout.WEST);
		
/*------Center Panel-------------------------------------------------------------------------------------*/	
		//create JPanel p6
		JPanel p6 = new JPanel();
		//define  p5 as center GridLayout with 6 columns and 2 rows
		p6.setLayout(new GridLayout(6, 2, 10, 10));
		
		//add JButton b1 and add it to p6 1st row, 1st column
		p6.add(b1 = new JButton("Celsius to Fehrenheit"));
		b1.setBackground(Color.GREEN);															//set background color for b1 green
		//add JButton b2 and add it to p6 1st row, 2st column
		p6.add(b2 = new JButton("Fehrenheit to Celsius"));
		b2.setBackground(Color.RED);															//set background color for b2 red
		
		//add JButton b3 and add it to p6 2nd row, 1st column
		p6.add(b3 = new JButton("Kelvin to Celsius"));
		b3.setBackground(Color.BLUE);															//set background color for b3 blue
		b3.setForeground(Color.WHITE);															//set foreground color for b3 white
		//add JButton b4 and add it to p6 2nd row, 2nd column	
		p6.add(b4 = new JButton("Kelvin to Fehrenheit"));
		b4.setBackground(Color.YELLOW);															//set background color for b4 yellow
		
		//add JButton b5 and add it to p6 3rd row, 1st column
		p6.add(b5 = new JButton("Fehrenheit to Kelvin"));
		b5.setBackground(Color.ORANGE);															//set background color for b5 orange
		//add JButton b6 and add it to p6 3rd row, 2nd column
		p6.add(b6 = new JButton("Celsius to Kelvin"));
		b6.setBackground(Color.PINK);															//set background color for b6 pink
		b6.setForeground(Color.BLUE);															//set foreground color for b6 blue
		
		//add JButton b7 and add it to p6 4th row, 1st column
		p6.add(b7 = new JButton("Newton to Fehrenheit"));
		b7.setBackground(Color.MAGENTA);														//set background color for b7 magenta
		//add JButton b8 and add it to p6 4th row, 2nd column
		p6.add(b8 = new JButton("Newton to Celsius"));	
		b8.setBackground(Color.BLACK);															//set background color for b8 black
		b8.setForeground(Color.YELLOW);															//set foreground color for b8 yellow
			
		//add JButton b9 and add it to p6 5th row, 1st column
		p6.add(b9 = new JButton("Newton to Kelvin"));
		b9.setBackground(Color.CYAN);															//set background color for b9 cyan
		//add JButton b2 and add it to p6 5th row, 2nd column
		p6.add(b10 = new JButton("Fehrenheit to Newton"));
		b10.setBackground(Color.WHITE);															//set background color for b9 white
		
		//add JButton b11 and add it to p6 6th row, 1st column
		p6.add(b11 = new JButton("Celsius to Newton"));
		b11.setBackground(Color.GRAY);															//set background color for b10 gray
		b11.setForeground(Color.BLUE);															//set foreground color for b11 blue
		//add JButton b12 and add it to p6 6th row, 2nd column	
		p6.add(b12 = new JButton("Kelvin to Newton"));
		b12.setBackground(Color.MAGENTA);														//set background color for b12 magenta
		b12.setForeground(Color.WHITE);															//set foreground color for b12 white
		
		p6.setBackground(Color.LIGHT_GRAY);														//set background color for p6 light gray
		
		//add p6 to center of BoarderLayout 
		add(p6, BorderLayout.CENTER);
		
/*------ Celsius action listeners -------------------------------------------------------------------------------------*/		
		//-action listener for Celsius to Fehrenheit
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//get value of cel from slider
				cel = (slider.getValue());
				//calculate value for newtemp
				newtemp = (((cel * 9/5)+ 32)*100)/100;
				//set output for converTemp from newtemp
				converTemp.setText(Double.toString(newtemp));		
			}
		});
		
		//action listener for Celsius to Kelvin
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//get value of cel from slider
				cel = (slider.getValue());
				//calculate value for newtemp
				newtemp =((cel + 273.15)*100)/100;
				//set output for converTemp from newtemp
				converTemp.setText(Double.toString(newtemp));		
			}
		});
		
		//action listener for Celsius to Newton
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//get value of cel from slider
				cel = (slider.getValue());
				//calculate value for newtemp
				newtemp = ((cel * 33/100)*100)/100;
				//set output for converTemp from newtemp
				converTemp.setText(Double.toString(newtemp));
			}
		});
/*------ Fehrenheit action listeners -------------------------------------------------------------------------------------*/		
		
		// action listener for Fehrenheit to Celsius
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
				{
				//try catch to make sure value is a parseDouble, if not returns "ERROR"
				try{
					//set value for fair from fTemp
					fair = Double.parseDouble(fTemp.getText());
					//calculate value for newtemp
					newtemp = Math.floor(((fair - 32)*5/9)*100)/100;
					//set output for converTemp from newtemp
					converTemp.setText(Double.toString(newtemp));
					}
				catch (NumberFormatException ex) {
					converTemp.setText("ERROR");
					}
				}
		});
		
		//action listener for Fehrenheit to Kelvin	
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//try catch to make sure value is a parseDouble, if not returns "ERROR"
				try{
					//set value for fair from fTemp
					fair = Double.parseDouble(fTemp.getText());
					//calculate value for newtemp
					newtemp = Math.floor (((fair + 459.67)*5/9)*100)/100;
					//set output for converTemp from newtemp
					converTemp.setText(Double.toString(newtemp));
				}
				catch (NumberFormatException ex) {
					converTemp.setText("ERROR");
				}
			}
		});
		
		//action listener for Fehrenheit to Newton	
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//try catch to make sure value is a parseDouble, if not returns "ERROR"
				try{
					//set value for fair from fTemp
					fair = Double.parseDouble(fTemp.getText());
					//calculate value for newtemp
					newtemp = Math.floor(((fair - 32)*11/60)*100)/100;
					//set output for converTemp from newtemp
					converTemp.setText(Double.toString(newtemp));
					
				}
			catch (NumberFormatException ex) {
				converTemp.setText("ERROR");
				}
			}
		});
		
/*------ Kelvin action listeners -------------------------------------------------------------------------------------*/
		
		//action listener for Kelvin to Celsius	
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//try catch to make sure value is a parseDouble, if not returns "ERROR"
				try{
					//set value for fair from fTemp
					kelvin = Double.parseDouble(kTemp.getText());
					//calculate value for newtemp
					newtemp = Math.floor((kelvin - 273.15)*100)/100;
					//set output for converTemp from newtemp
					converTemp.setText(Double.toString(newtemp));
				}
			catch (NumberFormatException ex) {
				converTemp.setText("ERROR");
				}
			}
		});
		
		//action listener for Kelvin to Fehrenheit	
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//try catch to make sure value is a parseDouble, if not returns "ERROR"
				try{
					//set value for kevlin from kTemp
					kelvin = Double.parseDouble(kTemp.getText());
					//calculate value for newtemp
					newtemp = Math.floor(((kelvin * 9/5)-459.67)*100)/100;
					//set output for converTemp from newtemp
					converTemp.setText(Double.toString(newtemp));
				}
				catch (NumberFormatException ex) {
					converTemp.setText("ERROR");
				}
			}
		});
		
		//action listener for Kelvin to Newton	
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//try catch to make sure value is a parseDouble, if not returns "ERROR"
				try{
					//set value for kevlin from kTemp
					kelvin = Double.parseDouble(kTemp.getText());
					//calculate value for newtemp
					newtemp = Math.round(((kelvin - 273.15)*33/100)*100)/100;
					//set output for converTemp from newtemp
					converTemp.setText(Double.toString(newtemp));
					}
				catch (NumberFormatException ex) {
					converTemp.setText("ERROR");
				}
			}
		});
		
/*------ Newton action listeners -------------------------------------------------------------------------------------*/
		
		//action listener for Newton to Fehrenheit	
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//try catch to make sure value is a parseDouble, if not returns "ERROR"
				try{
					//set value for newton from nTemp
					newton = Double.parseDouble(nTemp.getText());
					//calculate value for newtemp
					newtemp = Math.floor(((newton * 60/11)+32)*100)/100;
					//set output for converTemp from newtemp
					converTemp.setText(Double.toString(newtemp));
					}
				catch (NumberFormatException ex) {
					converTemp.setText("ERROR");
				}
			}
		});
		
		//action listener for Newton to Celsius	
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//try catch to make sure value is a parseDouble, if not returns "ERROR"
				try{
					//set value for newton from nTemp
					newton = Double.parseDouble(nTemp.getText());
					//calculate value for newtemp
					newtemp = Math.floor( (newton * 100/32)*100)/100;
					//set output for converTemp from newtemp
					converTemp.setText(Double.toString(newtemp));
					}
				catch (NumberFormatException ex) {
					converTemp.setText("ERROR");
				}
			}
		});
		
		//action listener for Newton to Kelvin	
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//try catch to make sure value is a parseDouble, if not returns "ERROR"
				try{
					//set value for newton from nTemp
					newton = Double.parseDouble(nTemp.getText());
					//calculate value for newtemp
					newtemp = Math.floor(((newton * 100/33)+273.15)*100)/100;
					//set output for converTemp from newtemp
					converTemp.setText(Double.toString(newtemp));
					}
				catch (NumberFormatException ex) {
					converTemp.setText("ERROR");
				}
			}
		});
	
/*------action listener clear-------------------------------------------------------------------------------------*/	
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//sets JTextField fTemp to a blank string when clear button is clicked
				fTemp.setText("");
				//sets JTextField nTemp to a blank string clear button is clicked
				nTemp.setText("");
				//sets JTextField kTemp to a blank string clear button is clicked
				kTemp.setText("");
				//sets JTextField converTemp to a blank string clear button is clicked
				converTemp.setText("");
				
				slider.setValue(50);
			}
		});
		
/*------action listener quit-------------------------------------------------------------------------------------*/
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//exits out of instance when quit button is clicked 
				System.exit(0);
			}
		});
	}
	
	/*------main method-------------------------------------------------------------------------------------*/
	public static void main (String arg[]) 
	{	
		TempConverter frame = new TempConverter();												//creates new frame TempConverter
		frame.setTitle("Temperature Converter");												//sets the title of frame to "Temperature Converter"
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);												//sets the size of the frame
		frame.setLocationRelativeTo(null);														//sets where the frame is placed on screen	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);									//sets how the frame can be killed
		frame.setResizable(false);																//sets the frame to non-resizeable
		frame.setVisible(true);																	//sets to frame to visable

	}
}
