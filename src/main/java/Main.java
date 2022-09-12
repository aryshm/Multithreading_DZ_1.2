import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable1 = new MyCallable("Поток 1");
        MyCallable myCallable2 = new MyCallable("Поток 2");
        MyCallable myCallable3 = new MyCallable("Поток 3");
        MyCallable myCallable4 = new MyCallable("Поток 4");
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<MyCallable> list = new ArrayList<>();
        list.add(myCallable1);
        list.add(myCallable2);
        list.add(myCallable3);
        list.add(myCallable4);
        List<Future<Integer>> tasks = threadPool.invokeAll(list);
        showResult(tasks);
        Integer result = threadPool.invokeAny(list);
        System.out.println("Результат самой быстрой задачи " + result);
        threadPool.shutdown();
    }

    public static void showResult(List<Future<Integer>> tasks) throws InterruptedException, ExecutionException {
        int result = 0;
        for (Future<Integer> future : tasks) {
            result += future.get();
        }
        System.out.println("Выведено " + result + " сообщений.");
    }
}

