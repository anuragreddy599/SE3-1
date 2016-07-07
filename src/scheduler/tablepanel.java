package scheduler;

import beans.Section;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
class tablepanel extends JPanel
{
	//private table[][][] ttable;
	DefaultTableModel model=new DefaultTableModel();
	JTable Table;
	int i;
//	public tablepanel(table[][][] t,int stgrp,inputdata input)
//	{
//		double[] time={8.0,9.0,10.0,11.0,1.0,2.0,3.0}; 
//    		String[] day={"Mon","Tue","Wed","Thurs","Fri"};
//		ttable=t;
//		int stno;
//		Table = new JTable(model){
//			public boolean isCellEditable(int rowIndex, int colIndex) {
//				return false;   //Disallow the editing of any cell
//			}
//		};
//		Table.setRowHeight(30);
//		Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		//JLabel label=new JLabel(input.stgrp[stno].code);
//		//add(label,BorderLayout.NORTH);
//		model.addColumn("    ");
//		for(i=1;i<=5;i++)
//		{
//			model.addColumn(day[i-1]);
//		}
//		//JScrollBar s=new JScrollBar(HORIZONTAL);
//		for(i=0;i<6;i++)
//		{
//			TableColumn column=Table.getColumnModel().getColumn(i);
//			column.setMinWidth(200);
//   			column.setPreferredWidth(100);
//   		}
//		for(stno=0;stno<stgrp;stno++)
//		{
//			model.addRow(new Object[]{input.stgrp[stno].code,"","","","",""});
//			model.addRow(new Object[]{"","","","","",""});
//			for(i=1;i<=7;i++)
//			{
//				double x=time[i-1]+1;
//				model.addRow(new Object[]{time[i-1]+"-"+x,ttable[stno][i-1][0].course+" "+ttable[stno][i-1][0].ins+" "+ttable[stno][i-1][0].room,ttable[stno][i-1][1].course+" "+ttable[stno][i-1][1].ins+" "+ttable[stno][i-1][1].room,ttable[stno][i-1][2].course+" "+ttable[stno][i-1][2].ins+" "+ttable[stno][i-1][2].room,ttable[stno][i-1][3].course+" "+ttable[stno][i-1][3].ins+" "+ttable[stno][i-1][3].room,ttable[stno][i-1][4].course+" "+ttable[stno][i-1][4].ins+" "+ttable[stno][i-1][4].room});
//				//model.addRow(new Object[]{"","","","","",""});
//			}
//			model.addRow(new Object[]{"","","","","",""});
//			model.addRow(new Object[]{"","","","","",""});
//		}
//		
//		JScrollPane scroll = new JScrollPane(Table);
//scroll.setHorizontalScrollBarPolicy( 
//   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
//scroll.setVerticalScrollBarPolicy( 
//   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.getViewport().setExtentSize(new Dimension(600,400));
//		//scroll.setHorizontalScrollBar(s);
//		add(scroll,BorderLayout.CENTER);
//	}
        
        public tablepanel(Section[] secArray){
            Table = new JTable();
		String[] header = new String[5];
		header[0] = "Course";
		header[1] = "Faculty";
		header[2] = "Days";
		header[3] = "Section";
                 header[4] = "Semester";
		
		String[][] obj = new String[secArray.length][5];
		for(int i=0;i<secArray.length;i++){
			obj[i][0] = (secArray[i].getCourse());
			obj[i][1] = (secArray[i].getFaculty());
			obj[i][2] = (secArray[i].getDays());
                        obj[i][3] = (secArray[i].getSectionNumber());
                         obj[i][4] = (secArray[i].getSemester());
			//obj[i][3] = Integer.toString(numberOfStudents.get(secArray[i].getCourse()));
		}
		
		Table.setModel(new DefaultTableModel(obj,header));
	
//                //double[] time={8.0,9.0,10.0,11.0,1.0,2.0,3.0}; 
//    		String[] day={"Course","Faculty","Days"};
//		ttable=t;
//		int stno;
//		Table = new JTable(model){
//			public boolean isCellEditable(int rowIndex, int colIndex) {
//				return false;   //Disallow the editing of any cell
//			}
//		};
//		Table.setRowHeight(30);
//		Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		//JLabel label=new JLabel(input.stgrp[stno].code);
//		//add(label,BorderLayout.NORTH);
//		model.addColumn("    ");
//		for(i=1;i<=5;i++)
//		{
//			model.addColumn(day[i-1]);
//		}
//		//JScrollBar s=new JScrollBar(HORIZONTAL);
//		for(i=0;i<6;i++)
//		{
//			TableColumn column=Table.getColumnModel().getColumn(i);
//			column.setMinWidth(200);
//   			column.setPreferredWidth(100);
//   		}
//		for(stno=0;stno<stgrp;stno++)
//		{
//			model.addRow(new Object[]{input.stgrp[stno].code,"","","","",""});
//			model.addRow(new Object[]{"","","","","",""});
//			for(i=1;i<=7;i++)
//			{
//				double x=time[i-1]+1;
//				model.addRow(new Object[]{time[i-1]+"-"+x,ttable[stno][i-1][0].course+" "+ttable[stno][i-1][0].ins+" "+ttable[stno][i-1][0].room,ttable[stno][i-1][1].course+" "+ttable[stno][i-1][1].ins+" "+ttable[stno][i-1][1].room,ttable[stno][i-1][2].course+" "+ttable[stno][i-1][2].ins+" "+ttable[stno][i-1][2].room,ttable[stno][i-1][3].course+" "+ttable[stno][i-1][3].ins+" "+ttable[stno][i-1][3].room,ttable[stno][i-1][4].course+" "+ttable[stno][i-1][4].ins+" "+ttable[stno][i-1][4].room});
//				//model.addRow(new Object[]{"","","","","",""});
//			}
//			model.addRow(new Object[]{"","","","","",""});
//			model.addRow(new Object[]{"","","","","",""});
//		}
		
		JScrollPane scroll = new JScrollPane(Table);
                scroll.setForeground(Color.GRAY);
		scroll.setBackground(Color.GRAY);
		scroll.setAutoscrolls(true);
		scroll.setToolTipText("");
		scroll.setRowHeaderView(Table);
		//scroll.setLayout(gl_contentPane);
		scroll.setViewportView(Table);;
                
                
scroll.setHorizontalScrollBarPolicy( 
   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
scroll.setVerticalScrollBarPolicy( 
   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.getViewport().setExtentSize(new Dimension(600,400));
		//scroll.setHorizontalScrollBar(s);
		add(scroll,BorderLayout.CENTER);
        }
}

