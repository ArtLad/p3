package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

public class DummyNeighbourApiService implements  NeighbourApiService {

    private final List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void setFavoriteStatus(long id, boolean status) {
        for (Neighbour n : neighbours) {
            if ( n.getId() == id ) {
                n.setFavoriteStatus(status);
                return;
            }
        }
    }

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favorites = new ArrayList<>();
        for (Neighbour m : neighbours) {
            if (m.isFavoriteStatus()) favorites.add(m);
        }
        return favorites;
    }
}
