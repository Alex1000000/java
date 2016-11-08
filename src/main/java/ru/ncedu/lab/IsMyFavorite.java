package ru.ncedu.lab;
import java.util.*;

/**
 * Created by Саша on 03.11.2016.
 */
public class IsMyFavorite implements Classificator {
    public String classify(int number) {
        int count[] = {42, 3, 9, 7, 14, 94};
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 5; i++) {
            set.add(count[i]);
        }
        if (set.contains(number)) {
            return "My favorite";
        } else {
            return "Not my favorite";
        }
    }
    public IsMyFavorite(){

    }
}
