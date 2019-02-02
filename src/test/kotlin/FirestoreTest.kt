import com.google.firebase.cloud.FirestoreClient
import org.junit.Test
import java.util.*

/**
 * @author hakiba
 */
class FirestoreTest {

    @Test
    fun sample() {
        val db = FirestoreClient.getFirestore(config())

        val docRef = db.collection("users").document("alovelace")
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
}
