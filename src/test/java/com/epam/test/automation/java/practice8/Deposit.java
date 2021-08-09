package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public abstract class Deposit implements Comparable<Deposit>,Prolongable {
    public final BigDecimal amount;
    public final int period;

    Deposit(BigDecimal amount , int period) {
        this.amount = amount ;
        this.period = period;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "amount=" + amount +
                ", income=" + income() +
                ", period=" + period +
                '}';
    }

    public abstract BigDecimal income();

    @Override
    public boolean equals(Object obj){return true;}

    @Override
    public int hashCode() {return 0;}

    @Override
    public int compareTo(Deposit o){
        return (getAmount().add(income())).compareTo((o.getAmount().add(o.income())));
    }
}