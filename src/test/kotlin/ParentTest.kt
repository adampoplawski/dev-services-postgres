import devservicespostgres.Parent
import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import jakarta.inject.Inject
import org.eclipse.microprofile.config.ConfigProvider.*
import org.junit.jupiter.api.Test

@QuarkusTest
class ParentTest: BaseTest() {

   @Test
    fun `Test Parent1`() {
       val config = getConfig()

       When {
            get("hello")
        } Then {
            statusCode(200)
        }
       println( Parent.findAll().list())
    }

    @Test
    fun `Test Parent2`() {
        When {
            get("hello")
        } Then {
            statusCode(200)
        }
        println( Parent.findAll().list())
    }
}
