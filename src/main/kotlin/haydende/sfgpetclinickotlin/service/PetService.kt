package haydende.sfgpetclinickotlin.service

import haydende.sfgpetclinickotlin.model.Pet
import haydende.sfgpetclinickotlin.model.PetType
import org.springframework.stereotype.Service

@Service
interface PetService: CrudService<Pet, Long> {

    fun findAllByPetType(petType: PetType): Set<Pet>

    fun findAllByOwnerId(ownerId: Long): Set<Pet>

}