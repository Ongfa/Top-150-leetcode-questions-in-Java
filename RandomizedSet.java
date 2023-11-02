import java.util.*;

public class RandomizedSet {
    Set<Integer> newSet;
    public RandomizedSet() {
        newSet = new HashSet<>();
    }

    public boolean insert(int val) {
        if (newSet.contains(val)) {
            return false;
        } else {
            newSet.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (newSet.contains(val)) {
            newSet.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<Integer>(newSet);
        int randomValue = (int) (Math.random() * newSet.size());
        return list.get(randomValue);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println("Enter the value to be inserted: ");
        int insertVal = sc.nextInt();
        boolean param_1 = randomSet.insert(insertVal);
        System.out.println("Enter the value to be removed: ");
        int removeVal = sc.nextInt();
        boolean param_2 = randomSet.remove(removeVal);
        int param_3 = randomSet.getRandom();
        System.out.println("Insert Result: " + param_1);
        System.out.println("Remove Result: " + param_2);
        System.out.println("Random Result: " + param_3);
    }
}
