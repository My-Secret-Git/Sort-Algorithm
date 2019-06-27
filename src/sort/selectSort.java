package sort;

import java.util.Arrays;

public class selectSort {
	
	public static void main(String[] args) {
		
		int[] array = new int[] {0,2,5,4,1,3,7,6,8,9};
		selectAlgorihthm(array);
		System.out.println(Arrays.toString(array));
	}
	
	/**
	 * 选择排序算法:
	 * 原理:选定一个标准位，逐个遍历待排序序列中的元素进行比较，反序则互换。
	 * 分析:1、假设在一轮排序中有n个元素是无序的，那么只需要进行n-1次排序便可以把
	 * 	        待排序序列中的最小值(或最大值)放在标准位上。
	 * 	   2、在一轮排序过后，标准位上的值一定是待排序序列中的最大值(降序)，或最小值(升序)
	 * 	   3、在第n轮排序中，数组中有n个元素是有序的，表示有n个元素是不参与比较的。
	 * 	   4、第n轮排序进行时，标准为的下标取值就是n。
	 * 时间复杂度:(n-1)+(n-2)+(n-3)+...+3+2+1=n*(n-1)/2=(n^2-n)/2=O(n^2)
	 * 空间复杂度:只在交换数据时用了一个辅助空间，所以空间复杂度为O(1)
	 * 稳定性:如果使用j=i+1向后遍历的方式，则是稳定的;
	 * 		如果使用j=array.length-1向前遍历,则不是稳定的。
	 * @param a
	 */
	public static void selectAlgorihthm(int[] array) {
		//创建一个循环，控制标准位在数组下标中的位置
		for(int i=0;i<array.length-1;i++) {
			//创建一个循环，控制在一轮排序中，待排序序列中与标准位进行比较的元素下标的前进
			for(int j=i+1;j<array.length;j++) {
				//比较标准位array[i]与正在被遍历 元素array[j]的大小,反序则互换。
				if(array[j]<array[i]) {
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
	}
}
