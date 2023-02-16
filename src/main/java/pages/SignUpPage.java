package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
//    Signup Page
//    Polje za unos imena
//    Polje za unos emaila
//    Polje za unos lozinke
//    Polje za potvrdi lozinku
//    Sign me up dugme


    public WebElement getFieldNameInput(){
        return driver.findElement(By.id("name"));
    }
    public WebElement getFieldEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getFieldPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getFieldConfirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));

    }
    public WebElement getSignMeUpButton(){
        return driver.findElement(By.xpath("//*[@type='submit']"));
    }
}
