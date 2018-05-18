package com.hongcd.strive.feign.consumer.client;

import com.hongcd.strive.provider.api.ProviderBookService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("provider")
public interface ProviderBookClient extends ProviderBookService {

}