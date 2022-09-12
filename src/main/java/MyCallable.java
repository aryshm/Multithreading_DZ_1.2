import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer call() throws Exception {
        int counter = 0;
        int maxBorder = 4;
        int random = (int) (Math.random() * ++maxBorder);
        for (int i = 0; i < random; i++) {
            Thread.sleep(2500);
            System.out.printf("Я %s. Всем привет!\n", getName());
            counter++;
        }
        return counter;
    }
}
