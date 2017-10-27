package test.hello.testarch.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.hello.testarch.R;
import test.hello.testarch.databinding.FragmentTestBinding;
import test.hello.testarch.viewmodel.TestViewModel;

/**
 * Created by ggikko on 2017. 10. 27..
 */

public class TestFragment extends Fragment {

    TestViewModel testViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        FragmentTestBinding fragmentTestBinding = FragmentTestBinding.bind(rootView);
        testViewModel = ViewModelProviders.of(getActivity()).get(TestViewModel.class);
        fragmentTestBinding.setViewmodel(testViewModel);

        rootView.findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testViewModel.setItem(String.valueOf(Integer.parseInt(testViewModel.testItem.get().getTitle()) + 1));
            }
        });
        return rootView;
    }
}
