package com.example.returnpals.composetools

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasNoClickAction
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class loginOptionsTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun signInTextDisplay() {
        //SignInText
        rule.setContent { loginOptions().drawLoginUI(user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { } ) }
        rule.onNode(hasText("Sign In |") and hasNoClickAction()).assertIsDisplayed()
    }
    @Test
    fun signInButtonDisplay() {
        rule.setContent { loginOptions().drawLoginUI(user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { } ) }
        rule.onNode(hasText("Sign In") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun guestButtonDisplay() {
        rule.setContent { loginOptions().drawLoginUI(user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { } ) }
        rule.onNode(hasText("Guest") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun textFieldEmailDisplay() {
        rule.setContent { loginOptions().drawLoginUI(user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { } ) }
        rule.onNode(hasText("Email") and hasSetTextAction()).assertIsDisplayed()
    }
    @Test
    fun textFieldPasswordDisplay() {
        rule.setContent { loginOptions().drawLoginUI(user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { } ) }
        rule.onNode(!hasText("Email") and hasSetTextAction()).assertIsDisplayed()
    }
    @Test
    fun forgotPasswordButtonDisplay() {
        rule.setContent { loginOptions().drawLoginUI(user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { } ) }
        rule.onNode(hasText("Forgot your password?") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun signUpButtonDisplay() {
        rule.setContent { loginOptions().drawLoginUI(user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { } ) }
        rule.onNode(hasText("Sign up") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun dontHaveAccountTextDisplay() {
        rule.setContent { loginOptions().drawLoginUI(user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { } ) }
        rule.onNode(hasText("Don't have an account yet?") and hasNoClickAction()).assertIsDisplayed()
    }
    @Test
    fun returnPalImageDisplay() {
        rule.setContent { loginOptions().drawLoginUI(user = {}, pass = { } , guest = { } , reset = { } , signin = { } , signup = { } ) }
        rule.onNodeWithContentDescription("ReturnPalName Image").assertIsDisplayed()
    }
    @Test
    fun guestSignInButtonDisplay() {
        rule.setContent { loginOptions().drawGuestLoginUI( signin = { },userSignIn= {}) {} }
        rule.onNode(hasText("Sign In ") and hasClickAction()).assertIsDisplayed()
    }
    @Test
    fun guestSignInAsGuestButtonDisplay() {
        rule.setContent { loginOptions().drawGuestLoginUI( signin = { },userSignIn= {}) {} }
        rule.onNode(hasText("Sign In as Guest") and hasClickAction()).assertIsDisplayed()
    }

    @Test
    fun guestSignUpButtonDisplay() {
        rule.setContent { loginOptions().drawGuestLoginUI( signin = { },userSignIn= {}) {} }
        rule.onNode(hasText("Sign up") and hasClickAction()).assertIsDisplayed()
    }

    @Test
    fun guestEmailTextDisplayed() {
        rule.setContent { loginOptions().drawGuestLoginUI( signin = { },userSignIn= {}) {} }
        rule.onNode(hasText("Email") and hasSetTextAction()).assertIsDisplayed()

    }
}