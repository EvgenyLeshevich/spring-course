package com.evgeniy.rest_client;

import com.evgeniy.rest_client.entity.Employee;
import com.evgeniy.rest_client.entity.yandex_weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    private final String URL = "http://localhost:8080/api/employees";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders httpHeaders;
    @Autowired
    private HttpEntity<String> httpEntity;

    public List<Employee> getAllEmployee() {

        // ResponseEntity - это обёртка http-response
        // <List<Employee>> - тип который будет содержаться в теле response (ответа от rest-сервера)
        // 1 URL
        // 2 HttpMethod.GET - метод с которым будет совершён запрос
        // 3 null - используют когда хотят добавить тело к request (нашему запросу к rest-серверу)
        // 4 new ParameterizedTypeReference<List<Employee>>() {} - вспомогательный класс который
        // передаёт дженерик тип
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {
                        });

        List<Employee> employeeList = responseEntity.getBody();

        return employeeList;
    }

    public Employee getEmployee(Long id) {

        // 1 URL
        // 2 Employee.class - то что мы ждём получить в ответ на наш request
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);

        return employee;
    }

    public void saveEmployee(Employee employee) {

        Long id = employee.getId();

        if (id == null) {
            // <String> - тип который будет содержаться в теле response
            // 1 URL
            // 2 employee - мы добавляем в тело метода post
            // 3 String - какого типа будет http-response,
            // в теле ResponseEntity нам будет возвращаться новосозданный объект в виде json
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            // 1 URL
            // 2 employee - мы добавляем в тело метода put
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID = " + id + " was updated");
        }
    }

    public void deleteEmployee(Long id) {

        // 1 URL
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID = " + id + " was deleted from DB");
    }

    public Weather yandexWeather() {
        String URLYandexWeatherApi = "https://api.weather.yandex.ru/v2/forecast?lat=52.40522706971962&lon=31.086360186987903&lang=ru_RU";

        httpHeaders.set("X-Yandex-API-Key", "my-api-key...");

        ResponseEntity<Weather> response = restTemplate.exchange(
                URLYandexWeatherApi,
                HttpMethod.GET, httpEntity,
                Weather.class);

        Weather weather = response.getBody();

        return weather;
    }
}
