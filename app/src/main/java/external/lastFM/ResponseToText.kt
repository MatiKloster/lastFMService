package ayds.spotisong.aurora.otherdetails.model.repository.external.lastFM

import ayds.spotisong.aurora.otherdetails.model.repository.external.ExternalArtist

interface ResponseToText {
    fun getWrapper(response: String, artistName: String): ExternalArtist
}