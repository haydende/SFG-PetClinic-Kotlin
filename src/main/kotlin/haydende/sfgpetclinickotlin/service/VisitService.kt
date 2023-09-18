package haydende.sfgpetclinickotlin.service

import haydende.sfgpetclinickotlin.model.Visit
import org.springframework.stereotype.Service

@Service
interface VisitService: CrudService<Visit, Long> {

    fun getAllByVetId(vetId: Long): Set<Visit>

    fun getAllByPetId(petId: Long): Set<Visit>

}