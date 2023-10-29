import devservicespostgres.Parent
import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import jakarta.inject.Inject
import org.junit.jupiter.api.Test

@QuarkusTest
class ParentTest2: BaseTest() {

    @Test
    fun `Test Parent3`() {
        When {
            get("hello")
        } Then {
            statusCode(200)
        } Extract {
            println( body().asString())
        }
    }

    @Test
    fun `Test Parent4`() {
        When {
            get("hello")
        } Then {
            statusCode(200)
        }Extract {
            println( body().asString())
        }
    }
}
