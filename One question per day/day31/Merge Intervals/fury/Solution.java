static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        List<Interval> temp = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            temp.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        temp.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                else if (o1.start > o2.start) return 1;
                else {
                    return o1.end - o2.end;
                }
            }
        });

        List<int[]> res = new ArrayList<>();
        int start = temp.get(0).start;
        int end = temp.get(0).end;
        for (Interval interval : temp) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new int[]{start, end});
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new int[]{start, end});
        int[][] finalRes = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) finalRes[i] = res.get(i);
        return finalRes;
    }
