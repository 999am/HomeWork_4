import java.util.*;
import java.util.stream.IntStream;
import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {
        task_1();
        task_2();
        task_3();
        task_4();
        task_5();
        task_6();
        task_7();
        task_8();
    }

    private static void task_1() {
        System.out.println("task_1\nПосчитать среднее значение листа Integer.");
        List<Integer> list1 = new Random().ints(0, 10).limit(5).boxed().toList();
        System.out.println("Лист из 5 элементов: " + list1);

        double d = list1.stream().mapToInt(a -> a).average().orElse(0);
        System.out.println("Среднее значение листа = " + d);

    }

    private static void task_2() {
        System.out.println("\ntask_2\nПреобразовать лист строк нижний регистр, используя стримы");


        List<String> list1 = List.of("WELCOME to the world of JAVA");
        List<String> result1 = list1.stream().map(String::toLowerCase).toList();
        System.out.println(result1);

        System.out.println("Преобразовать лист строк верхний регистр, используя стримы");

        List<String> list2 = List.of("WELCOME to the world of JAVA");
        List<String> result2 = list2.stream().map(String::toUpperCase).toList();
        System.out.println(result2);
    }

    private static void task_3() {
        System.out.println("\ntask_3\nПосчитать сумму всех нечетных элементов листа");
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        System.out.println("Лист из 5 элементов: " + list);
        int sum1 = IntStream.range(0, list.size()).filter(index -> index % 2 == 0).map(list::get).sum();
        System.out.println("Сумма всех нечетных элементов = " + sum1);


        int sum2 = IntStream.range(0, list.size()).filter(index -> index % 2 != 0).map(list::get).sum();
        System.out.println("Сумма всех четных элементов = " + sum2);
    }

    private static void task_4() {
        System.out.println("\ntask-4\nУбрать все дублирующиеся элементы из листа используя стримы.");
        List<Integer> list = Arrays.asList(5, 3, 3, 2, 1, 5, 4, 2, 4, 1);
        System.out.println("Лист из 10 элементов: " + list);
        List<Integer> noDuplicates = list.stream().distinct().toList();
        System.out.println("Cписок без дубликатов: " + noDuplicates);
    }

    private static void task_5() {
        System.out.println("\ntask_5\nПосчитать количество строк в stream, которые начинаются с определенного символа");
        List<String> list = Arrays.asList("one", "two", "three", "four", "five", "ten", "twelve");
        System.out.println(list);
        List<Character> ch = new ArrayList<>();
        IntStream.range(0, list.size()).forEach(i -> {
            char c = list.get(i).charAt(0);
            ch.add(c);
        });
        char symbol = 't';
        int count = (int) IntStream.range(0, ch.size()).filter(i -> symbol == ch.get(i)).count();
        System.out.println("Количество строк, которые начинаются с буквой '" + symbol + "' = " + count);
    }

    private static void task_6() {
        System.out.println("\ntask_6\nСортировка лист строк в алфавитном порядке");
        List<String> list = Arrays.asList("vwx", "mno", "abc", "stu", "pqr", "jkl", "ghi", "def");
        Collections.sort(list);
        System.out.println(list);
        System.out.println("Сортировка лист строк в убывающем порядке");
        Comparator<String> reverseComparator = Comparator.reverseOrder();
        list.sort(reverseComparator);
        System.out.println(list);
    }

    private static void task_7() {
        System.out.println("\ntask_7\nИз листа строк получить числа, затем найти максимум и минимум");
        System.out.print("Получение чисел: ");
        List<String> list = Arrays.asList("11", "55", "-44", "22", "-33", "99", "-44", "66");
        int[] in = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            in[i] = Integer.parseInt(list.get(i));
            System.out.print(in[i] + " ");
        }
        System.out.println();
        System.out.println("Максимальное значение։ " + stream(in).max().getAsInt());
        System.out.println("Минимальное значение։ " + stream(in).min().getAsInt());

    }

    private static void task_8() {
        System.out.println("\ntask_8\nНайти второй самый маленький и самый большой элементы в листе Integer");
        List<Integer> list = new Random().ints(-100, 100).limit(5).boxed().toList();
        System.out.println("Список: " + list);
        list.stream().sorted();
        System.out.println("Второй маленький элемент: " + list.stream().sorted().toList().get(1));
        System.out.println("Самый большой элемент: " + list.stream().sorted().toList().get(list.size() - 1));
    }
}