package com.test.component;

import com.mashape.unirest.http.Unirest;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Component
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    private final UnirestObjectMapper unirestObjectMapper;

    @Autowired
    public ContextRefreshedEventListener(UnirestObjectMapper unirestObjectMapper) {
        this.unirestObjectMapper = unirestObjectMapper;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Unirest.setHttpClient(getHttpClientWithProxy(null));
        Unirest.setObjectMapper(unirestObjectMapper);
        Unirest.setDefaultHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    private static HttpClient getHttpClientWithProxy(String restProxy) {
        HttpClientBuilder b = HttpClientBuilder.create();
        SSLContext sslContext = null;
        try {
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, (arg0, arg1) -> true).build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {

        }
        b.setSSLContext(sslContext);
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslSocketFactory)
                .build();
        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        b.setConnectionManager(connMgr);

        if (!StringUtils.isEmpty(restProxy)) {
            String[] splitProxy = restProxy.split(":");
            HttpHost proxy = new HttpHost(splitProxy[0], Integer.valueOf(splitProxy[1]));
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
            b.setRoutePlanner(routePlanner);
        }
        HttpClient client = b.build();
        return client;
    }
}
