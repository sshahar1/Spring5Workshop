package com.tikalk.workshop.client;

import com.tikalk.workshop.controller.PersonController;
import com.tikalk.workshop.entity.Person;
import com.tikalk.workshop.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Created by sigals on 07/10/2018.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    @Mock
    private PersonService personService;

    private WebTestClient client;

    @Before
    public void setUp() throws Exception {
        PersonController personController = new PersonController(personService);

        client = WebTestClient.bindToController(personController)
                .configureClient()
                .baseUrl("/person")
                .build();
    }

    @Test
    public void test() {
        this.client.get()
        .exchange()
        .expectStatus()
        .isOk();
    }
}
