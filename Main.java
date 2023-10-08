import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers1 = {2, 11, 7, 1};
        int target1 = 9;
        int[] numbers2 = {3, 2, 4};
        int target2 = 6;
        int[] numbersEmpty = {3,3};
        int target3 = 6;
        int[] negativeNumbers = {-1, -2, -3, -4, -5};
        int target4 = -8;

        int[] result = twoSum(numbers1, target1);
        int[] result2 = twoSum(numbers2, target2);
        int[] result3 = twoSum(numbersEmpty, target3);
        int[] negativeResult = twoSum(negativeNumbers, target4);
        System.out.println("arr: " + Arrays.toString(result));
        System.out.println("arr: " + Arrays.toString(result2));
        System.out.println("arr: " + Arrays.toString(result3));
        System.out.println("arr: " + Arrays.toString(negativeResult));
    }

    private static int[] twoSum(int[] args, int target2) {  //int[] numbers1 = {2, , 7, };
        int[] result = {};

        for (int i = 0; i < args.length - 1; i++) {

            int result1 = target2 - args[i];
            for (int j = i + 1; j < args.length ; j++) {
                if ( args[j] == result1) {
                    result = new int[]{i,j};
                }
            }
        }
        return result;

    }

}









