package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class AllMemberFrame extends JFrame implements ActionListener
{
	private JLabel memIdLabel, memMonthLabel,memMealLabel;
	private JTextField memIdTF, memMonthTF,memMealTF;
	private JButton loadBtn, insertBtn, logoutBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable empTable;
	private JScrollPane empTableSP;
	
	private User user;
	private AllMembersRepo er;
	private UserRepo ur;
	
	
	public AllMemberFrame(User user)
	{
		super("AllMemberFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new AllMembersRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", ""}};
		
		String head[] = {"Id", "Month", "TotalMeal"};
		
		empTable = new JTable(data,head);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(350, 100, 400, 150);
		empTable.setEnabled(false);
		panel.add(empTableSP);
		
		memIdLabel = new JLabel("ID :");
		memIdLabel.setBounds(100,100,100,30);
		panel.add(memIdLabel);
		
		memIdTF = new JTextField();
		memIdTF.setBounds(220,100,100,30);
		panel.add(memIdTF);
		
		memMonthLabel = new JLabel("Month :");
		memMonthLabel.setBounds(100,150,100,30);
		panel.add(memMonthLabel);
		
		memMonthTF = new JTextField();
		memMonthTF.setBounds(220,150,100,30);
		panel.add(memMonthTF);
		
		memMealLabel = new JLabel("TotalMeal: ");
		memMealLabel.setBounds(100,200,100,30);
		panel.add(memMealLabel);
		
		memMealTF = new JTextField();
		memMealTF.setBounds(220,200,100,30);
		panel.add(memMealTF);
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(200,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		/*insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);*/
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(400,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,300,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 300, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!memIdTF.getText().equals("") || !memIdTF.getText().equals(null))
			{
				AllMembers e = er.searchMember(memIdTF.getText());
				if(e!= null)
				{
					memMonthTF.setText(e.getMonth());
					memMealTF.setText(e.getTotalMeal()+"");
					
					memIdTF.setEnabled(false);
					memMonthTF.setEnabled(true);
					memMealTF.setEnabled(true);
					
					
					updateBtn.setEnabled(true);
					//deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					//insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			memIdTF.setText("");
			memMonthTF.setText("");
			memMealTF.setText("");
			
			memIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(true);
		}
		else if(command.equals(updateBtn.getText()))
		{
			AllMembers e = new AllMembers();
			
			e.setMemId(memIdTF.getText());
			e.setMonth(memMonthTF.getText());
			e.setTotalMeal(Double.parseDouble(memMealTF.getText()));
			
			er.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			memIdTF.setText("");
			memMonthTF.setText("");
			memMealTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(true);
			
			memIdTF.setEnabled(true);
			memMonthTF.setEnabled(true);
			memMealTF.setEnabled(true);
		
		}
		
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = er.getAllMembers();
			String head[] = {"Id", "Month", "TotalMeal"};
			
			panel.remove(empTableSP);
			
			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableSP = new JScrollPane(empTable);
			empTableSP.setBounds(350, 100, 400, 150);
			panel.add(empTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			MemberHome eh = new MemberHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}