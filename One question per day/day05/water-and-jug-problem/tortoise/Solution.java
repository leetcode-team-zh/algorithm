package leetcode.d365;

import java.util.*;

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0){
            return true;
        }

        if( x + y < z){
            return false;
        }

        Queue<State> queue = new LinkedList<>();
        Set<State> set = new HashSet<>();
        State init = new State(0,0);
        queue.offer(init);
        set.add(init);

        while(!queue.isEmpty()){
            State state = queue.poll();
            if(state.x == z || state.y == z || state.x + state.y == z){
                return true;
            }

            List<State> nextStates = getNextStates(state.x,state.y,x,y);

            for(State next : nextStates){
                if(!set.contains(next)){
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        return false;
    }

    private List<State> getNextStates(int curX, int curY,int x, int y) {
        List<State> nextStats = new ArrayList<>();
        //1.倒满x
        if(curX < x){
            nextStats.add(new State(x,curY));
        }
        //2.倒满y
        if(curY < y){
            nextStats.add(new State(curX,y));
        }
        //3.倒空x
        if(curX > 0 ){
            nextStats.add(new State(0,curY));
        }

        //4.倒空y
        if(curY > 0){
            nextStats.add(new State(curX,0));
        }

        //5.有剩余才倒
        if(curX - (y - curY) > 0 ){
            nextStats.add(new State(curX - (y - curY),y));
        }

        if(curY - (x - curX) > 0){
            nextStats.add(new State(x,curY - (x - curX)));
        }

        if(curX + curY < x){
            nextStats.add(new State(curX + curY, 0));
        }

        if(curX + curY < y){
            nextStats.add(new State(0,curX + curY));
        }
        return nextStats;
    }


    public static class State {
        int x;
        int y;
        public State(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x && y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
