package com.mohsinkd786.service;

import com.mohsinkd786.dto.GithubUserDto;
import com.mohsinkd786.service.config.GithubConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubService {

//    private GithubConfig githubConfig;
//
//    @Autowired
//    public void setGithubConfig(GithubConfig githubConfig) {
//        this.githubConfig = githubConfig;
//    }

    private RestTemplate restTemplate;

    @Value("${external.github.url}")
    private String url;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getNameFromGithub(){
        //GithubUserDto userDto = githubConfig.restTemplate().getForObject(githubConfig.getUrl(), GithubUserDto.class);
        ResponseEntity<GithubUserDto> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null,GithubUserDto.class);
        return responseEntity.getBody().getName();
    }
}
