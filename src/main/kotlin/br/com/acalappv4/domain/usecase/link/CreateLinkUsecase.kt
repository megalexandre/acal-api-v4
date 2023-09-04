package br.com.acalappv4.domain.usecase.link

import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.LinkResource
import br.com.acalappv4.domain.usecase.Usecase

class CreateLinkUsecase(
    private val linkResource: LinkResource
): Usecase<Link, Link> {

    override fun execute(input: Link): Link {
        validDuplicatedAddress(input)

        return linkResource.save(input)
    }

    private fun validDuplicatedAddress(link: Link){
        linkResource.findByAddressAndStatus(address = link.address, active = true )?.let {
            throw InvalidUsecaseException("address: ${link.address} already registered")
        }
    }


}