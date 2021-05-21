package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass{
	
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="email")
private WebElement txtUsername;

@FindBy(id="pass")
private WebElement txtPassword;


@FindBy(name="login")
private WebElement btnLogin;


@FindBy(xpath="//a[text()='Forgotten password?']")
private WebElement lnkForgotPassword;


@FindBy(name="email")
private WebElement txtMobileNo;


public WebElement getTxtUsername() {
	return txtUsername;
}


public WebElement getTxtPassword() {
	return txtPassword;
}


public WebElement getBtnLogin() {
	return btnLogin;
}


public WebElement getLnkForgotPassword() {
	return lnkForgotPassword;
}


public WebElement getTxtMobileNo() {
	return txtMobileNo;
}



}
