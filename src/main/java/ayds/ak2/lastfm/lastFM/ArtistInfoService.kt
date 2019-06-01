package ayds.ak2.lastfm.lastFM

import ayds.ak2.lastfm.ExternalArtist

interface ArtistInfoService {
    fun getArtistInfo(artistName: String): ExternalArtist
}
