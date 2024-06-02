package it.schipani.businessLayer.services;

public interface Mapper<D, S> {
    S map(D input);
}
