package com.api.user_comics.service;


import com.api.user_comics.openfeign.MarvelConsumerFeign;
import com.api.user_comics.openfeign.MarvelObject.MarvelComicResponse;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


@Service
public class MarvelService {
    private static final String PUBLIC_KEY = "89e43bbf153bb63197497529c991b6b1";
    private static final String PRIVATE_KEY = "dd64a5da1fd319140753591f7f9fe89ea44c4f35";

    private MarvelConsumerFeign marvelConsumerFeign;

    public MarvelService(MarvelConsumerFeign marvelConsumerFeign) {
        this.marvelConsumerFeign = marvelConsumerFeign;
    }

    public MarvelComicResponse findById(long id){
        Long timeStamp = new Date().getTime();
        return marvelConsumerFeign.findById(id, timeStamp, PUBLIC_KEY, buildHash(timeStamp));

    }

    private String buildHash(Long timeStamp){
        String text = timeStamp + PRIVATE_KEY + PUBLIC_KEY;

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(text.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
