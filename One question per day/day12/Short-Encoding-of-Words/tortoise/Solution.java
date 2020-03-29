package leetcode.d820;

import common.TreeNode;

import java.util.*;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        if(words.length == 0){
            return 0;
        }
        List<String> reverseWords = new ArrayList<>();
        //反转
        for(String word : words){
            reverseWords.add(new StringBuilder(word).reverse().toString());
        }
        //按字母排序
        Collections.sort(reverseWords);

        int count = 0;
        //me -> em ,time -> emit,stime -> emits,hello -> olleh
        for(int i = 0 ; i < reverseWords.size() - 1;i++){
            if(!reverseWords.get(i + 1).startsWith(reverseWords.get(i))){
                count += reverseWords.get(i).length() + 1;
            }
        }
        //加上最后一个
        count += reverseWords.get(reverseWords.size() - 1).length() + 1;
        return count;
    }

    /**
     * 字典树
     * @param words
     * @return
     */
    public int minimumLengthEncoding1(String[] words) {
        if(words == null || words.length == 0){
            return 0;
        }

        //需要按长度排序
        Arrays.sort(words,(o1,o2) -> o2.length() - o1.length());
        int count = 0;
        TrieTree trieTree = new TrieTree();
        for(String word : words){
            count += trieTree.add(word);
        }
        return count;
    }

    public class TireNode{
        final static int MAX_SIZE = 26;
        char data;
        boolean isEnd;
        TireNode[] childs;

        public TireNode(){
            childs = new TireNode[MAX_SIZE];
            isEnd = false;
        }
    }

    public class TrieTree{
        public int add(String word){
            boolean isNew = false;
            TireNode trieNode = new TireNode();
            char[] wordArr = word.toCharArray();
            for(int i = wordArr.length - 1 ; i >= 0 ; i--){
                int index = wordArr[i] - 'a';
                if(trieNode.childs[index] == null){
                    TireNode tireNode = new TireNode();
                    tireNode.data = wordArr[i];
                    trieNode.childs[index] = trieNode;
                    isNew = true;
                }
                trieNode = trieNode.childs[index];
            }
            trieNode.isEnd = true;
            return isNew ? word.length() + 1 : 0;
        }
    }

    public static void main(String[] args) {
        new Solution().minimumLengthEncoding1(new String[]{"mokgggq","pjdislx","bfrbsfs","hgwqzz","bnwxc","pzhmyo","wbfton","evdro","uwxuzmn","mdwfn","rinmw","cwvvrea","aqyxlev","ipypqev","cbdhb","ynqok","lieciy","sqhmdh","pcotcq","vyeqmey","gvpbu","kvhaag","qkaqq","mwtmzzs","gtywt","cnowp","ibfdgvp","jybmx","gseqh","yaohcp","jgarzaz","lgxogb","cjjiev","tjfbf","qwtlx","hehmv","oergh","ovehsf","zifrfb","tbykq","oasqrsw","hjmzil","fuylmzc","zokxci","wbyspc","cqwsb","oftqr","wvgtmrq","ymfyjm","odrnphc","mnoms","frhelt","gokypg","yoafppu","mmquko","klnvy","atcfwzv","yjmluf","hckdblw","wreortt","osuidhr","vmvopqa","snilp","lpygwbe","esqpirj","lacnfr","dnyehuz","qfvuo","jvnlky","gdnzemt","isewa","hvmfts","nuxsog","cckcw","bmxtsb","ozlilc","wmhku","uhoni","ckkbb","uwrakdx","kciqov","xrpjq","lqvbs","fyrglkp","xfbgq","vrojsdw","wwivh","frgontv","fgghrms","psxdbxb","ezapa","lvihja","oydcdih","ztefj","khpoypx","llwgyuq","heepqf","lneold","lxcyjrt","yrnzmvm","kwcluhu","qoqbzzu","cuwmp","qiejx","fnqceo","myizd","thggnqx","ixwbbve","gjwruu","alpglnk","zrhmh","evkojps","gvwol","pystdn","yhcjrd","qtyhucx","cwmbh","vrlmw","bwkntib","isyyx","bptejfp","gctufb","lewtr","llkwsi","rokvhw","jwagu","axchu","llshkne","lnrwco","ylnkjsu","ukdaxm","byfnel","deecwis","xwjjf","xwsyfi","bvnen","supbi","dzara","qtnyslh","zflzqu","rfbsz","yiwbok","kpvpmey","aosdked","gjogz","pwaww","qpqhoz","avlxwv","aakku","ykpjq","biejhfz","ngnmk","gucufvo","zonyhu","pwbnko","dianhi","svdulhs","seaqz","tupyev","rfsde","qgvwnz","ijjpsx","vwwizu","cegwsql","snsrb","kzarfp","xsvwq","zdend","hnnib","ghtfd","pgdlfx","iyrfnl","xhnpif","axinxpx","cttjnl","gmkji","ewbecn","fqpvci","iazmng","ehfmc","wsmjtm","vsxto","cguyk","mncgl","brafj","jvpivd","ljburu","pgxbvd","ewxxx","trmshp","spfdgn","oczwdxj","wvnared","ktzmiu","kdqww","saeuudb","mwzel","sbihma","jemgzpm","oogsc","lvhtgm","thuis","ljkdo","ewgvbu","emuxgt","kgxyfdi","tzwmlof","canbgua","nwqeqwg","ikmorv","uzanjn","npmjwyl"});
    }

}
