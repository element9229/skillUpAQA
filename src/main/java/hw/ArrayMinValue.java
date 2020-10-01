package hw;

public class ArrayMinValue {
    public static void main(String[] args) {
        int [] array = new int[] {9,8,7,6,5,4,3,2,1};

        int minValue = array [0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array [i];
        }
    }
        System.out.println("min value: " + minValue);
    }
}
