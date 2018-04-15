package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;

import core.DiceRolls;
import core.Event;

public class Application {

	private JFrame frmRpgmanager;
	private JTextField txtLogEntries;
	private JTextField txtEventtitle;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
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
		
		//create a  file
        File logFile = new File("tests/Logs.log");
        File parent = logFile.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
		
        // This will output the full path where the file will be written to...
        System.out.println(logFile.getCanonicalPath());

		Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh;
        
        try {  
	        //This block configure the logger with handler and formatter  
	        fh = new FileHandler(logFile.getCanonicalPath(), true);  //TODO replace according to changes
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        logger.info("First log");

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
		
//        JTextArea txtrLogs = null;
//        try {
//		    FileReader filereader = new FileReader("tests/Logs.log");
//		    BufferedReader reader = new BufferedReader(filereader);
//		    String line;
//			while ((line = reader.readLine()) != null)
//			{
//			    if (line.startsWith("INFOS"))
//			    {
//					txtrLogs.append(line + "\n");
//			    }
//			}
//		} catch (IOException ioe) {
//		    System.err.println(ioe);
//		}
        
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
		
		Logger logger = Logger.getLogger("MyLog");
		ArrayList<Event> eventList = new ArrayList<Event>();
		
		frmRpgmanager = new JFrame();
		frmRpgmanager.setBackground(Color.BLACK);
		frmRpgmanager.setResizable(false);
		frmRpgmanager.setTitle("RPGManager");
		frmRpgmanager.setBounds(100, 100, 752, 620);
		frmRpgmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmRpgmanager.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		tabbedPane.addTab("Game", null, panel_4, null);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{727, 0};
		gbl_panel_4.rowHeights = new int[]{74, 160, 17, 14, 20, 14, 20, 23, 151, 20, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JList list = new JList(eventList.toArray());
		list.setToolTipText("eventList");
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		panel_4.add(list, gbc_list);
		
		
		
		
		
		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 1;
		panel_4.add(textPane, gbc_textPane);
		
		JLabel lblRollTheDices = new JLabel("Roll the dices");
		lblRollTheDices.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblRollTheDices = new GridBagConstraints();
		gbc_lblRollTheDices.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblRollTheDices.insets = new Insets(0, 0, 5, 0);
		gbc_lblRollTheDices.gridx = 0;
		gbc_lblRollTheDices.gridy = 2;
		panel_4.add(lblRollTheDices, gbc_lblRollTheDices);
		
		JLabel lblNumberOfFaces = new JLabel("Number of Faces");
		lblNumberOfFaces.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNumberOfFaces = new GridBagConstraints();
		gbc_lblNumberOfFaces.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNumberOfFaces.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumberOfFaces.gridx = 0;
		gbc_lblNumberOfFaces.gridy = 3;
		panel_4.add(lblNumberOfFaces, gbc_lblNumberOfFaces);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(4, 4, 20, 2));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.anchor = GridBagConstraints.NORTHEAST;
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.gridx = 0;
		gbc_spinner.gridy = 4;
		panel_4.add(spinner, gbc_spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_1.gridx = 0;
		gbc_spinner_1.gridy = 6;
		panel_4.add(spinner_1, gbc_spinner_1);
		
		JButton btnRoll = new JButton("Roll!");
		btnRoll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DiceRolls.rollTheDices((int)spinner.getValue(), (int)spinner_1.getValue(), logger);
			}
		});
		
		GridBagConstraints gbc_btnRoll = new GridBagConstraints();
		gbc_btnRoll.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnRoll.insets = new Insets(0, 0, 5, 0);
		gbc_btnRoll.gridx = 0;
		gbc_btnRoll.gridy = 7;
		panel_4.add(btnRoll, gbc_btnRoll);
		
		JLabel lblNumberOfDices = new JLabel("Number of Dices");
		lblNumberOfDices.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNumberOfDices = new GridBagConstraints();
		gbc_lblNumberOfDices.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNumberOfDices.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumberOfDices.gridx = 0;
		gbc_lblNumberOfDices.gridy = 5;
		panel_4.add(lblNumberOfDices, gbc_lblNumberOfDices);
		

		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		panel_4.add(scrollPane, gbc_scrollPane);
		
		JTextArea txtrLogs = new JTextArea();
		scrollPane.setViewportView(txtrLogs);
		txtrLogs.setLineWrap(true);
		txtrLogs.setWrapStyleWord(true);
		
	    
		txtLogEntries = new JTextField();
		txtLogEntries.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
	            {
	                logger.info(txtLogEntries.getText());
	                txtLogEntries.setText("");
	            }
			}
		});
		GridBagConstraints gbc_txtLogEntries = new GridBagConstraints();
		gbc_txtLogEntries.anchor = GridBagConstraints.NORTH;
		gbc_txtLogEntries.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLogEntries.gridx = 0;
		gbc_txtLogEntries.gridy = 9;
		panel_4.add(txtLogEntries, gbc_txtLogEntries);
		txtLogEntries.setColumns(10);
