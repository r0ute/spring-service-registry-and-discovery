package com.example.ms.serviceregistry.client.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceResource {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    public List<String> getServices() {
        return discoveryClient.getServices();
    }
}
