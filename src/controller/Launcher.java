package controller;

import view.*;

import model.ClothRating;

import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        int sumer = 5;
        Engine engine=new Engine(sumer);
        View v = new View ("OOAD");
        Engine e = new Engine(v);
        e.initController();

    }
}
