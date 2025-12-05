package TP6.ex8;

import java.util.HashMap;


public class Document {
    private String content;   
    private HashMap<String, Double> frequencies;
      
    Document(String content){
        this.content = content;
        String[] worldList = preProcess();  
        for (String s: worldList){
            double freq = frequencies.get(s);
            if (freq instanceof Double){
                frequencies.put(s, freq+1.0/worldList.length);
            } else {
                frequencies.put(s, 1.0/worldList.length);
            }
        }
    }

    public String repr(){
        return content.split("\n",2)[0];
    }

    public String[] preProcess(){
        return content.toLowerCase().split("\s|\n");
    }

}
