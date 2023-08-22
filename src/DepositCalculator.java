
import java.util.Scanner;

import static java.lang.Math.*; //неиспользуемый импорт


public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().getDepositInfo();
    }

    double calculateComplexPercent(double a, double y, int d) { //y лучше удалить - он всегда равен 0.06
        //переменные названы неинформативно
        double pay = a * Math.pow((1 + y / 12), 12 * d); //1 + 0.06 / 12 = 1.005 второй аргумент метода pow
        //всегда double, поэтому нагляднее чтобы один из аргументов тоже был double, например 12.0
        return getRandom(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) { //yearRate всегда равен 0.06
        //лучше выражение в скобках предрассчитать строкой выше: 1. для читабельности 2. для симметрии с
        // методом calculateComplexPercent
        return getRandom(amount + amount * yearRate * depositPeriod, 2); //расчет можно упростить
    }

    double getRandom(double value, int places) { //метод вычисляет итоговую сумму вклада, точно не random ))
        //value - лучше назвать информативно; plases всегда равна 2, можно убрать из параметров
        double scale = Math.pow(10, places); //
        return Math.round(value * scale) / scale;
    }

    void getDepositInfo() { //метод, который назван get должен что-то возвращать.
        //Это, скорее, метод обработки меню
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt(); //объявления лучше сделать в начале метода

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double out = 0; //объявления лучше сделать в начале метода, out - не информативно

        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

}