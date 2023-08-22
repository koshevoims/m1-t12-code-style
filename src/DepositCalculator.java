
import java.util.Scanner;
import static java.lang.Math.*;


public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().getDepositInfo();
    }
    double calculateComplexPercent(double a, double y, int d ) {
        double pay = a * Math.pow(( 1 + y / 12), 12 * d);
        return getRandom(pay, 2);
    }
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRandom(amount + amount * yearRate * depositPeriod, 2);
    }
    double getRandom(double value,int places) {
        double scale = Math.pow( 10, places);
        return Math.round(value * scale) / scale;
    }

    void getDepositInfo( ) {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double out = 0;

        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        }
        else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

}
