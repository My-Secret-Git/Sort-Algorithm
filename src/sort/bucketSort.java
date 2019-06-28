package sort;

import java.util.Arrays;

/**
 * 桶排序算法:
 *1、 原理:将数组分到有限数量的桶里，每个桶再个别排序(有可能再使用别的排序算法或者递归调用桶排序)，
 * 		 最后把每个桶里的值遍历出来(值为几则对应桶的下标打印几遍)即的到有序序列。
 *2、基本思想:
 * 		 桶排序的思想近乎彻底的分治思想。 
 *3、时间复杂度:O(m+n)【n+n+m+n约为M+N】
 *		 查找最大值:n次
 *		 将原数组元素加入桶数组:n次
 *		 将桶数组中的元素进行输出:m+n【m是外层循环的次数（m+1）省略1得到，
 *		 n是内层循环是对原数组元素进行输出，所以总共进行原数组元素个数n次（空桶省略不计入次数）】
 *4、空间复杂度:使用长度为m+1的桶数组进行排序:O(m)	 
 *5、稳定性:无法讨论稳定性。
 * @author Coll-Chen
 *
 */

public class bucketSort {

	public static void main(String[] args) {
		int[] array = new int[] {0,2,5,4,1,3,7,6,8,9,0,0};
		bucketAlgorithm(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void bucketAlgorithm(int[] array) {
		//[1]遍历数组array,找到其中的最大值
		int max = array[0];
		for(int i = 0;i<array.length;i++) {
			if(array[i]>max) {
				max=array[i];
			}
		}
		//[2]创建一个下标最大值为max,也就是长度为max+1的数组，称之为桶数组。
		int[] buckets = new int[max+1];
		
		//再次遍历array数组，把其中取值为n的元素放入到桶数组下标为n的位置
		for(int i = 0;i<array.length;i++) {
			buckets[array[i]]++;
		}
		
		//[4]遍历桶数组，如果下标为n的位置上，取值为m，那么输出m个n
		int k = 0;//控制原始数组下标移动的变量
		for(int i = 0;i<buckets.length;i++) {
			for(int j=buckets[i];j>0;j--) {
	//k++先用后计算，所以array数组从头开始依次输入buckets数组的下标，该下标就对应原来未排序时array数组里面的值。			
				array[k++]=i;
			}
		}
	}

}
