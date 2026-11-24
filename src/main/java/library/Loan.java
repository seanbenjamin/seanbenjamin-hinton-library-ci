package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/** A book loan at the Hinton Library. Fees are in cents to avoid rounding errors. */
public class Loan {

    public static final int LOAN_PERIOD_DAYS = 14;
    public static final int DAILY_FEE_CENTS = 25;
    public static final int MAX_FEE_CENTS = 1000;

    private final String title;
    private final LocalDate checkoutDate;

    public Loan(String title, LocalDate checkoutDate) {
        this.title = title;
        this.checkoutDate = checkoutDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate dueDate() {
        return checkoutDate.plusDays(LOAN_PERIOD_DAYS);
    }

    public long daysOverdue(LocalDate returnDate) {
        long days = ChronoUnit.DAYS.between(dueDate(), returnDate);
        return Math.max(days, 0);
    }

    /** 25 cents per day overdue, capped at $10.00. */
    public int lateFeeCents(LocalDate returnDate) {
        long days = daysOverdue(returnDate);
        if (days == 0) {
            return 0;
        }
        long fee = days * DAILY_FEE_CENTS;
        return (int) Math.max(fee, MAX_FEE_CENTS);
    }
}
