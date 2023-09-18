package haydende.sfgpetclinickotlin.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import haydende.sfgpetclinickotlin.model.Owner
import haydende.sfgpetclinickotlin.repository.OwnerRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
internal class OwnerControllerTest(
    @Autowired var ownerRepository: OwnerRepository,
    @Autowired val mockMvc: MockMvc
) {


    val owner1: Owner = Owner(
        firstName = "first",
        lastName = "last",
        city = "cityville",
        telephone = "123456789"
    )

    val owner2: Owner = Owner(
        firstName = "second",
        lastName = "last",
        city = "cityopolis",
        telephone = "987654321"
    )

    val owner3: Owner = Owner(
        firstName = "third",
        lastName = "secondToLast",
        city = "north cityville",
        telephone = "082745524"
    )

    @BeforeEach
    fun preTest() {
        ownerRepository.deleteAll()
    }

    @Test
    fun `ownerRepository returns Owner by id with 200 OK`() {
        // Given...
        // ...the OwnerRepository saves 2 owners
        val savedOwner1 = ownerRepository.save(owner1)
        val savedOwner2 = ownerRepository.save(owner2)

        // When...
        // ...I call on the 'owner' endpoint, requesting the Owner with matching ID
        val response = mockMvc.perform(
            get("/owner/id/1"))
            .andDo(print())

        // Then...
        // ...the response is verified
        val result = response
            .andExpect(status().isOk())
            .andReturn()

        // And...
        // ...the response body is validated
        val sentOwner = ObjectMapper()
            .readValue<Owner>(result.response.getContentAsString())

        compareOwners(savedOwner1, sentOwner)
    }

    @Test
    fun `ownerRepository returns 404 Not Found if ID cannot be found`() {
        // Given...
        // ...No data is set up beforehand

        // When...
        // ...I call on the 'owner' endpoint, requesting the Owner with matching ID
        val response = mockMvc.perform(
            get("/owner/id/1"))
            .andDo(print())

        // Then...
        // ...the response is verified
        val result = response
            .andExpect(status().isNotFound())
            .andReturn()

        // ...the content is verified to be empty
        Assertions.assertEquals("", result.response.getContentAsString())
    }

    @Test
    fun `ownerRepository returns a List of Owners with matching surname`() {
        // Given...
        // ...Three Owner objects are saved via the repository
        val savedOwner1 = ownerRepository.save(owner1)
        val savedOwner2 = ownerRepository.save(owner2)
        val savedOwner3 = ownerRepository.save(owner3)

        // When...
        // ...I call on the 'owner' endpoint, request the Owner with matching surname
        val response = mockMvc.perform(
            get("/owner/surname/last"))
            .andDo(print())

        // Then...
        // ...the response is verified
        val result = response
            .andExpect(status().isOk)
            .andReturn()

        // And...
        // ...the response body is validated
        val sentOwners = ObjectMapper()
            .readValue<MutableSet<Owner>>(result.response.getContentAsString())

        Assertions.assertEquals(2, sentOwners.size)
        for (owner in sentOwners) {
            var toCompareWith = savedOwner1
            if (owner.id == owner2.id) {
                toCompareWith = savedOwner2
            }

            compareOwners(toCompareWith, owner)
        }
    }

    @Test
    fun `ownerRepository returns an empty List of Owners with no matches for surname`() {
        // Given...
        // ...Three Owner objects are saved via the repository
        val savedOwner1 = ownerRepository.save(owner1)
        val savedOwner2 = ownerRepository.save(owner2)
        val savedOwner3 = ownerRepository.save(owner3)

        // When...
        // ...I call on the 'owner' endpoint, requesting the Owner(s) with matching surname
        val response = mockMvc.perform(
            get("/owner/surname/thisshouldnotmatchanything"))
            .andDo(print())

        // Then...
        // ...the response is verified
        val result = response
            .andExpect(status().isOk())
            .andReturn()

        // And...
        // ...the response body is validated
        val sentOwners = ObjectMapper()
            .readValue<MutableSet<Owner>>(result.response.getContentAsString())

        Assertions.assertTrue(sentOwners.isEmpty())
    }

    fun compareOwners(expectedOwner: Owner, actualOwner: Owner) {
        Assertions.assertEquals(expectedOwner.id, actualOwner.id)
        Assertions.assertEquals(expectedOwner.firstName, actualOwner.firstName)
        Assertions.assertEquals(expectedOwner.lastName, actualOwner.lastName)
        Assertions.assertEquals(expectedOwner.city, actualOwner.city)
        Assertions.assertEquals(expectedOwner.telephone, actualOwner.telephone)
        Assertions.assertEquals(expectedOwner.pets, actualOwner.pets)
    }
}