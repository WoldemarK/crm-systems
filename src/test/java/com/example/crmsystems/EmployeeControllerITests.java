package com.example.crmsystems;

import com.example.crmsystems.company.model.Employee;
import com.example.crmsystems.company.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@RequiredArgsConstructor
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerITests {

    private final MockMvc mockMvc;

    private final EmployeeService service;

    private final ObjectMapper objectMapper;

    @BeforeEach
    void setup(Long id) {
        service.deleteById(id);
    }

    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception {

        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .listName("Fadatare")
                .phoneNumber("+123")
                .birthday("01.01.2000")
                .email("Ramesh@mail.ru")
                .salary(300L)
                .department("sales")
                .post("manager")
                .build();

        ResultActions response = mockMvc.perform(post("/api")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)));

        response.andDo(print()).
                andExpect(status().isCreated())

                .andExpect(jsonPath("$.firstName",
                        is(employee.getFirstName())))

                .andExpect(jsonPath("$.lastName",
                        is(employee.getListName())))

                .andExpect(jsonPath("$.phoneNumber",
                        is(employee.getPhoneNumber())))


                .andExpect(jsonPath("$.email",
                        is(employee.getEmail())))

                .andExpect(jsonPath("$.birthday",
                        is(employee.getBirthday())))

                .andExpect(jsonPath("$.salary",
                        is(employee.getSalary())))


                .andExpect(jsonPath("$.department",
                        is(employee.getDepartment())))

                .andExpect(jsonPath("$.post",
                        is(employee.getPost())));

    }

}
