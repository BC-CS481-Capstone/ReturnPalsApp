package com.example.returnpals.composetools


import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.returnpals.composetools.mainMenu.ChooseRP
import com.example.returnpals.composetools.mainMenu.GTA
import com.example.returnpals.composetools.mainMenu.MissionStatement
import com.example.returnpals.composetools.mainMenu.SocialImpact
import org.junit.Rule
import org.junit.Test


class AboutTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun missionStatementTest() {
        rule.setContent {
            MissionStatement()
        }
        rule.onNodeWithText("Mission Statement").assertIsDisplayed()

        rule.onNodeWithText("Our mission at ReturnPal is to revolutionize the way returns are done by providing a hassle-free and convenient solution for online shoppers.\n" +
                "\n" +
                "We aim to take the stress out of the return process by handling the entire repackaging and delivery process, allowing customers to sit back and relax.",).assertIsDisplayed()

        // Need to test van icon
    }

    @Test
    fun socialImpactTest() {
        rule.setContent {
            SocialImpact()
        }
        rule.onNodeWithText("Social Impact").assertIsDisplayed()

        rule.onNodeWithText("ReturnPal focuses on sustainability and community empowerment, that is why we’re minimizing waste by partnering with companies and agencies like Play Forever to redistribute unsold or unused returns. The returns are sorted, refurbished if needed, and redistributed to various communities in need.").assertIsDisplayed()
    }

    @Test
    fun gta() {
        rule.setContent {
            GTA()
        }
        rule.onNodeWithText("As a convenient one-stop service, We're bringing couriers to your location, repackaging, and delivering your return to a predefined location.\n" +
                "\n" +
                "Our goal is to save you from having to repackage items, print shipping labels, and take that long drive to the not so local post office.").assertIsDisplayed()

        rule.onNodeWithText("We are all over the GTA, with a local facility in Toronto designed to ensure shipping labels are printed and the repackaging of items can meet same-day return needs.\n" +
                "\n" +
                "Returning your online shopping purchases has never been easier.").assertIsDisplayed()
    }

    @Test
    fun chooseRP() {
        rule.setContent {
            ChooseRP()
        }
        rule.onNodeWithText("Why Choose ReturnPal?").assertIsDisplayed()

        rule.onNodeWithText("Our service allows everyday shoppers to return items with just a click of a button, all without leaving home. We also integrate seamlessly with existing business operations, making it easier for companies to offer hassle-free returns while maintaining customer satisfaction. What sets ReturnPal apart is our collaboration with brands to repurpose unsold or returned goods. We achieve this by partnering with various nonprofits and charities.").assertIsDisplayed()

        rule.onNodeWithText("Choosing ReturnPal is a win-win for everyone involved. It simplifies the return process, promotes a more sustainable way of doing business, and ultimately improves the quality of life for our customers. Our focus on simplifying returns, fostering sustainability, and improving quality of life has resonated with both consumers and businesses, making a real difference in the way online shopping returns are handled.").assertIsDisplayed()
    }

}
