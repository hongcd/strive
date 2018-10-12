package com.hongcd.strive.feign.consumer.client;

import com.hongcd.strive.provider.api.ProviderBookService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author HongD
 */
@FeignClient("provider")
public interface ProviderBookClient extends ProviderBookService {

}