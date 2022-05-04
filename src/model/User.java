package model;

import java.util.ArrayList;

public class User implements Comparable {
    private int userID;
    private ArrayList<Integer> reviewed;

    public User() {
        this.reviewed=new ArrayList<>();
    }

    public int getUserID() {
        return userID;
    }

    public ArrayList<Integer> getReviewed() {
        return reviewed;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setReviewed(ArrayList<Integer> reviewed) {
        this.reviewed= reviewed;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.userID, ((User)o).userID);
    }
}
