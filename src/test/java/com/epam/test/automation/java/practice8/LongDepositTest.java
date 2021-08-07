package com.epam.test.automation.java.practice8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class LongDepositTest {

    @Test
    public void test1(){
        LongDeposit longdep = new LongDeposit(BigDecimal.valueOf(1000),6);
        Assert.assertEquals(longdep.income(), BigDecimal.valueOf (0));
    }

    @Test
    public void test2(){
        LongDeposit longdep = new LongDeposit(BigDecimal.valueOf(1000),7);
        Assert.assertEquals(longdep.income(),BigDecimal.valueOf (150).setScale(2));
    }

    @Test
    public void test3(){
        LongDeposit longdep = new LongDeposit(BigDecimal.valueOf(1000),8);
        Assert.assertEquals(longdep.income(),BigDecimal.valueOf (322.5).setScale(2));
    }
}