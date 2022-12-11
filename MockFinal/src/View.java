import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton adult;
	private JRadioButton concession;
	private JRadioButton cashFare;
	private JRadioButton contactlessPayment;
	private JRadioButton storedValue;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton checkFare;
	private JButton reset;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JList to;
	private JList from;
	public static Model[] trainsInformation = new Model[57];
	public static  double fareAmount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	
	public void createLayout()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	}
	
	public void consumeData()
	{
		
		Controller control  = new Controller();
		trainsInformation = control.dBDemo();
		control.closedB();
	}
	
	
	public void insertData()
	{
		
		DefaultListModel<String> model1 = new DefaultListModel();
	    String[] trainList = new String[57];
	    
	    for(int i=0;i<trainList.length;i++)
	    {
	    	trainList[i] = trainsInformation[i].getName()+"("+trainsInformation[i].getLine()+")";
	        
	    }

	
	    for(String s : trainList)
	    {
	    	model1.addElement(s);
	    }
	   
	    from.setModel(model1);
	    
	    to.setModel(model1);
	
	}
	
	
	
	public void createObjects()
	{


		scrollPane = new JScrollPane();
		scrollPane_1 = new JScrollPane();
		
		lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cashFare = new JRadioButton("Cash Fare");
		
		buttonGroup_1.add(cashFare);
		
		contactlessPayment = new JRadioButton("Contactless Payment Fare");
		
		buttonGroup_1.add(contactlessPayment);
		
		storedValue = new JRadioButton("Stored Value");
		
		buttonGroup_1.add(storedValue);
		
		adult = new JRadioButton("Adult");
		buttonGroup.add(adult);
		
		concession = new JRadioButton("Concession");
		buttonGroup.add(concession);
		
		checkFare = new JButton("Check Fare");
		
		
		reset = new JButton("Reset");
		
		 to = new JList();
		
		
	     from = new JList();
		
	}
	
	
	
	
	
	public void createEvent()
	{
		
		checkFare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(from.isSelectionEmpty() || to.isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null,"Please select From/To stations");
				}	
				else
					if(!cashFare.isSelected() && !contactlessPayment.isSelected() && !storedValue.isSelected())
					{
						JOptionPane.showMessageDialog(null,"Please choose Payment option");
					}
					else
						if(!adult.isSelected() && !concession.isSelected())
						{
							JOptionPane.showMessageDialog(null,"Please choose Fare type");
						}
				
				int fromIndex = from.getSelectedIndex();
				int toIndex = to.getSelectedIndex();
				double addonFare = 0;
				
				
				int checkIndex;
				double fare;
				int zone;
				String fareType = "";
				boolean isZeroFair = false;
				if(fromIndex>toIndex)
				{
					checkIndex = fromIndex;
				}
				else {
					checkIndex = toIndex;
					
				}
				
				zone = trainsInformation[checkIndex].zone;
				
				if(trainsInformation[fromIndex].getLine().equals(Line.Canada.toString()))
				{
					
					if(trainsInformation[fromIndex].getName().equals("Templeton") ||
							trainsInformation[fromIndex].getName().equals("Sea Island Centre")	||
							trainsInformation[fromIndex].getName().equals("YVR-Airport"))
					{
					  addonFare = 5.0;
						
					}
					
					if(trainsInformation[toIndex].getLine().equals(Line.Canada.toString()))
					{
						if(trainsInformation[toIndex].getName().equals("Templeton") ||
								trainsInformation[toIndex].getName().equals("Sea Island Centre")	||
								trainsInformation[toIndex].getName().equals("YVR-Airport"))
						{
						  addonFare = 0.0;
						  isZeroFair = true;
							
						}	
						
						
					}
					
					
					
				}
				
				
				
				if(cashFare.isSelected())
				{
					concession.setEnabled(true);
					switch(zone)
					{
					case 1: 
						   if(adult.isSelected())
						   {
							   fareAmount = 3.05;
						   }
						   else if(concession.isSelected())
						   {
							   fareAmount = 2;
						   }
						
						   break;
					case 2:  if(adult.isSelected())
					   {
						fareAmount = 4.35;
					   }
					   else if(concession.isSelected())
					   {
						   fareAmount = 3;
					   }
						
						
						break;
					case 3:   if(adult.isSelected())
					   {
						fareAmount= 5.90;
					   }
					   else if(concession.isSelected())
					   {
						   fareAmount= 4.05;
					   }
						
						break;
					
					
					}
					fareType = "CASH";
				}
				else if(contactlessPayment.isSelected())
				{
				
					concession.setEnabled(false);
					switch(zone)
					{
					case 1: 
						   if(adult.isSelected())
			fareAmount = fareAmount + addonFare;				   {
							   fareAmount = 3.05;
						   }
						 
						
						   break;
					case 2:  if(adult.isSelected())
					   {
						fareAmount = 4.35;
					   }
					 
						
						
						break;
					case 3:   if(adult.isSelected())
					   {
						fareAmount= 5.90;
					   }
					   
						break;
					
					
					}
					fareType = "CONTACTLESS PAYMENT";
				}
				else if(storedValue.isSelected())
				{ concession.setEnabled(true);
					switch(zone)
					{
					case 1: 
						   if(adult.isSelected())
						   {
							   fareAmount = 2.45;
						   }
						   else if(concession.isSelected())
						   {
							   fareAmount = 2;
						   }
						
						   break;
					case 2:  if(adult.isSelected())
					   {
						fareAmount = 3.55;
					   }
					   else if(concession.isSelected())
					   {
						   fareAmount = 3;
					   }
						
						
						break;
					case 3:   if(adult.isSelected())
					   {
						fareAmount= 4.60;
					   }
					   else if(concession.isSelected())
					   {
						   fareAmount= 4.05;
					   }
						
						break;
					
					
					}
					fareType = "STORED VALUE";
					
				}
				
				if(isZeroFair)
				{
					fareAmount = 0;
				}
				else {
					fareAmount = fareAmount + addonFare;			
				}
		
				
				JOptionPane.showMessageDialog(null,"The "+adult.getText()+" fare ( by "+fareType+")"+"\n"
				  +"from "+trainsInformation[fromIndex].getName()+"\nto "+trainsInformation[toIndex].getName()+"\nis $"+fareAmount
				  +" ("+trainsInformation[checkIndex].getZone()+"-Zone)");
				
				
				  
				
				
			}
		});
		
		contactlessPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				concession.setEnabled(false);
			}
		});
		
		storedValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   concession.setEnabled(true);
			}
		});
		
		cashFare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concession.setEnabled(true);
			}
		});
	}
	
	
	public void groupLayout()
	{
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(adult)
							.addGap(32)
							.addComponent(concession)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(cashFare)
								.addGap(53)
								.addComponent(contactlessPayment)
								.addGap(39)
								.addComponent(storedValue)
								.addGap(134))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addGap(121)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(28, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
										.addGap(134)))))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(91)
					.addComponent(checkFare)
					.addGap(110)
					.addComponent(reset)
					.addContainerGap(221, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cashFare)
						.addComponent(contactlessPayment)
						.addComponent(storedValue))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(adult)
						.addComponent(concession))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(checkFare)
						.addComponent(reset))
					.addContainerGap())
		);
		
		
		scrollPane_1.setViewportView(to);
		scrollPane.setViewportView(from);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
	/**
	 * Create the frame.
	 */
	public View() {
		
		createLayout();
		createObjects();
		consumeData();
		insertData();
		createEvent();
		groupLayout();
		
	}
}
