package haydende.sfgpetclinickotlin.service

import haydende.sfgpetclinickotlin.model.Visit
import haydende.sfgpetclinickotlin.repository.VisitRepository
import org.springframework.data.repository.findByIdOrNull

class VisitServiceImpl(
    val visitRepository: VisitRepository
): CrudService<Visit, Long> {

    override fun findAll(): Set<Visit> {
        return visitRepository.findAll()
    }

    override fun deleteById(id: Long) {
        visitRepository.deleteById(id)
    }

    override fun delete(toDelete: Visit) {
        visitRepository.delete(toDelete)
    }

    override fun save(toSave: Visit): Visit {
        return visitRepository.save(toSave)
    }

    override fun findById(id: Long): Visit? {
        return visitRepository.findByIdOrNull(id)
    }
}