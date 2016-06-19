package net.droidPla.service;

import net.droidPla.model.Robot;
import net.droidPla.persistence.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Mindaugas Vidmantas on 2016-06-19.
 * email: minvidm@gmail.com, minvidm@ktu.lt
 */


@Service
public class RobotService {
    private final RobotRepository robotRepository;
    @Autowired
    public RobotService(RobotRepository robotRepository) {
        super();
        this.robotRepository = robotRepository;
    }
    public Collection<Robot> getAllRobots() {
        return robotRepository.getAllRobots();
    }
    public Robot getRobot(int identifier) {
        return robotRepository.getRobot(identifier);
    }
    public int addRobot(Robot robot) {
        return robotRepository.addRobot(robot);
    }
    public void updateOrAddRobot(int identifier, Robot robot) {
        robotRepository.updateOrAddRobot(identifier, robot);
    }
    public Robot deleteRobot(int identifier) {
        return robotRepository.deleteRobot(identifier);
    }
    public Collection<Robot> getRobotsInterval(int lowerId, int upperId) {
        return robotRepository.getRobotsInterval(lowerId, upperId);
    }
}
