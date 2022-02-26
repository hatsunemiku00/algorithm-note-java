public class Merge {
    /**
     *将数组递归的分成两半排序，结果归并
     * 原地归并：所有元素**/
    /**
     * 任意长度时间复杂度相同**/
    private static Comparable[] aux;//辅助数组
    public static void sort(Comparable[] a,int lo,int hi,int mid){//原地归并
        int i=lo,j=mid+1;
        aux=new Comparable[a.length];
        for(int k=lo;k<=hi;k++)//数组a完全复制到aux
            aux[k]=a[k];
        for(int k=lo;k<=hi;k++)
            if(i>mid)                       a[k]=aux[j++];
            else if (j>hi)                  a[k]=aux[i++];
            else if (less(aux[j],aux[i]))   a[k]=aux[j++];
            else                            a[k]=aux[i++];

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
        Comparable[] a={5,8,9,2,4,7,1,2,3,6};
        sort(a,0,a.length-1,5);
        assert isSorted(a);
        show(a);
    }
}
