package test.hello.testarch.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import test.hello.testarch.TestItem;
import test.hello.testarch.repository.TestRepository;

/**
 * Created by ggikko on 2017. 10. 27..
 */

public class TestViewModel extends ViewModel {

    public final ObservableField<TestItem> testItem = new ObservableField<TestItem>();

    private TestRepository testRepository;

    public void init() {
        testRepository = new TestRepository();
    }

    public ObservableField<TestItem> getTestItem() {
        return testItem;
    }

    public void setItem(String title){
        testRepository.setTestItem(new TestItem(title));
        testItem.set(testRepository.getTestItem());
    }
}
