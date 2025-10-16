package EX8;

public class Palindrome {
    static void printWord(char[] word){
        for (int i = 0; i<word.length; i++){
            System.out.print(word[i]);
        }
        System.out.println();
    }

    static void printWords(char[][] words){
        for (int i = 0; i< words.length; i++){
            printWord(words[i]);
        }
    }

    static Boolean isPalindrome(char[] word){
        for (int i = 0; i< word.length/2; i++){
            if (word[i] != word[word.length -1 -i]){
                return false;
            }
        }   
        return true;
    }

    static void printPalindromes(char[][] words){
        for (int i = 0; i<words.length; i++){
            if (isPalindrome(words[i])){
                printWord(words[i]);
            }
        }
    }

    static void reverseWord(char[] word){
        for (int i = 0; i< word.length/2; i++){
            char t = word[i];
            word[i] = word[word.length -1 -i];
            word[word.length -1 -i] = t;
        }
    }

    static void reverseWords(char[][] words){
        for (int i = 0; i< words.length; i++){
            reverseWord(words[i]);
        }
    }

    public static void main(String[] args) {
        char[][] words = {{ 'a', 'n', 'i', 'm', 'a', 'l' }, { 'r', 'a', 'd', 'a', 'r' } , { 'r', 'e', 's', 'u', 'm', 'a' }, { 'r', 'e', 's', 's', 'a', 's', 's', 'e', 'r' },{ 'r', 'e', 'l', 'a', 'c', 'e', 'r' },{ 'k', 'a', 'y', 'a', 'k' },{ 'v', 'i', 'v', 'e', ' ', 'J', 'a', 'v', 'a', ' ', '!' }};
        printWords(words);
        System.out.println("isPalindrome(words[0]): " + isPalindrome(words[0]));
        System.out.println("isPalindrome(words[1]): " + isPalindrome(words[1]));
        printPalindromes(words);
        reverseWord(words[0]);
        printWord(words[0]);
        reverseWords(words);
        printWords(words);
    }    
}
