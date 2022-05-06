package controller;

import view.*;
import appdata.Data;
import model.Cloth;
import model.ClothRating;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


import javax.swing.JOptionPane;

class Engine {
    public View view;
    public Engine(View v) {
     view = v;
   //  initView();
    }
   
    public void initController() {
   
     view.getEnterButton().addActionListener(e -> {
         //Create  a string array to store the values
       String[] s1=new String[3];
       s1[0]=view.clothType.getItemAt(view.clothType.getSelectedIndex());
       s1[1]=view.Size.getItemAt(view.Size.getSelectedIndex());
       s1[2]=view.colo.getItemAt(view.colo.getSelectedIndex());
        //print out s1
        System.out.println(s1[0]+ "\n"+ s1[1] + "\n"+ s1[2]);
      ArrayList<ClothRating> recommendations=getRecommendedClothes(3,s1[0],s1[1],s1[2]); 
      System.out.print("Please wait. Processing dataset....\n");
      //Make an ArrayList of String
        ArrayList<String> names=new ArrayList<>();

      for (ClothRating m: recommendations){
            System.out.println(m);
            names.add(m.getCloth());
        }
        //Make an arraylist of Strings
        for (String n: names){
        JOptionPane.showMessageDialog(null, n);
        }
    });




    //Recommendation button
    view.getReviewButton().addActionListener(e -> {
        String[] s1=new String[3];
       s1[0]=view.clothType.getItemAt(view.clothType.getSelectedIndex());
       s1[1]=view.Size.getItemAt(view.Size.getSelectedIndex());
       s1[2]=view.colo.getItemAt(view.colo.getSelectedIndex());
        //print out s1
         System.out.println(s1[0]+ "\n"+ s1[1] + "\n"+ s1[2]);
      ArrayList<ClothRating> recommendations=getRecommendedClothes(2,s1[0],s1[1],s1[2]); 
      System.out.print("Please wait. Processing dataset....\n");
      for (ClothRating m: recommendations){
          System.out.println(m);
            System.out.println("Enter the rating for this item: ");
            Scanner sc=new Scanner(System.in);
            float rating=sc.nextFloat();
    }
        System.out.println("Review submitted");
    }
        );
    
    }

    Engine(int subjectUser) {
        Data.getData().getSubject().setUserID(subjectUser);
        fetchResourses(Data.getData().getSubject().getUserID());
        orderClothesBasedOnRating();
    }

    private void orderClothesBasedOnRating() {
        Iterator iterator=Data.getData().getClothes().iterator();
        while (iterator.hasNext()){
            Cloth m=(Cloth) iterator.next();
            if (!Data.getData().getSubject().getReviewed().contains((Integer)m.getClothwID())){
                Data.getData().getOrderedRecommend().add(new ClothRating(m.getClothwID(),m.getRatingSum(),m.getUsers()));
            }
        }
        Collections.sort(Data.getData().getOrderedRecommend());
    }

    private void fetchResourses(int user) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    "/Users/akshay/testss/Recommendation-System/src/appdata/dataset"));
            String line = reader.readLine();
            while (line != null) {
                String[] attr = line.split(" ");
                if (attr[0].equals(String.valueOf(user))){
                    Data.getData().getSubject().getReviewed().add(Integer.valueOf(attr[1]));
                }else{
                    reduceToMapCloth(attr);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reduceToMapCloth(String[] attr) {
        Cloth m = new Cloth(Integer.parseInt(attr[1]));
        if (!Data.getData().getClothes().contains(m)) {
            Data.getData().getClothes().add(m);              //add clothes to TreeSet if not already added
        }
        Iterator i = Data.getData().getClothes().iterator();
        boolean found = false;
        while (i.hasNext() && !found) {                     //Traverse to cloth in the TreeSet
            Cloth im = (Cloth) i.next();
            if (im.getClothwID() == Integer.parseInt(attr[1])) { found = true;
                im.setUsers(im.getUsers()+1);
                im.setRatingSum(im.getRatingSum()+Double.valueOf(attr[2]));
            }
        }
    }

    public ArrayList<ClothRating> getRecommendedClothes(int num,String type,String size,String color) {
        ArrayList<ClothRating> returnClothes=new ArrayList<>();
        int i = 0;
        int j = Data.getData().getOrderedRecommend().size()-1;
        while(i<num){
            ClothRating temporary = Data.getData().getOrderedRecommend().get(j);
            int id = temporary.getID();
            try {
                FileReader fr = new FileReader("/Users/akshay/testss/Recommendation-System/src/appdata/clothing_items");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    String[] tokens = line.split(",");
                    int flag = 0;
                    if(!tokens[3].contains("Female")){
                        if (tokens[0].equals(Integer.toString(id))) {
                            if(tokens[2].contains(size)){
                                if(tokens[2].contains(type)){
                                    if(tokens[2].contains(color)){
                                        returnClothes.add(Data.getData().getOrderedRecommend().get(j));
                                        i++;
                                        flag =1;
                                    }
                                }
                            }
                        }
                    }
                    if(flag==1){
                        break;
                    }
                    line = br.readLine();
                }

                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Cloth not found");
            }

            j--;
        }
        return returnClothes;
    }

    public ArrayList<ClothRating> getRecommendedClothesF(int num,String type,String size,String color) {
        ArrayList<ClothRating> returnClothes=new ArrayList<>();
        int i = 0;
        int j = Data.getData().getOrderedRecommend().size()-1;
        while(i<num){
            ClothRating temporary = Data.getData().getOrderedRecommend().get(j);
            int id = temporary.getID();

            try {
                FileReader fr = new FileReader("/Users/akshay/testss/Recommendation-System/src/appdata/clothing_items");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    String[] tokens = line.split(",");
                    int flag = 0;
                    if(tokens[3].contains("Female")){
                        if (tokens[0].equals(Integer.toString(id))) {
                            if(tokens[2].contains(size)){
                                if(tokens[2].contains(type)){
                                    if(tokens[2].contains(color)){
                                        returnClothes.add(Data.getData().getOrderedRecommend().get(j));
                                        i++;
                                        flag =1;
                                    }
                                }
                            }
                        }
                    }
                    if(flag==1){
                        break;
                    }
                    line = br.readLine();
                }

                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Cloth not found");
            }

            j--;
        }
        return returnClothes;
    }
}
