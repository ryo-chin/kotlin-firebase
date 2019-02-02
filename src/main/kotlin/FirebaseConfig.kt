
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.Bucket
import com.google.cloud.storage.StorageOptions
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions


fun config() : FirebaseApp {
    val credentials = GoogleCredentials.getApplicationDefault()
    // if you set path in code, as below.
    //    val credentials = GoogleCredentials.fromStream(FileInputStream(<your credentials path>))

    val options = FirebaseOptions.Builder()
        .setCredentials(credentials)
        .build()
    return FirebaseApp.initializeApp(options)
}

fun bucket() : Bucket = StorageOptions.getDefaultInstance().service.get(System.getenv("PROJECT_NAME"))
