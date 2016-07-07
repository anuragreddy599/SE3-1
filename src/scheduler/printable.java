package scheduler;
import beans.Course;
import beans.Degree;
import beans.DegreePlanReqs;
import beans.Faculty;
import beans.Section;
import beans.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.*;
import java.util.HashMap;
import schedule.mainpage;
class printtable extends JFrame
{
	//private table[][][] ttable;
	JFrame tableframe;
	int stgrp;
	int i;
	tablepanel panel;
	JPanel south;
	//inputdata input;
        
        String[] args;
        Course[] crsArr;
        Faculty[] facArr;
        Student[] studArr;
	Degree[] degArr; 
        DegreePlanReqs[] degPlanArr; 
        String minFillPercent; 
	HashMap<String, Integer> facultyLoad;
        String maxOverage; String semester;
	Section[] secArray; HashMap<String, Integer> numberOfStudents; int[] bestGene;
        
        
//	public printtable(table[][][] t,int nostgrp,inputdata input1)
//	{
//		ttable=t;
//		tableframe=new JFrame();
//		stgrp=nostgrp;
//		south=new JPanel();
//		input=input1;
//	}
        public printtable(String[] args, Course[] crsArr, Faculty[] facArr, Student[] studArr, 
			Degree[] degArr, DegreePlanReqs[] degPlanArr, String minFillPercent, 
			HashMap<String, Integer> facultyLoad, String maxOverage, String semester,
			Section[] secArray, HashMap<String, Integer> numberOfStudents, int[] bestGene){
            tableframe=new JFrame();
            south=new JPanel();
            
            this.crsArr=crsArr;
            this.facArr=facArr;
            this.studArr=studArr;
            this.degArr=degArr;
            this.degPlanArr=degPlanArr;
            this.minFillPercent=minFillPercent;
            this.facultyLoad=facultyLoad;
            this.maxOverage=maxOverage;
            this.semester=semester;
             this.secArray=secArray;
            this.numberOfStudents=numberOfStudents;
            this.bestGene=bestGene;
        }
        
        
	void print()
	{
//		EventQueue.invokeLater(new Runnable()
//		{
//			public void run()
//			{
//				tableframe.setTitle("CLASS SCHEDULING");
//				tableframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				tableframe.setSize(800,600);
//				tableframe.setLayout(new GridBagLayout());
//				GridBagConstraints c=new GridBagConstraints();
//				c.weightx=0;
//				c.gridx=0;
//				c.gridy=0;
//				c.fill=GridBagConstraints.HORIZONTAL;
//				int j;
//				JButton next=new JButton("EXIT");
//				panel=new tablepanel(ttable,stgrp,input);
//				JPanel south=new JPanel();
//				south.setLayout(new GridLayout(1,10));
//				for(j=0;j<10;j++)
//					south.add(new JLabel(" "));
//				south.add(next);
//				tableframe.add(panel);
//				c.gridx=0;
//				c.gridy=100;
//				tableframe.add(south,c);
//				tableframe.setVisible(true);
//				next.addActionListener(new ActionListener()
//				{
//					public void actionPerformed(ActionEvent e)
//					{
//                                            
//                                            mainpage x=new mainpage();
//                                                //getContentPane().getParent().getParent().getParent().setVisible(false);
//       
//                                                x.main(null);
//					}
//				});
//			}
//		});	
	}
        void printData()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				tableframe.setTitle("CLASS SCHEDULING");
				tableframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				tableframe.setSize(800,600);
				tableframe.setLayout(new GridBagLayout());
				GridBagConstraints c=new GridBagConstraints();
				c.weightx=0;
				c.gridx=0;
				c.gridy=0;
				c.fill=GridBagConstraints.HORIZONTAL;
				int j;
				JButton next=new JButton("EXIT");
                                JButton testScheduleBtn=new JButton("Test Schedule");
				panel=new tablepanel(secArray);
				JPanel south=new JPanel();
				south.setLayout(new GridLayout(1,10));
                                south.add(testScheduleBtn);
				for(j=0;j<2;j++)
					south.add(new JLabel(" "));
				south.add(next);
                               // south.add(testScheduleBtn);
				tableframe.add(panel);
				c.gridx=0;
				c.gridy=100;
				tableframe.add(south,c);
				tableframe.setVisible(true);
				next.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						btnCloseActionPerformed(e);
//                                            mainpage x=new mainpage();
//                                                getContentPane().getParent().getParent().getParent().setVisible(false);
//       
//                                                x.main(null);
					}
				});
                                
                                testScheduleBtn.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						testSchedule(e);
                                            //btnCloseActionPerformed(e);
//                                            TestSchedule x=new TestSchedule();
//                                                getContentPane().getParent().getParent().getParent().setVisible(false);
//       
//                                                x.main(null);
					}
				});
                                
			}
		});	
	}
        private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {  
            mainpage x=new mainpage();

           tableframe.setVisible(false);
            dispose();
       
    } 
         private void testSchedule(java.awt.event.ActionEvent evt) {  
            new TestSchedule(args, bestGene, secArray, studArr, degPlanArr, degArr, minFillPercent, maxOverage, 
						crsArr, facArr, facultyLoad, semester, numberOfStudents).setVisible(true);

           tableframe.setVisible(false);
            //dispose();
       
    } 
}