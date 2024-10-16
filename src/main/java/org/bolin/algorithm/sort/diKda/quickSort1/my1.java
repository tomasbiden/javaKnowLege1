package org.bolin.algorithm.sort.diKda.quickSort1;

public class my1 {
//    问题真的太多了啊

//    我这里是基于快速排序的，之前我那个是基于堆排序的
     int paritition(int[] nums,int l,int r){
         if(l==r){
             return  l;
         }
         int priot=nums[l];
//             注意不能有三个while啊，即只用分一次就可以了啊 ,三个while就陷入了死循环了啊
//            上面的是错误的啊，就是要三个while才能完成啊，因为一次划分也需要多次交换，而不知一次啊
//             l<r不能漏掉了啊
         while (l<r){
             while (l<r&&nums[r]>priot){
                 r--;
             }
             /*  这里就错误了啊  if  l < r即可了啊
             if(l<r&&nums[r]<priot){
                 nums[l++]=nums[r];
             }

              */

             if(l<r){
                 nums[l++]=nums[r];
             }




             while (l<r&&nums[l]<priot){
                 l++;
             }
             /*
             if(l<r&&nums[l]>priot){
//                 这里是r--啊，不是r++
                 nums[r--]=nums[l];
             }

              */
             if(l<r){
//                 这里是r--啊，不是r++
                 nums[r--]=nums[l];
             }

         }


         nums[l]=priot;
         return  l;
     }

    public int findKthLargest2(int[] nums, int l, int r ,int k) {


         if(l==r){
             return  nums[l];
         }

        int index=paritition(nums,l,r);

        for (int num : nums) {
//            System.out.print(num+" ");


        }
//        System.out.println();
//        System.out.println(l+" "+r+" "+k+" "+" "+ index);
//        r-index+1 大
        if(r-index+1==k){
            return  nums[index];
        }
//        r-index+1太大了啊   ， 比如现在是第五大，  k 要的是第 8大，因此需要往左边走
//        [index,r]  这里的数字全部略过了
        if(r-index+1<k){
           return findKthLargest2(nums,l,index-1,k-(r-index+1));
        }else {

            return  findKthLargest2(nums,index+1,r,k);
        }

//        return 1;   这里记得要删除掉啊

    }

    public int findKthLargest(int[] nums, int k) {
         int len=nums.length;
         return findKthLargest2(nums,0,len-1,k);



    }

    public static void main(String[] args){
         System.out.println("sdfds");
         int [] nums=new int[]{99,99};
        my1 my1 = new my1();
//        原来是乌龙事件，自己先调用了啊
//      System.out.println(  my1.paritition(nums,0,nums.length-1));

        System.out.println(my1.findKthLargest(nums,1));




    }
}
