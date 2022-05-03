package main;

import model.ClothRating;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        int sumer = 1;
        Scanner input = new Scanner(System.in);
        try {
            FileReader fr = new FileReader("/Users/akshay/testss/Recommendation-System/src/appdata/clothing_items");
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            String line = br.readLine();
            while (i < 5) {
                String[] tokens = line.split(",");
                System.out.println("Rate " + tokens[2] + "out of 5:");
                int number = input.nextInt();
                sumer += number;
                line = br.readLine();
                i++;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Cloth dataset not found");
        }
        Engine engine=new Engine(sumer);
        System.out.print("Enter number of clothes to recommend: ");
        ArrayList<ClothRating> recommendations=engine.getRecommendedClothes(new Scanner(System.in).nextInt());
        for (ClothRating m: recommendations){
            System.out.println(m);
        }
    }
}
