package haydende.sfgpetclinickotlin.repository

import haydende.sfgpetclinickotlin.model.Owner
import org.springframework.data.jpa.repository.JpaRepository

interface OwnerRepository : JpaRepository<Owner, Long> {

    fun findAllByLastNameLike(search: String): Set<Owner>

    fun findAllByFirstNameLike(search: String): Set<Owner>

    fun save(owner: Owner): Owner

}