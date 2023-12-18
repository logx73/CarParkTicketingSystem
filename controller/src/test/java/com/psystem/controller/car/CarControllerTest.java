package com.psystem.controller.car;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.psystem.model.car.Car;
import com.psystem.service.car.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CarControllerTest {
    private MockMvc mockMvc;
    @Mock
    CarService carService;
    @InjectMocks
    CarController carController;

    Car car1 = new Car(1l,"MH1232","red");
    Car car2 = new Car(2l,"MH6235","black");
    Car car3 = new Car(3l,"MH5455","red");


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    public void getAllCarsTest_success() throws Exception{
        List<Car> carList = Arrays.asList(car1,car2,car3);
        Mockito.when(carService.getAllCars()).thenReturn(carList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/parking-management/cars")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[2].colour", is("red")));
    }

    @Test
    public void getCarByColour_success() throws Exception{
        List<String> carList = Arrays.asList("MH1232","MH6235","MH5455");
        Mockito.when(carService.getCarsByColour("black")).thenReturn(carList);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/parking-management/cars/black")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2]", is("MH5455")));
    }
}
