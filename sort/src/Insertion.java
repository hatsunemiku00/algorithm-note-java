public class Insertion {
    /**
     * 每一轮把本轮第一个数前移至正确位置
     * 如果第一个数小于前一个，则与前一个交换
     * **/
    /**
     * 数组越有序，时间复杂度越小
     * 对部分有序数组很有效
     * **/
    /** n^2 n^2 n 1 稳定**/
    public static void sort(Comparable[] a){
        for(int i=1;i< a.length;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){//当j>0且a[j]小于前一个元素时交换
                exch(a,j,j-1);
            }
        }
    }

    private static boolean less(Comparable v,Comparable w){return v.compareTo(w)<0;}
    private static void exch(Comparable[] a,int i,int j){Comparable t=a[i];a[i]=a[j];a[j]=t;}

    private static  void show(Comparable[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i< a.length;i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }
    public static void main(String[] args){
        Comparable[] a={5,8,9,2,4};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
