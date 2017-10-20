/**
 * Created by HaMi on 2017-09-27.
 * This program prints all the possible permutations of a string
 */
public class Permutations {
    public static void main(String[] args) {
        String prefix = "";
        permutation(prefix, "abc");
    }

    public static void permutation(String prefix, String str) {
        int n = str.length();
        // if str is empty we just return the prefix: THIS IS THE BASE CASE when all permutations are done, we print
        if (n == 0) {
            System.out.print(prefix + " ");
        }
        // if str is not empty, we will now do permutations
        else {
            for (int i = 0; i < n; i++) {
                // attaching the first char of str to prefix
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
}
