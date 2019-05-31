package ayds.ak2.lastfm.lastFM

interface ArtistInfoService {
    fun getArtistInfo(artistName: String): ExternalArtist
}
