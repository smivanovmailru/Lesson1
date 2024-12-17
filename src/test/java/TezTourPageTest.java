import lesson5.TezTourPage;
import org.testng.annotations.Test;

public class TezTourPageTest {
    @Test

    public void selectTrip() throws InterruptedException {
        TezTourPage.openPage();
        TezTourPage.selectVitebsk();
        TezTourPage.selectTyrkey();
        TezTourPage.selectDate();
        TezTourPage.days();
        TezTourPage.Tourists();
        TezTourPage.clickingFindButton();
        Thread.sleep(1000);
        TezTourPage.switchToNewTab();

    }
}
