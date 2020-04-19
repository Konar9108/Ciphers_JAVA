package utils;

import java.util.NoSuchElementException;

public class PropertiesTool implements IPropertyReader {
    //can read from, this order also show prioritize
    // - system environment
    // - property file

    private final SystemPropertyProxy systemProps;

    public PropertiesTool() {
        systemProps = new SystemPropertyProxy();
    }

    @Override
    public String readProperty(String propKey) {
        String property;
        try {
            property = systemProps.readProperty(propKey);
        } catch (NoSuchElementException ex) {
            property = null;
        }
        return property;
    }

}
