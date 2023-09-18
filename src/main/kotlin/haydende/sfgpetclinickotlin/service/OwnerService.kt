package haydende.sfgpetclinickotlin.service

import haydende.sfgpetclinickotlin.model.Owner

interface OwnerService: CrudService<Owner, Long> {

    fun findAllByFirstname(query: String): Set<Owner>

    fun findAllByLastname(query: String): Set<Owner>

}