package com.example.returnpals.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.returnpals.dataRepository.RegisterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel (
    private val registerRepository: RegisterRepository
): ViewModel(

){
    // You can expose LiveData or StateFlow for observing the operation's result in the UI
    private val _submissionSuccessful = MutableLiveData<Boolean?>()
    val submissionSuccessful: LiveData<Boolean?> = _submissionSuccessful
    private val _cancelRegistration = MutableLiveData<Boolean?>()
    val cancelRegistration: LiveData<Boolean?> = _cancelRegistration
    var failMessage = ""
    
    companion object {
        private const val TAG = "ReturnPalsApp"
    }

    fun onSubmit() {
        //Sends UI state to repository and lambda to set error message and condition variable.
        registerRepository.registerUser(registerUserInfo = uiState.value){ isSuccess,message->
            _submissionSuccessful.postValue(isSuccess)
            if (message != null) onFailMessage(message)
        }
    }
    fun onCancel() {
        //Clears the data saved in the UIstate
        _uiState.update{
            RegisterUserInfo()
        }
        //Sends navigation signal
        _cancelRegistration.postValue(true)
    }



    fun resetSubmissionSuccess() {
        _submissionSuccessful.value = null // Reset the LiveData to its initial state
    }


    /** Following the tutorial information from https://developer.android.com/topic/libraries/architecture/viewmodel
     * */
    private val _uiState = MutableStateFlow(RegisterUserInfo())
    val uiState: StateFlow<RegisterUserInfo> = _uiState.asStateFlow()

    fun onFistName(fisrtName:String) {
        _uiState.update {
            it.copy(firstName = fisrtName)
        }
    }
    fun onLastName(LastName:String) {
        _uiState.update {
            it.copy(lastName = LastName)
        }
    }
    fun onAddress(address:String) {
        _uiState.update {
            it.copy(address = address)
        }
    }
    fun onEmail(email:String) {
        _uiState.update {
            it.copy(email = email)
        }
    }
    fun onPhoneNumber(phoneNumber:String) {
        _uiState.update {
            it.copy(phoneNumber = phoneNumber)
        }
    }
    fun onCity(city:String) {
        _uiState.update {
            it.copy(city = city)
        }
    }
    fun onSuiteNumber(suiteNumber:String) {
        _uiState.update {
            it.copy(suiteNumber = suiteNumber)
        }
    }
    fun onPostalCode(postalCode:String) {
        _uiState.update {
            it.copy(postalCode = postalCode)
        }
    }
    fun onPassword1(password1:String) {
        _uiState.update {
            it.copy(password1 = password1)
        }
    }
    fun onPassword2(password2:String) {
        _uiState.update {
            it.copy(password2 = password2)
        }
    }
    fun onFailMessage(failMessage:String) {
        _uiState.update {
            it.copy(failMessage = failMessage)
        }
    }

}

data class RegisterUserInfo(
    val firstName:String = "",
    val lastName:String = "",
    val address:String = "",
    val email:String = "",
    val phoneNumber:String = "",
    val city:String = "",
    val suiteNumber:String = "",
    val password1:String = "",
    val password2:String = "",
    val postalCode:String = "",
    val failMessage:String = ""
)




