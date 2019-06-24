package com.metanit;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Set;

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
            //Далее необходимо посчитать частоту вхождений каждого символа файла
            CharacterSearcher Searcher = new CharacterSearcher();
            Searcher.CharacterCnt(FileArray); //Считаем вхождения каждого символа файла в файле
            PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>(10, new NodeComparator()); //очередь узлов с приориетом по убыванию

            //формируем из ассоциативного массива с частотами символов очередь узлов дерева

            Set <Character>keys = Searcher.Map.keySet(); //!Набор всех ключей ассоциативного массива "Символ - частота"
            ArrayList<Character>keysList = new  ArrayList<Character>(); //список ключей
            for (Character key: keys) {
                keysList.add(key); //!формируем список, состоящий из уникальных символов файла
            }

            //Из списка уникальных символов формируем очередь узлов
            for (i = 0; i < keysList.size(); i++){ //копируем
                Character tmp = keysList.get(i);   //!извлекаем текущий символ из массива уникальных символов
                int intTmp = Searcher.Map.get(tmp);//!по этому ключу получаем значение - вес узла
                nodeQueue.add(new Node(Character.toString(tmp), intTmp));//закидываем созданный узел в очередь
            }

            //!формируем дерево
            while(nodeQueue.size() > 1){
                Node tmp1 = null;
                Node tmp2 = null;
                //Извлекаем два элемента с наименьшим приоритетом
                tmp1 = nodeQueue.poll();
                tmp2 = nodeQueue.poll();

                int summWeight = tmp1.getWeight() + tmp2.getWeight(); //суммируем веса узлов
                String nodeName = tmp1.getNodeName() + tmp2.getNodeName(); //имя нового узла
                Node tmp3 = new Node(nodeName, summWeight);
                tmp3.setLeftChildNode(tmp1);
                tmp3.setRightChildNode(tmp2);
                nodeQueue.add(tmp3);
            }

            Node temp = nodeQueue.poll();
            Node tempLeft = temp.getLeftChildNode();
            Node tempRight = temp.getRightChildNode();

            System.out.println(tempLeft.getNodeName());
            System.out.println(tempRight.getNodeName());



        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
