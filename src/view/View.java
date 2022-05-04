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
// public JTextField carcompTextfield;
// public JTextField carModelTextfield;
// private JButton carCompSaveButton;
// public JButton b;
// public JButton b2;
 public JButton enterbutton;
 public JComboBox<String> clothType;
 public JComboBox<String> colo;
 public JComboBox<String> Size;
// private JButton carModelSaveButton;
// public JButton hello;
// private JButton bye;
 
 public JTextField numbertextField;
 public View(String title) {
  frame = new JFrame(title);
  frame.getContentPane().setLayout(new BorderLayout());
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(700,700);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
  clothType = new JComboBox<String>(
          new String[] { "Pants", "Shoes", "Hat", "Glasses", "Sunglasses", "T-Shirt", "Jacket", "Skirt", "Dress", "Belt", "Socks"});
  colo = new JComboBox<String>(
  new String[] {"Black", "Blue", "Red", "Green", "Yellow", "Purple", "Orange", "White", "Gray", "Pink", "Brown"});
  Size = new JComboBox<String>(
		  new String[] {"Small","Medium", "Large", "X-Larg", "XX-Large", "XXXL", "XXXXL"});
  enterbutton = new JButton("Enter Choice");
  // Create UI elements
  shirtLabel = new JLabel("CHOOSE SHIRT TYPE");
  colourLabel = new JLabel("CHOOSE COLOUR");
  sizeLabel = new JLabel("CHOOSE SIZE");
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
  enterbutton.setBounds(150,155,170,25);
  
  
//  frame.setBackground(Color.red);
  headLabel.setBounds(225,25,250,30);
  frame.add(headLabel);
 shirtLabel.setBounds(15,80,145,30);
 frame.add(shirtLabel);
 colourLabel.setBounds(175,80,145,30);
 frame.add(colourLabel);
 sizeLabel.setBounds(100,80,145,30);
 frame.add(sizeLabel);
// carModelTextfield.setBounds(150,155,170,25);
// frame.add(carModelTextfield);
// hello.setBounds(350,116,170,25);
// frame.add(hello);
// bye.setBounds(350,155,170,25);
// frame.add(bye);
//  b.setBounds(50,200,145,30);  
//  frame.add(b); 
//  b2.setBounds(200,200,145,30);  
//  frame.add(b2); 
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
// public JTextField getcarcompTextfield() {
//  return carcompTextfield;
// }
// public void setcarcompTextfield(JTextField carcompTextfield) {
//  this.carcompTextfield = carcompTextfield;
// }
// public JTextField getcarModelTextfield() {
//  return carModelTextfield;
// }
// public void setcarModelTextfield(JTextField carModelTextfield) {
//  this.carModelTextfield = carModelTextfield;
// }
// public JButton getcarCompSaveButton() {
//  return carCompSaveButton;
// }
 public JButton getEnterButton() {
	  return enterbutton;}
// public void setcarCompSaveButton(JButton carCompSaveButton) {
//  this.carCompSaveButton = carCompSaveButton;
// }
// public JButton getcarModelSaveButton() {
//  return carModelSaveButton;
// }
// public void setcarModelSaveButton(JButton carModelSaveButton) {
//  this.carModelSaveButton = carModelSaveButton;
// }
// public JButton getHello() {
//  return hello;
// }
// public void setHello(JButton hello) {
//  this.hello = hello;
// }
// public JButton getBye() {
//  return bye;
// }
// public JButton b() {
//	 return b;
// }
// public JButton b2() {
//	 return b2;
// }
// public void setBye(JButton bye) {
//  this.bye = bye;
// }

}