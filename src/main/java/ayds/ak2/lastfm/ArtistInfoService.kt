package ayds.ak2.lastfm

interface ArtistInfoService {
    fun getArtistInfo(artistName: String): ExternalArtist
}
