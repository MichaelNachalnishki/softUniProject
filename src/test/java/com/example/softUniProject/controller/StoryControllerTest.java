package com.example.softUniProject.controller;

import com.example.softUniProject.model.Enums.GenresEnum;
import com.example.softUniProject.model.dto.WriteStoryDto;
import com.example.softUniProject.repo.StoryRepository;
import com.example.softUniProject.service.GenreService;
import com.example.softUniProject.service.StoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
@AutoConfigureMockMvc
public class StoryControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private StoryService storyService;

    @MockBean
    private StoryRepository storyRepository;

    @MockBean
    private GenreService genreService;

    @Test
    void chooseWhatToDo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/chooseWhatToDo"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"));
    }

    @Test
    void createAStoryFormThrows() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/createAStory"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("createAStory"));
    }

    @Test
    void createAStorySubmitThrows() throws Exception {
        WriteStoryDto writeStoryDto = new WriteStoryDto("Test Title", "testAuthor", "Test Content", GenresEnum.FANTASY);

        doNothing().when(storyService).addStory(any(WriteStoryDto.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/createAStory")
                        .flashAttr("writeStoryDto", writeStoryDto))
                .andExpect(MockMvcResultMatchers.status().isForbidden()); // Expecting 403 status
    }


    @Test
    void readFantasy() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/genre/fantasy"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"));
    }

    @Test
    void readPoetry() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/genre/poetry"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"));
    }

    @Test
    void readCrime() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/genre/crime"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"));
    }

    @Test
    void readHorror() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/genre/horror"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"));
    }

    @Test
    void readSciFi() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/genre/scifi"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"));
    }

}
