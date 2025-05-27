package Flight.Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.concurrent.atomic.AtomicInteger;

public class TestRetry_Analyzer implements IRetryAnalyzer {
    public static final int MAX_RETRY_COUNT = 2;
    private static final AtomicInteger count = new AtomicInteger(MAX_RETRY_COUNT);

    public static void resetCount() {
        count.set(MAX_RETRY_COUNT);
    }

    public int getCount() {
        return count.get();
    }

    private boolean isRetryAvailable() {
        return (count.get() > 0);
    }

    @Override
    public boolean retry(ITestResult result) {
        boolean retry = false;
        if (isRetryAvailable()) {
            System.out.println("Going to retry test case: " + result.getMethod() + ", " + (((MAX_RETRY_COUNT - count.get()) + 1)) + " out of " + MAX_RETRY_COUNT);
            retry = true;
            count.decrementAndGet();
        }
        return retry;
    }


}
