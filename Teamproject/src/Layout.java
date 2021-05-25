import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Layout extends JFrame implements Runnable{
	Yatch yatch;
	int dices[] = {1,1,1,1,1};
	int imoji=0;
	int suit=-1;
	int myinfo;
	DefaultTableModel model;
	Object data[][];
	JLabel nowturn;
	JLabel nowturnnum;
	JButton diceButton1;
	JButton diceButton2;
	JButton diceButton3;
	JButton diceButton4;
	JButton diceButton5;
	JButton imojibtn1;
	JButton imojibtn2;
	JButton imojibtn3;
	JButton imojibtn4;
	JButton suitbtn1;
	JButton suitbtn2;
	JButton suitbtn3;
	JButton suitbtn4;
	JButton suitbtn5;
	JButton suitbtn6;
	JButton suitbtn7;
	JButton suitbtn8;
	JButton suitbtn9;
	JButton suitbtn10;
	JButton suitbtn11;
	JButton suitbtn12;
	public Layout(Yatch yatch) {
		this.yatch = yatch; 
		// TODO Auto-generated constructor stub
	}
	
	public void Frame() {
		JPanel panel_left = new JPanel();
		JPanel panelturns = new JPanel();
		panelturns.setLayout(new BorderLayout(0,0));
		nowturn = new JLabel("Player 1's turn");
		panelturns.add(nowturn,BorderLayout.WEST);
		nowturnnum = new JLabel(Integer.toString(yatch.turn)+"/12");
		panelturns.add(nowturnnum,BorderLayout.EAST);
		JPanel panel_right = new JPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel_left,panel_right);
		panel_right.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_right.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 3, 0, 0));
		
		imojibtn1 = new JButton(imojIcon(1));
		imojibtn1.setActionCommand("imo1");
		imojibtn1.addActionListener(new ButtonClickListener());
		panel_1.add(imojibtn1);

		imojibtn2 = new JButton(imojIcon(2));
		imojibtn2.setActionCommand("imo2");
		imojibtn2.addActionListener(new ButtonClickListener());
		panel_1.add(imojibtn2);

		imojibtn3 = new JButton(imojIcon(3));
		imojibtn3.setActionCommand("imo3");
		imojibtn3.addActionListener(new ButtonClickListener());
		panel_1.add(imojibtn3);

		imojibtn4 = new JButton(imojIcon(4));
		imojibtn4.setActionCommand("imo4");
		imojibtn4.addActionListener(new ButtonClickListener());
		panel_1.add(imojibtn4);
		
		JLabel lblNewLabel_5 = new JLabel("Choose Imoji");
		panel.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JButton sendimobtn = new JButton("Send");
		sendimobtn.setActionCommand("smo");
		sendimobtn.addActionListener(new ButtonClickListener());
		panel.add(sendimobtn, BorderLayout.SOUTH);
		
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
		diceButton1 = new JButton(diceicon(yatch.play.dieces[0]));
		diceButton1.setActionCommand("dic0");
		diceButton1.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton1,BorderLayout.CENTER);

		
		diceButton2 = new JButton(diceicon(yatch.play.dieces[1]));
		diceButton2.setActionCommand("dic1");
		diceButton2.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton2);
		
		diceButton3 = new JButton(diceicon(yatch.play.dieces[2]));
		diceButton3.setActionCommand("dic2");
		diceButton3.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton3);
		
		diceButton4 = new JButton(diceicon(yatch.play.dieces[3]));
		diceButton4.setActionCommand("dic3");
		diceButton4.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton4);
		
		diceButton5 = new JButton(diceicon(yatch.play.dieces[4]));
		diceButton5.setActionCommand("dic4");
		diceButton5.addActionListener(new ButtonClickListener());
		rowofdice.add(diceButton5);
		
		dicepanel.add(rowofdice);

		JPanel tablepanel = new JPanel();
		tablepanel.setLayout(new BorderLayout(0, 0));
		panel_left.setLayout(new BorderLayout(0,0));
		JPanel imojipanel = new JPanel();
		imojipanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Emoji");
		imojipanel.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Player1");
		imojipanel.add(lblNewLabel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_4 = new JLabel("Player2");
		imojipanel.add(lblNewLabel_4, BorderLayout.EAST);
		JPanel emojibottomPanel = new JPanel();
		emojibottomPanel.setLayout(new BorderLayout(0,0));
		JLabel player1EmoLabel = new JLabel(imojIcon(0));
		JLabel player2EmoLabel = new JLabel(imojIcon(0));
		emojibottomPanel.add(player1EmoLabel,BorderLayout.WEST);
		emojibottomPanel.add(player2EmoLabel,BorderLayout.EAST);
		imojipanel.add(emojibottomPanel,BorderLayout.SOUTH);
		panel_left.add(imojipanel,BorderLayout.NORTH);
		JPanel dicepanel2 = new JPanel();
		dicepanel2.setLayout(new BorderLayout(0,0));
		
		JLabel lblNewLabel_1 = new JLabel("Dice");
		JLabel restofLabel = new JLabel("3 Times Left");
		dicepanel2.add(lblNewLabel_1,BorderLayout.WEST);
		dicepanel2.add(restofLabel,BorderLayout.EAST);
		dicepanel.add(dicepanel2,BorderLayout.NORTH);
		JButton rollbtn = new JButton("Roll");
		rollbtn.setActionCommand("rol");
		rollbtn.addActionListener(new ButtonClickListener());
		dicepanel.add(rollbtn,BorderLayout.SOUTH);
		
		panel_right.add(dicepanel);
		
		JPanel panel_2 = new JPanel();
		panel_right.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Choose Emoji");
		panel_2.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(6, 2, 0, 0));
		
		suitbtn1 = new JButton("One");
		suitbtn1.setActionCommand("sui0");
		suitbtn1.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn1);
		
		suitbtn2 = new JButton("Two");
		suitbtn2.setActionCommand("sui1");
		suitbtn2.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn2);
		
		suitbtn3 = new JButton("Three");
		suitbtn3.setActionCommand("sui2");
		suitbtn3.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn3);
		
		suitbtn4 = new JButton("Four");
		suitbtn4.setActionCommand("sui3");
		suitbtn4.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn4);
		
		suitbtn5 = new JButton("Five");
		suitbtn5.setActionCommand("sui4");
		suitbtn5.addActionListener(new ButtonClickListener());
		
		panel_3.add(suitbtn5);
		
		suitbtn6 = new JButton("Six");
		suitbtn6.setActionCommand("sui5");
		suitbtn6.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn6);
		
		suitbtn7 = new JButton("Choice");
		suitbtn7.setActionCommand("sui6");
		suitbtn7.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn7);
		
		suitbtn8 = new JButton("Four of kind");
		suitbtn8.setActionCommand("sui7");
		suitbtn8.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn8);
		
		suitbtn9 = new JButton("S. Straight");
		suitbtn9.setActionCommand("sui8");
		suitbtn9.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn9);
		
		suitbtn10 = new JButton("Large Straight");
		suitbtn10.setActionCommand("sui9");
		suitbtn10.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn10);
		
		suitbtn11 = new JButton("Full House");
		suitbtn11.setActionCommand("sui10");
		suitbtn11.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn11);
		
		suitbtn12 = new JButton("Yatch");
		suitbtn12.setActionCommand("sui11");
		suitbtn12.addActionListener(new ButtonClickListener());
		panel_3.add(suitbtn12);
		
		JButton sendbtn = new JButton("Send");
		sendbtn.setActionCommand("det");
		sendbtn.addActionListener(new ButtonClickListener());
		panel_2.add(sendbtn, BorderLayout.SOUTH);
		JTable table = new JTable(model);
		tablepanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Table");
		tablepanel.add(lblNewLabel, BorderLayout.NORTH);
		tablepanel.setSize(200, 200);
		panel_left.add(tablepanel,BorderLayout.CENTER);
		panel_left.add(panelturns,BorderLayout.SOUTH);
		splitPane.setDividerLocation(200);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public ImageIcon diceicon(int i) {
		ImageIcon img = new ImageIcon("img/dice"+Integer.toString(i+1)+".png");
		Image orignimg = img.getImage();
		Image chagedimg = orignimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(chagedimg);
		return icon;
	}
	public ImageIcon imojIcon(int i) {
		ImageIcon img = new ImageIcon("img/emoji"+Integer.toString(i)+".png");
		Image orignimg = img.getImage();
		Image chagedimg = orignimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(chagedimg);
		return icon;
	}
	public void updates() {
		if(dices[0]==0) {
			diceButton1.setBackground(Color.LIGHT_GRAY);
		} else {
			diceButton1.setBackground(Color.WHITE);
		}
		if(dices[1]==0) {
			diceButton2.setBackground(Color.LIGHT_GRAY);
		}else {
			diceButton2.setBackground(Color.WHITE);
		}
		if(dices[2]==0) {
			diceButton3.setBackground(Color.LIGHT_GRAY);
		}else {
			diceButton3.setBackground(Color.WHITE);
		}
		if(dices[3]==0) {
			diceButton4.setBackground(Color.LIGHT_GRAY);
		}else {
			diceButton4.setBackground(Color.WHITE);
		}
		if(dices[4]==0) {
			diceButton5.setBackground(Color.LIGHT_GRAY);
		}else {
			diceButton5.setBackground(Color.WHITE);
		}
		
		imojibtn1.setBackground(Color.WHITE);
		imojibtn2.setBackground(Color.WHITE);
		imojibtn3.setBackground(Color.WHITE);
		imojibtn4.setBackground(Color.WHITE);
		
		if(imoji ==1) {
			imojibtn1.setBackground(Color.LIGHT_GRAY);
		}else if(imoji == 2) {
			imojibtn2.setBackground(Color.LIGHT_GRAY);
		}else if(imoji == 3) {
			imojibtn3.setBackground(Color.LIGHT_GRAY);
		}else if(imoji == 4){
			imojibtn4.setBackground(Color.LIGHT_GRAY);
		}
		suitbtn1.setBackground(Color.WHITE);
		suitbtn2.setBackground(Color.WHITE);
		suitbtn3.setBackground(Color.WHITE);
		suitbtn4.setBackground(Color.WHITE);
		suitbtn5.setBackground(Color.WHITE);
		suitbtn6.setBackground(Color.WHITE);
		suitbtn7.setBackground(Color.WHITE);
		suitbtn8.setBackground(Color.WHITE);
		suitbtn9.setBackground(Color.WHITE);
		suitbtn10.setBackground(Color.WHITE);
		suitbtn11.setBackground(Color.WHITE);
		suitbtn12.setBackground(Color.WHITE);
		if(suit == 0) {
			suitbtn1.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 1) {
			suitbtn2.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 2) {
			suitbtn3.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 3) {
			suitbtn4.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 4) {
			suitbtn5.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 5) {
			suitbtn6.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 6) {
			suitbtn7.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 7) {
			suitbtn8.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 8) {
			suitbtn9.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 9) {
			suitbtn10.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 10) {
			suitbtn11.setBackground(Color.LIGHT_GRAY);
		}else if(suit == 11) {
			suitbtn12.setBackground(Color.LIGHT_GRAY);
		}
		diceButton1.setIcon(diceicon(yatch.play.dieces[0]));
		diceButton2.setIcon(diceicon(yatch.play.dieces[1]));
		diceButton3.setIcon(diceicon(yatch.play.dieces[2]));
		diceButton4.setIcon(diceicon(yatch.play.dieces[3]));
		diceButton5.setIcon(diceicon(yatch.play.dieces[4]));
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
			if(realcommand.equals("imo")) {
				int a = Integer.parseInt(command.substring(3));
				imoji = a;
			}
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
			if(realcommand.equals("sio")) {
				imoji = 0;
			}
			if(realcommand.equals("det")) {
				yatch.pressscore(0,suit);
				suit = -1;
			}
		}
	}
	
}
