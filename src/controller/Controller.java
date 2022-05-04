package controller;
import view.View;

public class Controller {
 public View view;
 public Controller(View v) {
  view = v;
//  initView();
 }

 public void initController() {

  view.getEnterButton().addActionListener(e -> sendLauncher());
 }
 public String[] sendLauncher()
 {
    //Create  a string array to store the values
    String[] s1=new String[3];
	 s1[0]=view.clothType.getItemAt(view.clothType.getSelectedIndex());
	 s1[1]=view.Size.getItemAt(view.Size.getSelectedIndex());
	 s1[2]=view.colo.getItemAt(view.colo.getSelectedIndex());
    System.out.println(s1[0]);
    return s1;

 }}
