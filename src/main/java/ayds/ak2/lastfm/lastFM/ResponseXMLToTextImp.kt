package ayds.ak2.lastfm.lastFM

import android.util.Log
import ayds.ak2.lastfm.ExternalArtist
import ayds.ak2.lastfm.ExternalArtistImp
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import org.xml.sax.SAXException
import java.io.IOException
import java.io.StringReader
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException

private const val CONTENT_TAG = "content"
private const val EXTRALARGE = "extralarge"
private const val IMAGEN_TAG = "image"
private const val NO_RESULTS_TAG = "No results"

internal class ResponseXMLToTextImp : ResponseToText {

    override fun getWrapper(response: String, artistName: String): ExternalArtist {
        val doc: Document? = getDocument(response)
        val extract = getContenidoArtista(doc!!)
        val artistBio = darFormatoAResultado(extract)
        val artistImage = getImagePath(response)

        return ExternalArtistImp(artistBio, artistImage!!)
    }

    private fun darFormatoAResultado(extract: Node?): String {
        val infoAHTML: String
        infoAHTML = if (extract != null) {
            val infoExtraida = extract.textContent
            infoExtraida.replace("\\n", "\n")
        } else {
            NO_RESULTS_TAG
        }
        return infoAHTML
    }

    private fun getImagePath(response: String): String? {
        val doc = getDocument(response)
        val nodelist = getImagenes(doc!!)
        return getPathImagenLarga(nodelist)
    }

    private fun getDocument(callResponse: String): Document? {
        val dbf = DocumentBuilderFactory.newInstance()
        val db: DocumentBuilder
        var doc: Document? = null
        try {
            db = dbf.newDocumentBuilder()
            doc = db.parse(InputSource(StringReader(callResponse)))
        } catch (ioException: IOException) {
            Log.e("", "Error en obtener datos del artista")
        } catch (saxException: SAXException) {
            Log.e("", "saxException")
        } catch (parserException: ParserConfigurationException) {
            Log.e("", "parserException")
        }

        return doc
    }

    private fun getContenidoArtista(doc: Document): Node {
        val nodes = doc.documentElement.getElementsByTagName(CONTENT_TAG)
        return nodes.item(0)
    }

    private fun getImagenes(doc: Document): NodeList {
        return doc.documentElement.getElementsByTagName(IMAGEN_TAG)
    }

    private fun getPathImagenLarga(listaDeImagenes: NodeList): String? {
        var path: String? = null
        val cantImagenes = listaDeImagenes.length

        for (i in 0 until cantImagenes) {
            val image = listaDeImagenes.item(i)
            val atributosImagen = image.attributes
            val size = atributosImagen.getNamedItem("size")

            if (esTamanioGrande(size)) {
                path = image.textContent
                break
            }
        }
        return path
    }

    private fun esTamanioGrande(size: Node): Boolean {
        return size.textContent == EXTRALARGE
    }
}
