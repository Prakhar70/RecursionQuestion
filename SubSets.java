import java.util.ArrayList;
import java.util.List;

class SubSets {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        subsetSums(nums, 0, 0, ans);
        return ans;
    }

    private void subsetSums(int[] nums, int idx, int sum, List<Integer> ans) {
        ans.add(sum);
        for (int i = idx; i < nums.length; i++) {
            subsetSums(nums, i + 1, sum + nums[i], ans);
        }
    }
}
