package lastfmservice.lastFM

import lastfmservice.ExternalArtist

interface ResponseToText {
    fun getWrapper(response: String, artistName: String): ExternalArtist
}