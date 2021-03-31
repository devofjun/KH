package ch05;

public class BubbleSortEx {
	public static void main(String[] args) {
		int[] nums = {6,3,1,7,2};
		int tmp = 0;
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]+" ");
		}
	}
}
