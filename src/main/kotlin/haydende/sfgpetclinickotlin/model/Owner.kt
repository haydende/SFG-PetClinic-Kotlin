package haydende.sfgpetclinickotlin.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
open class Owner(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,
    open var firstName: String? = null,
    open var lastName: String? = null,
    open var city: String?,
    open var telephone: String?,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "owner")
    open var pets: MutableSet<Pet?> = mutableSetOf()
) {

    override fun equals(other: Any?): Boolean {
        if (other is Owner) {
            return this.id == other.id
        }
        return false
    }

}