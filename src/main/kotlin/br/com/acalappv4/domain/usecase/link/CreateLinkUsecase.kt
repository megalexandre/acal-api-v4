package br.com.acalappv4.domain.usecase.link

import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.datasource.LinkDataSource
import br.com.acalappv4.domain.usecase.Usecase

class CreateLinkUsecase(
    private val linkDataSource: LinkDataSource
): Usecase<Link, Link> {

    override fun execute(input: Link): Link {
        validDuplicatedAddress(input)

        return linkDataSource.save(input)
    }

    private fun validDuplicatedAddress(link: Link){
        linkDataSource.findByAddressAndStatus(address = link.address, active = true )?.let {
            throw InvalidUsecaseException("address: ${link.address} already registered")
        }
    }


}