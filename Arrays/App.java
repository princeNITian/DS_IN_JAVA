package Arrays;

public class App {

	public static void main(String[] args) {
		int[] nums = new int[5];
		
		for(int i=0;i<nums.length;i++) {
			nums[i]=i;
		}
		int num = nums[3];
		System.out.println(num);
		
		for(int i=0;i<nums.length;i++) {
			if(num == nums[i])
				System.out.println("Index found at: "+i);
		}
	} 
}
