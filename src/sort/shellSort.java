package sort;

import java.util.Arrays;

public class shellSort {
	
	public static void main(String[] args) {
		int[] a = new int[] {0,2,5,4,1,3,7,6,8,9};
		shellAlgorithm(a);
		System.out.println(Arrays.toString(a));
	}
	
	/*希尔排序原理：通过对步长以内的元素进行插入排序，使整个序列近似有序，最终使用一次步长为1的插入排序进行排列，
	      前面对步长以内的元素进行插入排序提升了最后一次用插入排序进行排序的效率。*/
	/*希尔排序时间复杂度:O(n^k) (1.3=<k<=2)
	 *空间复杂度:O(1)
	 *稳定性：不稳定(不同步长排序后的结果进行插入排序，大小相同的数值的位置可能会颠倒)
	 */
	public static void shellAlgorithm(int[] a) {
		//使用一个外层循环，控制步长的变化
		for(int step=a.length/2;step>=1;step/=2) {
			/*在内部创建一个循环，用于控制同一步长内，不同位置上的元素一共需要进行插入排序的次数
			 *如步长为2时，数组中a[0]、a[2]、a[4]、a[6]为一次插入排序，
			 *a[1]、a[3]、a[5]、a[7]为一次插入排序，
			 *依次类推，此层循环便是用来控制这种同一步长内的插入排序的执行次数。
			*/
			for(int start=0;start<step;start++) {
				//调用插入排序
				insertAlgorithm(a, step, start);
			}
		}
	}
	
	/**
	 * 希尔排序内部使用的插入排序算法
	 * @param a
	 * @param step
	 * @param start
	 */
	public static void insertAlgorithm(int[] a,int step,int start) {
		//创建一个循环控制排序的轮次，轮次从1开始，这样第i轮排序就表示数组下标为i的数为要插入的数值(即找到要进行排序的数值)
		for(int i=start+step;i<a.length;i+=step) {
			//创建一个循环控制要插入的数组在一轮比较内部不断和有序序列中的数值进行比较，
			//如果比较过程中要插入的数值比有序序列中的数值小，则交换位置。
			//如果比较过程中要插入的数值比有序序列中的数值大，则停止比较（因为一旦比有序序列中的一个值大，则一定大于前面所有值）。
			//如果比较过程中，要插入的数值已经达到数组的最左边，那么停止比较。
			for(int j=i;j-step>=0&&a[j-step]>a[j];j-=step) {
				int temp=a[j-step];
				a[j-step]=a[j];
				a[j]=temp;
			}
		}
	}
}
