package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
 
	public void selectDropDownMenu(WebElement element, String visibleText) {
		Select sel = new Select(element);
    	sel.selectByVisibleText(visibleText);
	}
	public int generatRandomNum(int boundaryNum) {
		 Random rnd = new Random();
		int generateNum = rnd.nextInt( boundaryNum);
		 return generateNum;
	}
}
