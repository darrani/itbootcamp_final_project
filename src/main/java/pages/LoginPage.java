package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButtonLink(){
        return driver.findElement(By.xpath("//div/a[3]"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//form/div/div[3]/button"));
    }


}
