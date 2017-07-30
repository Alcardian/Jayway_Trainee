package se.alcardian.jayway.trainee_test.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import se.alcardian.jayway.trainee_test.sort.*;
import se.alcardian.jayway.trainee_test.STool;
import se.alcardian.jayway.trainee_test.Language;
import se.alcardian.jayway.trainee_test.Main;
import se.alcardian.jayway.trainee_test.io.*;

public class SToolFrame extends JFrame{
	private JPanel mainPanel = new JPanel();
	
	// Window Default Size
	private int length = 900;
	private int height = 500;
	private String savePath = "";
	
	private ArrayList<STool> stool;
	private ArrayList<Language> lang;
	
	// For Panel 1
	private JList<STool> list;
	private STool listSelect = null;
	private DefaultListModel<STool> listModel = new DefaultListModel<>();
	private JButton nameSortB = new JButton("Name Sort");
	private JButton langSortB = new JButton("Language Sort");
	private JButton typeSortB = new JButton("Type Sort");
	private JButton intrSortB = new JButton("Intrusive Sort");
	
	// For Panel 2
	private JLabel nameLabel = new JLabel("Name:");
	private JTextField nameField = new JTextField();
	private JLabel typeLabel = new JLabel("Type:");
	private JTextField typeField = new JTextField();
	private JLabel langLabel = new JLabel("Language:");
	private JTextField langField = new JTextField();
	private JLabel intrLabel = new JLabel("Intrusive:");
	private JTextField intrField = new JTextField();
	private JLabel openLabel = new JLabel("Open Source:");
	private JTextField openField = new JTextField();
	private JButton addButton = new JButton("Add");
	private JButton updateButton = new JButton("Update");
	private JButton deleteButton = new JButton("Delete");
	private JLabel selectedLabel = new JLabel("Selected: ");
	
	// For Panel 3
	private JList<Language> langList;
	DefaultListModel<Language> langListModel;
	
	// For Panel 4
	private JLabel lNameLabel = new JLabel("Name:");
	private JTextField lNameField = new JTextField();
	private JLabel lIdLabel = new JLabel("Type:");
	private JTextField lIdField = new JTextField();
	private JButton lAddButton = new JButton("Add");
	
	public SToolFrame(String savePath) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("STool");
		setSize(length, height);
		this.savePath = savePath;
		
		// Will make the window popup in the middle of the screen instead of top-left corner
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		// Setting up tabs for panels
		JTabbedPane tab = new JTabbedPane();
		add(tab);
		
		// Panel 1, view all STool. Click on 1 to select for editing in other panel
		JPanel p1 = new JPanel();
		stool = Main.loadSTool(savePath);
		p1.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//DefaultListModel<STool> listModel = new DefaultListModel<>();
		//for(int i=0;i<stool.size();i++){
		//	listModel.addElement(stool.get(i));
		//}
		//list = new JList<>(listModel);
		updateList();
		list = new JList<>(listModel);
		list.setVisibleRowCount(8);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridx = 0;
		c.gridy = 0;
		p1.add(new JScrollPane(list), c);
		c.gridy = 1;
		p1.add(nameSortB, c);
		c.gridy = 2;
		p1.add(langSortB, c);
		c.gridy = 3;
		p1.add(typeSortB, c);
		c.gridy = 4;
		p1.add(intrSortB, c);
		// Tab name, the panel
		tab.addTab("STool", p1);
		
