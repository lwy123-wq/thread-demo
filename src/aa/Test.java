package aa;

public class Test extends Thread{
    private int i;
    private  static  int count=0;
    private static boolean flag;


        public synchronized void add1() throws InterruptedException{

            for ( i = 0; i < 26; i++) {
                while (flag){
                    wait();
                }
                System.out.println(++count);
                System.out.println(++count);

                flag=!flag;
                notifyAll();
            }

        }
        public synchronized void add2() throws InterruptedException{
            for (int i=0;i<26;i++) {
                while (!flag){
                    wait();
                }
                int num = 65+i;
                char c = (char)num ;
                System.out.println(c);
                flag=!flag;
                    notifyAll();
                }
            }
        }



class Aa{
    public static void main(String[] args) {
        Test test=new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.add1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.add2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
