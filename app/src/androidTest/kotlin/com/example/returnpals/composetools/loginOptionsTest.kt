package com.example.returnpals.composetools

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
        rule.setContent { LoginUIContent(settingsViewModel = SettingsViewModel(), user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { }, failMessage = "Fail Message" ) }
        rule.onNode(hasText("Sign In |") and hasNoClickAction()).assertIsDisplayed()
    }
    @Test
    fun signInButtonDisplay() {
        rule.setContent { LoginUIContent(settingsViewModel = SettingsViewModel(), user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { }, failMessage = "Fail Message" ) }
        rule.onNode(hasText("Sign In") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun guestButtonDisplay() {
        rule.setContent { LoginUIContent(settingsViewModel = SettingsViewModel(), user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { }, failMessage = "Fail Message" ) }
        rule.onNode(hasText("Guest") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun textFieldEmailDisplay() {
        rule.setContent { LoginUIContent(settingsViewModel = SettingsViewModel(), user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { }, failMessage = "Fail Message" ) }
        rule.onNode(hasText("Email") and hasSetTextAction()).assertIsDisplayed()
    }
    @Test
    fun textFieldPasswordDisplay() {
        rule.setContent { LoginUIContent(settingsViewModel = SettingsViewModel(), user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { }, failMessage = "Fail Message" ) }
        rule.onNode(!hasText("Email") and hasSetTextAction()).assertIsDisplayed()
    }
    @Test
    fun forgotPasswordButtonDisplay() {
        rule.setContent { LoginUIContent(settingsViewModel = SettingsViewModel(), user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { }, failMessage = "Fail Message" ) }
        rule.onNode(hasText("Forgot your password?") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun signUpButtonDisplay() {
        rule.setContent { LoginUIContent(settingsViewModel = SettingsViewModel(), user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { }, failMessage = "Fail Message" ) }
        rule.onNode(hasText("Sign up") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun dontHaveAccountTextDisplay() {
        rule.setContent { LoginUIContent(settingsViewModel = SettingsViewModel(), user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { }, failMessage = "Fail Message" ) }
        rule.onNode(hasText("Don't have an account yet?") and hasNoClickAction()).assertIsDisplayed()
    }
    @Test
    fun returnPalImageDisplay() {
        rule.setContent { LoginUIContent(settingsViewModel = SettingsViewModel(), user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { }, failMessage = "Fail Message" ) }
        rule.onNodeWithContentDescription("ReturnPalName Image").assertIsDisplayed()
    }
    @Test
    fun guestSignInButtonDisplay() {
        rule.setContent { GuestLoginUIContent(userSignIn = { /*TODO*/ }, signin = { /*TODO*/ }, signup = { /*TODO*/ }, email = {})}
        rule.onNode(hasText("Sign In ") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun guestSignInAsGuestButtonDisplay() {
        rule.setContent { GuestLoginUIContent(userSignIn = { /*TODO*/ }, signin = { /*TODO*/ }, signup = { /*TODO*/ }, email = {})}
        rule.onNode(hasText("Sign In as Guest") and hasClickAction()).assertIsDisplayed()
    }

    @Test
    fun guestSignUpButtonDisplay() {
        rule.setContent { GuestLoginUIContent(userSignIn = { /*TODO*/ }, signin = { /*TODO*/ }, signup = { /*TODO*/ }, email = {})}
        rule.onNode(hasText("Sign up") and hasClickAction()).assertIsDisplayed()
    }

    @Test
    fun guestEmailTextDisplayed() {
        rule.setContent { GuestLoginUIContent(userSignIn = { /*TODO*/ }, signin = { /*TODO*/ }, signup = { /*TODO*/ }, email = {})}
        rule.onNode(hasText("Email") and hasSetTextAction()).assertIsDisplayed()
    }

    @Test
    fun confirmNumberEmailDisplayed() {
        rule.setContent{ ConfirmNumberContent(
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
        rule.setContent{ ConfirmNumberContent(
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
        rule.setContent{ ConfirmNumberContent(
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
        rule.setContent{ ConfirmNumberContent(
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