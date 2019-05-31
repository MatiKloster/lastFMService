package ayd.ak2.lastfm.lastFM

import android.util.Log
import ayd.ak2.lastfm.ArtistInfoService
import ayd.ak2.lastfm.ExternalArtist
import java.io.IOException

private const val NO_RESULTS = "No Results"

internal class LastFMInfoService(api: LastFMAPI, resolverToText: ResponseToText) : ArtistInfoService {
    private val interfazComunicadoraLASTFM: LastFMAPI = api
    private val aplanadorDeTexto: ResponseToText = resolverToText

    override fun getArtistInfo(artistName: String): ExternalArtist {
        var response: String? = null
        var externalArtistInfo: ExternalArtist
        try {
            response = getCallResponse(artistName)
        } catch (e: IOException) {
            Log.e("", "Error en ejecutar la consulta al servidor LastFM")
        }
            externalArtistInfo = aplanadorDeTexto.getWrapper(response!!, artistName)
            if (noSeEncontraronResultados(externalArtistInfo)) {
                externalArtistInfo.artistBio=(NO_RESULTS)
            }
        return externalArtistInfo
    }

    @Throws(IOException::class)
    private fun getCallResponse(artistName: String): String? {
        val queryArtista = interfazComunicadoraLASTFM.getArtistInfo(artistName)
        val callResponse = queryArtista.execute()
        return callResponse.body()
    }

    private fun noSeEncontraronResultados(externalArtist: ExternalArtist): Boolean {
        return externalArtist.artistBio == null
    }
}