package br.unicamp.ecommerce;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

public final class ServerUtil {

    public static MappingBuilder getXml(String url, String fileName) {
        return get(urlMatching(url))
                .willReturn(aResponse().withStatus(200)
                        .withHeader("Content-Type", "text/xml").withBodyFile(fileName));
    }
}
