package lesson5.test1;

//Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
//Вилки лежат на столе между каждой парой ближайших философов.
//Каждый философ может либо есть, либо размышлять.
//Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
//Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
//Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза


public class MealPhilosophers {
    public static void main(String[] args) {
        final Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];
        for (int i = 0; i < forks.length; i++){
            forks[i] = new Object();
        }
        for (int i = 0; i < philosophers.length; i++){
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
            if (i == philosophers.length -1 ) {

                philosophers[i] = new Philosopher(rightFork, leftFork);
            }else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
