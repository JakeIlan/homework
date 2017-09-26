package sort;

public class MaxSubArray {

    private static int findSubArray(int[] arr) {
        int result = arr[0],
                left = 0,
                right = 0,
                sum = 0,
                prevPos = -1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > result) {
                result = sum;
                left = prevPos + 1;
                right = i;
            }
            if (sum < 0) {
                sum = 0;
                prevPos = i;
            }
        }
        return result;
    }

    private static boolean test(int[] arr, int expRes) {
        return findSubArray(arr) == expRes;
    }

    public static void main(String args[]) {
        int[] arr1 = {-1, 2, 3, -9};
        int[] arr2 = {2, -1, 2, 3, -9};
        int[] arr3 = {-1, 2, 3, -9, 11};
        int[] arr4 = {-2, -1, 1, 2};
        int[] arr5 = {100, -9, 2, -3, 5};
        int[] arr6 = {1, 2, 3};

        int testsPassed = 0;

        if (test(arr1, 5)) testsPassed++;
        if (test(arr2, 6)) testsPassed++;
        if (test(arr3, 11)) testsPassed++;
        if (test(arr4, 3)) testsPassed++;
        if (test(arr5, 100)) testsPassed++;
        if (test(arr6, 6)) testsPassed++;

        System.out.println(testsPassed);
    }
}
