package TP6.gps;

public class CityId {
    private String name;
    CityId(String name) {
        this.name  = name;
    } 

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CityId){
            return (((CityId)obj).name.equals(name));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
