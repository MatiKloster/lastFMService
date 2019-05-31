package ayds.ak2.lastfm.lastFM.lastFM

import ayds.ak2.lastfm.lastFM.ArtistInfoService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val URL_RETROFIT = "http://ws.audioscrobbler.com/2.0/"

object LastFMModule {
    fun getExternalService(): ArtistInfoService {
        return LastFMInfoService(createServiceAPI(), ResponseXMLToTextImp())
    }

    private fun createServiceAPI(): LastFMAPI {
        return buildRetrofit().create(LastFMAPI::class.java)
    }

    private fun buildRetrofit(): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
        val scalarsConverterFactory = ScalarsConverterFactory.create()
        retrofitBuilder.baseUrl(URL_RETROFIT)
        retrofitBuilder.addConverterFactory(scalarsConverterFactory)

        return retrofitBuilder.build()
    }
}
