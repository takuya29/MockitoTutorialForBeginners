package com.in28minutes.junit.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({StringHelperTest.class, StringHelperParametrizedTest.class, ArraysCompareTest.class})
public class AllTests {
}
