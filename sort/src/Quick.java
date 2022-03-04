public class Quick {
    /**
     * 一个数组分成两个子数组，两部分独立排序
     * 两个子数组都有序时全数组有序
     * 分组取决于数组
     * **/

    /**
     * 实现简单应用广泛,最通用
     * **/

    /** nlog2n n^2 nlog2n nlog2n 不稳定**/
    /**
     * 切分过程：
     * 某元素j
     * j之前所有元素不大于j
     * j之后所有元素不小于j
     * **/
    private static int partition(Comparable[] a,int lo,int hi){
        int i=lo,j=hi+1;//两扫描指针
        Comparable v=a[lo];//按a[lo]切分
        while(true){
            while(less(a[++i],v))if(i==hi)break;//a[i]<v,增大i
            while (less(v,a[--j]))if(j==lo)break;//a[j]>v,减小j
            if(i>=j) break;//break条件，ij相遇
            exch(a,i,j);
        }
        exch(a,lo,j);//将j放在正确位置
        return j;
    }

    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;//递归结束条件
        int j=partition(a,lo,hi);//使j左边小于j，右边大于j
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    /**改进**/
    /**改进方法一：
     * 小数组，快排比插入排序慢，因为小数组也有递归
     * 排序小数时应切换到插入排序,M与系统相关，可取5-15
     * 将sort（）中递归结束条件改为if(hi<=lo+M){Insertion.sort(a,lo,hi);return;}
     * **/

    /**改进方法二：
     * 避免对重复元素进行递归，适用于大量重复元素
     * 将数组切为三部分，对应小于 等于 大于v的元素
     * lt使a[lo...lt-1]小于v，gt使a[gt+1...hi]大于v
     * i使a[lt...i-1]等于v
     * **/
    private static void sort2(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int lt=lo,i=lo+1,gt=hi;//三指针
        Comparable v=a[lo];
        while(i<=gt){
            int cmp=a[i].compareTo(v);
            if(cmp<0) exch(a,lt++,i++);//a[i]<v,a[lt]与a[i]交换
            else if(cmp>0) exch(a,i,gt--);//a[i]>v,a[gt]与a[i]交换
            else i++;//a[i]=v,不做交换，i++
        }//此时a[lo...lt-1]<v=a[lt...gt]<a[gt+1...hi]
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
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
