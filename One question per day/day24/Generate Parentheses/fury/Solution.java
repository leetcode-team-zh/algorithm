public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) return res;
        backtracking(res, n, new StringBuilder());
        return res;
    }

    public void backtracking(List<String> res, int n, StringBuilder str) {
        if (str.length() == n * 2 && validParent(str.toString())) {
            res.add(str.toString());
        }
        if (str.length() > n * 2) return;
        char[] pat = {'(', ')'};
        for (char c : pat) {
            backtracking(res, n, str.append(c));
            str.deleteCharAt(str.length() - 1);
        }

    }

    private boolean validParent(String str) {
        if (str == null || str.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.add('C');
            else if (str.charAt(i) == ')') {
                if (!stack.isEmpty()) stack.pop();
                else return false;
            } else return false;
        }
        return stack.isEmpty();
    }
