package ru.ncedu.lab;

/**
 * Created by Саша on 03.11.2016.
 */
public class IsOdd implements Classificator{
    public String classify(int number) {
        if (number%2!=0) {
            return "Odd";
        }
        else {
            return "even";

        }
    }
    public IsOdd(){

    }
}
