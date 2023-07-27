package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataBase.Medicen;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class MainPanel 
{
    public static MainPanel singleInstance;
    public static MainPanel getInstance()
    {
    	if(singleInstance==null)
    	{
    		singleInstance = new MainPanel();
    	}	
    	return singleInstance;
    }
   
    JComboBox comboBox;
    JTable table;
    public JPanel panel;
    public MainPanel()
    {
    	panel = new JPanel();
    	panel.setBounds(0, 0, 450, 720);
    	panel.setLayout(null);
    
    	panel.setBackground(Color.GRAY);
    	
    	JLabel lblNewLabel = new JLabel("DISEASE");
    	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
    	lblNewLabel.setBounds(10, 391, 109, 34);
    	lblNewLabel.setForeground(new Color(139, 69, 19));
    	panel.add(lblNewLabel);
    	
    	String disease[] = {"Cold","Cough","Painkiller","Diabetes","Blood pressure"};
	    comboBox = new JComboBox(disease);
	    comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    comboBox.setForeground(new Color(139, 69, 19));
	    comboBox.setBackground(Color.WHITE);
    	comboBox.setBounds(145, 396, 127, 24);
       	panel.add(comboBox);
       	table  = new JTable();
       	Object[] column = {"Medicine"};
       	
       	table.setBackground(Color.WHITE);
       	table.setAutoCreateRowSorter(true);
       
       	JScrollPane pane = new JScrollPane(table);
       	pane.setBounds(21, 53, 402, 309);
       	panel.add(pane);
       	
       	JButton btnNewButton = new JButton("SEARCH");
       	btnNewButton.setForeground(new Color(139, 69, 19));
       	btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
       	btnNewButton.setBounds(303, 396, 127, 24);
       	btnNewButton.setFocusable(false);
       	btnNewButton.setBackground(Color.WHITE);
       	btnNewButton.setBorder(null);
       	btnNewButton.addActionListener(new ActionListener()
        {
			public void actionPerformed(ActionEvent e) {
		      
				table.setModel(DbUtils.resultSetToTableModel(Medicen.getInstance().fetch_Data(comboBox.getSelectedItem().toString())));
			}	
       	});
       	panel.add(btnNewButton);
    	panel.setVisible(true);
    }
    public JPanel getPanel()
    {
    	return panel;
    }
}
