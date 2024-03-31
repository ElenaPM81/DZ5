package lesson5.test1;

public class Philosopher implements Runnable{
    private final Object leftFork;
    private final Object rightFork;


    public Philosopher(Object leftFork, Object rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int)(Math.random() * 1000)));

    }

    @Override
    public void run() {
        int countEat = 0;

        try {
            while (countEat < 3){

                doAction( " Мыслит");

                synchronized (leftFork){
                    doAction(" Взял левую вилку");
                    synchronized (rightFork){
                        doAction(" Взял в руку правую вилку, ест спагетти");

                        doAction( " Опустил правую вилку");
                    }
                    doAction( " Опустил левую вилку, задумался");
                    countEat++;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return ;
        }
    }
}
