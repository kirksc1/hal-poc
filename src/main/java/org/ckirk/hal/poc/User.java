package org.ckirk.hal.poc;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author Chris Kirk
 * @since 1.0
 */
public class User extends ResourceSupport {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
