package ru.ncedu.lab;

/**
 * Created by Саша on 04.11.2016.
 */
public class IsDividedThree implements Classificator{
    public String classify(int number) {
        if (number%3==0) {
            return "Divided_By_Three";
        }
        else {
            return "Not_Divided_by_Three";

        }
    }
    public IsDividedThree(){

    }
}
