package library;

import java.time.LocalDate;

/** Prints a sample return receipt so the packaged .jar does something visible. */
public class Main {
    public static void main(String[] args) {
        Loan loan = new Loan("The Tortoise and the Hare", LocalDate.of(2026, 11, 2));
        LocalDate returned = LocalDate.of(2026, 11, 19);
        System.out.println("Title:    " + loan.getTitle());
        System.out.println("Due:      " + loan.dueDate());
        System.out.println("Returned: " + returned);
        System.out.println("Overdue:  " + loan.daysOverdue(returned) + " days");
        System.out.printf("Late fee: $%.2f%n", loan.lateFeeCents(returned) / 100.0);
    }
}
