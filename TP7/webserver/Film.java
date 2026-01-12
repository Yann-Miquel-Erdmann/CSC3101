package TP7.webserver;

public class Film {
    private String title;
    private int year;   

    public Film(String title, int year){
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " ("+year+")";
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Film) ){
            return false;
        }
    
        return title.equals(((Film) obj).title) && (year == ((Film)obj).year); 

    }

    @Override
    public int hashCode() {
        return year + title.hashCode();
    }

    public String asHTML(){
        return "<a href='/"+title.replace(" ", "%20")+"/"+year+"'>"+toString()+"</a>";
    }

}
