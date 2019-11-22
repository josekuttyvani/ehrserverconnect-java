package com.synnefx.ehrserver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Josekutty
 * 20-11-2019
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        EhrServerConnectTest.class, CompositionTest.class, EhrQueryTest.class
})
public class AppTest {
}
