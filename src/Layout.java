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
import javax.swing.JOptionPane;
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
	Yacht yatch;
	int userid; // Player를 나눌거임.
	int myinfo; // ??
	Userinfo userinfo;
	String action; // actionstring 이거는 layout에서 쓸거.
	DefaultTableModel model;
	Object data[][];
	JLabel nowturn; // 실시간으로 바뀌어야할것들.
	JLabel nowturnnum;
	JButton diceButton1;
	JButton diceButton2;
	JButton diceButton3;
	JButton diceButton4;
	JButton diceButton5;
	JButton emojibtn1;
	JButton emojibtn2;
	JButton emojibtn3;
	JButton emojibtn4;
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
	JLabel restofLabel;
	JLabel player1EmoLabel;
	JLabel player2EmoLabel;
	public Layout(Yacht yatch,int userid, Userinfo userinfo) {
		this.yatch = yatch; 
		this.userid = userid;
		this.userinfo = userinfo;
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
		
		emojibtn1 = new JButton(emojIcon(1));
		emojibtn1.setActionCommand("emo1");
		emojibtn1.addActionListener(new ButtonClickListener(this));
		panel_1.add(emojibtn1);

		emojibtn2 = new JButton(emojIcon(2));
		emojibtn2.setActionCommand("emo2");
		emojibtn2.addActionListener(new ButtonClickListener(this));
		panel_1.add(emojibtn2);

		emojibtn3 = new JButton(emojIcon(3));
		emojibtn3.setActionCommand("emo3");
		emojibtn3.addActionListener(new ButtonClickListener(this));
		panel_1.add(emojibtn3);

		emojibtn4 = new JButton(emojIcon(4));
		emojibtn4.setActionCommand("emo4");
		emojibtn4.addActionListener(new ButtonClickListener(this));
		panel_1.add(emojibtn4);
		
		JLabel lblNewLabel_5 = new JLabel("Choose Emoji");
		panel.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JButton sendemobtn = new JButton("Send");
		sendemobtn.setActionCommand("sem");
		sendemobtn.addActionListener(new ButtonClickListener(this));
		panel.add(sendemobtn, BorderLayout.SOUTH);
		
		JPanel dicepanel = new JPanel();
		dicepanel.setLayout(new BorderLayout());
		
		int i = 0;
		String title[] = {"Suits","Player1","Player2"};
		Object data[][] = {{"One",yatch.table[0][i],yatch.table[1][i++]}
		,{"Two",yatch.table[0][i],yatch.table[1][i++]},{"Three",yatch.table[0][i],yatch.table[1][i++]}
		,{"Four",yatch.table[0][i],yatch.table[1][i++]},{"Five",yatch.table[0][i],yatch.table[1][i++]}
		,{"Six",yatch.table[0][i],yatch.table[1][i++]},{
			"SubTotal",yatch.table[0][14],yatch.table[1][14]
		}
		,{"Bonus",yatch.table[0][12],yatch.table[1][12]},{"Choice",yatch.table[0][i],yatch.table[1][i++]}
		,{"4 of a Kind",yatch.table[0][i],yatch.table[1][i++]},
		{"S. Straight",yatch.table[0][i],yatch.table[1][i++]},{"L. Straight",yatch.table[0][i],yatch.table[1][i++]}
		,{"Full House",yatch.table[0][i],yatch.table[1][i++]}
		,{"Yatch",yatch.table[0][i],yatch.table[1][i++]},{"Result",yatch.table[0][13],yatch.table[1][13]}};
		model = new DefaultTableModel(data,title);
		JPanel rowofdice = new JPanel();
		rowofdice.setLayout(new GridLayout(1, 5));
		diceButton1 = new JButton(diceicon(yatch.play.dieces[0]));
		diceButton1.setActionCommand("dic0");
		diceButton1.addActionListener(new ButtonClickListener(this));
		rowofdice.add(diceButton1,BorderLayout.CENTER);

		
		diceButton2 = new JButton(diceicon(yatch.play.dieces[1]));
		diceButton2.setActionCommand("dic1");
		diceButton2.addActionListener(new ButtonClickListener(this));
		rowofdice.add(diceButton2);
		
		diceButton3 = new JButton(diceicon(yatch.play.dieces[2]));
		diceButton3.setActionCommand("dic2");
		diceButton3.addActionListener(new ButtonClickListener(this));
		rowofdice.add(diceButton3);
		
		diceButton4 = new JButton(diceicon(yatch.play.dieces[3]));
		diceButton4.setActionCommand("dic3");
		diceButton4.addActionListener(new ButtonClickListener(this));
		rowofdice.add(diceButton4);
		
		diceButton5 = new JButton(diceicon(yatch.play.dieces[4]));
		diceButton5.setActionCommand("dic4");
		diceButton5.addActionListener(new ButtonClickListener(this));
		rowofdice.add(diceButton5);
		
		dicepanel.add(rowofdice);

		JPanel tablepanel = new JPanel();
		tablepanel.setLayout(new BorderLayout(0, 0));
		panel_left.setLayout(new BorderLayout(0,0));
		JPanel emojipanel = new JPanel();
		emojipanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Emoji");
		emojipanel.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Player1");
		emojipanel.add(lblNewLabel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_4 = new JLabel("Player2");
		emojipanel.add(lblNewLabel_4, BorderLayout.EAST);
		JPanel emojibottomPanel = new JPanel();
		emojibottomPanel.setLayout(new BorderLayout(0,0));
		player1EmoLabel = new JLabel(emojIcon(0));
		player2EmoLabel = new JLabel(emojIcon(0));
		emojibottomPanel.add(player1EmoLabel,BorderLayout.WEST);
		emojibottomPanel.add(player2EmoLabel,BorderLayout.EAST);
		emojipanel.add(emojibottomPanel,BorderLayout.SOUTH);
		panel_left.add(emojipanel,BorderLayout.NORTH);
		JPanel dicepanel2 = new JPanel();
		dicepanel2.setLayout(new BorderLayout(0,0));
		
		JLabel lblNewLabel_1 = new JLabel("Dice");
		JLabel Yourname =new JLabel("You are Player"+Integer.toString(userid));
		Yourname.setHorizontalAlignment(JLabel.CENTER);
		
		restofLabel = new JLabel("3 Times Left");
		panelturns.add(Yourname,BorderLayout.NORTH);
		dicepanel2.add(lblNewLabel_1,BorderLayout.WEST);
		dicepanel2.add(restofLabel,BorderLayout.EAST);
		dicepanel.add(dicepanel2,BorderLayout.NORTH);
		JButton rollbtn = new JButton("Roll");
		rollbtn.setActionCommand("rol");
		rollbtn.addActionListener(new ButtonClickListener(this));
		dicepanel.add(rollbtn,BorderLayout.SOUTH);
		
		panel_right.add(dicepanel);
		
		JPanel panel_2 = new JPanel();
		panel_right.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Choose suits");
		panel_2.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(6, 2, 0, 0));
		
		suitbtn1 = new JButton("One");
		suitbtn1.setActionCommand("sui0");
		suitbtn1.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn1);
		
		suitbtn2 = new JButton("Two");
		suitbtn2.setActionCommand("sui1");
		suitbtn2.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn2);
		
		suitbtn3 = new JButton("Three");
		suitbtn3.setActionCommand("sui2");
		suitbtn3.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn3);
		
		suitbtn4 = new JButton("Four");
		suitbtn4.setActionCommand("sui3");
		suitbtn4.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn4);
		
		suitbtn5 = new JButton("Five");
		suitbtn5.setActionCommand("sui4");
		suitbtn5.addActionListener(new ButtonClickListener(this));
		
		panel_3.add(suitbtn5);
		
		suitbtn6 = new JButton("Six");
		suitbtn6.setActionCommand("sui5");
		suitbtn6.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn6);
		
		suitbtn7 = new JButton("Choice");
		suitbtn7.setActionCommand("sui6");
		suitbtn7.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn7);
		
		suitbtn8 = new JButton("Four of a kind");
		suitbtn8.setActionCommand("sui7");
		suitbtn8.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn8);
		
		suitbtn9 = new JButton("Small Straight");
		suitbtn9.setActionCommand("sui8");
		suitbtn9.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn9);
		
		suitbtn10 = new JButton("Large Straight");
		suitbtn10.setActionCommand("sui9");
		suitbtn10.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn10);
		
		suitbtn11 = new JButton("Full House");
		suitbtn11.setActionCommand("sui10");
		suitbtn11.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn11);
		
		suitbtn12 = new JButton("Yatch");
		suitbtn12.setActionCommand("sui11");
		suitbtn12.addActionListener(new ButtonClickListener(this));
		panel_3.add(suitbtn12);
		
		JButton sendbtn = new JButton("Send");
		sendbtn.setActionCommand("det");
		sendbtn.addActionListener(new ButtonClickListener(this));
		panel_2.add(sendbtn, BorderLayout.SOUTH);
		JTable table = new JTable(model);
		tablepanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Table");
		tablepanel.add(lblNewLabel, BorderLayout.NORTH);
		tablepanel.setSize(200, 300);
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
	public ImageIcon emojIcon(int i) {
		ImageIcon img = new ImageIcon("img/emoji"+Integer.toString(i)+".png");
		Image orignimg = img.getImage();
		Image chagedimg = orignimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(chagedimg);
		return icon;
	}
	public void updates() {
		player1EmoLabel.setIcon(emojIcon(yatch.emoji[0]));
		player2EmoLabel.setIcon(emojIcon(yatch.emoji[1]));
		player1EmoLabel.setBackground(Color.WHITE);
		player2EmoLabel.setBackground(Color.WHITE);
		restofLabel.setText(Integer.toString(yatch.rollchance)+" turns left");
		nowturn.setText("Player "+Integer.toString(2-(yatch.turn)%2)+"'s turn");
		nowturnnum.setText(Integer.toString((yatch.turn+1)/2)+"/12");
		if(userinfo.dices[0]==0) {
			diceButton1.setBackground(Color.LIGHT_GRAY);
		} else {
			diceButton1.setBackground(Color.WHITE);
		}
		if(userinfo.dices[1]==0) {
			diceButton2.setBackground(Color.LIGHT_GRAY);
		}else {
			diceButton2.setBackground(Color.WHITE);
		}
		if(userinfo.dices[2]==0) {
			diceButton3.setBackground(Color.LIGHT_GRAY);
		}else {
			diceButton3.setBackground(Color.WHITE);
		}
		if(userinfo.dices[3]==0) {
			diceButton4.setBackground(Color.LIGHT_GRAY);
		}else {
			diceButton4.setBackground(Color.WHITE);
		}
		if(userinfo.dices[4]==0) {
			diceButton5.setBackground(Color.LIGHT_GRAY);
		}else {
			diceButton5.setBackground(Color.WHITE);
		}
		
		emojibtn1.setBackground(Color.WHITE);
		emojibtn2.setBackground(Color.WHITE);
		emojibtn3.setBackground(Color.WHITE);
		emojibtn4.setBackground(Color.WHITE);
		
		if(userinfo.emoji ==1) {
			emojibtn1.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.emoji == 2) {
			emojibtn2.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.emoji == 3) {
			emojibtn3.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.emoji == 4){
			emojibtn4.setBackground(Color.LIGHT_GRAY);
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
		if(userinfo.suit == 0) {
			suitbtn1.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 1) {
			suitbtn2.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 2) {
			suitbtn3.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 3) {
			suitbtn4.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 4) {
			suitbtn5.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 5) {
			suitbtn6.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 6) {
			suitbtn7.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 7) {
			suitbtn8.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 8) {
			suitbtn9.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 9) {
			suitbtn10.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 10) {
			suitbtn11.setBackground(Color.LIGHT_GRAY);
		}else if(userinfo.suit == 11) {
			suitbtn12.setBackground(Color.LIGHT_GRAY);
		}
		diceButton1.setIcon(diceicon(yatch.play.dieces[0]));
		diceButton2.setIcon(diceicon(yatch.play.dieces[1]));
		diceButton3.setIcon(diceicon(yatch.play.dieces[2]));
		diceButton4.setIcon(diceicon(yatch.play.dieces[3]));
		diceButton5.setIcon(diceicon(yatch.play.dieces[4]));
		int i =0;
		for(int j =0; j<15;j++) {
			if(j==6) {
				model.setValueAt(Integer.toString((yatch.table[0][14]))+"/63", j, 1);
				model.setValueAt(Integer.toString((yatch.table[1][14]))+"/63", j, 2);
				continue;
			}
			if(j==7) {
				model.setValueAt(retval(yatch.table[0][12]), j, 1);
				model.setValueAt(retval(yatch.table[1][12]), j, 2);
				continue;
			
			}
			if(j==14) {
				model.setValueAt(retval(yatch.table[0][13]), j, 1);
				model.setValueAt(retval(yatch.table[1][13]), j, 2);
				continue;
			}
			model.setValueAt(retval(yatch.table[0][i]), j, 1);
			model.setValueAt(retval(yatch.table[1][i++]), j, 2);
		}
	}
	public Object retval(int i) {
		if(i==-1) {
			return null;
		}else {
			return i;
		}
	}
	public String Winner(int winner, int youare) {
		if(winner == 0) {
			return "Draw";
		}
		else if(winner == youare) {
			return "You win";
		}else {
			return "You Lose";
			}
	}
	@Override
	public void run() {
		if(yatch.numofman != 2) {
			JOptionPane.showMessageDialog(null, "Wait for people...");
		}
		while(true) {
			if(yatch.numofman == 2) {
				Frame(); // 한번밖에 실행이안됨
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		} // 두명이 뜰때까지 기다리는 과정임
		// TODO Auto-generated method stub
		while (true) {
			updates();
			if(yatch.turn==25) {
				JOptionPane.showMessageDialog(this, Winner(yatch.winner(),userid));
				System.exit(0);
			}
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	class ButtonClickListener implements ActionListener{
		JFrame jframe;
		public ButtonClickListener(JFrame jFrame) {
			this.jframe = jFrame;
			// TODO Auto-generated constructor stub
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			String realcommand = command.substring(0, 3);
			if(realcommand.equals("emo")) {
				int a = Integer.parseInt(command.substring(3));
				userinfo.emoji = a;
			}else if(realcommand.equals("sem")){
				userinfo.actionString = command;
			
			}else if(userid == (2- yatch.turn%2)) { // 버튼씹는거
				if(realcommand.equals("dic")) {
					if(yatch.rollchance ==3) {
						JOptionPane.showMessageDialog(jframe, "First roll must roll all dice");
					}else {
						int a = Integer.parseInt(command.substring(3));
						if(userinfo.dices[a] == 0) {
							userinfo.dices[a] = 1;
						}else {
							userinfo.dices[a] = 0;
						}
					}
				}else if(realcommand.equals("sui")) {
					int a = Integer.parseInt(command.substring(3));
					userinfo.suit = a;
					
				}else{
					if((realcommand.equals("rol")&&yatch.rollchance<=0)) {
						JOptionPane.showMessageDialog(jframe, "You're Already fully rolled");
						
					}else if(realcommand.equals("det")&&yatch.rollchance==3) {
						JOptionPane.showMessageDialog(jframe, "You are not rolled");
					}
					else if(realcommand.equals("det")&&userinfo.tablefilled[userinfo.suit] == 1) {
						JOptionPane.showMessageDialog(jframe, "Already Filled");
					}else {
					userinfo.actionString = command; // 이게 지정되면 clientsend가 일을하는거라서 마지막에 진짜 결정됬을때 실행된다.
					}
				}
			}
		}
	}
	
}
