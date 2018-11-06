package com.mvpstudy.presenter;

import android.content.Context;

import com.mvpstudy.model.RecyclerViewModel;
import com.mvpstudy.view.ViewImp;

public class PresenterImp implements RecyclerViewModel.onFinish {
    Context context;
    ViewImp mViewModel;
    private final RecyclerViewModel mRecyclerViewModel;

    public PresenterImp(ViewImp viewModel) {
        mRecyclerViewModel = new RecyclerViewModel(this);
        mViewModel = viewModel;
    }
//    public PresenterImp(Context context, ViewImp viewModel) {
//        this.context = context;
//        mViewModel = viewModel;
//    }

    @Override
    public void OnFinishListener(String string) {
        mViewModel.showData(string);
    }
    public void getData(){
        mRecyclerViewModel.managerModel();
    }
}
