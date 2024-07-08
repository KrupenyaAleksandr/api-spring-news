package spring.course.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.course.news.dto.NewsDTO;
import spring.course.news.entity.News;
import spring.course.news.repository.NewsRepository;
import spring.course.news.repository.UserDataRepository;
import spring.course.news.service.MappingService;

import java.util.List;

@RestController
@RequestMapping("api/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private UserDataRepository userDataRepository;
    @Autowired
    private final MappingService mappingService;

    public NewsController(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    @GetMapping("/get-all-news")
    public List<NewsDTO> getAllNews() {
        List<News> listNews = newsRepository.getAll();
        return mappingService.mapListNewsToNewsDTO(listNews);
    }

    @GetMapping("/get-news-by-id-user")
    public List<NewsDTO> getNewsByIdUser(@RequestParam Integer idUser) {
        List<News> listNews = newsRepository.getNewsByUserId(idUser);
        return mappingService.mapListNewsToNewsDTO(listNews);
    }

    @PostMapping("/create-news")
    public void createNews(@RequestBody NewsDTO newsDTO) {
        newsRepository.save
                (
                        new News
                                (
                                newsDTO.getHead(),
                                newsDTO.getBody(),
                                newsDTO.getDateCreate(),
                                userDataRepository.findUserDataById(newsDTO.getIdUser())
                                )
                );
    }

    @PutMapping("/update-news")
    public void updateNews(@RequestParam String head, @RequestBody NewsDTO newsDTO) {
        News newsTMP = newsRepository.findNewsByHead(head);
        mappingService.updateNewsFromNewsDTO(newsDTO, newsTMP);
        newsRepository.save(newsTMP);
    }
}