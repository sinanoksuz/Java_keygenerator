package assginmentpackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Dialog.ModalExclusionType;

public class Run extends JFrame {
//  I  use   sqlite 
	
	private JPanel contentPane;
	private JTextField textField;
	String Macadress;
	private JTextField Col_text;
	private JTextField Col2_text;
	int i,j;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Run frame = new Run();
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
	public Run() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Key Generator");
		JOptionPane.showMessageDialog(null, "I use sqlite\n it is created test.db on your computer", "Warning", 1);
		setBounds(100, 100, 298, 175);
		//Butons and textfields ,Labels settings
		contentPane = new JPanel();
		contentPane.setForeground(new Color(25, 25, 112));
		contentPane.setBackground(new Color(129, 255, 159));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Key Generator");
		lblNewLabel.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 11, 223, 37);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(30, 59, 223, 28);
		contentPane.add(textField);
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBackground(new Color(0, 128, 128));
		textField.setColumns(10);
		JButton btnNewButton = new JButton("Save Key");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(164, 93, 89, 28);
		contentPane.add(btnNewButton);
		btnGenerate.setBounds(30, 93, 89, 28);
		contentPane.add(btnGenerate);
		textField.getText();
	    contentPane.add(lblNewLabel);
		Col_text = new JTextField();
		Col_text.setText("5");
		Col_text.setHorizontalAlignment(SwingConstants.CENTER);
		Col_text.setBounds(224, 11, 29, 20);
		contentPane.add(Col_text);
		Col_text.setColumns(10);
		Col2_text = new JTextField();
		Col2_text.setText("5");
		Col2_text.setHorizontalAlignment(SwingConstants.CENTER);
		Col2_text.setColumns(10);
		Col2_text.setBounds(224, 38, 29, 20);
		contentPane.add(Col2_text);
		//settings finish
		
		//button save click
		Mac_adress ma=new Mac_adress();
		try {
			Macadress=ma.MacAdress().toString();
			//macadress is called from mac_adress class extends hardwareadresses
			
		} catch (Exception e1) {
			//Excheption e1 catch that Throw exception
			
			JOptionPane.showMessageDialog(null, "Error Mac_adress is null", "Warning", 2);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					
				
				try {
					
						mysql ms=new mysql();
					if(textField.getText()!=null&&btnGenerate.isVisible())
						//sql connect includes Insert Into macadress and serial
					ms.sqlconnec(Macadress, textField.getText());
					
				 
				if (btnGenerate.isVisible()==false) {
					JOptionPane.showMessageDialog(null, "you can click only one ", "Warning", 2);
				}}
				catch (Exception e) {
					String err=e.getLocalizedMessage();
					int val=err.indexOf("UNIQUE");
					if (val>0) {
						JOptionPane.showMessageDialog(null, "Error Mac_adress is same\n"+Macadress, "Warning", 2);
						 btnGenerate.setVisible(false);
					}
					
				 }
			
			
				}
		});
		//btn generate click
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s="";
				try {
					i=Integer.parseInt(Col_text.getText());
					j=Integer.parseInt(Col2_text.getText());
					Random_generator rd=new Random_generator(Macadress, i, j);
					ArrayList <String> arraylist=new ArrayList<>();
					arraylist=rd.generatorwithmac(rd.generator());
					//gelen arrayý burada ayýrarak aralara - koyup texte yazdýrýyorum
					//ý am putting arraylist that come to Random_generator class
					//then it is defined arraylist because of return object
					
					int size=rd.generatorwithmac(rd.generator()).size();

					for (int k =0; k < size; k++) {
						
						if (k%j==0&&k!=0) {
							s+="-";
						}s+=arraylist.get(k);
					}
				textField.setText(s);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please Enter Only Digits ", "Warning", 2);
				}
				
				
			}
		});
		
		
	}
}
