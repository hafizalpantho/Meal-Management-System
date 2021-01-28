package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class MemberHome extends JFrame implements ActionListener
{
	JButton logoutBtn, manageEmpBtn, allMemberBtn, bazarBtn;
	JPanel panel;
	
	User user;
	
	public MemberHome(User user)
	{
		super("Welcome Member Home");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 100, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		manageEmpBtn = new JButton("Manager");
		manageEmpBtn.setBounds(50, 100, 150, 30);
		manageEmpBtn.addActionListener(this);
		panel.add(manageEmpBtn);
		
		allMemberBtn = new JButton("All Member");
		allMemberBtn.setBounds(225, 100, 150, 30);
		allMemberBtn.addActionListener(this);
		panel.add(allMemberBtn);
		
		
		bazarBtn = new JButton("Bazar");
		bazarBtn.setBounds(400, 100, 150, 30);
		bazarBtn.addActionListener(this);
		panel.add(bazarBtn);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(manageEmpBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				ManagerFrame mf = new ManagerFrame(user);
				mf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(allMemberBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1)
			{
				AllMemberFrame am = new AllMemberFrame(user);
				am.setVisible(true);
				this.setVisible(false);
				
			}
			else{}
		}
		else if(command.equals(bazarBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1)
			{
				BazarFrame bf = new BazarFrame(user);
				bf.setVisible(true);
				this.setVisible(false);
			}
			else{}
		}
		else{}
	}
}