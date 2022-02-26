public class Selection {
    /**
     * 每一轮找到最小的元素，将之与此轮第一个元素交换
     * 不断选择剩余元素的最小者
     * **/
    /**
     * 运行时间与输入无关，有序数组与无序数组时间相同
     * 数据移动最少，N次交换，线性关系
     * **/
    /** n^2 n^2 n^2 1 不稳定**/
    public static void sort(Comparable[] a){
        int min;
        for(int i=0;i< a.length;i++){
            min=i;
            for(int j=i+1;j< a.length;j++){//j=i+1
                if(less(a[j],a[min])) min=j;
                exch(a,min,i);
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
        Comparable[] a={9,8,7,6,5,4,3,2,1};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
