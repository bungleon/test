package com.test.repository;

import com.test.domain.Proxy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProxyRepository extends JpaRepository<Proxy, UUID> {
    Proxy findByProxyList(String proxyList);

}
