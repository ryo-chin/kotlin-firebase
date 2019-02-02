
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class GoogleCloudStorageTest {

    @Test
    fun upload() {
        val imageFile = File("src/test/resources/images/hakiba.png")
        bucket().create(imageFile.name, Files.readAllBytes(Paths.get(imageFile.toURI())))
    }

    @Test
    fun download() {
        val image = bucket().get("hakiba.png")
        Assert.assertNotNull(image)
        println(image)
    }
}