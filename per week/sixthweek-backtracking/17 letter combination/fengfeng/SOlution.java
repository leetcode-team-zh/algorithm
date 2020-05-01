class Solution {
    private HashMap<String,String> mapping = new HashMap();


    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<String>();
        }
        mapping.put("2","abc");
        mapping.put("3","def");
        mapping.put("4","ghi");
        mapping.put("5","jkl");
        mapping.put("6","mno");
        mapping.put("7","pqrs");
        mapping.put("8","tuv");
        mapping.put("9","wxyz");
        
        List<String> result = new ArrayList<String>();
        String[] combination = new String[digits.length()];
        solve(digits,0,combination,result);
        return result;

    }

    private void solve(String digits,int start,String[] combination,List<String> result){
        if(start == digits.length()){
            StringBuilder builder = new StringBuilder();
            for(String str:combination){
                builder.append(str);
            }
            result.add(builder.toString());
            return;
        }
       String code =  mapping.get(digits.substring(start,start+1));
       for(int n=0;n<code.length();n++){
           combination[start] = code.substring(n,n+1);
           solve(digits,start+1,combination,result);
       }

    }
}
