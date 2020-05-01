HashMap<Integer, Integer> cache = new HashMap<>();
    int len = 0;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        len = mountainArr.length();
        int low = 0, high = len - 1;
        int peek = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int value = get(mid, mountainArr);
            int right = mid + 1 < len ? get(mid + 1, mountainArr) : 0;
            if (value < right) {
                low = mid + 1;
            } else high = mid - 1;


        }
        peek = low;


        low = 0;
        high = peek;
        while (low <= high) {
            int mid = (low + high) >> 1;

            int value = get(mid, mountainArr);

            if (value == target) return mid;
            else if (value > target) high = mid - 1;
            else low = mid + 1;
        }

        low = peek;
        high = len - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int value = get(mid, mountainArr);
            if (value == target) return mid;
            else if (value > target) low = mid + 1;
            else high = mid - 1;
        }


        return -1;
    }

    int get(int index, MountainArray array) {
        if (index < 0 || index >= len) return 0;
        else {
            if (cache.containsKey(index)) return cache.get(index);
            else {
                int value = array.get(index);
                cache.put(index, value);
                return value;
            }
        }
    }
