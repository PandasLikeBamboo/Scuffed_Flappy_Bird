public class StopWatch {

    private long startTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public float getElapsedTimeSeconds() {
        return (System.currentTimeMillis() - startTime) / 1000f;
    }
}
