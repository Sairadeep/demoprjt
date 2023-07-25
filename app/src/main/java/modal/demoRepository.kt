package modal

import com.google.firebase.database.*


class demoRepository {
    private val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    private val databaseReference : DatabaseReference = database.reference.child("Users")

    fun dataFetch(userData: (userNames: String, userEmail: String) -> Unit){
        databaseReference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val userName = snapshot.child("name").value.toString()
                val userEmail = snapshot.child("email").value.toString()

                userData(userName,userEmail)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }


}