package model;

public class Cloth implements Comparable {
    private int clothwID;
    private int usersNum;
    private double ratingSum;

    public Cloth(int clothwID) {
        this.clothwID = clothwID;
    }

    public void setClothwID(int clothwID) {
        this.clothwID = clothwID;
    }

    public int getUsers() {
        return usersNum;
    }

    public void setUsers(int users) {
        this.usersNum = users;
    }

    public double getRatingSum() {
        return ratingSum;
    }

    public void setRatingSum(double ratingSum) {
        this.ratingSum = ratingSum;
    }

    public int getClothwID() {
        return clothwID;
    }


    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.clothwID, ((Cloth) o).clothwID);
    }
}
