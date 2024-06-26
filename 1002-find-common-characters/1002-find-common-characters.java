class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res=new ArrayList<String>();
	int[] min=new int[26];
	for(int i=0;i<26;i++){
		min[i]=Integer.MAX_VALUE;
	}
	for(String s:A){
		int[] cur=new int[26];
		char[] ca=s.toCharArray();
		for(char c:ca){
			cur[c -'a']++;
		}
		for(int i=0;i<26;i++){
			min[i]=Math.min(min[i],cur[i]);
		}
	}
	for(int i=0;i<26;i++){
		for(int j=0;j<min[i];j++){
			res.add(String.valueOf((char)(i+'a')));
		}
	}
	return res;
    }
}