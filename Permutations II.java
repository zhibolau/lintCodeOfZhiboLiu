For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]

有重复元素的permutation

与permutations区别就是加上 排序 与  去重 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> items = new ArrayList<Integer>();
        if (nums ==  null) {
            return rst;
        }
        Collections.sort(nums);
        permuteUniqueHelper(rst, items, nums);
        return rst;
    }
    public void permuteUniqueHelper(ArrayList<ArrayList<Integer>> rst,
                                    ArrayList<Integer> items,
                                    ArrayList<Integer> nums) {
        if (nums.size() == 1) {
            items.add(nums.get(0));
            rst.add((ArrayList<Integer>) items.clone());
            items.remove(items.size() - 1);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (i > 0 && nums.get(i) == nums.get(i - 1)) {
                    continue;
                }
                items.add(nums.get(i));
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(nums.subList(0, i));
                temp.addAll(nums.subList(i + 1, nums.size()));//这里是num的size 不是items的
                permuteUniqueHelper(rst, items, temp);
                items.remove(items.size() - 1);//这里是items的size 不是num的
            }
        }
    }
}


