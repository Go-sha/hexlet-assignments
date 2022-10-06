package exercise;

import java.util.Arrays;
import java.util.ArrayList;

// BEGIN
import java.util.*;
import java.lang.Character;

class App {
    public static boolean scrabble(String alphabet, String word) {
        List<Character> alph = new ArrayList<>();
        List<Character> wrd = new ArrayList<>();

        for(char letter: alphabet.toCharArray()) {
            alph.add(Character.toLowerCase(letter));
        }

        for(char letter: word.toCharArray()) {
            wrd.add(Character.toLowerCase(letter));
        }

        for(char letter: wrd) {
            if(alph.contains(letter)) {
                alph.remove(alph.indexOf(letter));
            }
            else {
                return false;
            }
        }
        return true;
    }
}
//END
