import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubSet2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tans = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, tans, ans);
        return ans;
    }

    private void subsetsWithDup(int[] nums, int idx, List<Integer> tans, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(tans));
        for(int i=idx; i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            tans.add(nums[i]);
            subsetsWithDup(nums, i+1, tans, ans);
            tans.remove(tans.size()-1);
        }
    }
}