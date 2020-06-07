package com.hrms.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.PageInitializer;

public class commonMethods extends PageInitializer {

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * this method check if Radio/checkbox is enabled and clicks it
	 * 
	 * @param webElement
	 * @param b
	 */
	public static void clickRadioorCheckbox(List<WebElement> webElement, boolean b) {
		String actualValue;
		for (WebElement el : webElement) {
			actualValue = el.getAttribute("value").trim();
			if (actualValue.equals(b)) {
				el.click();
				break;
			}
		}
	}

	/**
	 * this method selects DD option by visible Text
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectDDvalue(WebElement element, String text) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement el : options) {
				if (el.getText().equals(text)) {
					select.selectByVisibleText(text);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method select DD using index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDDvalue(WebElement element, int index) {
		try {
			Select select = new Select(element);
			int size = select.getOptions().size();
			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method accepts alert
	 * 
	 */
	public static void acceptAlert() {
		try {

			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	public static String getAlertText() {
		String alertText = "";
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}
		return alertText;

	}

	public static void switchToFrame(String nameorId) {
		try {
			driver.switchTo().frame(nameorId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method switches to frame by index
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * explicit wait time
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	public static void waitForClickable(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void click(WebElement element) {
		waitForClickable(element);
		element.click();
	}

	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Method that will scroll the page down based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	public class DashBoardPageElements {

		@FindBy(id = "welcome")
		public WebElement welcome;

	}

	public static String takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		String screenshotDestination=Constants.SCREENSHOT_FILE_PATH+filename+getTimeStemp()+".png";
		
		try {
			FileUtils.copyFile(file, new File (screenshotDestination));
		} catch (Exception ex) {
			System.out.println("We cannot take screenshot");
		}
		return screenshotDestination;
	}
	public static String getTimeStemp() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return sdf.format(date.getTime());
	}

	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