//		try {
//		    FileReader filereader = new FileReader("tests/Logs.log");
//		    BufferedReader reader = new BufferedReader(filereader);
//		    String line;
//			while ((line = reader.readLine()) != null)
//			{
//			    if (line.startsWith("INFOS"))
//			    {
//			        txtrLogs.append(line + "\n");
//			    }
//			}
//		} catch (IOException ioe) {
//		    System.err.println(ioe);
//		}
		
		txtrLogs.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				try {
				    FileReader filereader = new FileReader("tests/Logs.log");
				    BufferedReader reader = new BufferedReader(filereader);
				    String line;
					while ((line = reader.readLine()) != null)
					{
					    if (line.startsWith("INFOS"))
					    {
					        txtrLogs.append(line + "\n");
					    }
					}
				} catch (IOException ioe) {
				    System.err.println(ioe);
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setToolTipText("Events");
		tabbedPane.addTab("Events", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblEventList = new JLabel("Event List");
		lblEventList.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblEventList = new GridBagConstraints();
		gbc_lblEventList.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventList.gridx = 2;
		gbc_lblEventList.gridy = 1;
		panel_1.add(lblEventList, gbc_lblEventList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 6;
		gbc_scrollPane_1.gridwidth = 11;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 2;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		JList listEvents = new JList();
		scrollPane_1.setViewportView(listEvents);
		
		JLabel lblCreateANew = new JLabel("Create a new Event");
		lblCreateANew.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreateANew.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_lblCreateANew = new GridBagConstraints();
		gbc_lblCreateANew.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateANew.gridx = 2;
		gbc_lblCreateANew.gridy = 9;
		panel_1.add(lblCreateANew, gbc_lblCreateANew);
		
		JLabel lblEventTitle = new JLabel("Event Title");
		lblEventTitle.setForeground(Color.WHITE);
		lblEventTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEventTitle = new GridBagConstraints();
		gbc_lblEventTitle.anchor = GridBagConstraints.WEST;
		gbc_lblEventTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventTitle.gridx = 2;
		gbc_lblEventTitle.gridy = 10;
		panel_1.add(lblEventTitle, gbc_lblEventTitle);
		
		txtEventtitle = new JTextField();
		GridBagConstraints gbc_txtEventtitle = new GridBagConstraints();
		gbc_txtEventtitle.gridwidth = 10;
		gbc_txtEventtitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtEventtitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEventtitle.gridx = 2;
		gbc_txtEventtitle.gridy = 11;
		panel_1.add(txtEventtitle, gbc_txtEventtitle);
		txtEventtitle.setColumns(10);
		
		JLabel lblEventContent = new JLabel("Event Content");
		lblEventContent.setForeground(Color.WHITE);
		lblEventContent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEventContent = new GridBagConstraints();
		gbc_lblEventContent.anchor = GridBagConstraints.WEST;
		gbc_lblEventContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventContent.gridx = 2;
		gbc_lblEventContent.gridy = 12;
		panel_1.add(lblEventContent, gbc_lblEventContent);
		
		JTextPane txtEventContent = new JTextPane();
		GridBagConstraints gbc_txtEventContent = new GridBagConstraints();
		gbc_txtEventContent.gridheight = 5;
		gbc_txtEventContent.gridwidth = 11;
		gbc_txtEventContent.insets = new Insets(0, 0, 5, 5);
		gbc_txtEventContent.fill = GridBagConstraints.BOTH;
		gbc_txtEventContent.gridx = 2;
		gbc_txtEventContent.gridy = 13;
		panel_1.add(txtEventContent, gbc_txtEventContent);
		
		JButton btnNewButton_3 = new JButton("Create Event");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Event event = new Event(txtEventtitle.getText(), txtEventContent.getText());
				eventList.add(event);
				
				txtEventtitle.setText("");
				txtEventContent.setText("");
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 18;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setToolTipText("Logs");
		tabbedPane.addTab("Logs", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setToolTipText("Players");
		tabbedPane.addTab("Players", null, panel_3, null);
		
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
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		tabbedPane.addTab("Help", null, panel_5, null);
	}

}
