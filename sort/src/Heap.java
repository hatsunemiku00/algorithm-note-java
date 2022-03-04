public class Heap {
    /**
     * 堆：一棵二叉树每个结点都大于等于两个子节点，两个子节点无要求
     * 使用完全二叉树-数组表示
     * 将二叉树从上至下放入数组，不使用数组第一个位置
     *
     * k的父亲  k/2（整除）
     * k的孩子  2k&2k+1
     * N个结点的完全二叉树高  int(lgN)
     *
     * 堆的有序化：当某节点优先级上升或加入新元素时，由下至上恢复顺序--上浮；
     *           当某节点优先级下降，由上至下恢复顺序--下沉
     * 堆插入：       新元素加入末尾，增加堆的大小，新元素上浮
     * 删除最大元素：  从数组顶端删除最大元素，将最后一个元素放到顶端并下沉，减小堆大小
     * **/
    Comparable[] pq;
    int N= pq.length;
    /**
     * 所有元素重新排成堆，按顺序取出所有元素
     * 数组本身作为堆，无需额外空间
     *
     * 堆构造： 从右至左使用sink()**/
    public  void sort(Comparable[] pq){//堆排序
        int N=pq.length;
        for(int k=N/2;k>=1;k--) sink(k);//堆构造,只需扫描一半元素，跳过大小为1的堆
        while (N>1){//删除最大元素，放入堆缩小后数组空出的位置
            exch(1,N--);
            sink(1);
        }
    }

    private void swim(int k){//上浮
        while(k>1&&less(k/2,k)){//k与父亲比较互换，直到大小合适或到顶
            exch(k/2,k);
            k=k/2;
        }
    }
    /**下沉
     * 将结点与子节点中较大者交换
     * 下沉可能在子节点处打破有序状态，需要不断用相同方式修复**/
    private void sink(int k){//下沉,直到结点的字节的比它小或到底
        while(2*k<=N){//j/2k左孩子
            int j=2*k;
            if(j<N&&less(j,j+1)) j++;//若左孩子不等于N（有右孩子）并右孩子大
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }
    public void insert(Comparable v){//插入
        pq[++N]=v;
        swim(N);
    }
    public Comparable delMax(){//删除最大元素
        Comparable max=pq[1];
        exch(1,N--);//最大元素与最后一个元素对调
        pq[N+1]=null;
        sink(1);
        return max;
    }

    private boolean less(int i,int j){return pq[i].compareTo(pq[j])<0;}
    private void exch(int i,int j){Comparable t=pq[i];pq[i]=pq[j];pq[j]=t;}
    private static  void show(Comparable[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    public void main(String[] args){
        Comparable[] a={5,8,9,2,4};
        sort(a);
        show(a);
    }
}
