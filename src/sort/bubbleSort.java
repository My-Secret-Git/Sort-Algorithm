package sort;

import java.util.Arrays;

public class bubbleSort {
	
	public static void main(String[] args) {
		
		int[] array = new int[] {0,2,5,4,1,3,7,6,8,9};
		bubbleAlgorithm(array);
		System.out.println(Arrays.toString(array));
	}
	
	/**冒泡排序算法
	 * 原理:相邻位比较，反序则互换。
	 * 分析:1、每一轮排序下来，都能将待排序序列中的最大值升到待排序序列的末尾。
	 *	   2、每一轮排序中，参与排序的待排序序列元素个数都比上一轮少一个。
	 * 	   3、如果待排序序列中的元素只剩下一个，那么这个元素是不需要和自己比较的，
	 * 		    也就是说，如果数组中有n个元素，则只需要进行n-1次比较即可保证所有元素有序。
	 * 	   4、从第0轮开始比较，则第n轮比较中，有n个元素是有序的，也就是说，在第n轮排序中，
	 * 	                有n个元素是不需要参与比较的剩余元素数量为(数组长度-n)，那么在这一轮排序当中，
	 *	                只需要进行(数组长度-n-1)次比较即可。
	 *时间复杂度:(n-1)+(n-2)+(n-3)+...+3+2+1=n*(n-1)/2=(n^2-n)/2=O(n^2)
	 *空间复杂度:只在交换数据时用了一个辅助空间，所以空间复杂度为O(1)
	 *稳定性:稳定
	 * @param array
	 */
	public static void bubbleAlgorithm(int[] array) {
		//创建一个i循环，表示比较的次数，总共进array.length-1轮比较
		for(int i=0;i<array.length-1;i++) {
			//创建一个j循环，控制一轮比较中元素下标的前进
			for(int j=0;j+1<array.length-i;j++) {//因为j+1比j更靠近待排序部分的右边缘
				if(array[j]>array[j+1]) {
					int temp=array[j];
					array[j]=array[j+1];;
					array[j+1]=temp;
				}
			}
		}
	}
}
