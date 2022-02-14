package com.api.user_comics.openfeign.MarvelObject;

public class ThumbnailResponse {
    private String path;
    private String extension;

    public String getUrl(){
        return path+"."+extension;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}
