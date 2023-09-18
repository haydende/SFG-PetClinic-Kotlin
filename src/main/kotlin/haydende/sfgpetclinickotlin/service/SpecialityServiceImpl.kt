package haydende.sfgpetclinickotlin.service

import haydende.sfgpetclinickotlin.model.Speciality
import haydende.sfgpetclinickotlin.repository.SpecialityRepository
import org.springframework.data.repository.findByIdOrNull

class SpecialityServiceImpl(
    val specialityRepository: SpecialityRepository
): SpecialityService {

    override fun findAll(): Set<Speciality> {
        return specialityRepository.findAll()
    }

    override fun findById(id: Long): Speciality? {
        return specialityRepository.findByIdOrNull(id)
    }

    override fun save(toSave: Speciality): Speciality {
        return specialityRepository.save(toSave)
    }

    override fun delete(toDelete: Speciality) {
        specialityRepository.delete(toDelete)
    }

    override fun deleteById(id: Long) {
        specialityRepository.deleteById(id)
    }
}