package ru.ingvord.test;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Igor Khokhriakov <igor.khokhriakov@hzg.de>
 * @since 4/18/17
 */
@ApplicationPath("test")
public class MyApplication extends Application {
    @Override
    public Set<Object> getSingletons() {
        Set<Object> result = new HashSet<>();

        result.add(new TestResource());

        return result;
    }
}
