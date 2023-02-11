package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


//metodu koja ceka da pop up bude vidljiv
//Elemente koji u sebi sadrze tekstove poruke
//Close dugme
//metodu koja ceka da se verify your account dijalog pojavi
//metodu koja vraca zaglavlje iz verify your account dijaloga koji sadrzi tekst IMPORTANT: Verify your account
//
//Close dugme iz verify account dijaloga

    public void waitForPopUpMessageToBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-snack__content"))));
    }

    public WebElement getTextFromDialogue() {
        return driver.findElement(By.className("v-card__title"));
    }

    public WebElement getCloseButton() {
        return driver.findElement(By.xpath("//*[contains(text(), 'Close')]"));
    }

    public void waitForVerifyYourAccountToBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-card__title"))));
    }
}


