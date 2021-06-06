package aa;

public class Test1 {
    public static void main(String[] args) {
        A a=new A();
        Thread a1=new Thread(a);
        Thread a2=new Thread(a);
        Thread a3=new Thread(a);
        a1.start();
        a2.start();
        a3.start();
    }

}
class A implements Runnable{
    private static char num='A';
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            abc();
        }
    }
    public synchronized void abc(){
        System.out.println(num);
        num=(char) (num+1);
        if(num=='D'){
            num='A';
        }
    }
}
