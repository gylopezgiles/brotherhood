package com.magneto.brotherhood.services;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CacheService {

    private MemcachedClient memcachedClient;

    public CacheService(@Value("${memcached.url.connection}") String memcachedConnection){
        try {
            memcachedClient = new MemcachedClient(AddrUtil.getAddresses(memcachedConnection));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public <T> void putContentInMemCache(String key, T value){
        memcachedClient.set(key, 3600, value);
    }

    public <T> T getContentInMemCache(String key, Class<T> type) {
        Object object = memcachedClient.get(key);
        return object != null ? type.cast(object) : null;
    }

    public void deleteContentFromMemCache(String key){
        memcachedClient.delete(key);
    }
}
