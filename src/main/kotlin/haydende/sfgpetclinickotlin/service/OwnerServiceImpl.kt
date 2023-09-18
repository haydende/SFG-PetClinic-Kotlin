package haydende.sfgpetclinickotlin.service

import haydende.sfgpetclinickotlin.model.Owner
import haydende.sfgpetclinickotlin.repository.OwnerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OwnerServiceImpl(
    @Autowired val ownerRepository: OwnerRepository
): OwnerService {

    override fun findAll(): Set<Owner> {
        return ownerRepository.findAll()    }

    override fun findById(id: Long): Owner? {
        return ownerRepository.findByIdOrNull(id)
    }

    override fun findAllByFirstname(query: String): Set<Owner> {
        return ownerRepository.findAllByFirstNameLike(query)
    }

    override fun findAllByLastname(query: String): Set<Owner> {
        return ownerRepository.findAllByLastNameLike(query)
    }

    override fun save(toSave: Owner): Owner {
        return ownerRepository.save(toSave)
    }

    override fun delete(toDelete: Owner) {
        ownerRepository.delete(toDelete)
    }

    override fun deleteById(id: Long) {
        ownerRepository.deleteById(id)
    }
}