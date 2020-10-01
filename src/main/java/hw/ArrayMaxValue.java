package hw;

public class ArrayMaxValue {
    public static void main(String[] args) {
        int [] array = new int[] {1,2,3,4,5,6,7,8,9};

        int maxValue = array [0];

        for(int i =0; i < array.length; i++)
        {
            if(maxValue < array[i])
                maxValue = array[i];
        }
        System.out.println("max value = " + maxValue);
        }
    }


