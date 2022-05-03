package appdata;

import model.Cloth;
import model.ClothRating;
import model.User;

import java.util.ArrayList;
import java.util.TreeSet;

public class Data {
    private static Data data;
    TreeSet<Cloth> clothes;
    User subject;
    ArrayList<ClothRating> orderedRecommend;

    public Data() {
        this.clothes =new TreeSet<Cloth>();
        this.subject=new User();
        this.orderedRecommend=new ArrayList<>();
    }

    public ArrayList<ClothRating> getOrderedRecommend() {
        return orderedRecommend;
    }

    public void setOrderedRecommend(ArrayList<ClothRating> orderedRecommend) {
        this.orderedRecommend = orderedRecommend;
    }

    public static Data getData() {
        if (data==null) data=new Data();
        return data;
    }

    public User getSubject() {
        return subject;
    }


    public TreeSet<Cloth> getClothes() {
        return clothes;
    }

}
