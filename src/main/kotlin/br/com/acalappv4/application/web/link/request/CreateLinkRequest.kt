package br.com.acalappv4.application.web.link.request

import br.com.acalappv4.application.web.components.adapter.RequestAdapter
import br.com.acalappv4.application.web.customer.request.CustomerCreateRequest
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.entity.Link
import io.azam.ulidj.ULID.random
import java.time.LocalDateTime
data class CreateLinkRequest (
    val category: Category,
    val address: Address,
    val addressMail: Address,
    val customer: CustomerCreateRequest,
    val createdBy: String,
): RequestAdapter<Link> {

    override fun toEntity(): Link = Link(
        id = random(),
        category = category,
        address= address,
        addressMail = addressMail,
        customer = customer.toCustomer(),
        createdBy = createdBy,
        active = true,
        startedAt = LocalDateTime.now(),
        finishedAt = null,
        invoices = listOf(),
    )

}
