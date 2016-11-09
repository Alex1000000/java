package main.java.ru.ncedu.lab;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Саша on 09.11.2016.
 */
public class AllTheClassificatorsTest {
    @Test
    public void classify() throws Exception {
        AllTheClassificators allClass = mock(AllTheClassificators.class);
        ArrayList<Classificator> listClss = new ArrayList<Classificator>();
        IsOdd objIs = new IsOdd();
        listClss.add(objIs);
        IsMyFavorite objIs2 = new IsMyFavorite();
        listClss.add(objIs2);
        IsDividedThree objIs3 = new IsDividedThree();
        listClss.add(objIs3);
        allClass.setClassificators(listClss);
        allClass.classify(3);
        verify(allClass).classify(3);

    }

}