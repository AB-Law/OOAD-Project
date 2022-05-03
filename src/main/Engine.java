package main;

import appdata.Data;
import model.Cloth;
import model.ClothRating;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Engine {

    Engine(int subjectUser) {
        Data.getData().getSubject().setUserID(subjectUser);
        fetchResourses(Data.getData().getSubject().getUserID());
        orderClothesBasedOnRating();
    }

    private void orderClothesBasedOnRating() {
        Iterator iterator=Data.getData().getClothes().iterator();
        while (iterator.hasNext()){
            Cloth m=(Cloth) iterator.next();
            if (!Data.getData().getSubject().getWatched().contains((Integer)m.getClothwID())){
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
                    Data.getData().getSubject().getWatched().add(Integer.valueOf(attr[1]));
                }else{
                    //if(Double.valueOf(attr[2])>2.5)
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
            Data.getData().getClothes().add(m);              //add movie to TreeSet if not already added
        }
        Iterator i = Data.getData().getClothes().iterator();
        boolean found = false;
        while (i.hasNext() && !found) {                     //Traverse to movie in the TreeSet
            Cloth im = (Cloth) i.next();
            if (im.getClothwID() == Integer.parseInt(attr[1])) { found = true;
                im.setUsers(im.getUsers()+1);
                im.setRatingSum(im.getRatingSum()+Double.valueOf(attr[2]));
            }
        }
    }
    public ArrayList<ClothRating> getRecommendedClothes(int num) {
        ArrayList<ClothRating> returnClothes=new ArrayList<>();
        for (int i = Data.getData().getOrderedRecommend().size()-1; i>=Data.getData().getOrderedRecommend().size()-num ; i--) {
            returnClothes.add(Data.getData().getOrderedRecommend().get(i));
        }
        return returnClothes;
    }
}
