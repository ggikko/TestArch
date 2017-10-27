package test.hello.testarch.repository;

import test.hello.testarch.TestItem;

/**
 * Created by ggikko on 2017. 10. 27..
 */

public class TestRepository {

    private TestItem testItem;

    public TestItem getTestItem() {
        return testItem;
    }

    public void setTestItem(TestItem testItem) {
        this.testItem = testItem;
    }
}
