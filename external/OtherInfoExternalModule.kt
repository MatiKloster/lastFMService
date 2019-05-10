package ayds.spotisong.aurora.otherdetails.model.repository.external

import ayds.spotisong.aurora.otherdetails.model.repository.external.lastFM.LastFMModule

object OtherInfoExternalModule {

    fun getExternalService(): OtherInfoExternalService {
        return LastFMModule.getExternalService()
    }
}