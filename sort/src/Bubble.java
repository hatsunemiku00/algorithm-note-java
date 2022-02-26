public class Bubble {
    /**
     * 每一轮遍历一边，每一个与后一个比较，大于则交换
     * 一轮结束最后一个一定正确
     * **/
    /** n^2 n^2 n 1 稳定 **/
    public static void sort(Comparable[] a){
        for(int i=0;i< a.length-1;i++){//i从0到length-1,j从0到length-1-i
            for(int j=0;j< a.length-1-i;j++){
                if(less(a[j+1],a[j]))exch(a,j,j+1);
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
