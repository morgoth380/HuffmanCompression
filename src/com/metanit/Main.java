package com.metanit;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	ArrayList <String> FileArray = new ArrayList<String>(); //контейнер для считываемых с сжимаемого файла строк

        try {
            FileInputStream fstream = new FileInputStream("testFile.txt"); //сжимаемый файл
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int i = 0;
            while ((strLine = br.readLine()) != null){ //!Читаем построчно файл
                FileArray.add(strLine); //!Сохраняем считанную строку во временном массиве строк
                i++; //после выхода из цикла i будет равно коли количеству считанных строк
            }
            System.out.println(i);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
