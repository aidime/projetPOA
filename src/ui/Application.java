package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import players.*;
import core.*;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Application {

	private JFrame frmRpgmanager;

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
