package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;
    private List<Neighbour> ListForTest = new ArrayList<>();
    private Neighbour addNeighbour, removeNeighbour;

    @Before
    public void setup() {

        service = DI.getNewInstanceApiService();

        ListForTest = service.getNeighbours();
        addNeighbour = new Neighbour(99,
                "James",
                "https://123",
                "uneadresse",
                "0493937463",
                "Jesuisuneiguane",
                false);
        removeNeighbour = new Neighbour(54,
                "Marguerite",
                "https://123",
                "uneadresse",
                "0493937463",
                "Jesuisuneiguane",
                true);
    }

    @Test
    public void getNeighbours(){
        //before
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        //then
        List<Neighbour> neighbours = service.getNeighbours();
        //expected
        Assert.assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));


    }

    @Test
    public void deleteNeighbour(){
        //before
        Neighbour neighbourToDelete = DummyNeighbourGenerator.generateNeighbours().get(0);
        //then
        service.deleteNeighbour(neighbourToDelete);
        //expected
        Assert.assertFalse(ListForTest.contains(neighbourToDelete));

    }

    @Test
    public void createNeighbour(){
        //before
        List<Neighbour> neighbourList = ListForTest;
        //then
        service.createNeighbour(addNeighbour);
        //expected
        Assert.assertTrue(ListForTest.contains(addNeighbour));

    }

    @Test
    public void setFavoriteStatus(){
        //before
        ListForTest.add(addNeighbour);
        //then
        service.setFavoriteStatus(99,true);
        //expected
        Assert.assertTrue(addNeighbour.isFavoriteStatus());

    }

    @Test
    public void removeFavoriteStatus(){
        //before
        ListForTest.add(removeNeighbour);
        //then
        service.setFavoriteStatus(54, false);
        //expected
        Assert.assertFalse(removeNeighbour.isFavoriteStatus());
    }

    @Test
    public void getFavoriteNeighbours(){
        //before
        ListForTest.add(removeNeighbour);
        //then
        List<Neighbour> favorite = service.getFavoriteNeighbours();
        //expected
        Assert.assertTrue(favorite.contains(removeNeighbour));


    }

}