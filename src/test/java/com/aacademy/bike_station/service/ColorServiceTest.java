package com.aacademy.bike_station.service;

import com.aacademy.bike_station.dto.ColorDto;
import com.aacademy.bike_station.exception.RecordNotFoundException;
import com.aacademy.bike_station.model.Color;
import com.aacademy.bike_station.repository.ColorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ColorServiceTest {

    @Mock
    private ColorRepository colorRepository;

    private ColorService colorService;

    @BeforeEach
    public void setUp() {
        colorService = new ColorService(colorRepository);
    }

    @Test
    public void verifyFindByColorThrowsRNE() {
        String color = "White";
        when(colorRepository.findByColor(color))
                .thenThrow(new RecordNotFoundException("something"));

        assertThrows(IllegalArgumentException.class, () -> {
            colorService.findByColor(color);
        });
    }

    @Test
    public void verifyFindByColorThrowsNPE() {
        assertThrows(NullPointerException.class,
                () -> colorService.findByColor(null));
    }

    @Test
    public void verifyFindByColorWorks() {
        String color = "White";

        Color expectedColor = Color.builder()
                .id(1L)
                .color(color)
                .build();
        when(colorRepository.findByColor(color))
                .thenReturn(Optional.of(expectedColor));

        ColorDto actualColorDto = colorService.findByColor(color);

        assertEquals(expectedColor.getId(), actualColorDto.getId());
        assertEquals(expectedColor.getColor(), actualColorDto.getColor());

        verify(colorRepository, times(1))
                .findByColor(color);
    }
}