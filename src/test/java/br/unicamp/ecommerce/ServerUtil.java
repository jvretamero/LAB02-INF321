package br.unicamp.ecommerce;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

public final class ServerUtil {

    public static MappingBuilder getXml(String url, String fileName) {
        return get(urlMatching(url))
                .willReturn(aResponse().withStatus(200)
                        .withHeader("Content-Type", "text/xml").withBodyFile(fileName));
    }

    public static <T> MappingBuilder getXml(String url, T obj) {
        return get(urlMatching(url))
                .willReturn(aResponse().withStatus(200)
                        .withHeader("Content-Type", "text/xml").withBody(null));
    }

    private <T> String marshal(T object, Class<T> objClass) {
        try {
            ByteArrayOutputStream baOut = new ByteArrayOutputStream();

            JAXBContext context = JAXBContext.newInstance(objClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(object, baOut);
            return baOut.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
