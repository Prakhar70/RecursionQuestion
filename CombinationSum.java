import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> tans = new ArrayList<>();
        List<List<Integer>> mans = new ArrayList<>();
        combinationSum(candidates, target, 0, tans, mans);
        return mans;
    }

    private void combinationSum(int[] arr, int target, int i, List<Integer> tans, List<List<Integer>> mans) {
        
        if (i==arr.length){
            return;
        }
        if(target == 0){
            mans.add(new ArrayList<>(tans));
            return;
        }
        if (arr[i]>target){
            return;
        }
        combinationSum(arr, target, i+1, tans, mans);

        tans.add(arr[i]);
        combinationSum(arr, target-arr[i], i, tans, mans);
        tans.remove(tans.size()-1);
    }
}