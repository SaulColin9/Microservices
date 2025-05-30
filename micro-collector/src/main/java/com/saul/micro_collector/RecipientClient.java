package com.saul.micro_collector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="recipient", url="#{'${recipient.url}'}")
public interface RecipientClient {
    @RequestMapping(method = RequestMethod.GET, value="/message")
    List<String> getMessages();
}
