package com.example.shopclothes.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/external-api")
public class ProxyController {

//    @GetMapping("/provinces")
//    public ResponseEntity<String> getProvinces() {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://vietnam-administrative-division-json-server-swart.vercel.app/";
//        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//        return response;
//    }

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/province")
    public ResponseEntity<String> getProvinces(@RequestParam int depth) {
        String url = "https://vietnam-administrative-division-json-server-swart.vercel.app/province?depth=" + depth;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }

    @GetMapping("/district")
    public ResponseEntity<String> getDistricts() {
        String url = "https://vietnam-administrative-division-json-server-swart.vercel.app/district";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }

    @GetMapping("/commune")
    public ResponseEntity<String> getCommunes() {
        String url = "https://vietnam-administrative-division-json-server-swart.vercel.app/commune";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }
}
