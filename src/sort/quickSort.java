package sort;

import java.util.Arrays;

/**
 * 快速排序算法 时间复杂度: 在快速排序中
 * 
 * @author Coll-Chen
 *
 */
public class quickSort {

	public static void main(String[] args) {
		
		int[] array = new int[] {0,2,5,4,1,3,7,6,8,9};
		quickAlgorithm(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	// start表示待排序序列的起点，end表示待排序序列的终点。
	public static void quickAlgorithm(int[] array, int start, int end) {
		
	/*限制递归出口:
		因为有两种情况不需要进行排序:
		【1】当前待排序序列中没有元素（用start>end判别控制）:即middle左边或middle右边没有元素
		(注意到这两种情况共同点为start>end,左边若为空end=j=middle-1后小于i，
		右边若为空start=i=middle+1>j,所以可以用i>j（start>end）来进行判别)
		【2】当前待排序序列中只有一个元素，不需要进行排序（用start=end判别控制）:即middle左边或middle右边只有一个元素
		左边若只有一个元素end=j=middle-1后等于i，
		右边若只有一个元素start=i=middle+1=j,所以可以用i>j（start=end）来进行判别
	*/	
		if(start>=end) {
			return;
		}
		//[1] 创建i、j两个变量，分别指向待排序数组的头和尾。
		int i = start;
		int j = end;
		//[4] 创建一个循环，让i、j交替执行和互换的步骤重复执行，知道i、j相遇为止。
		while (i < j) {
			// 创建一个循环，让j往回走，一边走一边寻找比array[i]小的值
			while (j > i && array[j] > array[i]) {
				j--;
			}
			// [2]当i和j相遇或者array[j]<array[i],循环结束。
			if (array[j] < array[i]) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			// [3]创建一个循环，让i往后走，一边走一边寻找比array[j]大的值
			while (i < j && array[i] < array[j]) {
				i++;
			}
			// [4]当i和j相遇或者array[i]>array[j],循环结束。
			if (array[i] < array[j]) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		/* [5]在上面的大循环退出之后，表示i、j相遇，元素归位，此时以i、j为分界线，
		                 将左侧的半个数组和右侧的半个数组进行快速排序。
		                 子问题与大问题一样，知识规模变小，用递归解决。(**注意:要考虑递归的出口问题)
		      */
		int middle = i;// middle=j也一样，因为此时i、j相遇，值相等。
		quickAlgorithm(array, start, middle-1);//左边的数组进行快速排序:起点不变，终点即为middle-1
		quickAlgorithm(array, middle+1, end);//右边的数组进行快速排序:起点为middle+1,终点不变
	}

}
