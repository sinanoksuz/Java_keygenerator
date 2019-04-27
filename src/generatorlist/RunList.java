package generatorlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RunList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int row,col;
	String chserial;
	mysql ms;
	private JButton del;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunList frame = new RunList();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Warning", 2);
						}
			}
		});
	}

	
	public RunList() {
		setTitle("Key Generator");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 367);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(25, 25, 112));
		contentPane.setBackground(new Color(129, 255, 159));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JOptionPane.showMessageDialog(null, "I use sqlite\n it is created test.db on your computer", "Warning", 1);
		
		JButton list = new JButton("List");
		list.setFont(new Font("Tahoma", Font.PLAIN, 12));
		list.setBackground(new Color(0, 128, 128));
		list.setBounds(20, 293, 89, 28);
		contentPane.add(list);
		table = new JTable();
		table.setColumnSelectionAllowed(true);
	
		
		
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setForeground(Color.BLACK);
		table.setBounds(10, 32, 431, 250);
		
		contentPane.add(table);
		
		del = new JButton("Delete");
		
		del.setVisible(false);
		del.setFont(new Font("Tahoma", Font.PLAIN, 12));
		del.setBackground(new Color(0, 128, 128));
		del.setBounds(126, 293, 89, 28);
		contentPane.add(del);
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//List Button
				try {
					del.setVisible(true);
					ms=new mysql(table);
				    ms.Filltable();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getLocalizedMessage(), "Warning", 2);
				}
				
			}
			});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 row =table.rowAtPoint(e.getPoint());
				 col=table.columnAtPoint(e.getPoint());
				 try {
						
				 if(col==1&&row>0) {
						 chserial=JOptionPane.showInputDialog("Enter Serial");
						 ms.sqlupdate(table.getValueAt(row, 0).toString()
									, chserial);					
				 }
				 if(row==0&&col==1)
					 JOptionPane.showMessageDialog(null, "you can only change Serial", "WARNÝNG", 3);
				
				 if(row==0&&col==0)
					 JOptionPane.showMessageDialog(null, "you can only change Serial", "WARNÝNG", 3);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null,e1.getLocalizedMessage(), "WARNÝNG", 3);
						
					
				}
					
				
			}
		
		});
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mysql ms=new mysql(table);
				try {
					ms.delet(table.getValueAt(row, 0).toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null,e.getLocalizedMessage(), "WARNÝNG", 3);
						
				}
			}
		});
		
	
}
	}
