import de.hybris.platform.servicelayer.search.FlexibleSearchQuery

flexibleSearchService = spring.getBean "flexibleSearchService"
mimeService = spring.getBean "mimeService"
modelService = spring.getBean "modelService"
def findMediasWithoutMime() {
	query = new FlexibleSearchQuery("SELECT {PK} FROM {AdighaProductModel} WHERE {ISTODAYSPECIAL} IS NULL")
	
	flexibleSearchService.search(query).result
}
findMediasWithoutMime().each {
	it.mime = mimeService.getMimeFromFileExtension(it.name)
	
	modelService.save it
}