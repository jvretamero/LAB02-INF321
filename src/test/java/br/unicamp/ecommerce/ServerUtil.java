package br.unicamp.ecommerce;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public final class ServerUtil {

    public static MappingBuilder postXml(String url, String fileName) {
        return post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBodyFile(fileName));
    }

    public static MappingBuilder postXmlTimeout(String url, String fileName) {
        return post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withFixedDelay(6000)
                        .withHeader("Content-Type", "text/xml")
                        .withBodyFile(fileName));
    }
}
