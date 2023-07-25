package viewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import modal.demoRepository

class dataViewModal(private val demo: demoRepository = demoRepository()) : ViewModel() {

    private val userName = MutableLiveData<String>()

    val userNamed: LiveData<String>
        get() = userName

    private val userGmail = MutableLiveData<String>()

    val email: LiveData<String>
        get() = userGmail

    fun data() {
        demo.dataFetch { username, userEmail ->
            userName.value = username
            userGmail.value = userEmail
        }
    }

}