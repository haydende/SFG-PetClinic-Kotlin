package haydende.sfgpetclinickotlin.service

import haydende.sfgpetclinickotlin.model.PetType
import haydende.sfgpetclinickotlin.repository.PetTypeRepository
import org.springframework.data.repository.findByIdOrNull

class PetTypeServiceImpl(
    val petTypeRepository: PetTypeRepository
): PetTypeService {

    override fun findAll(): Set<PetType> {
        return petTypeRepository.findAll()
    }

    override fun findById(id: Long): PetType? {
        return petTypeRepository.findByIdOrNull(id)
    }

    override fun save(toSave: PetType): PetType {
        return petTypeRepository.save(toSave)
    }

    override fun delete(toDelete: PetType) {
        petTypeRepository.delete(toDelete)
    }

    override fun deleteById(id: Long) {
        petTypeRepository.deleteById(id)
    }
}