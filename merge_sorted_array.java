import java.util.Scanner;
public class merge_sorted_array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, i = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }
        while(p2 >= 0) {
            nums1[i--] = nums2[p2--];
        }
        for(int j = 0; j < nums1.length; j++) {
            System.out.println(nums1[j] + "\n");
        }
        return;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of nums1: ");
        int m = s.nextInt();
        System.out.println("Enter size of nums2: ");
        int n = s.nextInt();
        System.out.println("Enter the sorted array nums1: ");
        int nums1[] = new int[m + n];
        int i = 0;
        for(; i < m;i++) {
            nums1[i] = s.nextInt();
        }
        for(; i < m + n;i++) {
            nums1[i] = 0;
        }
        System.out.println("Enter the sorted array nums2: ");
        int nums2[] = new int[n];
        for (int j = 0; j < n; j++) {
            nums2[j] = s.nextInt();
        }
        System.out.println("The merged sorted array is: ");
        merge(nums1, m, nums2, n);
    }
}
