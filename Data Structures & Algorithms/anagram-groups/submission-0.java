class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> seen = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            seen.putIfAbsent(sorted , new ArrayList<>());
            seen.get(sorted).add(s);
        }
        return new ArrayList<>(seen.values());
    }
}
