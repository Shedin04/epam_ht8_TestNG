package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BaseDeposit base = new BaseDeposit(new BigDecimal(3000), 6);
        System.out.println(base.income());

        SpecialDeposit special = new SpecialDeposit(BigDecimal.valueOf(1001),2);
        System.out.println("Special amount: " + special.amount);
        System.out.println("Can prolong? - " + special.canToProlong());
        System.out.println("Special income: " + special.income());

        System.out.println("\nClient tests");
        Client first = new Client();
        first.addDeposit(new LongDeposit(new BigDecimal(3000), 36));
        first.addDeposit(new BaseDeposit(new BigDecimal(200), 4));
        first.addDeposit(new SpecialDeposit(new BigDecimal(10000), 4));
        System.out.println("Can prolong? - " + (new LongDeposit(BigDecimal.valueOf(1001), 35)).canToProlong());
        System.out.println("Total income: " + first.totalIncome());

        System.out.println("\nIterator' test:");

        int i = 0;
        while (first.getIncomeByNumber(i) != BigDecimal.valueOf(0)) {
            System.out.println("Client' deposit " + i + ": " + first.getIncomeByNumber(i++));
        }

        System.out.println("Sorted: ");
        System.out.println(first.sortDeposits());

        System.out.println("How much can prolong? - " + first.countPossibleToProlongDeposit());

    }
}