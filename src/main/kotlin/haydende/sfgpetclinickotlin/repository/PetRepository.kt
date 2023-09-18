package haydende.sfgpetclinickotlin.repository

import haydende.sfgpetclinickotlin.model.Pet
import haydende.sfgpetclinickotlin.model.PetType
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PetRepository : PetClinicCrudRepository<Pet, Long> {

    fun findAllByPetType(petType: PetType): Set<Pet>

    @Query("SELECT p FROM Pet p WHERE p.owner.id = :ownerId")
    fun findAllByOwnerId(@Param("ownerId") ownerId: Long): Set<Pet>

}