package com.griftt.server.algorithm;

import java.util.Arrays;
import java.util.Spliterator;


public class bubble {

    /**
     *冒泡算法
     */
    public static void range(int[] data){
        for (int i=0;i<data.length-1;i++){
            for (int j=0;j<data.length-1-i;j++){
                //此时i为已经排序好的个数
                if(data[j]<data[j+1]){
                    //大的往上冒
                    int temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }

            System.out.println(Arrays.toString(data));

        }

    }

    /**
     * 快速排序
     * @param data
     */
    public static void fastRange(int[] data) {
        //从大到小排序,跟每个数一次比较，从而确定，当前位置该放的是哪个数
        for (int i=0;i<data.length;i++){
            for (int j=i+1;j<data.length;j++){
                if(data[i]>data[j]){
                    int temp=data[i];
                    data[i]=data[j];
                    data[j]=temp;
                }
            }
            System.out.println(Arrays.toString(data));

        }
    }
    //二分法查找
    public static int halfFind(int[] data,int find) {
        int length = data.length;
        if(length<=0){
            return -1;
        }
        if(length<2){
            if(data[0]==find){
                return  data[0];
            }else {
             return -1;
            }
       }else {
            int half = length / 2;
            if(data[half]==find){
                return data[half];
            }
            int[] ints=null;
            //需注意不能中间的数不能分配错
            if(data[half]>find){
               ints = Arrays.copyOf(data, half );
            }else {
                 ints = new int[length - half];
                System.arraycopy(data,half,ints,0,length-half);
                System.err.println("ints"+Arrays.toString(ints));
            }
           return halfFind(ints,find);
        }
    }
    public static void main(String[] args) {
        int[] a=new int[]{23,2,345,1231,123,234,2344657,5};
        System.err.println(Arrays.toString(a));
        fastRange(a);
        System.err.println(Arrays.toString(a));
        System.out.println(halfFind(a,122));

    }
}
