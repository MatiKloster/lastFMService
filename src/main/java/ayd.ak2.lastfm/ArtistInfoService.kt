package ayd.ak2.lastfm

interface ArtistInfoService {
    fun getArtistInfo(artistName: String): ExternalArtist
}
