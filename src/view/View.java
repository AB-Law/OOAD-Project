package view;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class View {

 private JFrame frame;
 private JLabel shirtLabel;
 private JLabel colourLabel;
 private JLabel sizeLabel;
 private JLabel headLabel;

 public JButton enterbutton;
 public JButton reviewbutton;
 
 public JComboBox<String> clothType;
 public JComboBox<String> colo;
 public JComboBox<String> Size;

 
 public JTextField numbertextField;
 public View(String title) {
  frame = new JFrame(title);
  frame.getContentPane().setLayout(new BorderLayout());
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(800,800);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
  // Create UI elements
  clothType = new JComboBox<String>(
          new String[] { "Pants", "Shoes", "Hat", "Glasses", "Sunglasses", "T-Shirt", "Jacket", "Skirt", "Dress", "Belt", "Socks"});
  colo = new JComboBox<String>(
  new String[] {"Black", "Blue", "Red", "Green", "Yellow", "Purple", "Orange", "White", "Gray", "Pink", "Brown"});
  Size = new JComboBox<String>(
		  new String[] {"Small","Medium", "Large", "X-Larg", "XX-Large", "XXXL", "XXXXL"});
  enterbutton = new JButton("Enter Choice");
  reviewbutton = new JButton("Review");
  
  shirtLabel = new JLabel("CHOOSE SHIRT TYPE");
  colourLabel = new JLabel("CHOOSE COLOUR");
  sizeLabel = new JLabel("");
  headLabel = new JLabel("CLOTHING RECOMMENDATION ENGINE");
  
//  carcompTextfield = new JTextField();
//  carModelTextfield = new JTextField();
//  numbertextField = new JTextField();
//  carCompSaveButton = new JButton("Click here to Save / Query");
//  b=new JButton("Retrieve DB...."); 
//  b2=new JButton("Query.....");
//  carModelSaveButton = new JButton("Update Model");
//  hello = new JButton("Click Here to Update DB!");
//  bye = new JButton("Click Here to Exit");
  
  frame.add(clothType); 
  clothType.setBounds(15,110,145,30);
  
  frame.add(colo);
  colo.setBounds(175,110,145,30);
  
  frame.add(Size);  
  Size.setBounds(335,110,145,30);
  
  frame.add(enterbutton);
  enterbutton.setBounds(90,155,170,25);
  
  frame.add(reviewbutton);
  reviewbutton.setBounds(300,155,170,25);
  
  
//  frame.setBackground(Color.red);
  headLabel.setBounds(225,25,250,30);
  frame.add(headLabel);
 shirtLabel.setBounds(15,80,145,30);
 frame.add(shirtLabel);
 colourLabel.setBounds(175,80,145,30);
 frame.add(colourLabel);
 sizeLabel.setBounds(100,80,145,30);
 frame.add(sizeLabel);

 }
  
   
 public JFrame getFrame() {
  return frame;
 }
 public void setFrame(JFrame frame) {
  this.frame = frame;
 }
 public JLabel getShirtLabel() {
  return shirtLabel;
 }
 public void setShirtLabel(JLabel shirtLabel) {
  this.shirtLabel = shirtLabel;
 }
 public JLabel getcolourLabel() {
  return colourLabel;
 }
 public JLabel getsizeLabel() {
	  return sizeLabel;
	 }
 public JComboBox<String> getSize(){
	 return Size;
 }
 public JComboBox<String> getType(){
	 return clothType;
 }
 public void setcolourLabel(JLabel colourLabel) {
  this.colourLabel = colourLabel;
 }
 public void setsizeLabel(JLabel sizeLabel) {
	  this.sizeLabel = sizeLabel;
	 }
 public JButton getEnterButton() {
	  return enterbutton;}
    public JButton getReviewButton() {
      return reviewbutton;}
  
  
}