package m3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class m3 {
	
	  public static boolean isBijective(int[][] relation) {
	        Map<Integer, Integer> mapping = new HashMap<>();
	        HashSet<Integer> seenValues = new HashSet<>();

	        for (int i = 0; i < relation.length; i++) {
	            int first = relation[i][0];
	            int second = relation[i][1];

	            // Проверяем на неполную пару
	            if (second == -1) {
	                return false; // Неполная пара
	            }

	            // Проверяем, что каждому элементу из второго множества
	            // соответствует не более одного элемента из первого множества
	            if (mapping.containsKey(first) || seenValues.contains(second)) {
	                return false; // Найдено более одного соответствия для элемента из множества
	            }
	            mapping.put(first, second);
	            seenValues.add(second);
	        }

	        return true;
	    }
	 public static boolean isInjective(int[][] relation) {
	        Map<Integer, Integer> mapping = new HashMap<>();
	        HashSet<Integer> seenValues = new HashSet<>();

	        for (int i = 0; i < relation.length; i++) {
	            int first = relation[i][0];
	            int second = relation[i][1];

	            // Проверяем на неполную пару
	            if (second == -1) {
	                return false; // Неполная пара
	            }

	            // Проверяем, что каждому элементу из второго множества
	            // соответствует не более одного элемента из первого множества
	            if (seenValues.contains(second)) {
	                return false; // Найдено более одного соответствия для элемента из второго множества
	            }
	            seenValues.add(second);
	            mapping.put(first, second);
	        }

	        return true;
	    }
    // Функция для проверки, является ли отношение сюрьективным
    public static boolean isSurjective(int[][] relation) {
        HashSet<Integer> secondSet = new HashSet<>();
        for (int[] pair : relation) {
            int second = pair[1];
            if (second != -1) {
                secondSet.add(second);
            }
        }

        HashSet<Integer> firstSet = new HashSet<>();
        for (int[] pair : relation) {
            int first = pair[0];
            if (first != -1) {
                firstSet.add(first);
            }
        }

        return secondSet.containsAll(firstSet);
    }
    // Функция для проверки, является ли отношение функцией
    public static boolean isFunction(int[][] relation) {
        Map<Integer, Integer> mapping = new HashMap<>();

        for (int i = 0; i < relation.length; i++) {
            int first = relation[i][0];
            int second = relation[i][1];

            // Проверяем на неполную пару
            if (second == -1) {
                return false; // Неполная пара
            }

            // Проверяем, что каждому элементу из первого множества
            // соответствует не более одного элемента из второго множества
            if (mapping.containsKey(first) && mapping.get(first) != second) {
                return false; // Найдено соответствие для элемента, которому уже присвоено другое значение
            }
            mapping.put(first, second);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества пар
        System.out.println("Введите количество пар в отношении:");
        int n = scanner.nextInt();

        // Инициализация массива для хранения пар
        int[][] relation = new int[n][2];

        // Ввод пар пользователем
        System.out.println("Введите пары (по одной на строку). Если второй элемент отсутствует, введите -1:");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.hasNextInt() ? scanner.nextInt() : -1;
            relation[i][0] = x;
            relation[i][1] = y;
        }
        
        if (isFunction(relation)) {
            System.out.println("Отношение является функцией.");
        } else {
            System.out.println("Отношение не является функцией.");
        }
        if (isBijective(relation)) {
            System.out.println("Отношение является биективным.");
        } else {
            System.out.println("Отношение не является биективным.");
        }
        if (isInjective(relation)) {
            System.out.println("Отношение является инъективным.");
        } else {
            System.out.println("Отношение не является инъективным.");
        }
        if (isSurjective(relation)) {
            System.out.println("Отношение является сюрьективным.");
        } else {
            System.out.println("Отношение не является сюрьективным.");
        }
        // Проверка, является ли отношение функцией
       
        scanner.close();
    }
}