package haydende.sfgpetclinickotlin.controller

import haydende.sfgpetclinickotlin.model.Owner
import haydende.sfgpetclinickotlin.service.OwnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/owner")
class OwnerController(
    @Autowired val ownerService: OwnerService
) {

    @GetMapping(value = ["/id/{id}"])
    fun getOwnerById(@PathVariable("id") id: Long): ResponseEntity<Owner> {
        val returnedOwner = ownerService.findById(id)
        val response: ResponseEntity<Owner> =
        if (returnedOwner == null) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity(returnedOwner, HttpStatus.OK)
        }
        return response
    }

    @GetMapping(value = ["/surname/{surname}"])
    fun getOwnersBySurname(@PathVariable("surname") query: String): ResponseEntity<Set<Owner>> {
        val returnedOwners = ownerService.findAllByLastname(query)
        return ResponseEntity(returnedOwners, HttpStatus.OK)
    }

}