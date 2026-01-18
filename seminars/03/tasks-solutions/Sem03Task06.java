import java.util.Scanner;

public class Sem03Task06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите список целых чисел, завершающийся нулём:");
        int sum = 0;
        int count = 0;
        int number = scanner.nextInt();
        while (number != 0) {
            sum += number;
            ++count;
            number = scanner.nextInt();
        };
        System.out.println("Сумма: " + sum);
        System.out.printf("Среднее арифметическое: %.3f", sum / (double) count);
    }
}
