package ayds.ak2.lastfm.lastFM

import ayds.ak2.lastfm.lastFM.lastFM.LastFMModule

object ExternalServiceModule {

    fun getExternalService(): ArtistInfoService {
        return LastFMModule.getExternalService()
    }
}