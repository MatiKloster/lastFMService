package ayds.ak2.lastfm

import ayds.ak2.lastfm.lastFM.ArtistInfoService
import ayds.ak2.lastfm.lastFM.LastFMModule

object ExternalServiceModule {

    fun getExternalService(): ArtistInfoService {
        return LastFMModule.getExternalService()
    }
}