
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import java.util.*


fun db() : Firestore {
    val credentials = GoogleCredentials.getApplicationDefault()
    // if you set path in code, as below.
    //    val credentials = GoogleCredentials.fromStream(FileInputStream(<your credentials path>))

    val options = FirebaseOptions.Builder()
        .setCredentials(credentials)
        .build()
    FirebaseApp.initializeApp(options)

    return FirestoreClient.getFirestore()
}

fun main() {
    val docRef = db().collection("users").document("alovelace")
    // Add document data  with id "alovelace" using a hashmap
    val data = HashMap<String, Any>()
    data["first"] = "Ada"
    data["last"] = "Lovelace"
    data["born"] = 1815
    //asynchronously write data
    val result = docRef.set(data)
    // ...
    // result.get() blocks on response
    System.out.println("Update time : " + result.get().getUpdateTime())
}


