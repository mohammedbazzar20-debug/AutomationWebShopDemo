package AuthTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import AuthPage.RegesterPage;
import Base.BaseTest;
import Utility.DataGenerator;
import Utility.RegisterDataProvider;

public class RegesterTest extends BaseTest{
	
	
	 @Test(priority = 1)
     public void validRegesterTest1() {
		 String email = DataGenerator.generateEmail();
		 RegesterPage regesterpage = new RegesterPage(driver);
		 waitSeconds(2);
         regesterpage.regester("Ahmad","Mahmoud",email,"A123456@a","A123456@a");
         waitSeconds(2);
         Assert.assertEquals(regesterpage.getSuccessMessage(),"Your registration completed");
         waitSeconds(2);
         System.out.println("Regester Successful");
         regesterpage.pressContuine();
    	 regesterpage.Presslogout();

	 }



	 @Test(
			    dataProvider = "registerNegativeData",
			    dataProviderClass = RegisterDataProvider.class
			)
			public void invalidRegisterTest(
			        String firstName,
			        String lastName,
			        String email,
			        String password,
			        String confirmPassword,
			        String expectedError) {

			    RegesterPage regesterpage = new RegesterPage(driver);

			    regesterpage.regester(
			            firstName,
			            lastName,
			            email,
			            password,
			            confirmPassword);

			    if (email.isEmpty()) {

			        Assert.assertEquals(
			                regesterpage.getEmailError(),
			                expectedError);

			    } else if (password.isEmpty()) {

			        Assert.assertEquals(
			                regesterpage.getPasswordError(),
			                expectedError);

			    } else {

			        Assert.assertEquals(
			                regesterpage.getConfirmPasswordError(),
			                expectedError);
			    }

			    System.out.println("Negative Test Passed");
			}
@Test(priority = 5)
public void registerWithLongFirstName() {

    String email = DataGenerator.generateEmail();

    RegesterPage regesterpage = new RegesterPage(driver);

    String longName = "A".repeat(450);
    waitSeconds(2);
    regesterpage.regester(
        longName,
        "Mahmoud",
        email,
        "A123456@a",
        "A123456@a"
    );
    waitSeconds(2);
    Assert.assertTrue(regesterpage.isRegistrationFailed());
    waitSeconds(2);
    System.out.println("Test Passed - System rejected long name");
}

}

    