		// Panel 2, add/edit/delete STools
		JPanel p2 = new JPanel();
		p2.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		p2.add(nameLabel, c);
		c.gridx = 1;
		nameField.setMinimumSize(new Dimension(200,25));
		nameField.setMaximumSize(nameField.getMinimumSize());
		nameField.setPreferredSize(nameField.getMinimumSize());
		p2.add(nameField, c);
		c.gridx = 0;
		c.gridy = 1;
		p2.add(typeLabel, c);
		c.gridx = 1;
		typeField.setMinimumSize(new Dimension(200,25));
		typeField.setMaximumSize(typeField.getMinimumSize());
		typeField.setPreferredSize(typeField.getMinimumSize());
		p2.add(typeField, c);
		c.gridx = 0;
		c.gridy = 2;
		p2.add(langLabel, c);
		c.gridx = 1;
		langField.setMinimumSize(new Dimension(200,25));
		langField.setMaximumSize(langField.getMinimumSize());
		langField.setPreferredSize(langField.getMinimumSize());
		p2.add(langField, c);
		c.gridx = 0;
		c.gridy = 3;
		p2.add(intrLabel, c);
		c.gridx = 1;
		intrField.setMinimumSize(new Dimension(200,25));
		intrField.setMaximumSize(intrField.getMinimumSize());
		intrField.setPreferredSize(intrField.getMinimumSize());
		p2.add(intrField, c);
		c.gridx = 0;
		c.gridy = 4;
		p2.add(openLabel, c);
		c.gridx = 1;
		openField.setMinimumSize(new Dimension(200,25));
		openField.setMaximumSize(openField.getMinimumSize());
		openField.setPreferredSize(openField.getMinimumSize());
		p2.add(openField, c);
		c.gridx = 0;
		c.gridy = 5;
		p2.add(addButton, c);
		c.gridy = 6;
		p2.add(updateButton, c);
		c.gridy = 7;
		p2.add(deleteButton, c);
		c.gridy = 8;
		p2.add(selectedLabel, c);
		c.gridy = 9;
		p2.add(new JLabel("0: Unknown, 1: Yes, 2: No"), c);
		tab.addTab("STool - Manage", p2);
		
		// Panel 3, view all languages
		JPanel p3 = new JPanel();
		lang = Main.loadLanguage(savePath, null);
		langListModel = new DefaultListModel<>();
		for(int i=0;i<lang.size();i++){
			langListModel.addElement(lang.get(i));
		}
		langList = new JList<>(langListModel);
		langList.setVisibleRowCount(10);
		langList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		p3.add(new JScrollPane(langList));
		tab.addTab("Language", p3);
		
		// Panel 4, adding new languages
		JPanel p4 = new JPanel();
		p4.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		p4.add(lNameLabel, c);
		c.gridx = 1;
		lNameField.setMinimumSize(new Dimension(200,25));
		lNameField.setMaximumSize(lNameField.getMinimumSize());
		lNameField.setPreferredSize(lNameField.getMinimumSize());
		p4.add(lNameField, c);
		c.gridx = 0;
		c.gridy = 1;
		p4.add(lIdLabel, c);
		c.gridx = 1;
		lIdField.setMinimumSize(new Dimension(200,25));
		lIdField.setMaximumSize(lIdField.getMinimumSize());
		lIdField.setPreferredSize(lIdField.getMinimumSize());
		p4.add(lIdField, c);
		c.gridy = 2;
		p4.add(lAddButton, c);
		tab.addTab("Language - Manage", p4);
		
		// Listeners
		//TODO add back later when I figure out how to not crash the entire thing....
		
