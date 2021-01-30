package bg.softuni.mobilelele.mobilelele.model.view;

import java.util.List;

public class BrandViewModel {

    private String name;

    private List<ModelViewModel> models;
//String name, List<ModelViewModel> models
    public BrandViewModel() {
        this.name = name;
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }

    public void setModels(List<ModelViewModel> models) {
        this.models = models;
    }
}
