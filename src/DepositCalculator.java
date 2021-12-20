import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double rate, int period) {
        double pay = amount * Math.pow((1 + rate / 12), 12 * period);
        return roundUpNumberOfDecimalPlaces(pay, 2);
    }

    double calculateSimplePercent(double amount, double rate, int period) {
        return roundUpNumberOfDecimalPlaces(amount + amount * rate * period, 2);
    }

    double roundUpNumberOfDecimalPlaces(double value, int numberOfDecimalPlaces) {
        double ScaLe = Math.pow(10, numberOfDecimalPlaces);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateSavings() {
        int initialAmount;
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        initialAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double finalAmount = 0;

        if (action == 1) {
            finalAmount = calculateSimplePercent(initialAmount, 0.06, period);
        } else if (action == 2) {
            finalAmount = calculateComplexPercent(initialAmount, 0.06, period);
        }

        System.out.println("Результат вклада: " + initialAmount + " за " + period + " лет превратятся в " + finalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateSavings();
    }
}
