package com.mvpstudy.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mvpstudy.R;
import com.mvpstudy.presenter.PresenterImp;

public class MainActivity extends AppCompatActivity implements ViewImp {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
//        RecyclerView recyclerView = findViewById(R.id.rv);
        mTextView = findViewById(R.id.tv);
        initData();

//        MyAdapter myAdapter = new MyAdapter();
//        recyclerView.setAdapter(myAdapter);

    }

    //这是单纯的用model来调用数据请求,而不是通过presenter调用model的getdata()的方法,仍然没有分离成mvp!
//    private void initData() {
//        //现在有一个问题, 不想再activity里面看到数据,只想调用显示?应该如何处理?用一个类来管理数据
//        ModelManager modelManager = new RecyclerViewModel(this);
//        //如果要请求RecyclerView的数据,就调用modelManager.managerModel();只要拿到modelManager对象即可  ,再深入一点的封装,把 modelManager对象也封装起来!
//        modelManager.managerModel();//调用完它以后,在他里面调用了onFinish方法,把string传出去
//    }
    //这是用presenter调用model的getdata()方法请求数据,实现了mvp的思想:model只生产数据,而presenter是数据的搬运工.所以要想清楚presenter和view层以及model层如何产生关联!!!
    private void initData() {
        //现在有一个问题, 不想再activity里面看到数据,只想调用显示?应该如何处理?用一个类来管理数据
//        ModelManager modelManager = new RecyclerViewModel(this);
        PresenterImp presenterImp = new PresenterImp(this);
        presenterImp.getData();//它里面实际的是调用的model的获取收的方法(modelManager.managerModel()//调用完它以后,在他里面调用了onFinish方法,把string传出去;)
        //如果要请求RecyclerView的数据,就调用modelManager.managerModel();只要拿到modelManager对象即可  ,再深入一点的封装,把 modelManager对象也封装起来!

        /* 小结
        *   1,model,view,presenter的初始化,在哪里?需要初始化哪些参数?
        *   2,记住一个关键点,数据的展示时view的责任,他不关心数据的制造;
        *                   数据的制造是model的责任,他不关心造出来以后在哪里用;
        *                   数据的传递是presenter的责任,他要拿到model产生的数据,去view那里填充;
        *                       因此,presenter需要拿到model的对象;
        *                            view需要拿到presenter的对象;
        *   3,把握最基本的类和接口,最基本的方法,每个人都要调用的方法,放到基类和接口里面
        *       让具体的实现子类去实现基类和接口的抽象方法
        *     定式: 1,创建ImpView接口或基类  ;   创建ImpModel接口或基类   创建ImpPresenter基类或接口
        *           2,创建各自的子类,实现基类或接口的抽象方法;
        *
        * */

    }

    @Override
    public void showData(String string) {
        mTextView.setText(string);
    }
}
