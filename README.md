# Hinton Library CI Demo (Java)

Minimal Java 21 / Maven / JUnit 5 project used in the DevOps lecture (Section 4.4) to show CI with GitHub Actions.

A `Loan` has a 14-day loan period and a late fee of 25 cents per day, capped at $10.00.

## Run locally
    mvn verify
    java -cp target/library-1.0.jar library.Main

## Demo
1. Push to GitHub. The workflow in `.github/workflows/ci.yml` runs and goes green.
2. In `src/main/java/library/Loan.java`, change `Math.min(fee, MAX_FEE_CENTS)` to `Math.max(fee, MAX_FEE_CENTS)`.
3. Push on a branch and open a PR. `lateFeeIsTwentyFiveCentsPerDay` and `lateFeeIsCappedAtTenDollars` both fail.
4. Revert and push. The build goes green.
