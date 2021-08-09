package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Client first = new Client();

        System.out.println("\nIterator' test:");

        first.addDeposit(new LongDeposit(BigDecimal.valueOf(3000), 7));
        first.addDeposit(new LongDeposit(new BigDecimal(300), 10));
        first.addDeposit(new SpecialDeposit(new BigDecimal(200), 15));

        System.out.println("Before sort:");
        int i = 0;
        while (first.getIncomeByNumber(i) != BigDecimal.valueOf(0)) {
            System.out.println("Client' deposit " + i + ": " + first.getIncomeByNumber(i++));
        }

        first.sortDeposits();

        System.out.println("After:");

        i = 0;
        while (first.getIncomeByNumber(i) != BigDecimal.valueOf(0)) {
            System.out.println("Client' deposit " + i + ": " + first.getIncomeByNumber(i++));
        }

        System.out.println("How many can prolong? - " + first.countPossibleToProlongDeposit());

    }
}