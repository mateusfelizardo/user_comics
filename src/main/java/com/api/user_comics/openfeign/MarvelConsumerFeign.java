package com.api.user_comics.openfeign;

import com.api.user_comics.dto.Comic.ComicDTO;
import com.api.user_comics.openfeign.MarvelObject.MarvelComicResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//http://gateway.marvel.com/v1/public/comics
//Timestamp = 1644130742
//Private key = dd64a5da1fd319140753591f7f9fe89ea44c4f35
//Public key = 89e43bbf153bb63197497529c991b6b1
//hash = e4840ae1c750331bd3ddfbb7ab977404


@FeignClient(name= "marvel", url ="${url.marvel}" )
public interface MarvelConsumerFeign {

    @GetMapping("/{id}")
    MarvelComicResponse findById(@PathVariable("id") long id, @RequestParam(value = "ts") Long timeStamp, @RequestParam(value = "apikey") String publicKey, @RequestParam(value = "hash") String hashMD5);

}
