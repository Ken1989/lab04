package fsd.lad04.dingke.salary_tool.util;

import java.math.BigDecimal;
import java.util.Scanner;

import fsd.lad04.dingke.salary_tool.sysmanage.FrequencyEnum;
import fsd.lad04.dingke.salary_tool.sysmanage.SystemInput;

public class SystemInputBuilder extends SystemInput{
	private Scanner scanner;

    public SystemInputBuilder() {
        scanner = new Scanner(System.in);
    }

    private String read(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public SystemInputBuilder collectStartingSalary() {
        String input = read("Input starting salary: ");
        try {
            BigDecimal result = new BigDecimal(input);
            if (result.compareTo(BigDecimal.ONE) >= 0) {
                this.setStartingSalary(result);
                return this;

            } else {
                System.err.println("Starting salary cannot be less than 1.");
                return this.collectStartingSalary();
            }

        } catch (Exception ex) {
            System.err.println("Input must be a double value.");
            return this.collectStartingSalary();
        }


    }

    public SystemInputBuilder collectIncrementInPercent() {
        String input = read("Input increment in percent: ");
        try {
            double result = Double.parseDouble(input);

            if (result >= 0) {
                this.setIncInPercent(result);

                return this;

            } else {
                System.err.println("Increment in percent cannot be less than 0.");
                return this.collectStartingSalary();
            }

        } catch (Exception ex) {
            System.err.println("Input must be a number.");
            return this.collectIncrementInPercent();
        }

    }

    public SystemInputBuilder collectIncrementFrequency() {
        String input = read("Input increment received frequency: ");
        try {
            FrequencyEnum frequency = FrequencyEnum.valueOf(Integer.valueOf(input));
            this.setIncFrequency(frequency);
            return this;

        } catch (Exception e) {
            System.err.print("Frequency must be one of the following values:");
            System.err.println(FrequencyEnum.getValues());
            return this.collectIncrementFrequency();
        }
    }

    public SystemInputBuilder collectDeductionsOnIncome() {
        String input = read("Input deductions on income: ");
        try {
            BigDecimal result = new BigDecimal(input);

            if (result.compareTo(BigDecimal.ZERO) >=0 ) {
                this.setDeductionsOnIncome(result);

                return this;

            } else {
                System.err.println("Deductions on income cannot be less than 0.");
                return this.collectDeductionsOnIncome();
            }

        } catch (Exception ex) {
            System.err.println("Input must be a number.");
            return this.collectDeductionsOnIncome();
        }

    }

    public SystemInputBuilder collectDeductionsFrequency() {
        String input = read("Input deductions received frequency: ");

        try {
            FrequencyEnum frequency = FrequencyEnum.valueOf(Integer.valueOf(input));
            this.setDecFrequency(frequency);
            return this;

        } catch (Exception e) {
            System.err.print("Frequency must be one of the following values:");
			System.err.println(FrequencyEnum.getValues());
            return this.collectDeductionsFrequency();
        }
    }

    public SystemInputBuilder collectPredictionYears() {
        String input = read("Input prediction years: ");
        try {
            int result = Integer.valueOf(input);
            if (result > 0) {
                this.setYears(result);
                return this;

            } else {
                System.err.println("Prediction years must be greater than 0.");
                return this.collectPredictionYears();
            }

        } catch (Exception e) {
            System.err.println("Input must be an integer.");
            return this.collectPredictionYears();
        }
    }


    public SystemInput build() {
        return (SystemInput) this;
    }
}
