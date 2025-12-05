package TP6.gps;

public class Location {
    private double latitude;
    private double longitude;

    Location(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;

    }

    @Override
    public String toString() {
        return latitude + ", " + longitude;
    }

}
