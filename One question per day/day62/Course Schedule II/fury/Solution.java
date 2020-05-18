import java.util.*;

public class Solution {
    static class Graph {
        int[] vertex;
        Map<Integer, List<Integer>> adjacentList;

        Graph(int num, int[][] edge) {
            vertex = new int[num];
            adjacentList = new HashMap<>();
            initGraph(edge);
        }

        void initGraph(int[][] edges) {
            for (int[] edge : edges) {
                if (!adjacentList.containsKey(edge[0])) {
                    adjacentList.put(edge[0], new ArrayList<>());
                }
                adjacentList.get(edge[0]).add(edge[1]);
            }
        }


    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] fanIn = new int[numCourses];
        Map<Integer, List<Integer>> adjacentList = new HashMap<>();

        for (int[] edge : prerequisites) {
            fanIn[edge[1]]++;
            if (!adjacentList.containsKey(edge[0])) {
                adjacentList.put(edge[0], new ArrayList<>());
            }
            adjacentList.get(edge[0]).add(edge[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (fanIn[i] == 0) queue.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            res.add(vertex);
            if (adjacentList.get(vertex) != null) {
                for (int vertexTo : adjacentList.get(vertex)) {
                    fanIn[vertexTo]--;
                    if (fanIn[vertexTo] == 0) queue.offer(vertexTo);
                }
            }

        }
        if (res.size() != numCourses) return new int[]{};
        Collections.reverse(res);
        int[] finalRes = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            finalRes[i] = res.get(i);

        }
        return finalRes;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = solution.findOrder(4, pre);
        for (int i : order)
            System.out.print(i + "->");
    }

}


