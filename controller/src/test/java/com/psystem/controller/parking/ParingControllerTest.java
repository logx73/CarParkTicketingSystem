package com.psystem.controller.parking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.psystem.service.parking.ParkingService;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ParingControllerTest {
    @Mock
    ParkingService parkingService;
    private MockMvc mockMvc;
    @InjectMocks
    ParkingController parkingController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(parkingController).build();
    }


    @Test
    public void createParkingLot() throws Exception {
        Mockito.when(parkingService.createParking(10)).thenReturn("Parking Lot Created");

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/v1/parking-management/parking/10")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("Parking Lot Created");
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

}
