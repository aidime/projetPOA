package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

import javax.swing.DefaultListCellRenderer;
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

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

import core.DiceRolls;
import core.Event;
import players.Player;

public class Application {

	private JFrame frmRpgmanager;
	private JTextField txtLogEntries;
	private JTextField txtEventtitle;
	private JTextField eventTitleGame;

	ArrayList<Player> playerList = new ArrayList<Player>();
	ArrayList<Event> eventList = new ArrayList<Event>();
	Event dummy1 = new Event("Dummy1", "I am a dummy event destined to be here only to be played with by devs");
	Event dummy2 = new Event("Dummy2", "Dummy events return...");
	
	
	Event currentEvent = new Event("Load an event to display it below","");
	Player currentPlayer = new Player("dummy");

	
	private JTextField txtPlayerCreate;
	private JTextField txtPlayerLoad;
	private JTextField Nickname;
	
	
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
	@SuppressWarnings("unchecked")
	private void initialize() {
		
		EventListCellRenderer eventListCellRenderer = new EventListCellRenderer();
		Logger logger = Logger.getLogger("MyLog");
		eventList.add(dummy1);
		eventList.add(dummy2);
		
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
		gbl_panel_4.columnWidths = new int[] {100, 39, 30, 30, 30, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 22, 0, 30, 30, 30};
		gbl_panel_4.rowHeights = new int[] {30, 30, 147, 14, 20, 14, 20, 23, 151, 44, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel = new JLabel("Event List");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);
		
		
		JList eventListGame = new JList(eventList.toArray());
		eventListGame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				updateEventList(eventListGame);
			}
		});
		eventListGame.setToolTipText("eventList");
		GridBagConstraints gbc_eventListGame = new GridBagConstraints();
		gbc_eventListGame.gridheight = 2;
		gbc_eventListGame.gridwidth = 4;
		gbc_eventListGame.fill = GridBagConstraints.BOTH;
		gbc_eventListGame.insets = new Insets(0, 0, 5, 5);
		gbc_eventListGame.gridx = 1;
		gbc_eventListGame.gridy = 1;
		panel_4.add(eventListGame, gbc_eventListGame);
		eventListGame.setCellRenderer(eventListCellRenderer);
		
		eventTitleGame = new JTextField();
		GridBagConstraints gbc_eventTitleGame = new GridBagConstraints();
		gbc_eventTitleGame.gridwidth = 12;
		gbc_eventTitleGame.insets = new Insets(0, 0, 5, 5);
		gbc_eventTitleGame.fill = GridBagConstraints.HORIZONTAL;
		gbc_eventTitleGame.gridx = 5;
		gbc_eventTitleGame.gridy = 1;
		panel_4.add(eventTitleGame, gbc_eventTitleGame);
		eventTitleGame.setColumns(10);
		
		
		
		
		
		JTextPane eventContentGame = new JTextPane();
		GridBagConstraints gbc_eventContentGame = new GridBagConstraints();
		gbc_eventContentGame.gridwidth = 12;
		gbc_eventContentGame.fill = GridBagConstraints.BOTH;
		gbc_eventContentGame.insets = new Insets(0, 0, 5, 5);
		gbc_eventContentGame.gridx = 5;
		gbc_eventContentGame.gridy = 2;
		panel_4.add(eventContentGame, gbc_eventContentGame);
		
		JButton btnLoadEvent = new JButton("Load event");
		btnLoadEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg) {
				for(int i = 0 ; i < eventList.size() ; i++) {
					if(eventList.get(i)._title == eventListGame.getSelectedValue()) {
						currentEvent = eventList.get(i);
						logger.info("Event : "+ currentEvent._title + " loaded.");
					}
				}
			}
		});
		GridBagConstraints gbc_btnLoadEvent = new GridBagConstraints();
		gbc_btnLoadEvent.gridwidth = 3;
		gbc_btnLoadEvent.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoadEvent.gridx = 1;
		gbc_btnLoadEvent.gridy = 3;
		panel_4.add(btnLoadEvent, gbc_btnLoadEvent);
		
		JButton btnNewButton_4 = new JButton("Update Event");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentEvent._title = eventTitleGame.getText();
				currentEvent._notes = eventContentGame.getText();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridwidth = 6;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 5;
		gbc_btnNewButton_4.gridy = 3;
		panel_4.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JLabel lblNumberOfFaces = new JLabel("Number of Faces");
		lblNumberOfFaces.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNumberOfFaces = new GridBagConstraints();
		gbc_lblNumberOfFaces.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNumberOfFaces.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfFaces.gridx = 16;
		gbc_lblNumberOfFaces.gridy = 3;
		panel_4.add(lblNumberOfFaces, gbc_lblNumberOfFaces);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(4, 4, 20, 2));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.anchor = GridBagConstraints.NORTHEAST;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 16;
		gbc_spinner.gridy = 4;
		panel_4.add(spinner, gbc_spinner);
		
		JLabel lblRollTheDices = new JLabel("Roll the dices");
		lblRollTheDices.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblRollTheDices = new GridBagConstraints();
		gbc_lblRollTheDices.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRollTheDices.insets = new Insets(0, 0, 5, 5);
		gbc_lblRollTheDices.gridx = 14;
		gbc_lblRollTheDices.gridy = 5;
		panel_4.add(lblRollTheDices, gbc_lblRollTheDices);
		
		JLabel lblNumberOfDices = new JLabel("Number of Dices");
		lblNumberOfDices.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNumberOfDices = new GridBagConstraints();
		gbc_lblNumberOfDices.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNumberOfDices.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfDices.gridx = 16;
		gbc_lblNumberOfDices.gridy = 5;
		panel_4.add(lblNumberOfDices, gbc_lblNumberOfDices);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 16;
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
		gbc_btnRoll.insets = new Insets(0, 0, 5, 5);
		gbc_btnRoll.gridx = 16;
		gbc_btnRoll.gridy = 7;
		panel_4.add(btnRoll, gbc_btnRoll);
		

		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 16;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 8;
		panel_4.add(scrollPane, gbc_scrollPane);
		
		JTextArea txtrLogs = new JTextArea();
		scrollPane.setViewportView(txtrLogs);
		txtrLogs.setLineWrap(true);
		txtrLogs.setWrapStyleWord(true);
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
				gbc_txtLogEntries.gridwidth = 15;
				gbc_txtLogEntries.insets = new Insets(0, 0, 0, 5);
				gbc_txtLogEntries.anchor = GridBagConstraints.NORTH;
				gbc_txtLogEntries.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtLogEntries.gridx = 1;
				gbc_txtLogEntries.gridy = 9;
				panel_4.add(txtLogEntries, gbc_txtLogEntries);
				txtLogEntries.setColumns(10);
		
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
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList listEvents = new JList(eventList.toArray());
		scrollPane_1.setViewportView(listEvents);
		listEvents.setCellRenderer(eventListCellRenderer);
		
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
				
				//listEvents = new JList(eventList.toArray());
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 18;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setToolTipText("Players");
		tabbedPane.addTab("Players", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {50, 50, 50, 50, 200, 50, 50, 50, 50};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblCreatePlayer = new JLabel("Create Player");
		lblCreatePlayer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCreatePlayer.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCreatePlayer = new GridBagConstraints();
		gbc_lblCreatePlayer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreatePlayer.gridx = 1;
		gbc_lblCreatePlayer.gridy = 1;
		panel_3.add(lblCreatePlayer, gbc_lblCreatePlayer);
		
		JLabel lblNickname = new JLabel("Nickname");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 3;
		gbc_lblNickname.gridy = 1;
		panel_3.add(lblNickname, gbc_lblNickname);
		
		txtPlayerCreate = new JTextField();
		GridBagConstraints gbc_txtPlayerCreate = new GridBagConstraints();
		gbc_txtPlayerCreate.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlayerCreate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlayerCreate.gridx = 4;
		gbc_txtPlayerCreate.gridy = 1;
		panel_3.add(txtPlayerCreate, gbc_txtPlayerCreate);
		txtPlayerCreate.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				try {
					playerList.add(new Player(txtPlayerCreate.getText()));
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
					txtPlayerCreate.setText("");
			}
		});
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreate.gridx = 5;
		gbc_btnCreate.gridy = 1;
		panel_3.add(btnCreate, gbc_btnCreate);
		
		JLabel lblLoadPlayerSheet = new JLabel("Load Player Sheet");
		lblLoadPlayerSheet.setForeground(Color.WHITE);
		lblLoadPlayerSheet.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblLoadPlayerSheet = new GridBagConstraints();
		gbc_lblLoadPlayerSheet.insets = new Insets(0, 0, 5, 5);
		gbc_lblLoadPlayerSheet.gridx = 1;
		gbc_lblLoadPlayerSheet.gridy = 3;
		panel_3.add(lblLoadPlayerSheet, gbc_lblLoadPlayerSheet);
		
		JLabel label = new JLabel("Nickname");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 3;
		panel_3.add(label, gbc_label);
		
		txtPlayerLoad = new JTextField();
		txtPlayerLoad.setColumns(10);
		GridBagConstraints gbc_txtPlayerLoad = new GridBagConstraints();
		gbc_txtPlayerLoad.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlayerLoad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlayerLoad.gridx = 4;
		gbc_txtPlayerLoad.gridy = 3;
		panel_3.add(txtPlayerLoad, gbc_txtPlayerLoad);
		
		
		
		JLabel lblPlayerSheet = new JLabel("Player Sheet");
		lblPlayerSheet.setForeground(Color.WHITE);
		lblPlayerSheet.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblPlayerSheet = new GridBagConstraints();
		gbc_lblPlayerSheet.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerSheet.gridx = 4;
		gbc_lblPlayerSheet.gridy = 5;
		panel_3.add(lblPlayerSheet, gbc_lblPlayerSheet);
		
		JLabel lblNickname_1 = new JLabel("Nickname");
		lblNickname_1.setForeground(Color.WHITE);
		lblNickname_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNickname_1 = new GridBagConstraints();
		gbc_lblNickname_1.anchor = GridBagConstraints.WEST;
		gbc_lblNickname_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname_1.gridx = 1;
		gbc_lblNickname_1.gridy = 7;
		panel_3.add(lblNickname_1, gbc_lblNickname_1);
		
		Nickname = new JTextField();
		GridBagConstraints gbc_Nickname = new GridBagConstraints();
		gbc_Nickname.insets = new Insets(0, 0, 5, 5);
		gbc_Nickname.fill = GridBagConstraints.HORIZONTAL;
		gbc_Nickname.gridx = 3;
		gbc_Nickname.gridy = 7;
		panel_3.add(Nickname, gbc_Nickname);
		Nickname.setColumns(10);
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setForeground(Color.WHITE);
		lblHealth.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblHealth = new GridBagConstraints();
		gbc_lblHealth.anchor = GridBagConstraints.WEST;
		gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth.gridx = 1;
		gbc_lblHealth.gridy = 8;
		panel_3.add(lblHealth, gbc_lblHealth);
		
		JSpinner Health = new JSpinner();
		Health.setModel(new SpinnerNumberModel(100, 0, 100, 1));
		GridBagConstraints gbc_Health = new GridBagConstraints();
		gbc_Health.insets = new Insets(0, 0, 5, 5);
		gbc_Health.gridx = 3;
		gbc_Health.gridy = 8;
		panel_3.add(Health, gbc_Health);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setForeground(Color.WHITE);
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.anchor = GridBagConstraints.WEST;
		gbc_lblLevel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevel.gridx = 1;
		gbc_lblLevel.gridy = 9;
		panel_3.add(lblLevel, gbc_lblLevel);
		
		JSpinner Level = new JSpinner();
		Level.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		GridBagConstraints gbc_Level = new GridBagConstraints();
		gbc_Level.insets = new Insets(0, 0, 5, 5);
		gbc_Level.gridx = 3;
		gbc_Level.gridy = 9;
		panel_3.add(Level, gbc_Level);
		
		JLabel lblInitiative = new JLabel("Initiative");
		lblInitiative.setForeground(Color.WHITE);
		lblInitiative.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblInitiative = new GridBagConstraints();
		gbc_lblInitiative.anchor = GridBagConstraints.WEST;
		gbc_lblInitiative.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitiative.gridx = 1;
		gbc_lblInitiative.gridy = 10;
		panel_3.add(lblInitiative, gbc_lblInitiative);
		
		JSpinner Initiative = new JSpinner();
		Initiative.setModel(new SpinnerNumberModel(100, 0, 200, 10));
		GridBagConstraints gbc_Initiative = new GridBagConstraints();
		gbc_Initiative.insets = new Insets(0, 0, 5, 5);
		gbc_Initiative.gridx = 3;
		gbc_Initiative.gridy = 10;
		panel_3.add(Initiative, gbc_Initiative);
		
		JLabel label_6 = new JLabel("Strength");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.WEST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 12;
		panel_3.add(label_6, gbc_label_6);
		
		JSpinner Strength = new JSpinner();
		Strength.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_Strength = new GridBagConstraints();
		gbc_Strength.insets = new Insets(0, 0, 5, 5);
		gbc_Strength.gridx = 3;
		gbc_Strength.gridy = 12;
		panel_3.add(Strength, gbc_Strength);
		
		JLabel lblPerception = new JLabel("Perception");
		lblPerception.setForeground(Color.WHITE);
		lblPerception.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPerception = new GridBagConstraints();
		gbc_lblPerception.anchor = GridBagConstraints.WEST;
		gbc_lblPerception.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerception.gridx = 1;
		gbc_lblPerception.gridy = 13;
		panel_3.add(lblPerception, gbc_lblPerception);
		
		JSpinner Perception = new JSpinner();
		Perception.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_Perception = new GridBagConstraints();
		gbc_Perception.insets = new Insets(0, 0, 5, 5);
		gbc_Perception.gridx = 3;
		gbc_Perception.gridy = 13;
		panel_3.add(Perception, gbc_Perception);
		
		JLabel lblEndurance = new JLabel("Endurance");
		lblEndurance.setForeground(Color.WHITE);
		lblEndurance.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblEndurance = new GridBagConstraints();
		gbc_lblEndurance.anchor = GridBagConstraints.WEST;
		gbc_lblEndurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndurance.gridx = 1;
		gbc_lblEndurance.gridy = 14;
		panel_3.add(lblEndurance, gbc_lblEndurance);
		
		JSpinner Endurance = new JSpinner();
		Endurance.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_Endurance = new GridBagConstraints();
		gbc_Endurance.insets = new Insets(0, 0, 5, 5);
		gbc_Endurance.gridx = 3;
		gbc_Endurance.gridy = 14;
		panel_3.add(Endurance, gbc_Endurance);
		
		JLabel lblCharisma = new JLabel("Charisma");
		lblCharisma.setForeground(Color.WHITE);
		lblCharisma.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblCharisma = new GridBagConstraints();
		gbc_lblCharisma.anchor = GridBagConstraints.WEST;
		gbc_lblCharisma.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharisma.gridx = 1;
		gbc_lblCharisma.gridy = 15;
		panel_3.add(lblCharisma, gbc_lblCharisma);
		
		JSpinner Charisma = new JSpinner();
		Charisma.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_Charisma = new GridBagConstraints();
		gbc_Charisma.insets = new Insets(0, 0, 5, 5);
		gbc_Charisma.gridx = 3;
		gbc_Charisma.gridy = 15;
		panel_3.add(Charisma, gbc_Charisma);
		
		JLabel lblIntelligence = new JLabel("Intelligence");
		lblIntelligence.setForeground(Color.WHITE);
		lblIntelligence.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblIntelligence = new GridBagConstraints();
		gbc_lblIntelligence.anchor = GridBagConstraints.WEST;
		gbc_lblIntelligence.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntelligence.gridx = 1;
		gbc_lblIntelligence.gridy = 16;
		panel_3.add(lblIntelligence, gbc_lblIntelligence);
		
		JSpinner Intelligence = new JSpinner();
		Intelligence.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_Intelligence = new GridBagConstraints();
		gbc_Intelligence.insets = new Insets(0, 0, 5, 5);
		gbc_Intelligence.gridx = 3;
		gbc_Intelligence.gridy = 16;
		panel_3.add(Intelligence, gbc_Intelligence);
		
		JLabel lblAgility = new JLabel("Agility");
		lblAgility.setForeground(Color.WHITE);
		lblAgility.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblAgility = new GridBagConstraints();
		gbc_lblAgility.anchor = GridBagConstraints.WEST;
		gbc_lblAgility.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgility.gridx = 1;
		gbc_lblAgility.gridy = 17;
		panel_3.add(lblAgility, gbc_lblAgility);
		
		JSpinner Agility = new JSpinner();
		Agility.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_Agility = new GridBagConstraints();
		gbc_Agility.insets = new Insets(0, 0, 5, 5);
		gbc_Agility.gridx = 3;
		gbc_Agility.gridy = 17;
		panel_3.add(Agility, gbc_Agility);
		
		JLabel lblLuck = new JLabel("Luck");
		lblLuck.setForeground(Color.WHITE);
		lblLuck.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblLuck = new GridBagConstraints();
		gbc_lblLuck.anchor = GridBagConstraints.WEST;
		gbc_lblLuck.insets = new Insets(0, 0, 5, 5);
		gbc_lblLuck.gridx = 1;
		gbc_lblLuck.gridy = 18;
		panel_3.add(lblLuck, gbc_lblLuck);
		
		JSpinner Luck = new JSpinner();
		Luck.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_Luck = new GridBagConstraints();
		gbc_Luck.insets = new Insets(0, 0, 5, 5);
		gbc_Luck.gridx = 3;
		gbc_Luck.gridy = 18;
		panel_3.add(Luck, gbc_Luck);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0 ; i < playerList.size() ; i++) {
					if(playerList.get(i)._nickName == txtPlayerLoad.getText()) {
						currentPlayer = playerList.get(i);
					}
					else
						return;
				}
				Nickname.setText(currentPlayer._nickName);
				Level.setValue(currentPlayer._level);
				Health.setValue(currentPlayer._health);
				Initiative.setValue(currentPlayer._initiative);
				
				Strength.setValue(currentPlayer._skills._skills.get("S"));
				Perception.setValue(currentPlayer._skills._skills.get("P"));
				Endurance.setValue(currentPlayer._skills._skills.get("E"));
				Charisma.setValue(currentPlayer._skills._skills.get("C"));
				Intelligence.setValue(currentPlayer._skills._skills.get("I"));
				Agility.setValue(currentPlayer._skills._skills.get("A"));
				Luck.setValue(currentPlayer._skills._skills.get("L"));
			}
		});
		
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoad.gridx = 5;
		gbc_btnLoad.gridy = 3;
		panel_3.add(btnLoad, gbc_btnLoad);
		
		
		JButton btnNewButton = new JButton("Submit changes");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 19;
		panel_3.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0 ; i < playerList.size() ; i++) {
					if(playerList.get(i)._nickName == Nickname.getText()) {
						currentPlayer = playerList.get(i);
					}
					else
						return;
				}
				Nickname.setText(currentPlayer._nickName);
				Level.setValue(currentPlayer._level);
				Health.setValue(currentPlayer._health);
				Initiative.setValue(currentPlayer._initiative);
				
				Strength.setValue(currentPlayer._skills._skills.get("S"));
				Perception.setValue(currentPlayer._skills._skills.get("P"));
				Endurance.setValue(currentPlayer._skills._skills.get("E"));
				Charisma.setValue(currentPlayer._skills._skills.get("C"));
				Intelligence.setValue(currentPlayer._skills._skills.get("I"));
				Agility.setValue(currentPlayer._skills._skills.get("A"));
				Luck.setValue(currentPlayer._skills._skills.get("L"));
			}
		});
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		tabbedPane.addTab("Help", null, panel_5, null);
	}
	
	public void updateEventList(JList list) {
		list = new JList(eventList.toArray());
	}
	
	public class EventListCellRenderer extends DefaultListCellRenderer {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Component getListCellRendererComponent(JList<?> list,
	                                 Object value,
	                                 int index,
	                                 boolean isSelected,
	                                 boolean cellHasFocus) {
	        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	        if (value instanceof Event) {
	            Event event = (Event)value;
	            setText(event.get_title());
	            setToolTipText(event.get_notes());
	        }
	        return this;
	    }
	}

}
