package com.getir;


import com.getir.pages.*;

public class Pages {


	private HeaderPage header;

	public HeaderPage headerSection(){
		if(header == null)
			header = new HeaderPage();
		return header;
	}
	private LoginPage login;
	public LoginPage loginPage(){
		if(login == null)
			login = new LoginPage();
		return login;
	}
	private ShoppingPage shop;
	public ShoppingPage shoppingPage(){
		if(shop == null)
			shop = new ShoppingPage();
		return shop;
	}
	private CheckoutPage checkout;
	public CheckoutPage checkoutPage(){
		if(checkout == null)
			checkout = new CheckoutPage();
		return checkout;
	}

	private WishListPage wishlist;
	public WishListPage wishListPage(){
		if(wishlist == null)
			wishlist = new WishListPage();
		return wishlist;
	}
}
