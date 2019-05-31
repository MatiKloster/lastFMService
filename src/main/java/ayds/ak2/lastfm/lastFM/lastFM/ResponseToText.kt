package ayds.ak2.lastfm.lastFM.lastFM

import ayds.ak2.lastfm.lastFM.ExternalArtist

interface ResponseToText {
    fun getWrapper(response: String, artistName: String): ExternalArtist
}