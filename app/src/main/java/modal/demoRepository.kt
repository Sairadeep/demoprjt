package modal

import com.google.firebase.database.*


class demoRepository {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val databaseReference: DatabaseReference = database.reference.child("Users")

    fun dataFetch(userData: (usersData: List<Map<String, String>>) -> Unit) {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val usersList = mutableListOf<Map<String, String>>()

                for (dataSnapshot in snapshot.children) {

                    val userName = dataSnapshot.child("name").value.toString()
                    val userEmail = dataSnapshot.child("email").value.toString()

                    val userMap = mutableMapOf<String, String>()
                    userMap["name"] = userName
                    userMap["email"] = userEmail

                    usersList.add(userMap)

                }

                userData(usersList)

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }


}