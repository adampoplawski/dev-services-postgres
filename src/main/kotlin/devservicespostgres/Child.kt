package devservicespostgres

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GenerationType.SEQUENCE

@Entity
class Child(

    @EmbeddedId
    val id: CompositeId,

    @ManyToOne(fetch = LAZY)
    @MapsId("parentId")
    @JoinColumn(name = "parent_id")
    val parent: Parent,

    val property: String,
)  {
}
