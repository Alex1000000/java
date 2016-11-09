package main.java.ru.ncedu.lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Саша on 09.11.2016.
 */
public class IsOddTest {
    @Test
    public void classify() throws Exception {
        int number =3;
        IsOdd objP = new IsOdd();
        Assert.assertEquals("Odd", objP.classify(number));
        Assert.assertEquals("even", objP.classify(4));
    }

}