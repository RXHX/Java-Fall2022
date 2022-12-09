import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private  JList courseList;
	private  JComboBox nameCombo;
	private  JComboBox gradeCombo;
	private  JLabel nameSubject;
	private  JButton btnNewButton;
	private Model[] students = new Model[10];

	/**
	 * Launch the application.
	 */
	
	
	
	
	
	
	
	
	public   void createEvent()
	{
		
   
		nameCombo.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int idx = nameCombo.getSelectedIndex();
	    		DefaultListModel<String> studCourse = new DefaultListModel();
	    		
	    		String[] subjectName = new String[10];
	    		
	    		if(idx == 0)
	    		{
	    			for(String c : subjectName)
			    		studCourse.addElement(c);
	    			 courseList.setModel(studCourse);
	    			  nameSubject.setText("");
	    			 
	    		}
	    		else {
	    			switch(idx)
		    		{
		    		case 1: 
		    			     subjectName[0] = students[0].getcCode()+"-"+students[0].getcTitle();
		    		         subjectName[1] = students[1].getcCode()+"-"+students[1].getcTitle();
		    		         subjectName[2] = students[2].getcCode()+"-"+students[2].getcTitle();   
		    		         break;
		    		case 2:  subjectName[0] = students[3].getcCode()+"-"+students[3].getcTitle();
		    		         subjectName[1] = students[4].getcCode()+"-"+students[4].getcTitle();
		    		         break;
		    		case 3:  subjectName[0] = students[5].getcCode()+"-"+students[5].getcTitle();
		    		         break;
		    		
		    		}
	    		
		    		
		    		for(String c : subjectName)
		    		studCourse.addElement(c);
		    		
		      	    courseList.setModel(studCourse);
		      
	    		}
	    	
	    	}
	    });
		
		courseList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultComboBoxModel model2 = new DefaultComboBoxModel(Grades.values());
				 
		               if(nameCombo.getSelectedIndex() == 0)
		               {
		            	   nameSubject.setText("");
		               }
		               else {
		            	   nameSubject.setText((String)courseList.getSelectedValue());	
		            	   gradeCombo.removeAll();
		            	  int indx = nameCombo.getSelectedIndex();
		            	  int indxVal = courseList.getSelectedIndex();
		            	  if(indx == 0)
		            	  {
		            		  model2.addElement(Grades.NA);
		            		 
		            	  }
		            	  else if(indx == 1)
		            	  {
		            		  
		            		  switch(indxVal)
		            		  {
		            		  case 0: model2.addElement(Grades.C); break;
		            		  case 1: model2.addElement(Grades.B); break;
		            		  case 2:  model2.addElement(Grades.NA);break;
		            		  default: break;
		            		  
		            		  }
		            		  
		            		  
		            	  }else if(indx == 2)
		            	  {
		            		  switch(indxVal)
		            		  {
		            		  case 0: model2.addElement(Grades.A); break;
		            		  case 1:  model2.addElement(Grades.A);break;
		            		 
		            		  default: break;
		            		  }
		            		  
		            		  
		            	  }else if(indx == 3)
		            	  {
		            		  switch(indxVal)
		            		  {
		            		  case 0: model2.addElement(Grades.F); break;
		            		  default: break;
		            		  
		            		  }
		            		  
		            	  }
		            	   
		            	  gradeCombo.setModel(model2);
		               }	
			}
		});
		
	  
	
		
	}
	
	public void getModel()
	{
		  Controller control = new Controller();
		  students = control.dBDemo();
		  String[] studNameAndRollNumber = {"",students[0].getsName()+"("+students[0].getsID()+")",students[3].getsName()+"("+students[3].getsID()+")",students[5].getsName()+"("+students[5].getsID()+")"};
  		DefaultComboBoxModel studName = new DefaultComboBoxModel(studNameAndRollNumber);
  	    nameCombo.setModel(studName);
  	  DefaultComboBoxModel model1 = new DefaultComboBoxModel(Grades.values());
		gradeCombo.setModel(model1);
	}
	

	public void layoutDesign()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
	    nameCombo = new JComboBox(); 
	    nameSubject = new JLabel("");	
		courseList = new JList();
		
		
		courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gradeCombo = new JComboBox();	
		
		btnNewButton = new JButton("Save");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(nameCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(courseList, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(91))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(485, Short.MAX_VALUE)
					.addComponent(gradeCombo, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(284, Short.MAX_VALUE)
					.addComponent(nameSubject, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(nameCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(nameSubject)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(gradeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(courseList, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addGap(114))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	
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

	/**
	 * Create the frame.
	 */
	public View() {
		layoutDesign();
	     getModel();
	     createEvent();	
	}
}
