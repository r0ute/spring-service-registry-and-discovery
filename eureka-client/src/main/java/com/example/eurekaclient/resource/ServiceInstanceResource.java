package com.example.eurekaclient.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service-instances")
public class ServiceInstanceResource {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{serviceId}")
    public List<ServiceInstance> SergetServiceInstances(@PathVariable String serviceId) {
        return discoveryClient.getInstances(serviceId);
    }
}
