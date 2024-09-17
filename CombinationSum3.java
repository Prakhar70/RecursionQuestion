import java.util.ArrayList;
import java.util.List;

class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> tans =  new ArrayList<>();
        List<List<Integer>> mans = new ArrayList<>();
        combinationSum3(k, n ,tans, mans, 1);
        return mans;
    }

    private void combinationSum3(int k, int targetSum, List<Integer> tans, List<List<Integer>> mans, int si) {
        if(targetSum < 0){
            return;
        }
        if(k==0){
            if(targetSum == 0){
                mans.add(new ArrayList<>(tans));
            }
            return;
        }
        for(int i=si; i<=9;i++){
            tans.add(i);
            combinationSum3(k-1, targetSum-i, tans, mans, i+1);
            tans.remove(tans.size()-1);
        }
    }

    
}