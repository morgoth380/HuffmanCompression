package com.metanit;

import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Serializer {

    //преобразование дерева в последовательность битов
    //nodeQueue - дерево
    //FileArray - исходный массив строк файла
    public void serialize(PriorityQueue<Node> nodeQueue, ArrayList<String> FileArray){
        for(int i = 0; i < FileArray.size(); i++){ //Извлекаем строки
            String tmp = FileArray.get(i); //
            char tmpChar;
            Node generalNode = nodeQueue.poll(); //!Корень дерева
            for(int j = 0; j < tmp.length(); j++){ //проходимся по всем символам текущей извлеченной строки
                tmpChar = tmp.charAt(j); //Проходимся по всем символам строки
                serialize(Character.toString(tmpChar), generalNode);
            }
        }

    }

    //метод поиска символа. вызывается рекурсивно
    private boolean serialize(String tmpChar, Node node){
        if((node.getRightChildNode() == null) && (node.getLeftChildNode() == null)){ //если текущий объект - это лист
            if(node.getNodeName() == tmpChar){ //если нашли элемент
                return(true);
            }else{ //!иначе, текущий лист - это не искомый элемент
                return(false);
            }
        }else{ //иначе, текущий объект - это узел. Он имеет двух детей
            if(serialize(tmpChar, node.getLeftChildNode())){ //!если нашли элемент слева
                char serial = serial << 1;
                k++; //приращаем позицию
            }else if(serialize(tmpChar, node.getRightChildNode())){
                char serial = serial << 1;
                serial |= (1 << k);
                k++;
            }
        }
    }

}
