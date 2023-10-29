package devservicespostgres

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import org.hibernate.annotations.Type
import org.hibernate.proxy.HibernateProxy
import java.io.Serializable
import java.util.*

@Embeddable
class CompositeId (

    @Enumerated(EnumType.STRING)
    @Type(PostgreSQLEnumType::class)
    val language: Language

) : Serializable {

    val parentId: Long? = null

    companion object {
        private const val serialVersionUID: Long = 198462937492L
    }

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(language = $language , parentId = $parentId )"
    }

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as CompositeId

        return language == other.language
                && parentId == other.parentId
    }

    final override fun hashCode(): Int = Objects.hash(language, parentId);

}
