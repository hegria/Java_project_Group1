import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
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

public class Layout extends JFrame {
	private JTable table;
	public Layout() {

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
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_1.add(btnNewButton_8);
		
		JLabel lblNewLabel_5 = new JLabel("Choose Imoji");
		panel.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JButton btnNewButton_9 = new JButton("Send");
		panel.add(btnNewButton_9, BorderLayout.SOUTH);
		
		JPanel dicepanel = new JPanel();
		dicepanel.setLayout(new BorderLayout());
		
		String title[] = {"Suits","Player1","Player2"};
		Object data[][] = {{"One","",""},{"Two","",""},{"Three","",""},{"Four","",""},{"Five","",""},{"Six","",""}
		,{"Bonus","",""},{"Choice","",""},{"FourOfkind","",""},{"FullHouse","",""},{"Small Straight","",""},{"Large Straight","",""}
		,{"Yatch","",""}};
		DefaultTableModel model = new DefaultTableModel(data,title);
		JPanel rowofdice = new JPanel();
		rowofdice.setLayout(new GridLayout(1, 5));
		JButton btnNewButton = new JButton("New button");
		rowofdice.add(btnNewButton,BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("New button");
		rowofdice.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		rowofdice.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		rowofdice.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		rowofdice.add(btnNewButton_4);
		
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
		JButton btnApply = new JButton("Roll");
		dicepanel.add(btnApply,BorderLayout.SOUTH);
		
		panel_right.add(dicepanel);
		
		JPanel panel_2 = new JPanel();
		panel_right.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Choose suit");
		panel_2.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(6, 2, 0, 0));
		
		JButton btnNewButton_10 = new JButton("One");
		panel_3.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Two");
		panel_3.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Three");
		panel_3.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Four");
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Five");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Six");
		panel_3.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("Choice");
		panel_3.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("Four of kind");
		panel_3.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("Small Straight");
		panel_3.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("Large Straight");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("Full House");
		panel_3.add(btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("Yatch");
		panel_3.add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("Send");
		panel_2.add(btnNewButton_22, BorderLayout.SOUTH);
		JTable table = new JTable(model);
		tablepanel.add(table, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Table");
		tablepanel.add(lblNewLabel, BorderLayout.NORTH);
		
		splitPane.setDividerLocation(200);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		
		
	}
}
