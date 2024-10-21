package org.bolin.javaBasic.preSave.ThreadPoolExecutor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.*;

public class tThreadPoolExecutor {
    public static void run() {
        System.out.println("sdfsdf");
    }

    public void method() throws InterruptedException {
        // 可能抛出检查型异常的方法
        Thread.sleep(1000);
    }
    public  static void tthrow(){
//        throw new RuntimeException("tthrow");
        throw new ArithmeticException();
    }

    public static void threadAndException(){
        Thread thread = new Thread(() -> {
            /*
            try {
                int i = 5 / 0;
            } catch (ArithmeticException ae) {
                System.out.println("dfsdf1");
                throw new RuntimeException(ae);
            }

             */
            throw new RuntimeException("re");


//            System.out.println("dfsdf2");
        });

        // 设置未捕获异常处理器
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Exception caught in thread: " + t.getName());
            e.printStackTrace(); // 打印堆栈跟踪
        });
        thread.start();
        System.out.println("hello");
    }





    public static void t1ThreadPoolExecutor() throws RuntimeException{

        Thread sdfsd = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("sdfsd");
            }
        });
        Thread dsfsdf = new Thread(() -> {
            System.out.println("dsfsdf");
        });
        Thread thread = new Thread(tThreadPoolExecutor::run);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        Future<?> submit = threadPoolExecutor.submit(() -> {
            /*
            try {

               Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Excep");

                throw new RuntimeException(e);
            }

            */

            try {
                System.out.println("submit");
                int i = 3 / 0;
                int j = 6 / 0;
                System.out.println(i);
            } catch (ArithmeticException ae) {
                System.out.println("ae Exception");
                throw new RuntimeException(ae);
//                throw new RuntimeException(ae);
            }


            System.out.println("sdfs");


        });

        threadPoolExecutor.execute(() -> {
            System.out.println("1sdfsdf");

        });
        threadPoolExecutor.shutdown();
    /*
       try {
           submit.get();

       }catch (RuntimeException e){
           System.out.println(e);
           throw e;
       }

     */
        // 等待任务完成并处理异常
        try {
            submit.get();
        } catch (InterruptedException e) {
            System.out.println("Task was interrupted: " + e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("Task failed with exception: " + e.getCause().getMessage());
            throw new RuntimeException("sdfs");

        }

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);


    }

    public static void processFile() throws IOException {
        // 读取文件的代码
        FileInputStream fileInputStream = new FileInputStream("sdfsd");
        // 处理文件
    }

    public static void main(String[] args) throws IOException {
    /*
        try {
            t1ThreadPoolExecutor();
        } catch (Exception e) {
            System.out.println("主程序");
            System.out.println(e+"sadas");
        }

     */
        /*
        try{
            t1ThreadPoolExecutor();
        }catch (RuntimeException e){
            System.out.println("sdfsdf");
            System.out.println(e);
        }

         */
        /*
        try {
            threadAndException();
        }catch (RuntimeException ae){
            System.out.println(ae);
        }
        System.out.println("sdfdsfsdf");
*/


        processFile();
        System.out.println("你好");
    }
}
