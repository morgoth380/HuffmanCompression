package com.metanit;

import java.util.ArrayList;

public class CharacterSearcher {
    String tmp;
    char tmpChar;
    public void CharacterCnt(ArrayList<String> FileArray){
        for(int i = 0; i < FileArray.size(); i++){
            tmp = FileArray.get(i); //!берем текущую строку массива строк

            for(int j = 0; j < tmp.length(); j++){
                tmpChar = tmp.charAt(j);
                for(int k = j; k < tmp.length(); k++){

                }
            }
        }

    }
}
