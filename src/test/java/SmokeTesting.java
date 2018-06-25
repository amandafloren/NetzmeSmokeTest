import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class SmokeTesting {

    public AppiumDriver<MobileElement> driver;

    // text_introduction_next
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Redmi 4");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0.1");//caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.netzme.netzmeandroid.staging");
        caps.setCapability("appActivity", "id.netzme.netzmeandroid.view.loadingscreen.LoadingScreenActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //  WebDriverWait wait = new WebDriverWait(driver, 100);
        //  wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("id"))));
        //  driver.findElement(By.id("id")).sendKeys("btn_register");


    }

    //  public void callNextBtn(){

    //    nextBtn.click();
    //}
    @Test
    public void registrationTest() throws InterruptedException {

        WebElement nextBtn = (new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.id(("text_introduction_next"))));

        nextBtn.click();
        nextBtn.click();
        nextBtn.click();

        WebElement join_btn = driver.findElementById("reward_onboarding_join_btn");
        join_btn.click();

        WebElement phone_number_et = driver.findElementById("edit_text_phone_number");
        phone_number_et.sendKeys("81282187488");

        WebElement agree_cbox = driver.findElementById("button_check_term_of_use");
        agree_cbox.click();

        WebElement register_btn = driver.findElementById("button_confirmation_registration");
        register_btn.click();

        WebElement verification_code_et = driver.findElementById("edit_text_verification_code");
        verification_code_et.sendKeys("0000");

        WebElement verification_btn = driver.findElementById("button_confirm_verification");
        verification_btn.click();

        WebElement full_name_et = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id(("edit_text_full_name"))));
        full_name_et.sendKeys("Dylan");

        WebElement regist_confirm_btn = driver.findElementById("button_confirmation_registration");
        regist_confirm_btn.click();
    }

    //Wait waitForElement = new FluentWait(appiumDriver).withTimeout(50, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);


    /*    WebElement promo_dialog = (new WebDriverWait(driver, 50)).until(ExpectedConditions.presenceOfElementLocated(By.id(("promotion_dialog_container"))));
        WebElement pin_dialog = (new WebDriverWait(driver, 50)).until(ExpectedConditions.presenceOfElementLocated(By.id(("show_pin_layout"))));
        if(promo_dialog.isDisplayed()){
            WebElement promo_dialog_cbox = driver.findElementById("promotion_dialog_close_button");
            promo_dialog_cbox.click();
        } else if (pin_dialog.isDisplayed()){
            WebElement input_pin_btn = driver.findElementById("input_show_pin");
            input_pin_btn.sendKeys("000000");

        } else{
            WebElement chat_container = driver.findElementById("contact_list_item_container");
            chat_container.click();

        }*/
    @Test
    public void closeDialog() {

        if (!driver.findElements(By.id("promotion_dialog_container")).isEmpty()) {
            WebElement promo_dialog_cbox = driver.findElementById("promotion_dialog_close_button");
            promo_dialog_cbox.click();
        }

        if (!driver.findElements(By.id("pampay_view_request_money_onboarding_block")).isEmpty()) {
            WebElement pin_box = driver.findElementById("button_set_pin_dialog");
            pin_box.click();

            WebElement pin_et = driver.findElementById("pin_input");
            pin_et.sendKeys("000000" + "\n");

            WebElement reinput_pin_et = driver.findElementById("pin_re_input");
            reinput_pin_et.sendKeys("000000");

            WebElement save_pin_btn = driver.findElementById("button_save_pin");
            save_pin_btn.click();

            if (!driver.findElements(By.id("pampay_view_request_money_onboarding_block")).isEmpty()) {
                WebElement set_ok_pin_btn = driver.findElementById("pin_success_dialog_ok_button");
                set_ok_pin_btn.click();
            }

        }

        //  if (!driver.findElements(By.id("show_pin_layout")).isEmpty()){
        //    WebElement input_pin_btn = driver.findElementById("input_show_pin");
        //  input_pin_btn.sendKeys("000000");
        //}

        // WebElement buffer_contact = (new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.id(("contact_list_item_container"))));
        //ada masalah disini no element found
        //tes chatting


        WebElement promo_dialog = (new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.id(("promotion_dialog_close_button"))));
        promo_dialog.click();

        WebElement input_pin_btn = (new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("input_show_pin"))));
        //input_pin_btn.sendKeys("000000");
        driver.getKeyboard().sendKeys("000000");
    }

    @Test
    public void chattingUser() {

        WebElement chat_container = driver.findElementById("contact_list_item_container");
        chat_container.click();

        WebElement chat_et = (new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(By.id("edit_text_chat_message"))));
        chat_et.sendKeys("Hai");

        WebElement send_chat_btn = driver.findElementById("button_chat_send");
        send_chat_btn.click();
    }

    @Test
    public void sendMedia() {
        //tes kirim video
        WebElement send_media_btn = driver.findElementById("button_chat_send_media");
        send_media_btn.click();

       /* WebElement take_video_btn = driver.findElementById("camera_video_record_button");
        take_video_btn.click();

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement stop_media_btn = driver.findElementById("camera_video_stop_record_button");
        stop_media_btn.click(); */

        WebElement el2 = driver.findElementByAccessibilityId("record video");
        el2.click();
        System.out.println("Start Video");

        //el2.click();

        //WebElement popUp = driver.findElementByAccessibilityId("stop record video");
        //popUp.click();
        // driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
        WebElement stopBtn = (new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//android.widget.ImageButton[@content-desc='stop record video']"))));
        stopBtn.click();

        System.out.println("Button stop found");
        //catch(NoSuchElementException e) {
        // System.out.println("Impossible to click the stop. Reason: " + e.toString());
        //}

       /* if (!driver.findElements(By.id("camera_video_record_button_switcher")).isEmpty()){
            System.out.println("Button switcher found");

            driver.findElement(By.id("camera_video_record_button_switcher")).click();
        } */
        //WebDriverWait wait = new WebDriverWait(driver, 80);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("camera_photo_video_capture_button_switcher")));
        //WebElement el3 = driver.findElementByAccessibilityId("hentikan rekam video");

        //WebElement el3 = (new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.id("com.netzme.netzmeandroid.staging:id/camera_video_record_button"))));
        //driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();


        WebElement el4 = driver.findElementById("text_posting_photo");
        el4.click();

        //id untuk ET content description : edit_content_description

        WebElement sent_media_txt = driver.findElementById("text_posting_photo");
        sent_media_txt.click();

        //tes kirim foto
        WebElement send_media2_btn = driver.findElementById("button_chat_send_media");
        send_media2_btn.click();

        WebElement send_photo_btn = driver.findElementById("camera_photo_mode_switch_button");
        send_photo_btn.click();

        WebElement take_photo_btn = driver.findElementById("camera_photo_capture_button");
        take_photo_btn.click();
        send_photo_btn.click();
        sent_media_txt.click();
    }

    @Test
    public void sendSticker() {
        //kirim sticker
        WebElement sticker_btn = driver.findElementById("button_chat_sticker");
        sticker_btn.click();
        WebElement download_sticker_btn = driver.findElementById("sticker_download_button");
        download_sticker_btn.click();

        if (!driver.findElements(By.id("grid_sticker_thumbnails")).isEmpty()) {
            driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();

            WebElement send_picked_btn = driver.findElementById("send_sticker_button");
            send_picked_btn.click();
        }

        WebElement quit_chat_btn = driver.findElementById("button_chat_back");
        quit_chat_btn.click();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}


