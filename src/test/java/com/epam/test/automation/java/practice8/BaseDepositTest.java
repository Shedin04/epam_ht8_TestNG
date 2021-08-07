package com.epam.test.automation.java.practice8;

import org.testng.*;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class BaseDepositTest {

    @Test
    public void test1(){
        BaseDeposit base = new BaseDeposit(BigDecimal.valueOf(1000),1);
        Assert.assertEquals(base.income(), BigDecimal.valueOf(50).setScale(2));
    }

    @Test
    public void test2(){
        BaseDeposit base = new BaseDeposit(BigDecimal.valueOf(1000),2);
        Assert.assertEquals(base.income(),BigDecimal.valueOf(102.50).setScale(2));
    }

    @Test
    public void test3(){
        BaseDeposit base = new BaseDeposit(BigDecimal.valueOf(3000),6);
        Assert.assertEquals(base.income(),BigDecimal.valueOf(1020.29).setScale(2));
    }
}