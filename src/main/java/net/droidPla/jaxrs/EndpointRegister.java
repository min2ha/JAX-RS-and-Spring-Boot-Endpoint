package net.droidPla.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by Mindaugas Vidmantas on 2016-06-19.
 * email: minvidm@gmail.com, minvidm@ktu.lt
 */
@Component
public class EndpointRegister extends ResourceConfig {
    public EndpointRegister() {
        super();
        register(RobotResource.class);
    }
}