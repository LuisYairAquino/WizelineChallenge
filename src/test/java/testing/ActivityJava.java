package testing;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class ActivityJava extends BaseTest {


	@Override
	protected WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Test
	public void loginWithValidCredentials() throws InterruptedException {
		driver.get(LoginPage.BASE_URL);
		LoginPage login = new LoginPage(driver);
		
		login.loginValid("standard_user", "secret_sauce");
		
		System.out.println(login.nextProdPage());
		
		Assert.assertEquals("PRODUCTS", login.nextProdPage());
		
	}
	
	@Test
	public void loginWithInvalidCredentials() throws InterruptedException {
		driver.get(LoginPage.BASE_URL);
		LoginPage login = new LoginPage(driver);

		login.loginInvalid("luis", "luis123");

		System.out.println(login.errorMessageCredentials());
		String error = "Epic sadface: Username and password do not match any user in this service";
		
		Assert.assertEquals(error, login.errorMessageCredentials());
		
	}
	
	@Test
	public void logoutFromHomePage() throws InterruptedException {
		driver.get(LoginPage.BASE_URL);
		LoginPage login = new LoginPage(driver);
		
		login.logout("standard_user", "secret_sauce");
		
		System.out.println(login.imageLoginPage());
		
		Assert.assertEquals(login.imageLoginPage(), login.imageLoginPage());
	}
	
	@Test
	public void sortProductoByLowToHigh() throws InterruptedException {
		driver.get(LoginPage.BASE_URL);
		LoginPage login = new LoginPage(driver);
		
		login.sortProducts("standard_user", "secret_sauce");
		
		System.out.println(login.nextProdPage());
		
		Assert.assertEquals("PRODUCTS", login.nextProdPage());
		
		System.out.println(login.itemDisplayedLowToHigh());
		Assert.assertEquals(login.itemDisplayedLowToHigh(), login.itemDisplayedLowToHigh());
		
	}
	
	@Test
	public void addMultiItems() throws InterruptedException {
		driver.get(LoginPage.BASE_URL);
		LoginPage login = new LoginPage(driver);
		
		login.addMultipleItemsShoppingCart("standard_user", "secret_sauce");
		
		System.out.println(login.yourCartPage());
		
		Assert.assertEquals("YOUR CART", login.yourCartPage());
		
	}
	
	@Test
	public void addOnesieItemToShoppingCart() throws InterruptedException {
		driver.get(LoginPage.BASE_URL);
		LoginPage login = new LoginPage(driver);
		
		login.addItemToShoppingCart("standard_user", "secret_sauce");
		
	}
	
	@Test
	public void completePurchaseTestCase() throws InterruptedException {
		driver.get(LoginPage.BASE_URL);
		LoginPage login = new LoginPage(driver);
		
		login.completePurchase("standard_user", "secret_sauce", "luis", "aquino", "12345");
		
	}

}
