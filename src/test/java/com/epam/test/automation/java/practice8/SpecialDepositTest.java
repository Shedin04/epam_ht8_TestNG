package com.epam.test.automation.java.practice8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class SpecialDepositTest {

    @Test
    public void test1(){
        SpecialDeposit specialdep = new SpecialDeposit(BigDecimal.valueOf(1000),1);
        Assert.assertEquals(specialdep.income(), BigDecimal.valueOf(10).setScale(2));
    }

    @Test
    public void test2(){
        SpecialDeposit specialdep = new SpecialDeposit(BigDecimal.valueOf(1000),2);
        Assert.assertEquals(specialdep.income(), BigDecimal.valueOf(30.2).setScale(2));
    }
}