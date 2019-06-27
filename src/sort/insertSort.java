package sort;

import java.util.Arrays;

public class insertSort {
	public static void main(String[] args) {
		int[] a = new int[] {0,2,5,4,1,3,7,6,8,9};
		insertAlgorithm(a);
		System.out.println(Arrays.toString(a));
	}
	
	
	public static void insertAlgorithm(int[] a) {
		//创建一个循环控制排序的轮次，轮次从1开始，这样第i轮排序就表示数组下标为i的数为要插入的数值
		for(int i=1;i<a.length;i++) {
			//创建一个循环控制要插入的数组在一轮比较内部不断和有序序列中的数值进行比较，
			//如果比较过程中要插入的数值比有序序列中的数值小，则交换位置。
			//如果比较过程中要插入的数值比有序序列中的数值大，则停止比较（因为一旦比有序序列中的一个值大，则一定大于前面所有值）。
			//如果比较过程中，要插入的数值已经达到数组的最左边，那么停止比较。
			for(int j=i;j>0&&a[j-1]>a[j];j--) {
				int temp=a[j-1];
				a[j-1]=a[j];
				a[j]=temp;
			}
		}
	}
}
