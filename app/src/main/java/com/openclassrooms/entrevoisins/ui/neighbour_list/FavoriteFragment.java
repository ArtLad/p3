package com.openclassrooms.entrevoisins.ui.neighbour_list;

public class FavoriteFragment extends NeighbourFragment implements FragmentTab {

    @Override
    public void initList() {
        setNeighbours(getApiService().getFavoriteNeighbours());
        getRecyclerView().setAdapter(new MyNeighbourRecyclerViewAdapter(getNeighbours(), getContext()));
    }
}

