package lech.bartlomiej.contacts.api;



import lech.bartlomiej.contacts.api.dtos.BasicPersonDto;

import java.util.List;

public class PersonSearchResults {

    private List<BasicPersonDto> results;

    public List<BasicPersonDto> getResults() {
        return results;
    }

    public void setResults(List<BasicPersonDto> results) {
        this.results = results;
    }
}
