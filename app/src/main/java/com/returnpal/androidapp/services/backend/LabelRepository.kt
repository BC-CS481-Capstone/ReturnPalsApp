package com.returnpal.androidapp.services.backend

import com.amplifyframework.datastore.generated.model.LabelType
import com.amplifyframework.datastore.generated.model.Labels

object LabelRepository : ModelRepository<Labels>(Labels::class.java) {

    fun create(
        returnId: String,
        type: LabelType,
        image: String? = null,
        qrcode: String? = null
    ): Labels? {
        return this.create(
            Labels.builder()
                .type(type)
                .returnsId(returnId)
                .image(image)
                .qrcode(qrcode)
                .build()
        )
    }

    fun delete(
        id: String
    ): Labels? {
        return this.delete(Labels.justId(id))
    }

    fun update(
        id: String,
        returnId: String,
        type: LabelType,
        image: String,
        qrcode: String
    ): Boolean {
        return this.update(
            Labels.builder()
                .type(type)
                .returnsId(returnId)
                .id(id)
                .image(image)
                .qrcode(qrcode)
                .build()
        )
    }

}