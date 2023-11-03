import java.util.Scanner;

public class productArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] productList = new int[len];
        productList[0] = 1;
        for(int i = 1;i < len; i++) {
            productList[i] = productList[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = len - 1; i >= 0; i--) {
            productList[i] *= right;
            right *= nums[i];
        }
        return productList;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int len = sc.nextInt();
        System.out.println("Enter the elements: ");
        int[] nums = new int[len];
        for (int i = 0;i < len;i++) {
            nums[i] = sc.nextInt();
        }
        int[] productArray = productExceptSelf(nums);
        for (int j : productArray) {
            System.out.printf("%d\t", j);
        }
    }
}
