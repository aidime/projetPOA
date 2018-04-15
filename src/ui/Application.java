package ui;

import core.*;
import players.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Application {

	private JFrame frmRpgmanager;
	private JTextField txtLogEntries;
	private JTextField txtNumber;
	private JTextField txtFaces;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frmRpgmanager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRpgmanager = new JFrame();
		frmRpgmanager.setBackground(Color.BLACK);
		frmRpgmanager.setResizable(false);
		frmRpgmanager.setTitle("RPGManager");
		frmRpgmanager.setBounds(100, 100, 752, 620);
		frmRpgmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmRpgmanager.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setToolTipText("Campaign");
		tabbedPane.addTab("Campaign", null, panel, null);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("New Campaign");
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New Campaign");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New Campaign");
		panel.add(btnNewButton_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		tabbedPane.addTab("Game", null, panel_4, null);
		panel_4.setLayout(new MigLayout("", "[grow]", "[grow][][][][][][][][][][][][][][][grow][][][]"));
		
		JList list = new JList();
		list.setToolTipText("eventList");
		panel_4.add(list, "cell 0 0 1 3,grow");
		
		JLabel lblRollTheDices = new JLabel("Roll the dices");
		panel_4.add(lblRollTheDices, "cell 0 9,alignx right");
		
		txtNumber = new JTextField();
		txtNumber.setToolTipText("Number of dices to roll");
		txtNumber.setText("Number");
		panel_4.add(txtNumber, "cell 0 10,alignx right");
		txtNumber.setColumns(10);
		
		txtFaces = new JTextField();
		txtFaces.setToolTipText("Number of faces of the dices");
		txtFaces.setText("Faces");
		panel_4.add(txtFaces, "cell 0 11,alignx right");
		txtFaces.setColumns(10);
		
		JButton btnRoll = new JButton("Roll!");
//		btnRoll.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				int n;
//				int f;
//				try{
//					n = (int)txtNumber.getText();
//					f = (int)txtFaces.getText();
//				} catch {
//					
//				}
//				}
//			}
//		});
		panel_4.add(btnRoll, "cell 0 12,alignx right");
		
		JTextArea txtrLogs = new JTextArea();
		txtrLogs.setText("Logs");
		panel_4.add(txtrLogs, "cell 0 13 1 5,grow");
		
		txtLogEntries = new JTextField();
		txtLogEntries.setText("Log entries");
		panel_4.add(txtLogEntries, "cell 0 18,growx");
		txtLogEntries.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setToolTipText("Events");
		tabbedPane.addTab("Events", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setToolTipText("Logs");
		tabbedPane.addTab("Logs", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setToolTipText("Players");
		tabbedPane.addTab("Players", null, panel_3, null);
	}

}
