package LDUBGD.DSNS.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * et_json="https://www.etryvoga.com/api/v1/notification"
 * st_json="https://emapa.fra1.cdn.digitaloceanspaces.com/statuses.json"
 * lv_json="https://airalerts.online/api/mock/notification"
 * ua_json="https://api.ukrainealarm.com/api/v3/alerts"
 * https://api.ukrainealarm.com/swagger/index.html
 *
 * A_BEARER="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsb3Vkc3BlYWtlcl9sdml2IiwiYXV0aCI6IlJPTEVfQVBJX1VTRVIiLCJleHAiOjE2ODU2NDY0ODZ9.tR0hbkBP_rjGD2BKh1z0Gv71OvBl95jrA3tVhML7l32k9-7bmUa9bLmHKCc6PoDR51gyd4H425uJzqMVACKWPA"
 * U_A_KEY="Authorization: c8040565:eae8e82b7f066f0c64effb5b6b1b5d4e"
 *
 * https://map.ukrainealarm.com/api/data/getHistory
 * https://api.ukrainealarm.com/api/v3/alerts/1602
 * Alert{
 * regionId	string
 * nullable: true
 * regionType	v2RegionTypestring
 * Enum:
 * [ State, District, Community, Null ]
 * type	AlertTypestring
 * Enum:
 * [ UNKNOWN, AIR, ARTILLERY, URBAN_FIGHTS, CHEMICAL, NUCLEAR, INFO ]
 * lastUpdate	string($date-time)
 * }
 */
@RestController
public class UkraineAlarm {
//    @Autowired
//    RestTemplate restTemplate;

//    private HttpEntity<String> getHeaders(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "c8040565:eae8e82b7f066f0c64effb5b6b1b5d4e");
////        headers.set("X-COM-LOCATION", "USA");
//
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        return entity;
//    }
//    @GetMapping("alerts/status")
//    public ResponseEntity<String> getAlertsStatus() {
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange("/alerts/status", HttpMethod.GET, getHeaders(), String.class);
//
////        ResponseEntity<String> responseEntity = restTemplate.getForEntity("alerts/status", String.class);
//
////        ObjectMapper mapper = new ObjectMapper();
////        JsonNode root = mapper.readTree(responseEntity.getBody());
//        ResponseEntity<User> responseEntity = restTemplate
//                .exchange("/users/" + id, HttpMethod.GET, entity, User.class);
//
//        User[] usersArray = restTemplate.getForObject(URI_USERS, User[].class);
//        return new ResponseEntity<>(Arrays.asList(usersArray), HttpStatus.OK);
//    }
}
