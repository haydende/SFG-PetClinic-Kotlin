package haydende.sfgpetclinickotlin.service

interface CrudService<T, ID> {

    fun findAll(): Set<T>

    fun findById(id: ID): T?

    fun save(toSave: T): T

    fun delete(toDelete: T)

    fun deleteById(id: ID)

}