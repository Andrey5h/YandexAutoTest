/**
 * @author Andrey Strelnikov
 * Seccond AutoTest
 */


import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class YandexTest {
    private WebDriver driver;


    @Before
    public void setUp() throws Exception {
        System.setProperty( "webdriver.gecko.driver", "drv/geckodriver.exe" );
        System.setProperty( "webdriver.chrome.driver", "drv/chromedriver.exe" );

        driver = new ChromeDriver();
        driver.get( "https://www.yandex.ru/" );
        driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.findElement( By.xpath( "//A[@class='home-link home-link_blue_yes home-tabs__link home-tabs__search'][text()='Маркет']" ) ).click();
        driver.findElement( By.xpath( "//A[@class='link topmenu__link'][text()='Электроника']" ) ).click();

    }


    @Test
    public void yandextTestOne() throws InterruptedException {

        driver.findElement( By.xpath( "//A[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited'][text()='Телевизоры']" ) ).click();
        driver.findElement( By.xpath( "//INPUT[@id='glf-pricefrom-var']" ) ).sendKeys( "20000" );
        driver.findElement( By.xpath( "//LABEL[@class='checkbox__label'][text()='Samsung']" ) ).click();
        driver.findElement( By.xpath( "//LABEL[@class='checkbox__label'][text()='LG']" ) ).click();
        driver.findElement( By.xpath( "//button[@class='button button_action_n-filter-apply button_size_s button_pseudo_yes button_theme_pseudo i-bem button_js_inited']" ) ).click();

        assertEquals( 12, driver.findElements( By.xpath( "(//div[@class='n-snippet-card2__title'])" ) ).size() );

        String a = driver.findElement( By.xpath( "(//div[@class='n-snippet-card2__title'])[1]" ) ).getText();
        driver.findElement( By.xpath( "//INPUT[@id='header-search']" ) ).sendKeys( a );
        Thread.sleep( 1000 );
        driver.findElement( By.xpath( "(//BUTTON[@role='button'])[1]" ) ).click();
        Assert.assertTrue( driver.findElement( By.xpath( "//H1[@class='title title_size_28 title_bold_yes']" ) ).getText().contains( a ) );
    }


    @Test
    public void yandextTestTwo() throws InterruptedException {

        driver.findElement( By.xpath( " (//A[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited'][text()='Наушники и Bluetooth-гарнитуры'])[2]" ) ).click();
        driver.findElement( By.xpath( "//INPUT[@id='glf-pricefrom-var']" ) ).sendKeys( "5000" );
        Thread.sleep( 1000 );
        driver.findElement( By.xpath( "//LABEL[@class='checkbox__label'][text()='Beats']" ) ).click();
        Thread.sleep( 1000 );
        driver.findElement( By.xpath( "//button[@class='button button_action_n-filter-apply button_size_s button_pseudo_yes button_theme_pseudo i-bem button_js_inited']" ) ).click();
        assertEquals( 12, driver.findElements( By.xpath( "(//DIV[@class='n-snippet-cell2__title'])" ) ).size() );
        Thread.sleep( 1000 );
        String g = driver.findElement( By.xpath( "(//DIV[@class='n-snippet-cell2__title'])[1]" ) ).getText();
        driver.findElement( By.xpath( "//INPUT[@id='header-search']" ) ).sendKeys( g );
        Thread.sleep( 1000 );
        driver.findElement( By.xpath( "(//BUTTON[@role='button'])[1]" ) ).click();
        Assert.assertTrue( driver.findElement( By.xpath( "//LI[@class='n-breadcrumbs__item n-breadcrumbs__item_type_text']" ) ).getText().contains( g ) );

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}