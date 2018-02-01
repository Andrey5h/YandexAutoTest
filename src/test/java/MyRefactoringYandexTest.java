/**
 * @author Andrey Strelnikov
 * Seccond AutoTest
 */

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import org.openqa.selenium.By;
import pages.MainPage;
import pages.MarketPage;
import steps.BaseSteps;

import static org.junit.Assert.assertEquals;

public class MyRefactoringYandexTest extends BaseSteps {


    @Test
    public void newYandexTestOne() throws InterruptedException {
        driver.get( baseUrl );
        MainPage mainPage = new MainPage( driver );
        MarketPage marketPage = new MarketPage( driver );
        mainPage.selectMainMenu( "Маркет" );
        marketPage.electronica.click();
        marketPage.televizor.click();
        marketPage.fillField("Сумма", "20000");
        marketPage.clickSamsung.click();
        marketPage.clickLG.click();
        marketPage.clickButtonPrimenit.click();

        assertEquals( 12, driver.findElements( By.xpath( "(//div[@class='n-snippet-card2__title'])" ) ).size() );

        String a = marketPage.takeFirstElement.getText();
        marketPage.searchField.sendKeys( a );
        Thread.sleep( 1000 );
        marketPage.clickButton2.click();
        Assert.assertTrue( marketPage.tittleOfElement.getText().contains( a ) );

    }


    @Test
    public void newYandexTestTwo() throws InterruptedException {
        driver.get( baseUrl );
        MainPage mainPage = new MainPage( driver );
        MarketPage marketPage = new MarketPage( driver );
        mainPage.selectMainMenu( "Маркет" );
        marketPage.electronica.click();
        marketPage.headphones.click();
        marketPage.fillField("Сумма", "5000");
        Thread.sleep( 1000 );
        marketPage.clickBeats.click();
        Thread.sleep( 1000 );
        marketPage.clickButtonPrimenit.click();
        Thread.sleep( 1000 );
        assertEquals( 12, driver.findElements( By.xpath( "(//DIV[@class='n-snippet-cell2__title'])" ) ).size() );
        Thread.sleep( 1000 );
        String b = marketPage.takeFirstElementOfheadphones.getText();
        marketPage.searchField.sendKeys( b );
        Thread.sleep( 1000 );
        marketPage.clickButton2.click();
        Thread.sleep( 1000 );
        Assert.assertTrue(marketPage.tittleOfHeadphonesElement.getText().contains( b ));

    }

}
