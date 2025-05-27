import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Annotation {



    @BeforeSuite
    public void method1(){
        System.out.println("BeforeSuite");
    }
    @BeforeClass
    public void method2(){
        System.out.println("BeforeClass");
    }
    @BeforeMethod
    public void method3(){
        System.out.println("BeforeMethod");
    }
    @BeforeTest
    public void method4(){
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void method5(){
        System.out.println("After Test");
    }@Test(priority = 0)
    public void method6(){
        System.out.println("Test 1 Logesh");
    }@AfterClass
    public void method7(){
        System.out.println("After Class");
    }
    @AfterMethod
    public void method8(){
        System.out.println("After Method");
    }
    @AfterSuite
    public void method9(){
        System.out.println("After Suite");

    }@Test(priority = 2)
    public void method10(){
        System.out.println("Test 3  logesh");
    }
    @Test(priority = 1)
    public void method11(){
        System.out.println("Test 2 logesh");
    }

    @DataProvider(name="jjsj")
    public Object[][] getData(){
        return new Object[][]{
                {"logesh","newton"},
            {"sanjai","Dats"}
        };
    }
    @Test(dataProvider="jjsj")
    public void ss(String sss,String xyz){
        String x=sss;
        String y=xyz;
        System.out.println(x+" "+y);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(x,y);
        Assert.assertEquals(x,y);

    }





        }
