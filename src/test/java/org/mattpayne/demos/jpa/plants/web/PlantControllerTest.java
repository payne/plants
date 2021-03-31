package org.mattpayne.demos.jpa.plants.web;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mattpayne.demos.jpa.plants.dto.PlantDTO;
import org.mattpayne.demos.jpa.plants.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetPlanByIdFound() throws Exception {
        mockMvc.perform(get("/api/plant/{id}",1))
                .andExpect(status().isOk());
    }


    @Test
    void testCreatePlant() throws Exception {
        PlantDTO postPlantDTO = new PlantDTO();
        postPlantDTO.setName("Weed");
        HashSet<Category> cats = new HashSet<Category>();
        cats.add(new Category("seasonal"));
        cats.add(new Category("unwanted"));
        postPlantDTO.setCategories(cats);

        mockMvc.perform(post("/api/plant/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(postPlantDTO))
        ).andExpect(status().isCreated());
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
