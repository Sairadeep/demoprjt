package viewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import modal.demoRepository

class dataViewModal(private val demo: demoRepository = demoRepository()) : ViewModel() {

    val userInfo = MutableLiveData<List<Map<String,String>>>()

    val userDetails: LiveData<List<Map<String,String>>>
        get() = userInfo

       fun data(){
        demo.dataFetch { usersData ->
            userInfo.value = usersData
        }


//        demo.dataFetch { username, userEmail ->
//            userName.value = username
//            userGmail.value = userEmail
//        }
    }

}