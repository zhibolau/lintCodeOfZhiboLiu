给你一个5 million个元素的数组，元素都是10bit的整数,sort

每个元素才10bit，开10bit个桶，也就是2^10=1024个桶，然后用桶排序就行了，时间复杂度O(n)


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
	public static final int ARRAY_SIZE = 10000;// 5 million 百万
	public static final int BUCKET_SIZE=10;// 1024 10 bit
	public static void sort(int[] array) {
		ArrayList<ArrayList<Integer>> bucket=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<BUCKET_SIZE;i++)
		{
			bucket.add(new ArrayList<Integer>());
		}
         for(int i=0;i<array.length;i++)
         {
        	 int k=array[i]/10;
        	 bucket.get(k).add(array[i]);
         }
         for(ArrayList<Integer> list:bucket)
        	 Collections.sort(list);
         for(ArrayList<Integer> list:bucket)
        	 System.out.println(list);
	}

	public static int[] init() {
	    int[] array = new int[ARRAY_SIZE];
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader("d:/score.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String string = new String();
		int i = 0;
		try {
			while ((string = br.readLine()) != null) {
				array[i] = Integer.valueOf(string);
				i++;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return array;
	}
	public static void main(String[] argv)
	{
	
			int[] array=init();
           sort(array);

		
	}
	
}




import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BucketSort {

    public static void bucketSort(double array[]) {
        int length = array.length;
        ArrayList arrList[] = new ArrayList[length];
        /*
         *  每个桶是一个list，存放落在此桶上的元素
         *  上次的基数排序我采用的是计数排序实现的，其实也可以用下面的方法，有兴趣的读者不妨一试(我认为太复杂)
         *  不过效率估计不高(采用了动态数组)
         */
        //划分桶并填元素
        for (int i = 0; i < length; i++) {
            //0.7到0.79放在第8个桶里,编号7；第一个桶放0到0.09
            int temp = (int) Math.floor(10 * array[i]);
            if (null == arrList[temp])
                arrList[temp] = new ArrayList();
            arrList[temp].add(array[i]);
        }
        // 对每个桶中的数进行插入排序
        for (int i = 0; i < length; i++) {
            if (null != arrList[i]) {
                //此处排序方法不定，不过越快越好，除了三大线性排序外，都没有Collections
                //和Arrays里的sort好，因为这是调优后的快拍
                //Arrays里也有，在基数排序里用过copyOf和fill方法
                Collections.sort(arrList[i]);
            }
                
        }
        //输出类似鸽巢排序
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (null != arrList[i]) {
                Iterator iter = arrList[i].iterator();
                while (iter.hasNext()) {
                    Double d = (Double) iter.next();
                    array[count] = d;
                    count++;
                }
            }
        }
    }

    /*
     * 每个元素满足0<=array[i]<1,貌似还要长度相同，
     * 若是相同小数位(digit)，则可以把小数搞为整数，最后再除以10^digit
     *  可以Random.nextInt(101)/100
     */
    public static void main(String[] args) {
        double array[] = { 0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12,
                0.23, 0.68 };
        bucketSort(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}




