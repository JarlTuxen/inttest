package com.example.inttest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InttestApplicationTests {

	@LocalServerPort
	int port;

	@Test
	public void indexPage() {
		WebDriver driver = getDriver();
		driver.get("http://localhost:"+port+"/");
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		WebElement usernameField = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		usernameField.clear();
		usernameField.sendKeys("jon");
		WebElement velkommen = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("velkommen")));
		Assert.assertNotNull(velkommen);
		driver.close();

	}

	private WebDriver getDriver(){
//		File file = new File(path);
//		System.out.println(path);
//		if(file.isFile()) {
//			ChromeDriverService drService = new ChromeDriverService.Builder()
//					.usingDriverExecutable(file)
//					.usingAnyFreePort()
//					.build();
//			return new ChromeDriver(drService);
//		}else {
//			System.out.println("no driver created");
//			return null;
//		}
		String path = System.getProperty("user.dir")+"/chromedriver";
		System.setProperty("webdriver.chrome.driver",path);
		return new ChromeDriver();
	}


}
