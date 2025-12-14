import java.util.Arrays;
import java.util.Scanner;

/**
 * Пример чтения массива целых чисел с пользовательского ввода, обрабатывающий некорректный ввод и сообщающий об ошибке.
 * <br/>
 * Аналог {@link ProperParsingExample}, но для нескольких чисел.
 */
public class ProperArrayParsingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите массив целых чисел (каждое число через пробел): ");
        String line = scanner.nextLine(); // Считываем всю строку целиком (метод nextInt не подходит, т.к. он не способен обработать некорректный ввод)
        line = line.strip(); // Убираем пробельные символы по краям

        // Пустая строка - это не массив. Сообщаем об ошибке и выходим
        if (line.isEmpty()) {
            System.out.println("Ошибка: пустая строка");
            return;
        }

        String[] lineItems = line.split(" "); // Разбиваем строку по пробелам (каждая подстрока - отдельное число)
        // NOTE: способ работает плохо, если встречаются несколько подряд идущих пробелов

        int[] numbers = new int[lineItems.length]; // Заранее создаём массив нужной длины

        for (int j = 0; j < lineItems.length; j++) {
            String lineItem = lineItems[j];
            for (int i = 0; i < lineItem.length(); i++) {
                char c = lineItem.charAt(i); // NOTE: т.к. здесь оперируют char'ами (т.е. code unit'ами), а не code point'ами, могут быть проблемы с символами, состоящими из двух code unit'ов. Но ради простоты опустим этот момент
                if (!Character.isDigit(c)) { // Проверяем, является ли каждый символ цифрой. Если нет - сообщаем об ошибке и выходим
                    System.out.println("Ошибка: не число по индексу " + j);
                    return;
                }
            }

            // NOTE: данный способ некорректно обрабатывает числа, выходящие за пределы допустимых значений типа int. Но ради простоты опустим этот момент (в будущем мы посмотрим, как можно обработать такой случай проще)
            // NOTE: данный способ не учитывает отрицательные числа (это остаётся в качестве самостоятельного задания)

            numbers[j] = Integer.parseInt(lineItem); // Переводим строку в число
        }

        System.out.println("Прочитанный массив: " + Arrays.toString(numbers));
    }
}
