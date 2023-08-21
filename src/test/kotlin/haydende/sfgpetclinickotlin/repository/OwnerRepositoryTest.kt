package haydende.sfgpetclinickotlin.repository

import haydende.sfgpetclinickotlin.model.Owner
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class OwnerRepositoryTest(
    @Autowired val ownerRepository: OwnerRepository
) {

    @AfterEach
    fun `postTest`() {
        ownerRepository.deleteAll()
    }

    @Test
    fun `repository should be initialised`() {}

    @Test
    fun `repository should return Owners with similar firstName`() {
        // Given...
        // ...an Owner is defined without Id or Pets values
        val owner1 = Owner(
            firstName = "first",
            lastName = "last",
            city = "city",
            telephone = "123456789"
        )
        // ...the defined Owner instance is saved via the repository
        val savedOwner = ownerRepository.save(owner1)

        // When...
        // ...the repository is called for Owner object(s) with similar firstName
        val returnedOwners = ownerRepository.findAllByFirstNameLike("first")

        // Then...
        // ...we confirm the number of Owners returned
        Assertions.assertEquals(1, returnedOwners.size)

        // ...we confirm that the only Owner object returned is equal to the object returned by the repository
        Assertions.assertEquals(savedOwner, returnedOwners.first())
    }

    @Test
    fun `repository should return Owners with similar lastName`() {
        // Given...
        // ...an Owner is defined without Id or Pets values
        val owner1 = Owner(
            firstName = "first",
            lastName = "last",
            city = "city",
            telephone = "123456789"
        )
        // ...the defined Owner instance is saved via the repository
        val savedOwner = ownerRepository.save(owner1)

        // When...
        // ...the repository is called for Owner object(s) with similar lastName
        val returnedOwners = ownerRepository.findAllByLastNameLike("last")

        // Then...
        // ...we confirm the number of Owners returned
        Assertions.assertEquals(1, returnedOwners.size)

        // ...we confirm that the only Owner object returned is equal to the object returned by the repository
        Assertions.assertEquals(savedOwner, returnedOwners.first())

    }

}