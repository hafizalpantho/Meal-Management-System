package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class BazarFrame extends JFrame implements ActionListener
{
	private JLabel bzDateLabel, bzIdLabel,bzNameLabel,bzAmountLabel;
	private JTextField bzDateTF, bzIdTF,bzNameTF,bzAmountTF;
	private JButton loadBtn, logoutBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable empTable;
	private JScrollPane empTableSP;
	
	private User user;
	private BazarRepo er;
	private UserRepo ur;
	
	
	public BazarFrame(User user)
	{
		super("BazarFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new BazarRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Date", "Name", "Id", "AmountOfBazar"};
		
		empTable = new JTable(data,head);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(350, 100, 400, 150);
		empTable.setEnabled(false);
		panel.add(empTableSP);
		
		bzDateLabel = new JLabel("Date :");
		bzDateLabel.setBounds(100,100,100,30);
		panel.add(bzDateLabel);
		
		bzDateTF = new JTextField();
		bzDateTF.setBounds(220,100,100,30);
		panel.add(bzDateTF);
		
		bzNameLabel = new JLabel("Name :");
		bzNameLabel.setBounds(100,150,100,30);
		panel.add(bzNameLabel);
		
		bzNameTF = new JTextField();
		bzNameTF.setBounds(220,150,100,30);
		panel.add(bzNameTF);
		
		bzIdLabel = new JLabel("Id : ");
		bzIdLabel.setBounds(100,200,100,30);
		panel.add(bzIdLabel);
		
		bzIdTF = new JTextField();
		bzIdTF.setBounds(220,200,100,30);
		panel.add(bzIdTF);
		
		bzAmountLabel = new JLabel("AmountOfBazar: ");
		bzAmountLabel.setBounds(100,250,100,30);
		panel.add(bzAmountLabel);
		
		bzAmountTF = new JTextField();
		bzAmountTF.setBounds(220,250,100,30);
		panel.add(bzAmountTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(200,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
				
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(400,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(true);
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
			if(!bzDateTF.getText().equals("") || !bzDateTF.getText().equals(null))
			{
				Bazar e = er.searchBazar(bzDateTF.getText());
				if(e!= null)
				{
					bzNameTF.setText(e.getbName());
					bzIdTF.setText(e.getbId());
					bzAmountTF.setText(e.getAmount()+"");
					
					bzDateTF.setEnabled(false);
					bzNameTF.setEnabled(true);
					bzIdTF.setEnabled(true);
					bzAmountTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Data");
				}
			}
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			bzDateTF.setText("");
			bzNameTF.setText("");
			bzIdTF.setText("");
			bzAmountTF.setText("");
			
			bzDateTF.setEnabled(true);
			loadBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			refreshBtn.setEnabled(true);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Bazar e = new Bazar();
			
			e.setDate(bzDateTF.getText());
			e.setbName(bzNameTF.getText());
			e.setbId(bzIdTF.getText());
			e.setAmount(Double.parseDouble(bzAmountTF.getText()));
			
			er.updateBazar(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			bzDateTF.setText("");
			bzNameTF.setText("");
			bzIdTF.setText("");
			bzAmountTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			bzDateTF.setEnabled(true);
			bzNameTF.setEnabled(true);
			bzIdTF.setEnabled(true);
			bzAmountTF.setEnabled(true);
		}
	
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = er.getAllBazar();
			String head[] = {"Date", "Name", "Id", "AmountOfBazar"};
			
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