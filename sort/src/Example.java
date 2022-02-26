import java.util.Scanner;

public class Example {
    /**
     * 选择   n^2     n^2     n^2         1       不稳定
     * 插入   n^2     n^2     n           1       稳定
     * 冒泡   n^2     n^2     n           1       稳定
     *
     * 希尔   nlog2n  n^2     n           1       不稳定
     * 归并   nlog2n  nlog2n  nlog2n      n       稳定
     * **/
    public static void sort(Comparable[] a){}

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
