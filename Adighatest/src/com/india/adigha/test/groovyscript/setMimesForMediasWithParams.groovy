import de.hybris.platform.servicelayer.search.FlexibleSearchQuery
 
flexibleSearchService = spring.getBean "flexibleSearchService"
mimeService = spring.getBean "mimeService"
modelService = spring.getBean "modelService"

// the query finds all medias for which mime type is null and whose realfile nasme has a specific pattern.
def findMediasWithoutMime() {
	query = new FlexibleSearchQuery("SELECT {PK} FROM {Media} WHERE {mime} IS NULL AND {realfilename} LIKE ?realfilename")
	query.addQueryParameter("realfilename", realfilename);
	flexibleSearchService.search(query).result
}
findMediasWithoutMime().each {
	it.mime = mimeService.getMimeFromFileExtension(it.realfilename)
	
	modelService.save it
}