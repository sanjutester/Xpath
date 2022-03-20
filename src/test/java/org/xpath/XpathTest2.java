package org.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathTest2 {
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/Apple-iPhone-13-128GB-Pink/dp/B09G9FPGTN/ref=sr_1_1_sspa?keywords=iphone%2B13&qid=1647572217&sprefix=ipho%2Caps%2C966&sr=8-1-spons&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFBWTBBRTFUR1o4R08mZW5jcnlwdGVkSWQ9QTAwMjMzNjExRTZHVERXSlpRMzhVJmVuY3J5cHRlZEFkSWQ9QTA4NzI2MDRKQzVDSTJGMVJXU08md2lkZ2V0TmFtZT1zcF9hdGYmYWN0aW9uPWNsaWNrUmVkaXJlY3QmZG9Ob3RMb2dDbGljaz10cnVl&th=1");

		WebElement txtRating = driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']/following::div[@aria-valuenow='82%']"));
		String text = txtRating.getText();
		
		System.out.println(text);
		
		
		
}
}