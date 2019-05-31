package ayd.ak2.lastfm

import ayd.ak2.lastfm.lastFM.LastFMModule

object ExternalServiceModule {

    fun getExternalService(): ArtistInfoService {
        return LastFMModule.getExternalService()
    }
}