package library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class LoanTest {

    private final LocalDate checkout = LocalDate.of(2026, 11, 2);
    private final Loan loan = new Loan("The Tortoise and the Hare", checkout);

    @Test
    void dueDateIsTwoWeeksAfterCheckout() {
        assertEquals(LocalDate.of(2026, 11, 16), loan.dueDate());
    }

    @Test
    void onTimeReturnHasNoFee() {
        assertEquals(0, loan.lateFeeCents(LocalDate.of(2026, 11, 16)));
        assertEquals(0, loan.lateFeeCents(LocalDate.of(2026, 11, 10)));
    }

    @Test
    void lateFeeIsTwentyFiveCentsPerDay() {
        // 3 days late
        assertEquals(75, loan.lateFeeCents(LocalDate.of(2026, 11, 19)));
    }

    @Test
    void lateFeeIsCappedAtTenDollars() {
        // 60 days late would be $15.00 without the cap
        assertEquals(1000, loan.lateFeeCents(LocalDate.of(2027, 1, 15)));
    }
}
