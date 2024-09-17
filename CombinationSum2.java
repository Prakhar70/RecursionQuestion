import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tans = new ArrayList<>();
        combinationSum2_(candidates, target, 0, tans, ans);
        return ans;

    }

    private void combinationSum2_(int[] arr, int target, int idx, List<Integer> tans, List<List<Integer>> ans) {
        if(target == 0){
            ans.add(new ArrayList<>(tans));
            return;
        }
        for(int i=idx; i<arr.length; i++){
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }
            tans.add(arr[i]);
            combinationSum2_(arr, target-arr[i], i+1, tans, ans);
            tans.remove(tans.size()-1);
        }
    }
}