package com.company;

import java.io.*;
import java.util.Scanner;

public class Files {
    public static Scanner scan = new Scanner(System.in);
    public static Array arrayFromFILE (String namefrom){
        Array arr = null;
        try (BufferedReader br = new BufferedReader(new FileReader(namefrom))){
            String [] data = br.readLine().split(";");
            int size = Integer.parseInt(data[0]);
            float[] temp = new float[size];
            String sign ="";
            sign+=data[1];
            for (int i = 0; i< size; i++){
                temp[i] = Float.parseFloat(data[i+2]);
            }
            arr = new Array(temp,sign);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static String strFromFile () {
        System.out.println("Введите имя файла");
        String namefrom = scan.nextLine();
        String rezult = null;
        try (BufferedReader r = new BufferedReader(new FileReader(namefrom))) {
            StringBuffer st= new StringBuffer(" ");
            String s = r.readLine();
            for (int i = 0; i< s.length(); i ++){
                st.append(s.charAt(i));
            }
            rezult= st.toString();
        }
        catch (NullPointerException e) {
            System.out.println("Файл пустой"); strFromFile();
        }
        catch (IOException e) {
            System.out.println("Ошибка в чтение файла"); strFromFile();
        }
        return rezult;
    }


    public static void saveArray (float [] array, String filename1) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename1)))
        {
            for (var v : array) {
                dos.writeFloat(v);
            }
            System.out.println("Сохранено в файл: " + filename1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Файл не найден");
        } catch (IOException ioException) {
            System.out.println("Ошибка записи");
        }
    }

    public static void save(int count) {
        System.out.println("Введите имя файла или места, где нужно создать файл");
        String nameto = scan.nextLine();
        try {
            FileOutputStream fos = new FileOutputStream(nameto);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(count);
            System.out.println("Сохранено в файл: " + nameto);
            pw.close();
            fos.close();
        }catch (IOException e) {
            System.out.println("Ошибка записи");

        }
    }

    public static void saver(String str) {
        System.out.println("Введите имя файла или места, где нужно создать файл");
        String nameto = Menu.scan.nextLine();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nameto))){
            br.write(str);
            System.out.println("Строка" + str);
            System.out.println("Сохранено в файл: " + nameto);
        }catch (IOException e) {
            System.out.println("Ошибка записи");

        }
    }

}
