package com.chinmay.movieapp.baserecyclerview;

import java.util.List;

/**
 * Created by ChiP on 4/2/2016.
 */
public interface IFragmentDataLoader {
    void process(List<RecyclerViewItemWrapper> list, LoaderCallBack callBack);

    interface LoaderCallBack {
        void onFinish();
    }
}
