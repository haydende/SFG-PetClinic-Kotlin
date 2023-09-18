package haydende.sfgpetclinickotlin.service

import haydende.sfgpetclinickotlin.model.Pet
import haydende.sfgpetclinickotlin.model.PetType
import haydende.sfgpetclinickotlin.repository.PetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

class PetServiceImpl(
    @Autowired
    val petRepository: PetRepository
): PetService {

    override fun findAll(): Set<Pet> {
        return petRepository.findAll()
    }

    override fun findById(id: Long): Pet? {
        return petRepository.findByIdOrNull(id)
    }

    override fun findAllByPetType(petType: PetType): Set<Pet> {
        return petRepository.findAllByPetType(petType)
    }

    override fun findAllByOwnerId(ownerId: Long): Set<Pet> {
        return petRepository.findAllByOwnerId(ownerId)
    }

    override fun save(toSave: Pet): Pet {
        return petRepository.save(toSave)
    }

    override fun delete(toDelete: Pet) {
        petRepository.delete(toDelete)
    }

    override fun deleteById(id: Long) {
        petRepository.deleteById(id)
    }
}