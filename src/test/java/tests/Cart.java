package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;

public class Cart extends BaseTest {
	
	@Test
	public void cartAction()
	{
		CartPage cart=new CartPage(driver);
		cart.clickOncart();
	}

}
