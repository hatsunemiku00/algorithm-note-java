public class Merge {
    /**
     *将数组递归的分成两半排序，结果归并
     * 原地归并：所有元素复制到辅助数组，归并回a
     * 自顶向下：递归
     * 自底向上：非递归
     * **/
    /**
     * 任意长度时间复杂度相同
     * **/

    /** nlog2n nlog2n nlog2n n 稳定**/
    private static Comparable[] aux;//辅助数组

    public static void merge(Comparable[] a,int lo,int mid,int hi){//原地归并
        //将有序数组a[lo...mid]与有序a[mid+1...hi]归并
        int i=lo,j=mid+1;//i代表前半，j代表后半
        for(int k=lo;k<=hi;k++)//数组a完全复制到aux
            aux[k]=a[k];
        for(int k=lo;k<=hi;k++)
            if(i>mid)                       a[k]=aux[j++];//前半用尽，取后半
            else if (j>hi)                  a[k]=aux[i++];//后半用尽，取前半
            else if (less(aux[j],aux[i]))   a[k]=aux[j++];//后小于前
            else                            a[k]=aux[i++];//前小于后
    }
    public static void sort(Comparable[] a){//自顶向下递归
        aux=new Comparable[a.length];
        sort(a,0, a.length-1);
    }
    public static void sort(Comparable[] a,int lo,int hi){//自顶向下递归
        //将a[lo...hi]排序
        if(hi<=lo) return;//递归结束条件
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }


    public static void sortup(Comparable[] a){//自底向上非递归，多次遍历，适合链表
        int N=a.length;
        aux=new Comparable[N];
        for(int sz=1;sz<N;sz=sz+sz){//sz:子数组大小，从1开始（两两归并）
            for(int lo=0;lo<N-sz;lo+=sz+sz){
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
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
        Comparable[] a={1,3,5,8,9,2,4,5,7,8};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
