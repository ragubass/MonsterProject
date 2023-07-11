package com.carousel.test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class monsterDemo {

	public static void main(String[] args) {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		pages.HomePageCarousel.enter_url(driver);
		driver.manage().window().maximize();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();

		int[] arr = new int[] { 1, 2 };
		System.out.println("Carousel index: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			String selector = "//*[@id=\"main-content\"]/div/div[2]/div[1]/div[" + arr[i]
					+ "]/div/div/div/div/div[2]/div/section/div/ul";
			String arrow = "//*[@id=\"main-content\"]/div/div[2]/div[1]/div[" + arr[i]
					+ "]/div/div/div/div/div[2]/div/section/div/div[1]/button[2]";
			WebElement element = driver.findElement(By.xpath(selector));
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();

			List<WebElement> optionCount = driver.findElements(By.xpath(selector + "/li"));
			WebElement p = driver.findElement(By.xpath(selector));
			String productTitle;
			WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(20));
			webdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(arrow)));
			for (int j = 1; j <= 7; j++) {
				driver.findElement(By.xpath(arrow)).click();
				webdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(arrow)));
				productTitle = p.getText();
				System.out.println("Carousel count:" + optionCount.size());
				System.out.println("Carousel Text:" + productTitle);
				list1.add(productTitle);
				System.out.println("Carousel list1" + list1);
				if (optionCount.size() < 15) {
					System.out.println("Carousel don't have 15 elements test failed");
				} else {
					System.out.println("Carousel have 15 elements test pass");
				}
			}
		}

		int[] arr2 = new int[] { 5, 6, 8 };
		System.out.println("Carousel index: ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
			WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(20));
			String selector = "//*[@id=\"main-content\"]/div/div[2]/div[" + arr2[i]
					+ "]/div/div/div/div/div/div[2]/div/section/div/ul";
			String arrow = "//*[@id=\"main-content\"]/div/div[2]/div["+arr2[i]+"]/div/div/div/div/div/div[2]/div/section/div/div[1]/button[2]";
			webdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
			WebElement element = driver.findElement(By.xpath(selector));
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();

			List<WebElement> optionCount = driver.findElements(By.xpath(selector + "/li"));
			System.out.println("Carousel count:" + optionCount.size());
			String productTitle;
			WebElement p = driver.findElement(By.xpath(selector));
			webdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(arrow)));
			for (int j = 1; j <= 7; j++) {
				driver.findElement(By.xpath(arrow)).click();
				webdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(arrow)));
				productTitle = p.getText();
				System.out.println("Carousel Text:" + productTitle);
				list2.add(productTitle);
				System.out.println("Carousel list2" + list2);
				if (optionCount.size() < 15) {
					System.out.println("Carousel don't have 15 elements test failed");
				} else {
					System.out.println("Carousel have 15 elements test pass");
				}
			}
			 if (list1.equals(list2) == true) {
		            System.out.println("Elements are not unique");
		        }
		        else {
		            System.out.println("Elements are unique");
		        }
			
		}
	}
}