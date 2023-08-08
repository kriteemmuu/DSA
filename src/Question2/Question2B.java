package Question2;

/*
Given an integer value k and an array of integers representing blacklisted ports, create an algorithm that outputs a
random port (an integer value between 0 and k-1) that is also a whitelisted port (meaning it is not in the array of
blacklisted ports). The goal is to minimize the number of built-in random calls in the algorithm.
The program should have two inputs: k, an integer value, and blacklisted_ports, an array of integers. The program
should also have a get() function that returns a whitelisted random number between 0 and k-1. The algorithm
should be optimized to reduce the number of built-in random calls required.
Example 1:
Input
["Program", "get", "get "get", "get", "get"]
[[7, [2, 3, 5]], [], [], [], [], [], [], []]
Output
[null, 0, 4, 6,1,4]
Explanation
program p = new program(7, [2, 3, 5]);
p.get(); // return 0, any number from [0,1,4,6] should be ok. Note that for every call of pick,
 // 0, 1, 4, and 6 must be equally likely to be returned (i.e., with probability 1/4).
p.get(); // return 4
 */
public class Question2B {

    //implement your code here
    public static class Program {
        int k;
        int[] blacklist;
        int[] whitelist;
        int[] map;
        int size;
        int index;
        public Program(int k, int[] blacklist) {
            this.k = k;
            this.blacklist = blacklist;
            this.whitelist = new int[k - blacklist.length];
            this.map = new int[k];
            this.size = k - blacklist.length;
            this.index = 0;
            for (int i = 0; i < k; i++) {
                map[i] = i;
            }
            for (int i = 0; i < blacklist.length; i++) {
                map[blacklist[i]] = -1;
            }
            for (int i = 0; i < k; i++) {
                if (map[i] != -1) {
                    whitelist[index++] = map[i];
                }
            }
        }

        public int get() {
            int random = (int) (Math.random() * size);
            return whitelist[random];
        }
    }

    public static void main(String[] args) {
        int k = 7;
        int[] blacklist = {2, 3, 5};
        Program program = new Program(k, blacklist);
        System.out.println(program.get());
        System.out.println(program.get());
        System.out.println(program.get());
        System.out.println(program.get());
        System.out.println(program.get());
    }
}
