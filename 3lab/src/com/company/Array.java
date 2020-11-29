package com.company;

import java.util.Scanner;

class Array {
    //Поля
    private float[] array;
    private int size;
    private String sign;
    //Конструкторы
    public Array(){
        this (2);
        array = new float[size];
        sign="+2";
    }
    public Array(int size){
        this.size = size;
        array = new float[size];
        sign="+2";
    }
    public Array(String sign){
        size=2;
        array = new float[size];
        this.sign = sign;
    }
    public Array(int size, String sign){
        this.size = size;
        this.sign =sign;
        array = new float[size];
    }
    public Array(float[] array, String sign){
        this.array = array;
        this.sign = sign;
        this.size = array.length;
    }
    public Array(Array input){
        this.size = input.size;
        this.sign =input.sign;
        array = new float[input.size];
        for(int i = 0; i < input.size; i++){
            array[i]=input.array[i];
        }
    }

    public Array(float[] readable) {
    }

    //Getters and Setters
    public void setSign(String sign) {
        this.sign = sign;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
        this.array = new float[this.size];
    }
    public void setArray(float [] array){
        for(int i = 0; i < this.size; i++){
            this.array[i]=array[i];
        }
    }

    public float[] getArray() {
        return this.mathAct();
    }

    //Метод, выводящий размер массива
    public static void Print(int size) {
        System.out.print(size+" ");
    }
    // Метод для работы с массивом
    public float [] mathAct() {
        char[] mark = sign.toCharArray();
        char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char act = '0';
        for (char c : mark) {
            if (c == '+') {
                act = '+';
                break;
            }
            if (c == '-') {
                act = '-';
                break;
            }
            if (c == '*') {
                act = '*';
                break;
            }
            if (c == '/') {
                act = '/';
                break;
            }
        }
        String digit ="";
        for (char c : mark) {
            for (char value : digits) {
                if (value == c) {
                    digit += value;
                    break;
                }
            }
        }
        if (digit.equals("/0"))
        {
            throw new ArithmeticException("Попытка деления на 0");
        }
        int number = Integer.parseInt(digit);
        switch (act) {
            case '+' -> {
                for (int i = 0; i < this.getSize(); i++) {
                    this.array[i] += number;
                }
            }
            case '-' -> {
                for (int i = 0; i < this.getSize(); i++) {
                    this.array[i] -= number;
                }
            }
            case '*' -> {
                for (int i = 0; i < this.getSize(); i++) {
                    this.array[i] *= number;
                }
            }
            case '/' -> {
                for (int i = 0; i < this.getSize(); i++) {
                    this.array[i] /= number;
                }
            }
        }
        return array;
    }
    @Override
    public String toString()
    {
        StringBuilder line = new StringBuilder("");
        for (int i =0; i< this.size; i++)
        {
            line.append(this.array[i]).append(" ");
        } return line.toString();
    }
}