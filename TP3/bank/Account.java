package TP3.bank;

public class Account {
    String name;
    double balance;

    public static Account create(String name) {
        Account acc = new Account();
        acc.name = name;
        acc.balance = Math.floor(Math.random() * 100);
        return acc;
    }

    public void display() {
        System.out.println(this.name + ": € " + this.balance);
    }

    public int compareTo(String name){
        // int max_index = Math.min(name.length(), acc2.name.length());
        // // System.out.println(max_index);
        // int i = 0;

        // while ((i < max_index) && (acc2.name.charAt(i) == this.name.charAt(i))){
        //     i++;
        // }
        // i++;


        // if ((i == max_index + 1) && (acc2.name.length() == this.name.length())){
            
        //     return 0;
            
        // }

        // if (acc2.name.length() < name.length()){
        //     return i;
        // } else {
        //     return -i;
        // }
        
        return this.name.compareTo(name);

    }

}
