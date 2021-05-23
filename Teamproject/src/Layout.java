import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Layout extends JFrame implements Runnable{
	Yatch yatch;
	int dices[] = {1,1,1,1,1};
	int suit=0;
	DefaultTableModel model;
	Object data[][];

	JButton diceButton1;
	JButton diceButton2;
	JButton diceButton3;
	JButton diceButton4;
	JButton diceButton5;
	public Layout(Yatch yatch) {
		this.yatch = yatch; 
		// TODO Auto-generated constructor stub
	}
	
	public void Frame() {
		
		JPanel panel_left = new JPanel();
		panel_left.setLayout(null);
	
		
		JPanel panel_right = new JPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel_left,panel_right);
		panel_right.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_right.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton imojibtn1 = new JButton("New button");
		panel_1.add(imojibtn1);
		
		JButton imojibtn2 = new JButton("New button");
		panel_1.add(imojibtn2);
		
		JButton imojibtn3 = new JButton("New button");
		panel_1.add(imojibtn3);
		
		JButton imojibtn4 = new JButton("New button");
		panel_1.add(imojibtn4);
		
		JLabel lblNewLabel_5 = new JLabel("Choose Imoji");
		panel.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JButton btnNewButton_9 = new JButton("Send");
		panel.add(btnNewButton_9, BorderLayout.SOUTH);
		
		JPanel dicepanel = new JPanel();
		dicepanel.setLayout(new BorderLayout());
		
		int i = 0;
		String title[] = {"Suits","Player1","Player2"};
		Object data[][] = {{"One",yatch.table[0][i],yatch.table[1][i++]}
		,{"Two",yatch.table[0][i],yatch.table[1][i++]},{"Three",yatch.table[0][i],yatch.table[1][i++]}
		,{"Four",yatch.table[0][i],yatch.table[1][i++]},{"Five",yatch.table[0][i],yatch.table[1][i++]}
		,{"Six",yatch.table[0][i],yatch.table[1][i++]}
		,{"Bonus",yatch.table[0][12],yatch.table[1][12]},{"Choice",yatch.table[0][i],yatch.table[1][i++]}
		,{"FourOfkind",yatch.table[0][i],yatch.table[1][i++]},
		{"Small Straight",yatch.table[0][i],yatch.table[1][i++]},{"Large Straight",yatch.table[0][i],yatch.table[1][i++]}
		,{"Full House",yatch.table[0][i],yatch.table[1][i++]}
		,{"Yatch",yatch.table[0][i],yatch.table[1][i++]},{"Result",yatch.table[0][13],yatch.table[1][13]}};
		model = new DefaultTableModel(data,title);
		JPanel rowofdice = new JPanel();
		rowofdice.setLayout(new GridLayout(1, 5));
		diceButton1 = new JButton(Integer.toString(yatch.play.dieces[0]+1));
		diceButton1.setActionCommand("dic0");
		diceButton1.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton1,BorderLayout.CENTER);
		
		diceButton2 = new JButton(Integer.toString(yatch.play.dieces[1]+1));
		diceButton2.setActionCommand("dic1");
		diceButton2.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton2);
		
		diceButton3 = new JButton(Integer.toString(yatch.play.dieces[2]+1));
		diceButton3.setActionCommand("dic2");
		diceButton3.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton3);
		
		diceButton4 = new JButton(Integer.toString(yatch.play.dieces[3]+1));
		diceButton4.setActionCommand("dic3");
		diceButton4.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton4);
		
		diceButton5 = new JButton(Integer.toString(yatch.play.dieces[4]+1));
		diceButton5.setActionCommand("dic4");
		diceButton5.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton5);
		
		dicepanel.add(rowofdice);

		JPanel tablepanel = new JPanel();
		tablepanel.setLayout(new BorderLayout(0, 0));
		panel_left.setLayout(new BorderLayout(0, 0));
		JPanel imojipanel = new JPanel();
		imojipanel.setSize(199, 50);
		panel_left.add(imojipanel, BorderLayout.NORTH);
		imojipanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("ImoJi");
		imojipanel.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		imojipanel.add(lblNewLabel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		imojipanel.add(lblNewLabel_4, BorderLayout.EAST);
		panel_left.add(tablepanel);
		
		JLabel lblNewLabel_1 = new JLabel("Dice");
		dicepanel.add(lblNewLabel_1,BorderLayout.NORTH);
		JButton rollbtn = new JButton("Roll");
		rollbtn.setActionCommand("rol");
		rollbtn.addActionListener(new ButtonClickListener());
		dicepanel.add(rollbtn,BorderLayout.SOUTH);
		
		panel_right.add(dicepanel);
		
		JPanel panel_2 = new JPanel();
		panel_right.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Choose suit");
		panel_2.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(6, 2, 0, 0));
		
		JButton suitbtn1 = new JButton("One");
		suitbtn1.setActionCommand("sui0");
		suitbtn1.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn1);
		
		JButton suitbtn2 = new JButton("Two");
		suitbtn2.setActionCommand("sui1");
		suitbtn2.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn2);
		
		JButton suitbtn3 = new JButton("Three");
		suitbtn3.setActionCommand("sui2");
		suitbtn3.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn3);
		
		JButton suitbtn4 = new JButton("Four");
		suitbtn4.setActionCommand("sui3");
		suitbtn4.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn4);
		
		JButton suitbtn5 = new JButton("Five");
		suitbtn5.setActionCommand("sui4");
		suitbtn5.addActionListener(new ButtonClickListener());
		
		panel_3.add(suitbtn5);
		
		JButton suitbtn6 = new JButton("Six");
		suitbtn6.setActionCommand("sui5");
		suitbtn6.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn6);
		
		JButton suitbtn7 = new JButton("Choice");
		suitbtn7.setActionCommand("sui6");
		suitbtn7.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn7);
		
		JButton suitbtn8 = new JButton("Four of kind");
		suitbtn8.setActionCommand("sui7");
		suitbtn8.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn8);
		
		JButton suitbtn9 = new JButton("S. Straight");
		suitbtn9.setActionCommand("sui8");
		suitbtn9.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn9);
		
		JButton suitbtn10 = new JButton("Large Straight");
		suitbtn10.setActionCommand("sui9");
		suitbtn10.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn10);
		
		JButton suitbtn11 = new JButton("Full House");
		suitbtn11.setActionCommand("sui10");
		suitbtn11.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn11);
		
		JButton suitbtn12 = new JButton("Yatch");
		suitbtn12.setActionCommand("sui11");
		suitbtn12.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn12);
		
		JButton sendbtn = new JButton("Send");
		sendbtn.setActionCommand("det");
		sendbtn.addActionListener(new ButtonClickListener());
		panel_2.add(sendbtn, BorderLayout.SOUTH);
		JTable table = new JTable(model);
		tablepanel.add(table, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Table");
		tablepanel.add(lblNewLabel, BorderLayout.NORTH);
		
		splitPane.setDividerLocation(200);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		setSize(1000,500);
		setVisible(true);
		
	}
	public void updates() {
		diceButton1.setText(Integer.toString(yatch.play.dieces[0]+1));
		diceButton2.setText(Integer.toString(yatch.play.dieces[1]+1));
		diceButton3.setText(Integer.toString(yatch.play.dieces[2]+1));
		diceButton4.setText(Integer.toString(yatch.play.dieces[3]+1));
		diceButton5.setText(Integer.toString(yatch.play.dieces[4]+1));
		int i =0;
		for(int j =0; j<14;j++) {
			if(j==6) {
				model.setValueAt(yatch.table[0][12], j, 1);
				model.setValueAt(yatch.table[1][12], j, 2);
				continue;
			}
			if(j==13) {
				model.setValueAt(yatch.table[0][13], j, 1);
				model.setValueAt(yatch.table[1][13], j, 2);
				continue;
			}
			model.setValueAt(yatch.table[0][i], j, 1);
			model.setValueAt(yatch.table[1][i++], j, 2);
		}
	}
	@Override
	public void run() {
		
		yatch.rolldice(dices);
		// TODO Auto-generated method stub
		Frame();
		while (true) {
			//값을 읽어오는 쓰래드를 실행시키는
			updates();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	class ButtonClickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			String realcommand = command.substring(0, 3);
			if(realcommand.equals("dic")) {
				int a = Integer.parseInt(command.substring(3));
				if(dices[a] == 0) {
					dices[a] = 1;
				}else {
					dices[a] = 0;
				}
			}
			if(realcommand.equals("sui")) {
				int a = Integer.parseInt(command.substring(3));
				suit = a;
			}
			if(realcommand.equals("rol")) {
				yatch.rolldice(dices);
				
			}
			if(realcommand.equals("det")) {
				yatch.pressscore(0,suit);
			}
		}
	}
	
}
