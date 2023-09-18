package haydende.sfgpetclinickotlin.service

import haydende.sfgpetclinickotlin.model.Vet
import haydende.sfgpetclinickotlin.repository.VetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

class VetServiceImpl(
    @Autowired
    val vetRepository: VetRepository
): VetService {

    override fun findAll(): Set<Vet> {
        return vetRepository.findAll()
    }

    override fun findById(id: Long): Vet? {
        return vetRepository.findByIdOrNull(id)
    }

    override fun save(toSave: Vet): Vet {
        return vetRepository.save(toSave)
    }

    override fun delete(toDelete: Vet) {
        vetRepository.delete(toDelete)
    }

    override fun deleteById(id: Long) {
        vetRepository.deleteById(id)
    }
}