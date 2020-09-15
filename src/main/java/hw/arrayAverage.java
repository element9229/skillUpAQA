package hw;

public class arrayAverage {
    public static void main(String[] args) {
        int[] numbers = {-5,-15,21,13,27,32,44,51};

        double average = 0;
        if (numbers.length > 0) {
            double sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            average = sum / numbers.length;
            System.out.println("result - " + average);
            }
        }
    }
