package com.api.user_comics.openfeign.MarvelObject;
import java.util.List;

public class ResultsResponse{
    private Long id;
    private String title;
    private String isbn;
    private String description;
    private List<PricesResponse> prices;
    private ThumbnailResponse thumbnail;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<PricesResponse> getPrices() {
        return prices;
    }

    public String getIsbn() {
        if (isbn == "") {
            return "999-9-9999-9999-9";
        }
        return isbn;
    }

    public String getDescription() {
        return description;
    }

    public ThumbnailResponse getThumbnail() {
        return thumbnail;
    }
}
