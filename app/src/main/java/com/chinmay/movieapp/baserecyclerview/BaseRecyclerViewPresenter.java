package com.chinmay.movieapp.baserecyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChiP on 4/2/2016.
 */
public class BaseRecyclerViewPresenter {
    private final IBaseRecylerView baseRecylerViewFragment;
    private final List<IFragmentDataLoader> loaders = new ArrayList<>();
    final List<RecyclerViewItemWrapper> list = new ArrayList();

    public BaseRecyclerViewPresenter(IBaseRecylerView baseRecylerViewFragment) {
        this.baseRecylerViewFragment = baseRecylerViewFragment;
    }

    public void addDataLoader(IFragmentDataLoader loader) {
        loaders.add(loader);
    }

    public void onCreate() {
        baseRecylerViewFragment.setupLoaders();
        populateData();
    }

    private void populateData() {
        for(IFragmentDataLoader loader : loaders) {
            loader.process(list, new IFragmentDataLoader.LoaderCallBack() {
                @Override
                public void onFinish() {
                    baseRecylerViewFragment.refreshList();
                }
            });
        }
    }
}
