import java.util.ArrayList;
import java.util.List;

class PhoneKeyPad {
    private final static String[] keypadMap = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
            "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        letterCombinations(0, "", ans, digits);
        return ans;

    }

    private void letterCombinations(int i, String ssf, List<String> ans, String digits) {
        if (i == digits.length()) {
            ans.add(ssf);
            return;
        }
        int digit = digits.charAt(i) - '0';
        String mappedString = keypadMap[digit];
        for (int ii = 0; ii < mappedString.length(); ii++) {
            letterCombinations(i + 1, ssf + mappedString.charAt(ii), ans, digits);
        }
    }
}