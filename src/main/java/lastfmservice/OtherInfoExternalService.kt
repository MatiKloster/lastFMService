package lastfmservice

interface OtherInfoExternalService {
    fun getInfoFromService(artistName: String): ExternalArtist
}
