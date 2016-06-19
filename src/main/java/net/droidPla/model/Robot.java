package net.droidPla.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Mindaugas Vidmantas on 2016-06-19.
 * email: minvidm@gmail.com, minvidm@ktu.lt
 */

@Data
@EqualsAndHashCode(of = { "email" })
public class Robot {
    private String name;
    //private String model;
    private String email;
}