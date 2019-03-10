/*
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）

以这种方式修改数组后，返回数组可能的最大和。


示例 1：
输入：A = [4,2,3], K = 1
输出：5
解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。

例 2：
输入：A = [3,-1,0,2], K = 3
输出：6
解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。

示例 3：
输入：A = [2,-3,-1,5,-4], K = 2
输出：13
解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
*/
package lianxi0310;
import java.util.*;
public class test0310 {
	public static void main(String[] args) {
		Solution S = new Solution();
		int[] A = new int[] { 2, -3, -1 , 5, -4};
		int K = 2;
		int sum = S.largestSumAfterKNegations(A, K);
		System.out.println(sum);
	}
}

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        if(A[0] == 0){
        	//如果最小值为 0，那么直接返回数组总和
            return sum(A);
        }else if(A[0] > 0){
        	//如果最小值大于 0，那么只需要在最小值上取反
            while(K > 0){
                A[0] = -A[0];
                K--;
            }
            return sum(A);
        }else{
        	//如果有负数，那么需要先找出最小值，然后取反。
             while(K > 0){
                 A[min(A)] = -A[min(A)];
                 K--;
             }
        }
        return sum(A);
        
    }
    public int sum(int[] A){
    	//数组求和
        int count = 0;
        for(int i = 0 ;i < A.length ; i++){
            count += A[i];
        }
        return count;
    }
    public int min(int[] A){  
    	//找出数组中的最小值 ，返回其下标
        int min = A[0];
        int a = 0;
		for(int i = 1; i < A.length; i++){
            if(min > A[i]){
                min = A[i];
                a = i;
            }
		}
        return a;
    }
}
