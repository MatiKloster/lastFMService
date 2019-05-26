package lastfmservice

import lastfmservice.lastFM.LastFMModule

object OtherInfoExternalModule {

    fun getExternalService(): OtherInfoExternalService {
        return LastFMModule.getExternalService()
    }
}