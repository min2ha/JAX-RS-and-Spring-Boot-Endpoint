package net.droidPla.jaxrs;

import net.droidPla.UrlConstants;
import net.droidPla.model.Robot;
import net.droidPla.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

/**
 * Created by Mindaugas Vidmantas on 2016-06-19.
 * email: minvidm@gmail.com, minvidm@ktu.lt
 */


@Path(UrlConstants.ROBOTS_URL)
@Component
public class RobotResource {
    private final RobotService robotService;

    @Autowired
    public RobotResource(RobotService robotService) {
        super();
        this.robotService = robotService;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Robot> getRobots() {
        return robotService.getAllRobots();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Robot getRobot(@PathParam("id") int identifier) {
        try {
            return robotService.getRobot(identifier);
        } catch (UnsupportedOperationException uoe) {
            throw new WebApplicationException(uoe, Response.Status.BAD_REQUEST);
        }
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postRobot(Robot Robot) throws URISyntaxException {
        int identifier = robotService.addRobot(Robot);
        URI uri = new URI(UrlConstants.ROBOTS_URL + "/" + identifier);
        return Response.created(uri).build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putRobot(@PathParam("id") int identifier, Robot Robot)
            throws URISyntaxException {
        robotService.updateOrAddRobot(identifier, Robot);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteRobot(@PathParam("id") int identifier) {
        robotService.deleteRobot(identifier);
        return Response.ok().build();
    }
}
