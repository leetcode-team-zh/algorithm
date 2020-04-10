public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder str = new StringBuilder();
        List<String> res = new ArrayList<>();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            res.add(s.substring(j + 1, i + 1));
            i = j;
        }

        for (String word : res) str.append(word).append(' ');
        if (str.length() != 0) str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
