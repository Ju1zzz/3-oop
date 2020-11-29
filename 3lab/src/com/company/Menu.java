package com.company;
import java.util.Scanner;

public class Menu {
    public static Scanner scan;

    public Menu() {
    }

    public static int ReadInt() {
        int read= -1;

        try {
            read = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException var2) {
            System.out.println("Вводите только числа!");
            ReadInt();
        }

        return read;
    }

    public static void MainMenu() {

        int w;
        do {
            System.out.println("Главное меню");
            System.out.println("1 - Выполнить первое задание");
            System.out.println("-- Дан массив чисел, знак операции и операнд. Выведите на печать\nмассив, полученный в результате арифметического действия, совершенного над элементами массива. ");
            System.out.println("2 - Выполнить второе задание");
            System.out.println("-- Подсчитайте количество гласных букв в заданном тексте.");
            System.out.println("3 - Выполнить третье задание");
            System.out.println("-- Переставьте слова в предложении в обратном порядке.");
            System.out.println("0 - Выход из программы");
            w = ReadInt();
            switch(w) {
                case 0:
                    break;
                case 1:
                    subMenu1();
                    break;
                case 2:
                    subMenu2();
                    break;
                case 3:
                    subMenu3();
                    break;
                default:
                    System.out.println("Ошибка, введите 1, 2, 3 или 0");
            }
        } while(w != 0);

    }

    public static void Print() {
        System.out.println("1 - Ввести данные с клавиатуры");
        System.out.println("2 - Считать данные из файла");
        System.out.println("0 - Выход");
    }

    public static void PrintOut() {
        System.out.println("Сохранить массив в файл?");
        System.out.println("1 - да, 0 - выход");
    }
    public static int Positive ()
    {   int pos;
        pos = scan.nextInt();
        if ( pos <= 0)
        {throw new NegativeArraySizeException(" Вводите только положительное число");}
        return pos;
    }

    public static void subMenu1() {
        Array a = new Array();
        Print();
        int w = ReadInt();
        int k;
        String nameto;
        switch(w) {
            case 0:
                break;
            case 1:
                System.out.print("Введите размерность массива");
                int plus = Positive();
                a.setSize(plus);
                System.out.print("Введите оператор и операнд");
                a.setSign(scan.next());
                System.out.print("Введите массив ");
                float[] arr1 = new float[a.getSize()];

                for(k = 0; k < a.getSize(); ++k) {
                    arr1[k] = (float)scan.nextInt();
                }
                a.setArray(arr1);
                System.out.print("Массив ");
                a.mathAct();
                System.out.println(a.toString());
                PrintOut();
                k = ReadInt();
                switch(k) {
                    case 0:
                    default:
                        return;
                    case 1:
                        System.out.println("Введите имя файла или места, где нужно создать файл");
                        nameto = scan.nextLine();
                        Files.saveArray(a.mathAct(), nameto);
                        return;
                }
            case 2:
                System.out.println("Введите имя файла или местo");
                String namefrom = scan.nextLine();
                Array Input = Files.arrayFromFILE(namefrom);
                System.out.print("Массив ");
                Input.mathAct();
                System.out.println(Input.toString());
                PrintOut();
                k = ReadInt();
                switch(k) {
                    case 0:
                    default:
                        return;
                    case 1:
                        System.out.println("Введите имя файла или места, где нужно создать файл");
                         nameto = scan.nextLine();
                        Files.saveArray(Input.mathAct(), nameto);
                        return;
                }
            default:
                System.out.println("Ошибка, введите 1, 2 или 0");
        }

    }

    public static void subMenu2() {
        Strings b = new Strings();
        System.out.println("1 - Ввести данные с клавиатуры");
        System.out.println("2 - Считать данные из файла");
        System.out.println("0 - Выход");
        int w = ReadInt();
        int k;
        switch(w) {
            case 0:
                break;
            case 1:
                Scanner sc = new Scanner(System.in);
                System.out.print("Введите предложение");
                b.setS(sc.nextLine());
                System.out.println("Количество гласных в заданном тексте: " + b.Vowel());
                PrintOut();
                k = ReadInt();
                switch(k) {
                    case 0:
                    default:
                        return;
                    case 1:
                        Files.save(b.Vowel());
                        return;
                }
            case 2:
                b.setS(Files.strFromFile());
                System.out.println(b.Vowel());
                PrintOut();
                k = ReadInt();
                switch(k) {
                    case 0:
                    default:
                        return;
                    case 1:
                        Files.save(b.Vowel());
                        return;
                }
            default:
                System.out.println("Ошибка, введите 1, 2 или 0");
        }

    }

    public static void subMenu3() {
        Strings c = new Strings();
        System.out.println("1 - Ввести данные с клавиатуры");
        System.out.println("2 - Считать данные из файла");
        System.out.println("0 - Выход");
        int w = ReadInt();
        int k;
        switch(w) {
            case 0:
                break;
            case 1:
                System.out.print("Введите предложение");
                c.setS(scan.nextLine());
                System.out.println(c.opposite());
                PrintOut();
                k = ReadInt();
                switch(k) {
                    case 0:
                    default:
                        return;
                    case 1:
                        Files.saver(c.opposite());
                        return;
                }
            case 2:
                c.setS(Files.strFromFile());
                System.out.println(c.opposite());
                PrintOut();
                k = ReadInt();
                switch(k) {
                    case 0:
                    default:
                        return;
                    case 1:
                        Files.saver(c.opposite());
                        return;
                }
            default:
                System.out.println("Ошибка, введите 1, 2 или 0");
        }

    }

    static {
        scan = new Scanner(System.in);
    }
}
