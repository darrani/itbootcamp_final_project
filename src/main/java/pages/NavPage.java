package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    //Nav Page
    //Home link
    //About link
    //My profile link
    //Admin dugme
    //Cities link iz padajuceg Admin menija
    //Users link iz padajuceg Admin menija
    //Sign up dugme
    //Login dugme
    //Logout dugme
    //Dugme za izbor jezika
    //EN dugme iz padajuceg menija za izbor jezika
    //ES dugme iz padajuceg menija za izbor jezika
    //FR dugme iz padajuceg menija za izbor jezika
    //CN dugme iz padajuceg menija za izbor jezika

    public WebElement getHomeLink(){
        return driver.findElement(By.linkText("HOME"));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.linkText("ABOUT"));
    }
    public WebElement getMyProfile(){
        return driver.findElement(By.linkText("MY PROFILE"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnAdmin')]"));
    }
    public WebElement getCitiesLink(){
        return driver.findElement(By.id("list-item-142"));
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
    public WebElement getSignOutButon(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnLogout')]"));
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

}
