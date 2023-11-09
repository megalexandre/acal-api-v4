package br.com.acalappv4.application.web.link.response

import br.com.acalappv4.application.web.address.response.AddressResponse
import br.com.acalappv4.domain.entity.Link
import org.springframework.data.domain.Page

class PageResponseLink (
    val id: String,
    val address: AddressResponse,
    val customerName: String,
    val customerDocument: String,
    val categoryName: String,
    val categoryTotal: Number,
    val categoryType: String,
    val addressName: String,
    val addressDetail: String,
){
    constructor(link: Link) : this(
        id = link.id,
        address = AddressResponse(link.address),
        customerName = link.customer.name,
        customerDocument = link.customer.documentNumber.number,
        categoryName = link.category.name,
        categoryTotal = link.category.total,
        categoryType = link.category.type.name,
        addressName = link.address.area.name,
        addressDetail = "Núm: " +link.address.number +"/"+ link.address.letter,
    )
}

fun Page<Link>.toLinkPageResponse() = map { PageResponseLink(it) }