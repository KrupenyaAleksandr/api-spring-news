package spring.course.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.course.news.dto.UserDataDTO;
import spring.course.news.repository.UserDataRepository;
import spring.course.news.service.MappingService;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserDataRepository userDataRepository;
    @Autowired
    private final MappingService mappingService;

    public UserController(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody UserDataDTO userDataDTO) {
        userDataRepository.save(mappingService.mapUserDTOToUserData(userDataDTO));
    }

    @GetMapping("/get-user")
    public UserDataDTO getUser(@RequestParam Integer id) {
        return mappingService.mapUserDataToUserDataDTO(userDataRepository.findUserDataById(id));
    }

    @PutMapping("/update-user")
    public void updateUser(@RequestParam Integer id, @RequestBody UserDataDTO userDataDTO) {
        mappingService.updateUserDataFromUserDataDTO(userDataDTO, userDataRepository.findUserDataById(id));
    }
}