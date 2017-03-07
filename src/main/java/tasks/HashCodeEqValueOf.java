package tasks;

/**
 * Created by Egor on 07-Mar-17.
 */
public class HashCodeEqValueOf {
    public static void main(String[] args) {
        String string;
        //try every int number positive and negative and "+positive"
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            string = ((Integer)i).toString();
            int diff = string.hashCode() - Integer.valueOf(string);
            if (diff == 0) {
                System.out.println("IT EXISTS : " + i);
                return;
            }
            if (i > 0) {
                string = "+" + string;
                diff = string.hashCode() - Integer.valueOf(string);
                if (diff == 0) {
                    System.out.println("IT EXISTS : +" + i);
                    return;
                }
            }
        }
        string = ((Integer)Integer.MAX_VALUE).toString();
        System.out.println(string);
        int diff = string.hashCode() - Integer.valueOf(string);
        if (diff == 0) {
            System.out.println("IT EXISTS : max_value");
            return;
        }
        System.out.println("IT DOES NOT EXIST");
    }
}
