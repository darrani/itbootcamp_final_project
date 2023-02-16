package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getHomeLink(){
        return driver.findElement(By.linkText("HOME"));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.linkText("ABOUT"));
    }
    public WebElement getLoginLink(){
        return driver.findElement(By.linkText("LOGIN"));
    }
    public WebElement getMyProfile(){
        return driver.findElement(By.linkText("MY PROFILE"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnAdmin')]"));
    }
    public WebElement getCitiesLink(){
        return driver.findElement(By.linkText("Cities"));
    }
    public WebElement getUsersLink(){
        return driver.findElement(By.id("list-item-145"));
    }
    public WebElement getSignUpButton(){
        return driver.findElement(By.linkText("SIGN UP"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnLogin')]"));
    }
    public WebElement getLogoutButton() {
        return this.driver.findElement(By.xpath("//*[contains(@class, 'btnLogout')]"));
    }
    public void visibilityOfLogoutButton(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("btnLogout"))));
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.xpath(
                "//div[@class='v-toolbar__items']/button[contains(@class, 'btnLocaleActivation')]"));
    }
    public WebElement getENButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnEN')]"));

    }
    public WebElement getESButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnES')]"));
    }
    public WebElement getFRButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnFR')]"));
    }
    public WebElement getCNButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnCN')]"));
    }


    public WebElement getLandingPageHeading(){
        return driver.findElement(By.tagName("h1"));
    }
}
