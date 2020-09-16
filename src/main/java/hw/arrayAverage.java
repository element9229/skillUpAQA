package hw;

public class arrayAverage {
<<<<<<< HEAD

=======
>>>>>>> 926673e9c0e94f60d9d2767e4b2f7f8468b44f1a
    public static void main(String[] args) {
        int[] numbers = {-5,-15,21,13,27,32,44,51};

        double average = 0;
        if (numbers.length > 0) {
            double sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            average = sum / numbers.length;
<<<<<<< HEAD
            System.out.println("Average : " + average);

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] < average) {
                    System.out.println("Numbers less than average : " + numbers[i]);
                }
            }
        }
    }
}
=======
            System.out.println("result - " + average);
            }
        }
    }
>>>>>>> 926673e9c0e94f60d9d2767e4b2f7f8468b44f1a
