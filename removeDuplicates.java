import java.util.Scanner;

public class removeDuplicates {

    public static int[] removeSortedArrayDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        } else {
            int index = 1;
            for (int i = 1;i < nums.length;i++) {
                if (nums[i - 1] != nums[i]) {
                    nums[index++] = nums[i];
                }
            }
            for (int i = index;i < nums.length;i++) {
                nums[index++] = 0;
            }
            return nums;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int len = s.nextInt();
        int[] nums = new int[len];
        System.out.println("Enter elements of the sorted array: ");
        for (int i = 0;i < len;i++) {
            nums[i] = s.nextInt();
        }
        int[] sortedNoDuplicates = removeSortedArrayDuplicates(nums);
        for (int i = 0; i < sortedNoDuplicates.length;i++) {
            System.out.printf("%d\t", sortedNoDuplicates[i]);
        }
    }
}
