package com.plivo.framework.commons;

import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class AssertionHelper {
    private final Assertion hardAssert = new Assertion();
    private final SoftAssert softAssert = new SoftAssert();

    public Assertion getHardAssert() {
        return hardAssert;
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }
}
