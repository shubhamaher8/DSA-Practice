public class Learning {
    public static void main(String[] args) {
        
        // System.out.println("Hello World");

        // int a = 1;
        // int b = a;
        // System.out.println(b);

    }
}

// Leetcode - 3871. Count Commas in Range II
// Approach: Loop ranges while start <= n to safely avoid overflow, capping each range's end at n.
// Add each range's contribution using (end - start + 1) * commas, then multiply start by 1000 for the next range.
// class Solution {
//     public long countCommas(long n) {
//         long comma = 1;
//         long start = 1000;
//         long end = 0;
//         long x = 0;
//         while(start <= n) {
//             end = start * 1000 - 1;
//             end = Math.min(end, n);
//             x = x + comma * (end - start + 1);
//             comma++;
//             start = start * 1000;
//         }
//         return x;
//     }
// }


