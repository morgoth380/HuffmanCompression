package com.metanit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CharacterSearcher {
    String tmpString;
    char tmpChar;
    int cnt = 0;
    ArrayList<Character>keyMap = new ArrayList<Character>(); //контейнер массива ключей
    public HashMap<Character, Integer> Map = new HashMap<Character, Integer>(); //массив для хранения количества вхождений каждого символа

    //Функция подсчета количества всех симолов, из которых состоит файл
    public void CharacterCnt(ArrayList<String> FileArray){
        HashMap<Character, Integer> TmpMap = null; //временный массив для хранения уже посчитанных при текущем проходе символов
        //Цикл перебора строк файла
        for(int i = 0; i < FileArray.size(); i++){
            tmpString = FileArray.get(i); //!берем текущую строку из массива строк
            TmpMap = new HashMap<Character, Integer>(); //временный массив
            //цикл обработки строки. Считаем количество всех символов, из которых состоит текущая строка
            for(int j = 0; j < tmpString.length(); j++){
                tmpChar = tmpString.charAt(j); //читаем очередной символ массива строк
                if(TmpMap.get(tmpChar)== null){//если данный символ в текущей строке еще не искали
                    //цикл подсчета количества вхождений текущего взятого символа tmpChar
                    for(int k = j; k < tmpString.length(); k++){
                        if(tmpString.charAt(k) == tmpChar){
                            cnt++;
                        }
                    }
                    TmpMap.put(tmpChar, cnt); //запоминаем, что данный символ в текущей строке уже искали
                    if(cnt != 0){ //если искомый символ найден...
                        if(Map.get(tmpChar)!= null){//..и его находили ранее..
                            cnt+=Map.get(tmpChar); //приращаем счетчик вхождений символа
                        }
                        Map.put(tmpChar, cnt);//сохраняем количество вхождений текущего символа в строке
                        cnt = 0; //сброс счетчика перед поиском следующего символа
                    }
                }
            }
        }
    }
}
