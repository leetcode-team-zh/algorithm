import java.util.HashSet;
import java.util.Set;

public class Solution {
    //983. 最低票价
    //示例 1：
//
//输入：days = [1,4,6,7,8,20], costs = [2,7,15]
//输出：11
//解释：
//例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
//在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
//在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
//在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
//你总共花了 $11，并完成了你计划的每一天旅行。
//
    int[] costs;
    Integer[] memo;
    Set<Integer> daySet;


    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        daySet = new HashSet<>();
        for (int day : days) daySet.add(day);

        return dp(1);
    }

    public int dp(int i) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        if (daySet.contains(i)) {
            memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
        } else {
            memo[i] = dp(i + 1);
        }
        return memo[i];
    }

}

