package ru.ingvord.test;

import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Igor Khokhriakov <igor.khokhriakov@hzg.de>
 * @since 4/18/17
 */
@Path("/")
public class TestResource {
    private final AtomicLong counter = new AtomicLong(0L);

    @GET
    public void get(){
        System.out.println(counter.incrementAndGet());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            throw new WebApplicationException(e);
        }
    }
}
