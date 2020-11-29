package com.company;

public class Strings {
    //Field
    private String s;
    //Конструкторы
    public Strings(){
        s ="";
    }
    public Strings(String s){
        this.s = s ;
    }
    public Strings(Strings clone){
        this.s = clone.s;
    }
    //Getters and Setters
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    //Метод поиска и подсчета гласных
    public int  Vowel() {
        int count = 0;
        s=s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'y' || s.charAt(i) == 'u' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'a') {
                count++;
            }
        } return count;
    }
    //Метод переворачивания слов в предложении в обратном порядке
    public String opposite() {
        String[] sentence = s.split(" ");
        String change;
        for (int i = sentence.length-1, j = 0; i >=sentence.length/2 ; i--,j++) {
            change = sentence[j];
            sentence[j] = sentence[i];
            sentence[i] = change;
        }
        StringBuffer str = new StringBuffer(" ");
        for (int i = 0; i < sentence.length; i++) {
            str.append(sentence[i]).append(" ");
        }
        return str.toString();
    }

}


