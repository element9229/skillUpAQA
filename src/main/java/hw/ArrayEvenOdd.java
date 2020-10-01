package hw;

public class ArrayEvenOdd {
    public static void main(String[] args) {
        int[] array = new int[]{-5, -4, -3, -2, -1, 1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (array[i] % 2 ==0) {
                    sum += array[i];
                }
            }
        }
        System.out.println("Сумма четных положительных элементов - " + sum);
    }
}
