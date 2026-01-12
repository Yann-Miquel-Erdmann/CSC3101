package TP7.webserver;

import java.util.ArrayList;
import java.util.Collection;

public class Recommendations {
    private Collection<String> recommendations;

    public Recommendations() {
        recommendations = new ArrayList<>();
    }

    public void addRecommendation(String recommendation) {
        recommendations.add(recommendation);
    }

    @Override
    public String toString() {
        String res = new String();

        for (String s : recommendations) {
            res += s + System.lineSeparator();
        }
        return res;

    }

    public String asHTML() {
        String response = "<ul>";

        for (String s : recommendations) {
            response += "<li> " + s + "</li>" + System.lineSeparator();
        }

        response += "</ul>";
        return response;
    }

}
