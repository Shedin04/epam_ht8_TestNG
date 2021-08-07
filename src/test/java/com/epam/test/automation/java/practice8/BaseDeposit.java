package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public class BaseDeposit extends Deposit {
    BaseDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        int i = 0;
        BigDecimal income = BigDecimal.ZERO;
        BigDecimal tempamount = amount;
        while (i<period){
            BigDecimal temp = tempamount.multiply(BigDecimal.valueOf(0.05));
            tempamount = tempamount.add(temp);
            income = income.add(temp);
            i++;
        }
        return income.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean canToProlong() {
        return false;
    }
}