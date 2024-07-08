package spring.course.news.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.course.news.dto.UserDataDTO;
import spring.course.news.entity.News;
import spring.course.news.entity.UserData;
import spring.course.news.dto.NewsDTO;
import spring.course.news.repository.UserDataRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MappingService {

    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private UserDataRepository userDataRepository;

    public MappingService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<NewsDTO> mapListNewsToNewsDTO(List<News> listNews) {
        List<NewsDTO> listNewsDTOtmp = new ArrayList<>();
        NewsDTO newsDTOtmp;

        for (News news : listNews) {
            newsDTOtmp = this.modelMapper.map(news, NewsDTO.class);
            listNewsDTOtmp.add(newsDTOtmp);
        }

        return listNewsDTOtmp;
    }

    public UserData mapUserDTOToUserData(UserDataDTO userDataDTO) {
        return this.modelMapper.map(userDataDTO, UserData.class);
    }

    public UserDataDTO mapUserDataToUserDataDTO(UserData userData) {
        return this.modelMapper.map(userData, UserDataDTO.class);
    }

    public void updateNewsFromNewsDTO(NewsDTO newsDTO, News news) {
        news.setHead(newsDTO.getHead());
        news.setBody(newsDTO.getBody());
        news.setDateCreate(newsDTO.getDateCreate());
        news.setIdUser(userDataRepository.findUserDataById(newsDTO.getIdUser()));
    }

    public void updateUserDataFromUserDataDTO(UserDataDTO userDataDTO, UserData userData) {
        userData.setName(userDataDTO.getName());
        userData.setLogin(userDataDTO.getLogin());
        userData.setPassword(userDataDTO.getPassword());
    }
}
