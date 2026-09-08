class Solution {

    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
       for(String s : strs){
        sb.append(s.length()).append('#').append(s);
       }
       return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = str.length();

        while(i<n){
            int hashIndex = str.indexOf('#',i);
            int length = Integer.parseInt(str.substring(i,hashIndex));
            int start = hashIndex + 1;
            res.add(str.substring(start,start+length));
            i = start + length;
        }
    return res;
    }
}
