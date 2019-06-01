# lastFMService -AK2
Modulo encargado de la comunicacion con el servicio externo LastFM
Para hacer uso del mismo, sera necesario que el usuario importe la interfaz ayds.ak2.lastfm.lastFM.ArtistInfoService y llame al metodo:
	-getArtistInfo()
El mismo devolvera un objeto de tipo ExternalArtist, el cual contiene 2 propiedades:
	-artistBio : String?
	-artistImagePath : String?
Estas propiedades almacenan los resultados del pedido hacia el servicio externo LastFM
