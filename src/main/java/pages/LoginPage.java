package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage extends BasePage {


	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String BASE_URL = "https://www.saucedemo.com/";
	
	@FindBy(how = How.ID, using = "user-name")
	private WebElement userNameInput;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement pwdInput;
	
	@FindBy(how = How.ID, using = "login-button")
	private WebElement loginBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header_container\"]/div[2]/span")
	private WebElement nextProductPage;
	
	//Invalid credential message error
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"login_button_container\"]/div/form/div[3]")
	private WebElement errorMsg;
	
	//Logout Elements
	
	@FindBy(how = How.ID, using = "react-burger-menu-btn")
	private WebElement BurguerBtn;
	
	@FindBy(how = How.ID, using = "logout_sidebar_link")
	private WebElement logoutBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[1]/div[2]")
	private WebElement imageSauceLogin;
	
	//Sorting Products
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
	private WebElement selectProduct;
		
	@FindBy(how = How.CSS, using = "#item_2_title_link > div")
	private WebElement newItemDisplayed;
	
	//Adding Multiple Items to Shopping cart
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	private WebElement productOne;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
	private WebElement productTwo;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
	private WebElement productThree;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
	private WebElement productFour;
	
	@FindBy(how = How.CSS, using = "#shopping_cart_container > a")
	private WebElement shoppingCartButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header_container\"]/div[2]/span")
	private WebElement yourCartPageTitle;
	
	//Souce Labs Onesie Item
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
	private WebElement onesieItem;
	
	@FindBy(how = How.CSS, using = "#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_quantity")
	private WebElement onesieItemConfirmation;
	
	@FindBy(how = How.CSS, using = "#item_2_title_link > div")
	private WebElement onesieItemCartAdded;
	
	//Checkout button
	
	@FindBy(how = How.ID, using = "checkout")
	private WebElement checkoutButton;
	
	//Information Filled
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header_container\"]/div[2]/span")
	private WebElement informationFormPage;
	
	@FindBy(how = How.ID, using = "first-name")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "last-name")
	private WebElement lastName;
	
	@FindBy(how = How.ID, using = "postal-code")
	private WebElement postalCode;
	
	//Continue button
	
	@FindBy(how = How.ID, using = "continue")
	private WebElement continueButton;
	
	//Checkout Page
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header_container\"]/div[2]/span")
	private WebElement checkoutPage;
	
	//Finish Transaction button and finish page
	
	@FindBy(how = How.ID, using = "finish")
	private WebElement finishButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"checkout_complete_container\"]/img")
	private WebElement finishPageImage;
	
	
	
	public void loginValid(String username, String password) throws InterruptedException {
		userNameInput.sendKeys(username);
		Thread.sleep(3000);
		pwdInput.sendKeys(password);
		Thread.sleep(3000);
		loginBtn.click();
	}
	
	public void loginInvalid(String username, String password) throws InterruptedException {
		userNameInput.sendKeys(username);
		Thread.sleep(3000);
		pwdInput.sendKeys(password);
		Thread.sleep(3000);
		loginBtn.click();
		Thread.sleep(3000);
	}
	
	public void logout(String username, String password) throws InterruptedException {
		userNameInput.sendKeys(username);
		Thread.sleep(3000);
		pwdInput.sendKeys(password);
		Thread.sleep(3000);
		loginBtn.click();
		Thread.sleep(3000);
		BurguerBtn.click();
		Thread.sleep(3000);
		logoutBtn.click();
	}
	
	public void sortProducts(String username, String password) throws InterruptedException {
		userNameInput.sendKeys(username);
		Thread.sleep(3000);
		pwdInput.sendKeys(password);
		Thread.sleep(3000);
		loginBtn.click();
		Thread.sleep(3000);
		selectProduct.click();
		Thread.sleep(3000);
		Select product = new Select(selectProduct);
		Thread.sleep(3000);
		product.selectByVisibleText("Price (low to high)");
		Thread.sleep(3000);
		
	}
	
	public void addMultipleItemsShoppingCart(String username, String password) throws InterruptedException {
		userNameInput.sendKeys(username);
		Thread.sleep(3000);
		pwdInput.sendKeys(password);
		Thread.sleep(3000);
		loginBtn.click();
		Thread.sleep(3000);
		productOne.click();
		Thread.sleep(3000);
		productTwo.click();
		Thread.sleep(3000);
		productThree.click();
		Thread.sleep(3000);
		productFour.click();
		Thread.sleep(3000);
		shoppingCartButton.click();
		Thread.sleep(3000);
		
	}
	
	public void addItemToShoppingCart(String username, String password) throws InterruptedException {
		userNameInput.sendKeys(username);
		pwdInput.sendKeys(password);
		loginBtn.click();
		onesieItem.click();
		shoppingCartButton.click();
		System.out.println(onesieItemConfirmation.getText());
		Assert.assertEquals("1", onesieItemAdded());
		System.out.println(onesieItemCartAdded.getText());
		Assert.assertEquals("Sauce Labs Onesie", onesieItemAddedTitleCart());
	}
	
	public void completePurchase(String username, String password, String firstname, String lastname, String postalcode) throws InterruptedException {
		userNameInput.sendKeys(username);
		pwdInput.sendKeys(password);
		loginBtn.click();
		onesieItem.click();
		shoppingCartButton.click();
		System.out.println(onesieItemConfirmation.getText());
		Assert.assertEquals("1", onesieItemAdded());
		System.out.println(onesieItemCartAdded.getText());
		Assert.assertEquals("Sauce Labs Onesie", onesieItemAddedTitleCart());
		checkoutButton.click();
		System.out.println(informationFormPage.getText());
		Assert.assertEquals("CHECKOUT: YOUR INFORMATION", informationPage());
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		postalCode.sendKeys(postalcode);
		continueButton.click();
		System.out.println(checkoutPage.getText());
		Assert.assertEquals("CHECKOUT: OVERVIEW", checkoutMessagePage());
		finishButton.click();
		System.out.println(finishTransactionPage());
		Assert.assertEquals(finishTransactionPage(), finishTransactionPage());
	}
	
	
	public String nextProdPage() {
		return nextProductPage.getText();
	}
	
	public String errorMessageCredentials() {
		return errorMsg.getText();
	}
	
	public String imageLoginPage() {
		return imageSauceLogin.getText();
	}
	
	public String itemDisplayedLowToHigh() {
		return newItemDisplayed.getText();
	}
	
	public String yourCartPage() {
		return yourCartPageTitle.getText();
	}
	
	public String onesieItemAdded() {
		return onesieItemConfirmation.getText();
	}
	
	public String onesieItemAddedTitleCart() {
		return onesieItemCartAdded.getText();
	}
	
	public String informationPage() {
		return informationFormPage.getText();
	}
	
	public String checkoutMessagePage() {
		return checkoutPage.getText();
	}
	
	public String finishTransactionPage() {
		return finishPageImage.getTagName();
	}
}
