package aa;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

class Forletys extends Thread{
    BlockingQueue shit = new ArrayBlockingQueue(100);
    Random random = new Random();
    static boolean flag;
    public  void Per() throws InterruptedException {
        
        while (true) {
            int num = random.nextInt(7874);
                this.shit.put(num);
            System.out.println("sheng   "+num);

        }
    }

    public void Sute() throws InterruptedException {
        while (true) {
            if(!shit.isEmpty()){
                Thread.sleep(300);

            System.out.println("nazou " + shit.take());


            }
        }

    }



}












public class Fore {
    public static void main(String[] args) {
        Forletys forletys = new Forletys();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    forletys.Per();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for(int i = 0;i < 3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        forletys.Sute();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }



    }
}
