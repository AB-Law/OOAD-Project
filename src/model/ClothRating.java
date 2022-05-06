package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Creates a ClothRating model class which is used to implement the ClothRating class
public class ClothRating implements Comparable {
    private int id;
    private double ratingSum;
    private int userNum;

    public ClothRating(int id, double rating, int userNum) {
        this.id = id;
        this.ratingSum = rating;
        this.userNum = userNum;
    }

    @Override
    public int compareTo(Object o) {
        //required

        double thisavg=this.ratingSum/this.userNum;
        double thatAvg=((ClothRating)o).ratingSum/((ClothRating)o).userNum;
        return Double.compare(thisavg,thatAvg);


    }

    public int getID() {
        return id;
    }

    public String getCloth(){
        String string="Clothing ID: "+id+" Avg Rating: "+(ratingSum/userNum);
        try {
            FileReader fr = new FileReader("/Users/akshay/testss/Recommendation-System/src/appdata/clothing_items");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] tokens = line.split(",");
                if (tokens[0].equals(Integer.toString(id))) {
                    System.out.println(tokens[2]);
                    string = tokens[2] + " Rated: "+ ratingSum/userNum;
                }
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Cloth not found");
        }
        return string;
    }

    @Override
    public String toString() {
        String string="Clothing ID: "+id+" Avg Rating: "+(ratingSum/userNum);
        try {
            FileReader fr = new FileReader("/Users/akshay/testss/Recommendation-System/src/appdata/clothing_items");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] tokens = line.split(",");
                if (tokens[0].equals(Integer.toString(id))) {
                    System.out.println(tokens[2]);
                }
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Cloth not found");
        }
        return string;
    }
}
