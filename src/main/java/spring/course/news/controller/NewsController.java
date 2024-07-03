package spring.course.news.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.course.news.dto.ListNewsDTO;
import spring.course.news.dto.NewsDTO;
import spring.course.news.entity.News;
import spring.course.news.repository.NewsRepository;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private final ModelMapper modelMapper;
    private ListNewsDTO listNewsDTO = new ListNewsDTO();

    public NewsController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping("/get-all-news")
    public List<NewsDTO> getAllNews() {
        List<News> listNews = newsRepository.getAll();
        List<NewsDTO> listNewsDTOtmp = listNewsDTO.getListNewsDTO();
        NewsDTO newsDTOtmp;

        for (News news : listNews) {
            newsDTOtmp = this.modelMapper.map(news, NewsDTO.class);
            listNewsDTOtmp.add(newsDTOtmp);
        }

        return listNewsDTOtmp;
    }

    @PostMapping("/create-news")
    public NewsDTO createNews(@RequestBody NewsDTO newsDTO){
        return new NewsDTO();
    }

    @GetMapping("/test")
    public void test() {
        System.out.println(listNewsDTO.getListNewsDTO().size());
    }
}
