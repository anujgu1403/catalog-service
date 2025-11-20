
package com.retail.catalogservice.api.controllers;

import com.retail.catalogservice.application.model.ProductDTO;
import com.retail.catalogservice.application.services.ProductAppService;
import com.retail.catalogservice.infrastructure.repositories.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = CatalogController.class)
class CatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductAppService productAppService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAll_returnsProducts() throws Exception {
        var products = List.of(new Product(1, "p1", 10.0));
        var productDTOs = List.of(new ProductDTO(1, "p1", 10.0));
        when(productAppService.getAll()).thenReturn(productDTOs);

        mockMvc.perform(get("/api/catalog/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productDTOs)));
    }
}
