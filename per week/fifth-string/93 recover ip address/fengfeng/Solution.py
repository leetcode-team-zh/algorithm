class Solution {
    private List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        split(s,0,0,new ArrayList<Integer>());
        return list;
    }
    private void split(String s,int start,int num,ArrayList<Integer> splitPoints){

        if(num ==3){
            String part =  s.substring(start,s.length());
            if(part.length() <=0 || part.length() > 3 || (part.startsWith("0") && !part.equals("0"))|| Integer.parseInt(part) > 255){
                return;
            }else{
                String result =  String.format("%s.%s.%s.%s", s.substring(0,splitPoints.get(0) + 1),s.substring(splitPoints.get(0) + 1,splitPoints.get(1) + 1),s.substring(splitPoints.get(1)+1,splitPoints.get(2)+1),s.substring(splitPoints.get(2)+1,s.length()));
                list.add(result);

            }
        }


        for(int i=start;i<start+3 && i < s.length();i++){
            String part = s.substring(start,i+1);

            if(!part.startsWith("0") && Integer.parseInt(part) <= 255){
                splitPoints.add(i);
                split(s,i+1,num+1,splitPoints);
                splitPoints.remove(splitPoints.size()-1);
            }else if(part.equals("0")){
                splitPoints.add(i);
                split(s,i+1,num+1,splitPoints);
                splitPoints.remove(splitPoints.size()-1);
                break;
            }


        }



    }
}
