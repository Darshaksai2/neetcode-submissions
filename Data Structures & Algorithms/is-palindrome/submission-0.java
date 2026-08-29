class Solution {
    public boolean isPalindrome(String str) {
        if (str == null) return false;
        
        int left = 0;
        int right = str.length() - 1; // Fixed: 0-indexed
        
        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            
            // Compare characters case-insensitively
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}