package com.example.returnpals.composetools

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasNoClickAction
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.returnpals.composetools.login.ConfirmEmailContent
import com.example.returnpals.composetools.login.GuestLoginContent
import com.example.returnpals.composetools.login.LoginContent
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    //Test Login screen for user and guest display elements. Also check confirmNumber for user registration process.
    @get:Rule
    val rule = createComposeRule()
    @Test
    fun signInButton() {
        rule.setContent { LoginContent() }
        val n = rule.onAllNodes(hasText("Sign In") and hasClickAction())
        n.assertCountEquals(2)
        n[0].assertIsDisplayed()
        n[1].assertIsDisplayed()
    }
    @Test
    fun modeToggle() {
        rule.setContent { LoginContent() }
        rule.onNode(hasText("Guest") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun guestModeToggle() {
        rule.setContent { GuestLoginContent() }
        rule.onNode(hasText("Sign In") and hasClickAction()).assertIsDisplayed()
        rule.onNode(hasText("Guest") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun emailTextField() {
        rule.setContent { LoginContent(email="test@bellevue.college") }
        rule.onNode(hasText("test@bellevue.college") and hasSetTextAction()).assertIsDisplayed()
    }
    @Test
    fun guestEmailTextField() {
        rule.setContent { GuestLoginContent(email="test@bellevue.college") }
        rule.onNode(hasText("test@bellevue.college") and hasSetTextAction()).assertIsDisplayed()
    }
//    @Test
//    fun passwordTextField() {
//        rule.setContent { LoginContent(password="Password123$") }
//        rule.onNode(hasText("************") and hasSetTextAction()).assertIsDisplayed()
//    }
//    @Test
//    fun failMessageText() {
//        rule.setContent { LoginContent(failMessage="Nuh-uh") }
//        rule.onNode(hasText("Nuh-uh") and hasSetTextAction()).assertIsDisplayed()
//    }
    @Test
    fun forgotPasswordButton() {
        rule.setContent { LoginContent() }
        rule.onNode(hasText("Forgot your password?") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun signUpButton() {
        rule.setContent { LoginContent() }
        rule.onNode(hasText("Sign up") and hasClickAction()).assertIsDisplayed()
    }

    @Test
    fun guestSignUpButton() {
        rule.setContent { GuestLoginContent() }
        rule.onNode(hasText("Sign up") and hasClickAction()).assertIsDisplayed()
    }

    @Test
    fun dontHaveAccountText() {
        rule.setContent { LoginContent() }
        rule.onNode(hasText("Don't have an account yet?") and hasNoClickAction()).assertIsDisplayed()
    }
    @Test
    fun guestDontHaveAccountText() {
        rule.setContent { GuestLoginContent() }
        rule.onNode(hasText("Don't have an account yet?") and hasNoClickAction()).assertIsDisplayed()
    }
    @Test
    fun returnPalImage() {
        rule.setContent { LoginContent() }
        rule.onNodeWithContentDescription("ReturnPalName Image").assertIsDisplayed()
    }
    @Test
    fun guestReturnPalImage() {
        rule.setContent { GuestLoginContent() }
        rule.onNodeWithContentDescription("ReturnPalName Image").assertIsDisplayed()
    }
    @Test
    fun guestSignInAsGuestButtonDisplay() {
        rule.setContent { GuestLoginContent() }
        rule.onNode(hasText("Sign In as Guest") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun confirmNumberEmailDisplayed() {
        rule.setContent{
            ConfirmEmailContent(
                emailToConfirm = "test@test.com",
                message = "help test",
                submitNumber = "",
                onSubmitNumberChange = {}
            ) {}
        }
        rule.onNodeWithText("test@test.com").assertIsDisplayed()
    }
    @Test
    fun confirmNumberMessageDisplayed() {
        rule.setContent{
            ConfirmEmailContent(
                emailToConfirm = "test@test.com",
                message = "help test",
                submitNumber = "",
                onSubmitNumberChange = {}
            ) {}
        }
        rule.onNodeWithText("help test").assertIsDisplayed()
    }
    @Test
    fun confirmNumberPromptDisplayed() {
        rule.setContent{
            ConfirmEmailContent(
                emailToConfirm = "test@test.com",
                message = "help test",
                submitNumber = "",
                onSubmitNumberChange = {}
            ) {}
        }
        rule.onNodeWithText("Please enter the confirmation number sent to,\n").assertIsDisplayed()
    }
    @Test
    fun confirmNumberButtonTest() {
        rule.setContent{
            ConfirmEmailContent(
                emailToConfirm = "test@test.com",
                message = "help test",
                submitNumber = "",
                onSubmitNumberChange = {}
            ) {}
        }
        rule.onNode(hasText("Verify") and hasClickAction()).assertIsDisplayed()
    }
    /* REMOVE test that use Amplify commands.  This uses amplify command in the backend.
    @Test
    fun loginUIStateTestToGuest() {

        rule.setContent { val navController = TestNavHostController(LocalContext.current)
            LoginScreen(LoginViewModel(), navController) }
        rule.onNode(hasText("Guest") and hasClickAction()).performClick()
        rule.onNode(hasText("Sign In as Guest") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun loginUIStateTestToUser() {
        var model = LoginViewModel()
        model.switchGuestUser()
        rule.setContent { val navController = TestNavHostController(LocalContext.current)
            LoginScreen(model, navController) }
        rule.onNode(hasText("Sign In ") and hasClickAction()).performClick()
        rule.onNode(hasText("Sign In") and hasClickAction()).assertIsDisplayed()
    }
    */
}