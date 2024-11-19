import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FormSubmissionTest {
  WebDriver driver;
  
  @BeforeMethod
  public void setup() {
  WebDriverManager.chromedriver().setup();
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://demoqa.com/automation-practice-form");
  
  
  }
  @Test
  public void testFormSubmission() {
	
	  // Fill out the form fields
      driver.findElement(By.id("firstName")).sendKeys("John");
      driver.findElement(By.id("lastName")).sendKeys("Doe");
      driver.findElement(By.id("userEmail")).sendKeys("john.doe@example.com");
      driver.findElement(By.xpath("//label[text()='Male']")).click(); 
      
      // Select gender
      driver.findElement(By.id("userNumber")).sendKeys("1234567890");

      // Select date of birth
      driver.findElement(By.id("dateOfBirthInput")).click();
      driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day--015')]")).click();

      // Select subjects
      driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
      driver.findElement(By.id("subjectsInput")).sendKeys("\n");

      // Select hobbies
      driver.findElement(By.xpath("//label[text()='Sports']")).click();

      // Upload a file
      driver.findElement(By.id("uploadPicture")).sendKeys("C:\\path\\to\\file.jpg");

      // Enter address
      driver.findElement(By.id("currentAddress")).sendKeys("123 Main Street");

      // Submit the form
      WebElement submitButton = driver.findElement(By.id("submit"));
      submitButton.click();

      // Assert confirmation
      WebElement confirmation = driver.findElement(By.id("example-modal-sizes-title-lg"));
      Assert.assertTrue(confirmation.isDisplayed(), "Form submission confirmation is not displayed");
      System.out.println("Form submitted successfully!");
	  
	  
  }
  
  @AfterMethod
  public void tearDown() {
//	  driver.quit();
  }

}
