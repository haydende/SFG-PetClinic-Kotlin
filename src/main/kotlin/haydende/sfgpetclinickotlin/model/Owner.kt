package haydende.sfgpetclinickotlin.model

import jakarta.persistence.*

@Entity
open class Owner(

    id: Long? = null,

    @Column
    open var firstName: String? = null,

    @Column
    open var lastName: String? = null,

    @Column
    open var city: String? = null,

    @Column
    open var telephone: String? = null,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "owner", fetch = FetchType.LAZY)
    open var pets: MutableSet<Pet?> = mutableSetOf()

) : BaseEntity(id) {

}