		list.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						listSelect = list.getSelectedValue();
						//nameField.setText(listSelect.getName().substring(0));
						//typeField.setText(Boolean.toString(listSelect.isFramework()));
						//langField.setText(Integer.toString(listSelect.getLanguage()));
						//intrField.setText(Integer.toString(listSelect.getIntrusive()));
						//openField.setText(Integer.toString(listSelect.getOpenSource()));
						selectedLabel.setText("Selected: "+listSelect.toString());
					}
				}
		);
		
		ButtonListener bl = new ButtonListener();
		// Panel 1 buttons
		nameSortB.addActionListener(bl);
		langSortB.addActionListener(bl);
		typeSortB.addActionListener(bl);
		intrSortB.addActionListener(bl);
		// Panel 2 buttons
		addButton.addActionListener(bl);
		updateButton.addActionListener(bl);
		deleteButton.addActionListener(bl);
		// Panel 4 buttons
		lAddButton.addActionListener(bl);
		
		for(int i=0;i<stool.size();i++){
			System.out.println(stool.get(i).toFileFormat());
		}
	}
	
	private void updateList(){
		while(listModel.size()>0){
			listModel.remove(0);
		}
		for(int i=0;i<stool.size();i++){
			listModel.addElement(stool.get(i));
		}
		//list.fire
		//return listModel;
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == nameSortB){
				// Trying to fix crash if trying to sort while having something selected
				//list.clearSelection();
				//selectedLabel.setText("Selected: ");
				//listSelect = null;
				Collections.sort(stool, new NameSort());
				updateList();
				
			}else if(e.getSource() == langSortB){
				Collections.sort(stool, new LangSort());
				updateList();
			}else if(e.getSource() == typeSortB){
				Collections.sort(stool, new TypeSort());
				updateList();
			}else if(e.getSource() == intrSortB){
				Collections.sort(stool, new IntrSort());
				updateList();
			}else if(e.getSource() == lAddButton){
				// x
				// TODO save changes to file
				Language temp = new Language(lNameField.getText(), Integer.parseInt(lIdField.getText()), stool, lang);
				lang.add(temp);
				ArrayList<String> tmp = new ArrayList<String>();
				for(int i=0;i<lang.size();i++){
					tmp.add(lang.get(i).toFileFormat());
				}
				Jay_IO.writeToFile(tmp, savePath+"\\Language.txt");
			}else{
				if(langField.getText() != "" && intrField.getText() != "" && openField.getText() != ""){
					// TODO add check to see if it's a number or some text that shouldn't be in the numbers only fields
					if(e.getSource() == addButton){
						// Create a new STool
						stool.add(new STool(nameField.getText(), typeField.getText().equals("true"),
							Integer.parseInt(langField.getText()), Integer.parseInt(intrField.getText()),
							Integer.parseInt(openField.getText())));
						updateList();
						ArrayList<String> tmp = new ArrayList<String>();
						for(int i=0;i<stool.size();i++){
							tmp.add(stool.get(i).toFileFormat());
						}
						Jay_IO.writeToFile(tmp, savePath+"\\STool.txt");
					}else if(e.getSource() == updateButton && listSelect != null){
						// Update an existing STool
						listSelect.setName(nameField.getText());
						listSelect.setFramework(typeField.getText().equals("true"));
						listSelect.setLanguage(Integer.parseInt(langField.getText()));
						listSelect.setIntrusive(Integer.parseInt(intrField.getText()));
						listSelect.setOpenSource(Integer.parseInt(openField.getText()));
						ArrayList<String> tmp = new ArrayList<String>();
						for(int i=0;i<stool.size();i++){
							tmp.add(stool.get(i).toFileFormat());
						}
						Jay_IO.writeToFile(tmp, savePath+"\\STool.txt");
						selectedLabel.setText("Selected: ");
						listSelect = null;
					}else if(e.getSource() == deleteButton && listSelect != null){
						// Delete an existing STool
						selectedLabel.setText("Selected: ");
						for(int i=0;i<stool.size();i++){
							if(stool.get(i) == listSelect){
								stool.remove(i);
							}
						}
						listSelect = null;
						// TODO save changes to file
						//list.firePropertyChange(0, list.getModel().getSize(), true);
						
						ArrayList<String> tmp = new ArrayList<String>();
						for(int i=0;i<stool.size();i++){
							tmp.add(stool.get(i).toFileFormat());
						}
						Jay_IO.writeToFile(tmp, savePath+"\\STool.txt");
						// update is after save to file as update will crash the program...changes will atleast be saved before crashing :)
						updateList();
					}
				}
			}
		}
	}

}
