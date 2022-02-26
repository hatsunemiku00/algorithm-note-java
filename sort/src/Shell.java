public class Shell {
    /**
     * 基于插入排序，更加高效
     * 使数组中任意间隔h的元素有序--h有序数组
     * 对每个h，用插入排序将h个子数组独立排序
     * 将插入排序中的移动距离由1改为h
     * **/

    /**
     * 权衡了子数组的规模与有序性，适用于大型数组与任意排序数组
     * 排序之初子数组很短，排序后子数组均有序，都很适合插入
     * 唯一无法准确描述对于乱序数组的性能特征的算法
     * **/
    /** nlog2n n^2 n 1 不稳定 **/
    public static void sort(Comparable[] a){
        int h=1;//h初始值是数组长度*常数，最小为1
        int N=a.length;
        while(h<N/3)h=3*h+1;//h递增序列
        while(h>=1){
            for(int i=h;i<N;i++){//插入排序，使每一个数与相隔h的数有序
                for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
                    exch(a,j,j-h);
            }
            h=h/3;
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
