package com.epam.test.automation.java.practice8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class DepositTest {

    @Test
    public void test0() {
        Deposit deposit = new LongDeposit(BigDecimal.valueOf(2), 3);
        Assert.assertEquals(deposit.getPeriod(), 3);
    }

    @Test
    public void test1() {
        Deposit deposit = new BaseDeposit(BigDecimal.valueOf(2000), 3);
        Assert.assertEquals(deposit.getAmount(), BigDecimal.valueOf(2000));
    }
}