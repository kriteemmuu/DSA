package Question4;

/*
There are n tasks you need to complete for a game, labelled from 1 to n.
We are given r[i]=[x,y] representing a prerequisite relationship between task x and task y: task x has to be
completed before task y.
In one step you can complete any number of task as long as you have completed all the prerequisites for the tasks
you are provided while playing game.
Return the minimum number of steps needed to complete all tasks. If there is no way to complete all the tasks,
return -1.
Input: N = 3, r= [[1,3],[2,3]]
Output: 2
Explanation:
In the first step, you can complete task 1 and 2. In the second semester, step task 3 can be completed.
 */
public class Question4A {

    //implement your code here
    public static int minSteps(int n, int[][] r) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int[] prerequisite : r) {
            inDegree[prerequisite[1]]++;
            outDegree[prerequisite[0]]++;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0 && outDegree[i] == 0) {
                continue;
            }
            if (inDegree[i] == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] r = {{1, 3}, {2, 3}};
        System.out.println(minSteps(n, r));
    }
}
