package com.returnpal.androidapp.compose

import SettingsViewModel
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasNoClickAction
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class loginOptionsTest {
    //Test Login screen for user and guest display elements. Also check confirmNumber for user registration process.
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun signInTextDisplay() {
        //SignInText
        rule.setContent { LoginContent(settingsViewModel = SettingsViewModel(), failMessage = "Fail Message" ) }
        rule.onNode(hasText("Sign In |") and hasNoClickAction()).assertIsDisplayed()
    }
    @Test
    fun signInButtonDisplay() {
        rule.setContent { LoginContent(settingsViewModel = SettingsViewModel(), failMessage = "Fail Message" ) }
        rule.onNode(hasText("Sign In") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun guestButtonDisplay() {
        rule.setContent { LoginContent(settingsViewModel = SettingsViewModel(), failMessage = "Fail Message" ) }
        rule.onNode(hasText("Guest") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun textFieldEmailDisplay() {
        rule.setContent { LoginContent(settingsViewModel = SettingsViewModel(), failMessage = "Fail Message" ) }
        rule.onNode(hasText("Email") and hasSetTextAction()).assertIsDisplayed()
    }
    @Test
    fun textFieldPasswordDisplay() {
        rule.setContent { LoginContent(settingsViewModel = SettingsViewModel(), failMessage = "Fail Message" ) }
        rule.onNode(!hasText("Email") and hasSetTextAction()).assertIsDisplayed()
    }
    @Test
    fun forgotPasswordButtonDisplay() {
        rule.setContent { LoginContent(settingsViewModel = SettingsViewModel(), failMessage = "Fail Message" ) }
        rule.onNode(hasText("Forgot your password?") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun signUpButtonDisplay() {
        rule.setContent { LoginContent(settingsViewModel = SettingsViewModel(), failMessage = "Fail Message" ) }
        rule.onNode(hasText("Sign up") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun dontHaveAccountTextDisplay() {
        rule.setContent { LoginContent(settingsViewModel = SettingsViewModel(), failMessage = "Fail Message" ) }
        rule.onNode(hasText("Don't have an account yet?") and hasNoClickAction()).assertIsDisplayed()
    }
    @Test
    fun returnPalImageDisplay() {
        rule.setContent { LoginContent(settingsViewModel = SettingsViewModel(), failMessage = "Fail Message" ) }
        rule.onNodeWithContentDescription("ReturnPalName Image").assertIsDisplayed()
    }
    @Test
    fun guestSignInButtonDisplay() {
        rule.setContent { GuestLoginContent() }
        rule.onNode(hasText("Sign In ") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun guestSignInAsGuestButtonDisplay() {
        rule.setContent { GuestLoginContent() }
        rule.onNode(hasText("Sign In as Guest") and hasClickAction()).assertIsDisplayed()
    }

    @Test
    fun guestSignUpButtonDisplay() {
        rule.setContent { GuestLoginContent() }
        rule.onNode(hasText("Sign up") and hasClickAction()).assertIsDisplayed()
    }

    @Test
    fun guestEmailTextDisplayed() {
        rule.setContent { GuestLoginContent(email="Email") }
        rule.onNode(hasText("Email") and hasSetTextAction()).assertIsDisplayed()
    }

    @Test
    fun confirmNumberEmailDisplayed() {
        rule.setContent{ ConfirmEmailContent(
            emailToConfirm = "test@test.com",
            message = "help test",
            submitNumber = "",
            onSubmitNumberChange = {}
        ) {

        } }
        rule.onNodeWithText("test@test.com").assertIsDisplayed()
    }
    @Test
    fun confirmNumberMessageDisplayed() {
        rule.setContent{ ConfirmEmailContent(
            emailToConfirm = "test@test.com",
            message = "help test",
            submitNumber = "",
            onSubmitNumberChange = {}
        ) {

        } }
        rule.onNodeWithText("help test").assertIsDisplayed()
    }
    @Test
    fun confirmNumberPromptDisplayed() {
        rule.setContent{ ConfirmEmailContent(
            emailToConfirm = "test@test.com",
            message = "help test",
            submitNumber = "",
            onSubmitNumberChange = {}
        ) {

        } }
        rule.onNodeWithText("Please enter the confirmation number sent to,\n").assertIsDisplayed()
    }
    @Test
    fun confirmNumberButtonTest() {
        rule.setContent{ ConfirmEmailContent(
            emailToConfirm = "test@test.com",
            message = "help test",
            submitNumber = "",
            onSubmitNumberChange = {}
        ) {

        } }
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