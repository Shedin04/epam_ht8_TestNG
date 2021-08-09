package com.epam.test.automation.java.practice8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ClientTest {

    @Test
    public void test1(){
        Client client = new Client();
        boolean actually = client.addDeposit(new SpecialDeposit(BigDecimal.ONE, 1));
        Assert.assertTrue(actually);
    }

    @Test
    public void test2(){
        Client first = new Client();
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(1000), 3));
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(2000), 3));
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(3000), 3));
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(4000), 3));
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(5000), 3));
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(6000), 3));
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(7000), 3));
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(8000), 3));
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(9000), 3));
        boolean actually =  first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(10000), 3));
        Assert.assertFalse(actually);
    }

    @Test
    public void test3(){
        Client first = new Client();
        first.addDeposit(new SpecialDeposit(BigDecimal.valueOf(1000), 1));
        System.out.println("TOTAL = " + first.totalIncome());
        first.addDeposit(new BaseDeposit(BigDecimal.valueOf(2000), 3));
        first.addDeposit(new LongDeposit(BigDecimal.valueOf(3000), 7));
        Assert.assertEquals(first.totalIncome(), BigDecimal.valueOf(10+100+105+110.25+450).setScale(2));
    }

    @Test
    public void test4(){
        Client first = new Client();
        first.addDeposit(new LongDeposit(BigDecimal.valueOf(1000), 1));
        first.addDeposit(new BaseDeposit(BigDecimal.valueOf(2000), 2));
        first.addDeposit(new LongDeposit(BigDecimal.valueOf(3000), 7));
        Assert.assertEquals(first.totalIncome(),BigDecimal.valueOf(100+105+450).setScale(2));
        Assert.assertEquals(first.maxIncome(),BigDecimal.valueOf(450).setScale(2));
        Assert.assertEquals(first.getIncomeByNumber(1),BigDecimal.valueOf(100+105).setScale(2));
    }

    @Test
    public void test5(){
        Client first = new Client();
        first.addDeposit(new LongDeposit(new BigDecimal(100), 8));
        first.addDeposit(new BaseDeposit(new BigDecimal(200), 4));
        first.addDeposit(new SpecialDeposit(new BigDecimal(10000), 4));
        Assert.assertEquals(first.countPossibleToProlongDeposit(), 2);
    }

    @Test
    public void test6(){
        Client first = new Client();
        first.addDeposit(new BaseDeposit(new BigDecimal(4000), 2));
        first.addDeposit(new LongDeposit(new BigDecimal(300), 10));
        first.addDeposit(new SpecialDeposit(new BigDecimal(200), 15));
        first.sortDeposits();
        Assert.assertEquals(first.getIncomeByNumber(2), new BigDecimal(224.68).setScale(2, RoundingMode.HALF_EVEN));
    }
}