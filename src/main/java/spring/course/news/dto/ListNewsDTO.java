package spring.course.news.dto;

import java.util.ArrayList;
import java.util.List;

public class ListNewsDTO {

    private List<NewsDTO> listNewsDTO;

    public ListNewsDTO() {
        this.listNewsDTO = new ArrayList<NewsDTO>();
    }

    public List<NewsDTO> getListNewsDTO() {
        return this.listNewsDTO;
    }

    @Override
    public String toString() {
        return "ListNewsDTO{" +
                "listNewsDTO=" + listNewsDTO +
                '}';
    }
}
