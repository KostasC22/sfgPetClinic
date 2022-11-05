package com.havistudio.sfgpetclinic.controllers;

import com.havistudio.sfgpetclinic.model.Owner;
import com.havistudio.sfgpetclinic.services.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("owners/index"))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));
    }

    @Test
    void listOwnersByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/index"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("owners/index"))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("notimplemented"));

        verifyZeroInteractions(ownerService);
    }
}