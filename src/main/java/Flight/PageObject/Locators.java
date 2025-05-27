package Flight.PageObject;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class Locators {


   public By FlightDaparture = By.id("roundorigin");
   public By FlightReturn = By.name("rounddestination");
   public By FlightDepartureDatePicker = By.name("rounddateorigin");
   public By FlightDepartureMonth = By.xpath("//select[@class='ui-datepicker-month']");
   public By FlightDepartureYear = By.cssSelector(".ui-datepicker-year");
   public By FlightDepartureDate = By.xpath("//a[contains(@class,'ui-state-default')]");
   public By FlightDatePickerNext = By.xpath("//a[contains(@class,'ui-datepicker-next ui-corner-all')]");
   public By FlightDatePrevButton = By.xpath("//a[contains(@class,'ui-datepicker-next ui-corner-all')]");
   public By BookNow = By.xpath("//a[contains(text(),'Book Now')]");
   public By datepicker=By.xpath("//div[contains(@class,'react-datepicker__current-month')]");
   public By date=By.xpath("//div[contains(@class,'react-datepicker__input-container')]");
   public By continueShopping=By.xpath("//button[contains(text(),'Continue Shopping')]");
   public By Continue=By.id("continue");
   public By shop=By.xpath("//a[contains(@class,'shopping_cart_link')]");
   public By checkOut=By.xpath("//button[contains(text(),'Checkout')]");
   public By itemTotal=By.xpath("//div[contains(@class,'summary_subtotal_label')]");
   public By Tax=By.xpath("//div[contains(@class,'summary_tax_label')]");
   public By cancel=By.xpath("//button[contains(text(),'Cancel')]");
   public By Finish=By.xpath("//button[contains(text(),'Finish')]");
   public By SuccessMessage=By.xpath("//h2[contains(text(),'Thank you for your order!')]");
   public By FirstName=By.xpath("//input[contains(@placeholder,'First Name')]");
   public By LastName=By.xpath("//input[contains(@placeholder,'Last Name')]");
   public By Zipcode=By.xpath("//input[contains(@placeholder,'Zip/Postal Code')]");


}
