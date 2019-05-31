package ayd.ak2.lastfm.lastFM

import ayd.ak2.lastfm.ExternalArtist

interface ResponseToText {
    fun getWrapper(response: String, artistName: String): ExternalArtist
}