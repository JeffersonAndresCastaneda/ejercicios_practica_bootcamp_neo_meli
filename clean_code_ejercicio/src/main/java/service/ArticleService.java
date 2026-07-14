package service;

public class ArticleService {

// mala practica

  public String getImageUrl(Article article) {
        String imageUrl = null;
        if (article != null) {
            if (article.getImage() != null) {
                 if (article.getImage().getUrl() != null) {
                    imageUrl = article.getImage().getUrl();
                     }
                 }
             }
         return imageUrl;
         }



// buena practica

public String getimageUrl(Article article){

      if (article==null) return null;
      if (article.getImage() == null) return null;
      if(article.getImage().getUrl() == null) return null;
      return article.getImage().getUrl();
}






}
