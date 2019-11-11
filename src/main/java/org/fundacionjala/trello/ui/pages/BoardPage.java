package org.fundacionjala.trello.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoardPage {
    private WebDriver webDriver;

    public BoardPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.CSS, using = ".list-name-input")
    private WebElement txtNameList;

    @FindBy(how = How.CSS, using = ".mod-list-add-button.js-save-edit")
    private WebElement btnAddList;

    @FindBy(how = How.CSS, using = ".open-card-composer.card-templates-enabled.js-open-card-composer")
    private WebElement btnAddCard;

    @FindBy(how = How.CSS, using = ".js-cancel-edit")
    private WebElement btnExitCard;

    @FindBy(how = How.CSS, using = ".list-card-composer-textarea.js-card-title")
    private WebElement txtNameCard;

    @FindBy(how = How.CSS, using = ".js-add-card")
    private WebElement btnAcceptAddCard;

    @FindBy(how = How.CSS, using = ".js-cancel")
    private WebElement btnCancelAddCard;

    @FindBy(how = How.CSS, using = ".button-link.js-archive-card")
    private WebElement btnArchiveCard;

    @FindBy(how = How.CSS, using = ".button-link.js-delete-card.negate")
    private WebElement btnDeleteCard;

    @FindBy(how = How.CSS, using = ".js-confirm.full.negate")
    private WebElement btnConfirmDeleteCard;

    public void createList(final String nameList) {
        txtNameList.sendKeys(nameList);
        btnAddList.click();
        btnExitCard.click();
    }

    public void createCard(final String nameCard) {
        btnAddCard.click();
        txtNameCard.sendKeys(nameCard);
        btnAcceptAddCard.click();
        btnCancelAddCard.click();
    }

    public String extractTextToTheCard(final String cardName) {
        String node = String.format("//*[@class='list-card-title js-card-name' and contains(text(),'%s')]", cardName);
        return webDriver.findElement(By.xpath(node)).getText();
    }

    public void deleteCard(final String cardName) {
        String node = String.format("//*[@class='list-card-title js-card-name' and contains(text(),'%s')]", cardName);
         webDriver.findElement(By.xpath(node)).click();
         btnArchiveCard.click();
         btnDeleteCard.click();
         btnConfirmDeleteCard.click();
    }

    public List<WebElement> listOfCards(final String cardName){
        String node = String.format("//*[@class='list-card-title js-card-name' and contains(text(),'%s')]", cardName);
        List<WebElement> elements = webDriver.findElements(By.xpath(node));
        return elements;
    }
}