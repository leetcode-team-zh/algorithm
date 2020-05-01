public boolean isHappy(int n) {
        HashSet<Integer> cache = new HashSet<>();
        while (true) {
            int sum = sumOfDigits(n);
            if (sum == 1) return true;
            else if (cache.contains(sum)) break;
            else n = sum;

            cache.add(sum);
        }
        return false;
    }

    private int sumOfDigits(int temp) {
        int sum = 0;
        while (temp != 0) {
            int x = temp % 10;
            sum += x * x;
            temp = temp / 10;
        }
        System.out.println(sum);
        return sum;
    }
