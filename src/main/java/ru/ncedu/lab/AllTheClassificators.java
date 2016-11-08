package ru.ncedu.lab;

import java.util.Collection;
import java.util.List;

/**
 * Created by Саша on 04.11.2016.
 */
public class AllTheClassificators implements Classificator{

    private List<Classificator> classificators;

    public void setClassificators(List<Classificator> classificators){
        this.classificators=classificators;
    }

    public String classify(int number) {
        String allClassify ="";
        for (Classificator c: classificators ){
            allClassify=allClassify+"    "+c.classify(number);
        }
        return  allClassify;
    }
    public AllTheClassificators(){

    }




}
