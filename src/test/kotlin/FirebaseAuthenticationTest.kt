
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import org.junit.Test
import java.util.*

/**
 * @author hakiba
 */
class FirebaseAuthenticationTest {

    @Test
    fun authentication() {
        val auth = FirebaseAuth.getInstance(config())
        val uid = UUID.randomUUID().toString()

        updateOrCreateUser(auth, uid)
        val customToken = createCustomToken(auth, uid)

        println(customToken)
    }

    private fun updateOrCreateUser(auth: FirebaseAuth, uid: String) {
        val updateRequest = UserRecord.UpdateRequest(uid)
        updateRequest.setDisplayName("DisplayName")
        updateRequest.setEmail("$uid@submarine.co.jp")
        updateRequest.setEmailVerified(true)
        updateRequest.setPhotoUrl("http:/user/photo_url")

        try {
            auth.updateUserAsync(updateRequest).get()
        } catch (e: Exception) {
            e.printStackTrace()

            val createRequest = UserRecord.CreateRequest()
            createRequest.setUid(uid)
            createRequest.setDisplayName("DisplayName")
            createRequest.setEmail("$uid@submarine.co.jp")
            createRequest.setEmailVerified(true)
            createRequest.setPhotoUrl("http:/user/photo_url")
            auth.createUserAsync(createRequest).get()
        }
    }

    private fun createCustomToken(auth: FirebaseAuth, uid: String) : String {
        return auth.createCustomTokenAsync(uid).get()
    }
}
