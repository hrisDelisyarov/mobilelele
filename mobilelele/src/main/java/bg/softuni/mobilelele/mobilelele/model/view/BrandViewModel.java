package bg.softuni.mobilelele.mobilelele.model.view;

import java.util.ArrayList;
import java.util.List;

public class BrandViewModel {

    //   I'm an idiot who forgot to initialize the arraylist and proceeded to debug for half an hour,
    //   and this comment is here to remind me of my stupidity
    private String name;

    private List<ModelViewModel> models;
//String name, List<ModelViewModel> models
    public BrandViewModel() {
        this.name = name;
        this.models = new ArrayList<>();
    }

    public void addModel(ModelViewModel modelViewModel)
    {
        this.models.add(modelViewModel);
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
