package it.schipani.businessLayer;

public interface Mapper<D, S> {

    S map(D input);
}
