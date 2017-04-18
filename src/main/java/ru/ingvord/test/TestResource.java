package ru.ingvord.test;

import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Igor Khokhriakov <igor.khokhriakov@hzg.de>
 * @since 4/18/17
 */
@Path("/")
public class TestResource {
    private final AtomicLong counter = new AtomicLong(0L);

    private final ExecutorService singleThread = Executors.newSingleThreadExecutor();

    @GET
    public void get(final @Suspended AsyncResponse asyncResponse){
        System.out.println(counter.incrementAndGet());
        singleThread.submit(() -> {
            try {
                Thread.sleep(3000L);
                asyncResponse.cancel();
            } catch (InterruptedException e) {
                asyncResponse.resume(e);
            }
        });
    }
}
