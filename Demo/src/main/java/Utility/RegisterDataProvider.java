package Utility;

import org.testng.annotations.DataProvider;

public class RegisterDataProvider {
	
    @DataProvider(name = "registerNegativeData")
    public Object[][] registerNegativeData() {

        return new Object[][] {

            {
                "Ahmad",
                "Mahmoud",
                "",
                "A123456@a",
                "A123456@a",
                "Email is required."
            },

            {
                "Ahmad",
                "Mahmoud",
                DataGenerator.generateEmail(),
                "",
                "A123456@a",
                "Password is required."
            },

            {
                "Ahmad",
                "Mahmoud",
                DataGenerator.generateEmail(),
                "A123456@a",
                "",
                "Password is required."
            }

        };
    }
}

