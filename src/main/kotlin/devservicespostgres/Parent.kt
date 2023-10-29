package devservicespostgres

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*
import jakarta.persistence.GenerationType.SEQUENCE

@Entity
class Parent(
    val property: String,
) : PanacheEntity(){

    companion object: PanacheCompanion<Parent>

    @SequenceGenerator(name = "parent_seq", sequenceName = "parent_seq", allocationSize = 50)
    @GeneratedValue(strategy = SEQUENCE, generator = "parent_seq")
    override var id: Long? = null

    @OneToMany(mappedBy = "parent", cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    val childs: MutableSet<Child> = mutableSetOf()
}
