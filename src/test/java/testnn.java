import org.testng.annotations.Test;

public class testnn {





    // Sequential execution using priority
    @Test(priority = 1)
    public void test1() {
        System.out.println("Test 1 - Sequential");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test 2 - Sequential");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Test 3 - Sequential");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("Test 4 - Sequential");
    }

    // Parallel execution using threadPoolSize
    @Test(priority = 5,  invocationCount =2)
    public void test5() {
        System.out.println("Test 5 - Parallel");
    }

    @Test(priority = 6, threadPoolSize = 4, invocationCount = 2)
    public void test6() {
        System.out.println("Test 6 - Parallel");
    }

    @Test(priority = 7, threadPoolSize = 4, invocationCount = 2)
    public void test7() {
        System.out.println("Test 7 - Parallel");
    }

    @Test(priority = 8, threadPoolSize = 4, invocationCount = 2)
    public void test8() {
        System.out.println("Test 8 - Parallel");
    }


        @Test
        public void login() {
            System.out.println("Login test failed");
            throw new RuntimeException("Login failed");  // Simulating a failure
        }

        @Test(dependsOnMethods = "login")
        public void accessDashboard() {
            System.out.println("Accessing dashboard");  // This test will be skipped
        }
    }



