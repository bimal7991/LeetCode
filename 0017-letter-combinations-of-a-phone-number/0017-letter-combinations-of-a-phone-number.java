class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> hm=new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        List<String> list=new ArrayList<>();
        if(digits.length()==0)
            return list;
        helper(list,hm,digits,0,new StringBuilder());
        return list;
        
    }
   void helper(List<String> list,HashMap<Character,String> hm, String dig,int i,StringBuilder s){
        if(s.length()==dig.length()){
            list.add(new String(s.toString()));
            return;
        }
        for(int j=i;j<dig.length();j++){
            String sub=hm.get(dig.charAt(j));
            for(int k=0;k<sub.length();k++){
                s.append(sub.charAt(k));
                helper(list,hm,dig,j+1,s);
                s.deleteCharAt(s.length() - 1);
            }
            
        }
    }
}