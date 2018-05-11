package com.test.repository;

import com.test.domain.Bank;
import com.test.domain.Proxy;
import com.test.domain.ProxyBlackList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProxyBlackListRepository extends JpaRepository<ProxyBlackList, UUID> {
    ProxyBlackList findByProxyAndBank(Proxy proxy,Bank bank);
}
