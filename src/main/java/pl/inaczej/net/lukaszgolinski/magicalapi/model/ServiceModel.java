package pl.inaczej.net.lukaszgolinski.magicalapi.model;

import lombok.Data;

import java.util.List;

@Data
public class ServiceModel {
    protected String name;
    protected String language;
    protected List<FeatureModel> features;
}
