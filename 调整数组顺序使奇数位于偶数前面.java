
Given a list of input numbers, output odd numbers first followed by even numbers


 public class AdjustOrder {
    public void adjust(int []a){
        //指向数组第一个元素
        int i = 0;
        //指向数组最后一个元素
        int j = a.length - 1;
        int temp;
        while(i < j){
            while((i < j) && ((a[i]&1) == 1)){
                i++;
            }
            while((i < j) && ((a[j]&1) == 0)){
                j--;
            }
            if(i < j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        AdjustOrder ajo = new AdjustOrder();
        int[] a = {4,2,3,4,5,6,7,8};
        ajo.adjust(a);
        for(int i:a){
            System.out.print(i);
        }
    }
}