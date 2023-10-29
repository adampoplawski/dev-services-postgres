package devservicespostgres

import jakarta.transaction.Transactional
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON
import org.jboss.resteasy.reactive.ResponseStatus

@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Path("/hello")
class ParentController(
) {

    @GET
    @ResponseStatus(200)
    @Transactional
    fun saveParent ()  {
        val parent = Parent(property = "test")
        val child1 = Child(property = "child1", id= CompositeId(Language.PL), parent = parent)
        val child2 = Child(property = "child2", id= CompositeId(Language.EN), parent = parent)
        parent.childs.add(child1)
        parent.childs.add(child2)
        Parent.persist(parent)
    }
}
