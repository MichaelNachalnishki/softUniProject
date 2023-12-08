package com.example.softUniProject.service.schedulers;

import com.example.softUniProject.repo.StoryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OldStoriesCleanUpScheduler {

    private final StoryRepository storyRepository;

    public OldStoriesCleanUpScheduler(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

//    @Scheduled(cron = "0 * * * * ?")
//    public void cleanUp(){
//        if(storyRepository.count() == 0){
//            System.out.println("No stories to clean up");
//            return;
//        }
//
//         storyRepository.deleteAll();
//        System.out.println("Cleaning up all stories");
//
//    }
}
