package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.utils.AbstractPage;
import org.fundacionjala.trello.pages.board.Dashboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractPage {

    @FindBy(css = "#user")
    private WebElement userField;
    @FindBy(css = "#password")
    private WebElement passwordField;
    @FindBy(css = "#login")
    private WebElement loginButton;

    protected void setUserName(final String userName) {
        webDriverAction.waitVisibility(userField);
        webDriverAction.setValue(userField, userName);
    }

    protected void setPassword(final String password) {
        webDriverAction.waitVisibility(passwordField);
        webDriverAction.setValue(passwordField, password);
    }

    protected Dashboard clickLoginButton() {
        webDriverAction.waitVisibility(loginButton);
        webDriverAction.click(loginButton);
        return new Dashboard();
    }

    public Dashboard login(final String username, final String password) {
        this.setUserName(username);
        this.setPassword(password);
        return this.clickLoginButton();
    }
}