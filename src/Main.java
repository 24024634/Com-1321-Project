import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;


class FinancialPlanner {

    public static double calculateTax(double grossIncome, double taxRate) {
        return grossIncome * (taxRate / 100);
    }

    //calculation of total living expenditure

    public static double calculateExpenses(double[] expenses) {
        double totalLivingExpenditure = 0;
        for (int i=0;i<expenses.length;i++) {
            totalLivingExpenditure += expenses[i];
        }

        return totalLivingExpenditure;
    }

    //calculation of the home loan

    public static double calculateHomeLoan(double Price, double deposit, double interestRate, int months) {
        double loanAmount = Price - deposit;
        double InterestRate = interestRate / 100 / 12;
        return (loanAmount * InterestRate) / (1 - Math.pow(1 + InterestRate, -months));
    }

    //calculation of the car loan

    public static double carMonthlyPayment (double purchasePrice, double deposit, double interestRate, int months) {

        {
            double loanAmount = purchasePrice - deposit;
            double monthlyInterestRate = interestRate / 100 / 12;
            double carMonthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months));

            return carMonthlyPayment;
        }
    }
    /*
     * This program is designed to help users plan their monthly financial goals by calculating their net income and comparing it against their monthly expenses.
     *
     * 1. The user inputs their gross income (before tax) and the tax rate, which is then used to calculate the net income after tax.
     * 2. The user is asked to enter their monthly expenses across various categories like groceries, utilities, travelling, telecommunications, insurance, savings, and healthcare.
     * 3. Each expense is stored in an array for later financial planing.
     *
     * Methods:
     * - calculateTax: This method calculates the total tax based on the user's net income after tax.
     * - Main method: Asks the user for inputs, calculates tax, net income, and collects their expenses for financial their financial planner.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your monthly financial goal plan!");

        System.out.print("Enter monthly income before tax: ");
        double grossIncome = scanner.nextDouble();

        //Salary after tax

        System.out.print("Enter the tax rate (in%)? ");
        double taxRate = scanner.nextDouble();

        double tax = calculateTax(grossIncome, taxRate);
        double netIncome = grossIncome - tax;

        //User input of expenses

        System.out.println("\nEnter your expenses");


        double[] expenses = new double[7];

        System.out.print("Enter your monthly grocery expenses: ");
        expenses[0] = scanner.nextDouble();

        System.out.print("Enter your monthly water and electricity expenses: ");
        expenses[1] = scanner.nextDouble();

        System.out.print("Enter your monthly travelling expenses: ");
        expenses[2] = scanner.nextDouble();

        System.out.print("Enter your monthly telecommunications expenses: ");
        expenses[3] = scanner.nextDouble();

        System.out.print("Enter your monthly insurance expenses: ");
        expenses[4] = scanner.nextDouble();

        System.out.println("Enter your monthly savings expenses:");
        expenses[5] = scanner.nextDouble();

        System.out.println("Enter your monthly healthcare expenses:");
        expenses[6] = scanner.nextDouble();

        //Display of total expenditure

        double totalLivingExpenditure = calculateExpenses(expenses);


        System.out.println("\nThe total expenses is :" + totalLivingExpenditure);

        /*
         * This section of the program handles the user's accommodation expenses and includes the following:
         * 1. Simphiwe is asked to choose whether he wants  to rent or buy a residence.
         * 2. If he chooses to rent,he will have to input his  monthly rent, which is recorded as accommodation expense.
         * 3. If he chooses to buy, he will have to input the property price, deposit, interest rate, and loan term, and the program calculates their monthly home loan payment using the calculateHomeLoan method.
         * 4. If the home loan repayment exceeds one-third of he's gross income, a warning is displayed indicating that he may not qualify for the loan.
         *
         * Method:
         * - calculateHomeLoan: Calculates the monthly payment for a home loan based on the purchase price, deposit, interest rate, and loan term (in months).
         */



        double accommodationExpense = 0;
        double carMonthlyPayment = 0;
        double expenditureTotal = 0;


        //Choice off accommodation

        System.out.print("\nDo you want to rent or buy residence? (rent/buy): ");
        String choice = scanner.next();


        if (choice.equalsIgnoreCase("rent")) {
            System.out.print("What’s your monthly rent? ");
            accommodationExpense = scanner.nextDouble();
        } else if (choice.equalsIgnoreCase("buy")) {
            System.out.print("What’s the property purchase price? ");
            double purchasePrice = scanner.nextDouble();

            System.out.print("How much are you putting down as a deposit? ");
            double deposit = scanner.nextDouble();

            System.out.print("What’s the interest rate (%) on the home loan? ");
            double interestRate = scanner.nextDouble();

            System.out.print("Over how many months is the loan? (e.g., 240 for 20 years): ");
            int loanTerm = scanner.nextInt();

            accommodationExpense = calculateHomeLoan(purchasePrice, deposit, interestRate, loanTerm);

            System.out.println("\nThis how much you will be spending on accomodation: " + accommodationExpense);
        } else {

            System.out.println("Invalid choice, Please select either 'buy' or 'rent' ");

            if (choice.equalsIgnoreCase("buy") && accommodationExpense > (grossIncome / 3)) {
                System.out.println("Be alert your homeloan repayment is more than a third of your income you may not qualify");
            }


            /*
             * This part handles Simphiwe's car loan calculations.
             *
             * Steps:
             * 1. Simphiwe is asked if they want to buy a car.
             * 2. If the chooses "yes", he will have to input the car brand, price, deposit, interest rate, and loan term.
             * 3. The calculateCarLoan method is used to determine the monthly car payment.
             * 4. If the car loan repayment exceeds one-fifth of the user's gross income, a warning is displayed to indicate that the user may not qualify for the loan.
             *
             * Method:
             * - calculateCarLoan: Calculates the monthly payment for a car loan based on the car price, deposit, interest rate, and loan term (in months).
             */


            System.out.print("\nDo you want to buy a vehicle(yes/no): ");
            String vehicleChoice = scanner.next();

            //Choice to buy or rent a car

            carMonthlyPayment = 0;
            if (vehicleChoice.equalsIgnoreCase("yes")) {
                System.out.print("What car brand do you prefer: ");
                String car = scanner.next();

                System.out.print("What is the purchase price of the vehicle? ");
                double Price = scanner.nextDouble();

                System.out.print("How much will your deposit be? ");
                double Deposit = scanner.nextDouble();

                System.out.print("How much is the interest rate (%) of the car? ");
                double InterestRate = scanner.nextDouble();

                System.out.print("What is the length of the loan(in months)? ");
                int LoanTerm = scanner.nextInt();

                carMonthlyPayment = carMonthlyPayment(Price, Deposit, InterestRate, LoanTerm);

                System.out.println("The monthly payments for the car is: " + carMonthlyPayment);
            }

            if (vehicleChoice.equalsIgnoreCase("yes") && carMonthlyPayment > (grossIncome / 5)) {
                System.out.println("Be alert that the car monthly repayment is more than income/5:You are unlikely to qualify");
            }


            /*
             * This part calculates the Simphiwe's total expenditure, remaining income, and provides alerts if expenditure exceeds 75% of the net income.
             *
             * Steps:
             * 1. Total expenditure is calculated by summing accommodation expenses, car monthly payments, and other living expenses.
             * 2. Remaining income is derived by subtracting total expenditure from net income.
             * 3. If the total expenditure exceeds 75% of the net income, an alert is displayed.
             * 4. Simphiwe's expenses are sorted in descending order to highlight the highest expenses first.
             *
             * Additional features:
             * -The expenses are arranged using `Arrays.sort` with `Collections.reverseOrder` to arrange the expenses from highest to lowest.
             */

            expenditureTotal = accommodationExpense + carMonthlyPayment + totalLivingExpenditure;
            double remainingIncome = netIncome - expenditureTotal;

            System.out.println("The remaining income is: " + remainingIncome);

            if (expenditureTotal > 0.75 * netIncome) {
                System.out.println("Be alert you have now exceeded 75% of your income");
            }


            Double[] expenseArray = new Double[expenses.length];
            for (int i = 0; i < expenses.length; i++) {
                expenseArray[i] = expenses[i];
            }
            //Decending order display

            Arrays.sort(expenseArray, Collections.reverseOrder());

            //Display of expenses

            System.out.println("\nExpenses in descending order:");
            for (double expense : expenseArray) {
                System.out.println(expense);
            }
        }
        /*
         * This part provides a review Simphiwe's financial details.
         * The Simphiwe is presented with:
         * - Gross income (before tax)
         * - Net income (after tax)
         * - Total amount spent on living expenses, accommodation, transportation
         * - Total sum of all expenditures
         */

        System.out.println("\nHere is a review of everything so far: ");
        System.out.println("\nYour monthly income before tax was:" + grossIncome);
        System.out.println("\nYour net income after tax was: " + netIncome);
        System.out.println("\nThe amount you spent on living expenses is: " + totalLivingExpenditure);
        System.out.println("\nThe amount you spent on accomodation is: " + accommodationExpense);
        System.out.println("\nThe amount you spent on Transportation: " + carMonthlyPayment);
        System.out.println("\nThe total sum of all your expenditure is: " + expenditureTotal);


        //Ends the code

        System.out.println("\nGoodluck i hope your monthly fanancial plans were met!!");
        scanner.close();
    }
}

