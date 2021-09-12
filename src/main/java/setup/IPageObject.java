package setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    Object getPageObject();

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

}
