package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class ManagerFrame extends JFrame implements ActionListener
{
	private JLabel manIdLabel, manNameLabel, manDesignationLabel, manAmountLabel;
	private JTextField manIdTF, manNameTF, manDesignationTF, manTotalAmountTF;
	private JButton loadBtn, logoutBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable manTable;
	private JScrollPane manTableSP;
	
	private User user;
	private ManagerRepo er;
	private UserRepo ur;
	
	
	public ManagerFrame(User user)
	{
		super("ManagerFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new ManagerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Id", "Name", "Designation", "TotalAmount"};
		
		manTable = new JTable(data,head);
		manTableSP = new JScrollPane(manTable);
		manTableSP.setBounds(350, 100, 400, 150);
		manTable.setEnabled(false);
		panel.add(manTableSP);
		
		manIdLabel = new JLabel("ID :");
		manIdLabel.setBounds(100,100,100,30);
		panel.add(manIdLabel);
		
		manIdTF = new JTextField();
		manIdTF.setBounds(220,100,100,30);
		panel.add(manIdTF);
		
		manNameLabel = new JLabel("Name :");
		manNameLabel.setBounds(100,150,100,30);
		panel.add(manNameLabel);
		
		manNameTF = new JTextField();
		manNameTF.setBounds(220,150,100,30);
		panel.add(manNameTF);
		
		manDesignationLabel = new JLabel("Designation: ");
		manDesignationLabel.setBounds(100,200,100,30);
		panel.add(manDesignationLabel);
		
		manDesignationTF = new JTextField();
		manDesignationTF.setBounds(220,200,100,30);
		panel.add(manDesignationTF);
		
		manAmountLabel = new JLabel("TotalAmount: ");
		manAmountLabel.setBounds(100,250,100,30);
		panel.add(manAmountLabel);
		
		manTotalAmountTF = new JTextField();
		manTotalAmountTF.setBounds(220,250,100,30);
		panel.add(manTotalAmountTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 300, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
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
			if(!manIdTF.getText().equals("") || !manIdTF.getText().equals(null))
			{
				Manager e = er.searchMember(manIdTF.getText());
				if(e!= null)
				{
					manNameTF.setText(e.getName());
					manDesignationTF.setText(e.getDesignation());
					manTotalAmountTF.setText(e.getTotalAmount()+"");
					
					manIdTF.setEnabled(false);
					manNameTF.setEnabled(true);
					manDesignationTF.setEnabled(true);
					manTotalAmountTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Manager e = new Manager();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			e.setManId(manIdTF.getText());
			e.setName(manNameTF.getText());
			e.setDesignation(manDesignationTF.getText());
			e.setTotalAmount(Double.parseDouble(manTotalAmountTF.getText()));
			
			u.setUserId(manIdTF.getText());
			u.setPassword(x+"");
			
			if(((manDesignationTF.getText()).equals("Manager")) || ((manDesignationTF.getText()).equals("manager")))
			{
				u.setStatus(0);
			}
			else
			{
				u.setStatus(1);
			}
			
			er.insertInDB(e);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+manIdTF.getText()+"and Password: "+x);
			
			manIdTF.setText("");
			manNameTF.setText("");
			manDesignationTF.setText("");
			manTotalAmountTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			manIdTF.setText("");
			manNameTF.setText("");
			manDesignationTF.setText("");
			manTotalAmountTF.setText("");
			
			manIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Manager e = new Manager();
			
			e.setManId(manIdTF.getText());
			e.setName(manNameTF.getText());
			e.setDesignation(manDesignationTF.getText());
			e.setTotalAmount(Double.parseDouble(manTotalAmountTF.getText()));
			
			er.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			manIdTF.setText("");
			manNameTF.setText("");
			manDesignationTF.setText("");
			manTotalAmountTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			manIdTF.setEnabled(true);
			manNameTF.setEnabled(true);
			manDesignationTF.setEnabled(true);
			manTotalAmountTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			er.deleteFromDB(manIdTF.getText());
			ur.deleteUser(manIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			manIdTF.setText("");
			manNameTF.setText("");
			manDesignationTF.setText("");
			manTotalAmountTF.setText("");
			
			manIdTF.setEnabled(true);
			manNameTF.setEnabled(true);
			manDesignationTF.setEnabled(true);
			manTotalAmountTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = er.getAllMember();
			String head[] = {"Id", "Name", "Designation", "TotalAmount"};
			
			panel.remove(manTableSP);
			
			manTable = new JTable(data,head);
			manTable.setEnabled(false);
			manTableSP = new JScrollPane(manTable);
			manTableSP.setBounds(350, 100, 400, 150);
			panel.add(manTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			MemberHome mh = new MemberHome(user);
			mh.setVisible(true);
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