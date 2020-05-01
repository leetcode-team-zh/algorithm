class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 10){
            return res;
        }

        Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        Map<Character,Integer> mapping = new HashMap<>();
        mapping.put('A',0);
        mapping.put('C',1);
        mapping.put('T',2);
        mapping.put('G',3);

        int key = 0;
        for(int n=0;n<10;n++){
            key = (key << 2) | mapping.get(s.charAt(n));
        }
        countMap.put(key,1);

        for(int n=10;n<s.length();n++){
            key = ((key&0x3ffff) <<2)|mapping.get(s.charAt(n));
            
            int count = countMap.getOrDefault(key,0);
            if(count == 1){
                res.add(s.substring(n-9,n+1));
            }
            countMap.put(key,count+1);
            
        }
        return res;

    }
}
