/*
 * ����һ���������� A������ֻ�������·����޸ĸ����飺����ѡ��ĳ�������� i ���� A[i] �滻Ϊ -A[i]��Ȼ���ܹ��ظ�������� K �Ρ������ǿ��Զ��ѡ��ͬһ������ i����

�����ַ�ʽ�޸�����󣬷���������ܵ����͡�


ʾ�� 1��
���룺A = [4,2,3], K = 1
�����5
���ͣ�ѡ������ (1,) ��Ȼ�� A ��Ϊ [4,-2,3]��

�� 2��
���룺A = [3,-1,0,2], K = 3
�����6
���ͣ�ѡ������ (1, 2, 2) ��Ȼ�� A ��Ϊ [3,1,0,2]��

ʾ�� 3��
���룺A = [2,-3,-1,5,-4], K = 2
�����13
���ͣ�ѡ������ (1, 4) ��Ȼ�� A ��Ϊ [2,3,-1,5,4]��
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
        	//�����СֵΪ 0����ôֱ�ӷ��������ܺ�
            return sum(A);
        }else if(A[0] > 0){
        	//�����Сֵ���� 0����ôֻ��Ҫ����Сֵ��ȡ��
            while(K > 0){
                A[0] = -A[0];
                K--;
            }
            return sum(A);
        }else{
        	//����и�������ô��Ҫ���ҳ���Сֵ��Ȼ��ȡ����
             while(K > 0){
                 A[min(A)] = -A[min(A)];
                 K--;
             }
        }
        return sum(A);
        
    }
    public int sum(int[] A){
    	//�������
        int count = 0;
        for(int i = 0 ;i < A.length ; i++){
            count += A[i];
        }
        return count;
    }
    public int min(int[] A){  
    	//�ҳ������е���Сֵ ���������±�
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
