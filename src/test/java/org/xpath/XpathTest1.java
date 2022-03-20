package org.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathTest1 {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/s?k=iphone12+256GB&crid=2HOU4P1375MBH&sprefix=iphone+12+256%2Caps%2C7394&ref=nb_sb_noss_1");
		
		WebElement txtXpath= driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (256GB) - Blue']/ancestor::div[@class='a-section a-spacing-none s-padding-right-small s-title-instructions-style']/following-sibling::div[@class='sg-row']/descendant::span[@class='a-price-whole']"));
		
		WebElement symplXpath= driver.findElement(By.xpath("//span[text()='Ap"
				+ "ple iPhone 12 (256GB) - Blue']/ancestor::div[@class='a-section a-spacing-none s-padding-right-small s-title-instructions-style']/following-sibling::div[@class='sg-row']/descendant::span[@class='a-price-symbol']"));
		
		
		String text2 = txtXpath.getText();
		
		String text = symplXpath.getText();
		
		System.out.println(text+text2);
		
		
		
		
		
		
	}
	

}
