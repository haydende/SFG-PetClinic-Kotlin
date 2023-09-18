package haydende.sfgpetclinickotlin.repository

import haydende.sfgpetclinickotlin.model.Owner

interface OwnerRepository : PetClinicCrudRepository<Owner, Long> {

    fun findAllByLastNameLike(search: String): Set<Owner>

    fun findAllByFirstNameLike(search: String): Set<Owner>

}