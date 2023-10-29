import jakarta.inject.Inject
import org.flywaydb.core.Flyway
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

abstract class BaseTest {

    @Inject
    private lateinit var flyway: Flyway


    @BeforeEach
    fun setUp() {
        flyway.clean()
        flyway.migrate()
    }

    @AfterEach
    fun tearDown() {
    }
}
