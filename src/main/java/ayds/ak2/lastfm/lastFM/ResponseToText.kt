package ayds.ak2.lastfm.lastFM

import ayds.ak2.lastfm.ExternalArtist

interface ResponseToText {
    fun getWrapper(response: String, artistName: String): ExternalArtist
}