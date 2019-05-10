package ayds.spotisong.aurora.otherdetails.model.repository.external

interface OtherInfoExternalService {
    fun getInfoFromService(artistName: String): ExternalArtist
}
