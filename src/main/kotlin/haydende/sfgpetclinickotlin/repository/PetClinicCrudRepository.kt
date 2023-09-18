package haydende.sfgpetclinickotlin.repository

import haydende.sfgpetclinickotlin.model.BaseEntity
import org.springframework.data.repository.CrudRepository

interface PetClinicCrudRepository<T: BaseEntity, ID>: CrudRepository<T, ID> {

    override fun findAll(): Set<T>

}