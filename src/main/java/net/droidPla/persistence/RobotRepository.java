package net.droidPla.persistence;

import net.droidPla.model.Robot;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Mindaugas Vidmantas on 2016-06-19.
 * email: minvidm@gmail.com, minvidm@ktu.lt
 */

@Repository
public class RobotRepository {

    private final Map<Integer, Robot> robots = new HashMap<>();
    private int robotSequence;
    public synchronized Collection<Robot> getAllRobots() {
        return Collections.unmodifiableCollection(robots.values());
    }
    public synchronized Robot getRobot(int identifier) {
        if (identifier == -1) {
            throw new UnsupportedOperationException("Identifier -1 is not supported.");
        }
        return robots.get(identifier);
    }
    public synchronized int addRobot(Robot robot) {
        robots.put(robotSequence, robot);
        return robotSequence++;
    }
    public synchronized void updateOrAddRobot(int identifier, Robot robot) {
        robots.put(identifier, robot);
    }
    public synchronized Robot deleteRobot(int identifier) {
        return robots.remove(identifier);
    }
    public synchronized Collection<Robot> getRobotsInterval(int lowerId, int upperId) {
//@formatter:off
        Collection<Robot> robotsInIdInterval = robots.entrySet().stream()
                .filter(p -> p.getKey() >= lowerId && p.getKey() <= upperId)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()))
                .values();
//@formatter:on
        return Collections.unmodifiableCollection(robotsInIdInterval);
    }


}
