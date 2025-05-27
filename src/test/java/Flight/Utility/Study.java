package Flight.Utility;

import org.apache.logging.log4j.core.net.Priority;
import org.example.*;
import org.testng.annotations.*;

public class Study {
    overload1 overload1;
    overload2 overload2;
    Staff staff;
    Manager manager;
    inheritance2 inheritance2;
    overRide2 overRide2;
    Abstraction1 abstraction1;
    datatypes datatypes;

    public  Study(){
        overload1 = new overload1();
        overload2 = new overload2();
       // staff = new Staff();
        manager = new Manager("sanjai",303,"AGRI");
        inheritance2 =new inheritance2();
        overRide2 = new overRide2();
        abstraction1 = new Abstraction1();
        datatypes = new datatypes();
    }

    @BeforeTest
    public void managers(){
        System.out.println("Before Test");
         manager.displayDetails();
    }
    @BeforeClass
    public void overloaded(){
        System.out.println("Before Class");
        overload2.Employee(10);
    }
    @BeforeMethod
    public void initialize(){
        System.out.println("Before Method");
        System.out.println("Initialize the method to start the functionality");
    }
    @BeforeSuite
    public void startlearning(){
        System.out.println("Before Suite");
        System.out.println("welcome to learn java with joyful");
    }
    @AfterTest
    public void abstractive(){
        System.out.println("After Test");
        datatypes.main();
    }
    @Test(priority = 0)
    public void Atest(){
        System.out.println("first test");
    }
    @Test(priority=1)
    public void BTest(){
        System.out.println("second test");
    }
    @Test(priority=4)
    public void CTest(){
        System.out.println("third test");
    }
    @Test(priority = 2)
    public void DTest(){
        System.out.println("fourth test");
    }
    @Test(priority=3)
    public void ETest(){
        System.out.println("fifth test");
    }
    @AfterSuite
    public void endLearning(){
        System.out.println("After suite");
        System.out.println("Thank you for the learning and spend time for this");
    }
    @AfterMethod
    public void finish(){
        System.out.println("After method");
        System.out.println("close to now class on last minute");
    }
    @AfterClass
    public void overRided(){
        System.out.println("After class");
        overRide2.Sound();
    }



}
