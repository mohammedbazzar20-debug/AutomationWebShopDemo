package AuthTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import AuthPage.RegesterPage;
import Base.BaseTest;
import Utility.DataGenerator;

public class RegesterTest extends BaseTest{
	private RegesterPage regesterpath;
	
	
	 @Test(priority = 1)
     public void validRegesterTest1() throws InterruptedException {
		 String email = DataGenerator.generateEmail();
		 RegesterPage regesterpage = new RegesterPage(driver);
         Thread.sleep(1000);
         regesterpage.regester("Ahmad","Mahmoud",email,"A123456@a","A123456@a"); //data provider
         Assert.assertEquals(regesterpage.getSuccessMessage(),"Your registration completed");
         System.out.println("Regester Successful");
         regesterpage.pressContuine();
    	 regesterpage.Presslogout();

	 }



@Test(priority = 2)
public void Regesterwithoutemail() throws InterruptedException {
	 RegesterPage regesterpage = new RegesterPage(driver);
    Thread.sleep(1000);
    regesterpage.regester("Ahmad","Mahmoud","","A123456@a","A123456@a");
    Assert.assertEquals( regesterpage.getEmailError(), "Email is required." );
    System.out.println("Regester unSuccessful");
}



@Test(priority = 3)
public void Regesterwithoutpassword() throws InterruptedException {
	String email = DataGenerator.generateEmail();
	 RegesterPage regesterpage = new RegesterPage(driver);
    Thread.sleep(1000);
    regesterpage.regester("Ahmad","Mahmoud",email,"","A123456@a");
    Assert.assertEquals( regesterpage.getPasswordError(), "Password is required." );
    System.out.println("Regester unSuccessful");
}



@Test(priority = 4)
public void Regesterwithoutconfirmpass() throws InterruptedException {
	String email = DataGenerator.generateEmail();
	 RegesterPage regesterpage = new RegesterPage(driver);
    Thread.sleep(1000);
    regesterpage.regester("Ahmad","Mahmoud",email,"A123456@a","");
    Assert.assertEquals( regesterpage.getConfirmPasswordError(), "Password is required." );
    System.out.println("Regester unSuccessful");
}
@Test(priority = 5)
public void registerWithLongFirstName() throws InterruptedException {

    String email = DataGenerator.generateEmail();

    RegesterPage regesterpage = new RegesterPage(driver);

    String longName = "A".repeat(450);

    regesterpage.regester(
        longName,
        "Mahmoud",
        email,
        "A123456@a",
        "A123456@a"
    );

    Assert.assertTrue(regesterpage.isRegistrationFailed());
    System.out.println("Test Passed - System rejected long name");
}

}

    


