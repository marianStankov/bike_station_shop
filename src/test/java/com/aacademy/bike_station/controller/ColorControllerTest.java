package com.aacademy.bike_station.controller;

import com.aacademy.bike_station.dto.ColorDto;
import com.aacademy.bike_station.service.ColorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(controllers = ColorController.class)
class ColorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ColorService colorService;

    @Test
    public void verifyFindByColorWorks() throws Exception {
        String color = "White";
        when(colorService.findByColor(color))
                .thenReturn(ColorDto.builder().color("White").build());

        mockMvc.perform(
                get("/colors" + color)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE));

        verify(colorService, times(1)).findByColor(color);
    }
}