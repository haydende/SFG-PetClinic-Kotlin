package haydende.sfgpetclinickotlin.model

open class Person(
    override val id: Long,
    open var firstName: String,
    open var secondName: String
) : BaseEntity(id) {
}