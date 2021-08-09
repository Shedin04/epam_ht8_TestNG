package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.util.*;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public class Client implements Iterable<Deposit>{
    private final Deposit[] deposits;
    private int num = 0;
    private int index = 0;
    private int count = 0;

    public Client() {
        this.deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit) {
        if (num >= deposits.length) return false;
        if (deposits[num] == null) {
            this.deposits[num] = deposit;
            num++;
        }
        boolean flag = false;
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] != null) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }

    public BigDecimal totalIncome() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] != null) total = total.add(deposits[i].income());
        }
        return total;
    }

    public BigDecimal maxIncome() {
        BigDecimal max = BigDecimal.ZERO;
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] != null && deposits[i].income().compareTo(max) > 0) {
                max = deposits[i].income();
            }
        }
        return max;
    }

    public BigDecimal getIncomeByNumber(int number) {
        if (deposits[number] == null) return BigDecimal.valueOf(0);
        else {
            return deposits[number].income();
        }
    }

    @Override
    public Iterator<Deposit> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < deposits.length && deposits[index] != null;
            }

            @Override
            public Deposit next() {
                if (index >= deposits.length) throw new NoSuchElementException();
                else return deposits[index++];
            }
        };
    }

    public Deposit[] sortDeposits() {
        Arrays.sort(deposits, (o1, o2) -> {
            if (o1 != null && o2!=null)
            { return o2.amount.add(o2.income()).compareTo(o1.amount.add(o1.income())); }
            else  {return (o1 == null) ? 1 : -1; }
        });
        return deposits;
    }

    public int countPossibleToProlongDeposit() {
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] != null && deposits[i].canToProlong()) count++;
        }
        return count;
    }
}