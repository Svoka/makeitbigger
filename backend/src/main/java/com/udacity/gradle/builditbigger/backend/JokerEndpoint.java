package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import artem.osipov.joker.Joker;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokerEndpoint {

    private Joker joker = new Joker();

    @ApiMethod(name = "getAJoke")
    public JokerBean getAJoke() {
        JokerBean response = new JokerBean();
        response.setJoke(joker.tellAJoke());

        return response;
    }

}
