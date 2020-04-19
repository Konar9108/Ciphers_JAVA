package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

class SystemPropertyProxy implements IPropertyReader {
    private Map<String, Optional<String>> systemPropertiesCache = new HashMap<>();

    @Override
    public String readProperty(String propKey) {
        if (!hadInCache(propKey)) {
            readAndCacheValueFromEnvironment(propKey);
        }
        return propValueFromCache(propKey).orElseThrow();
    }

    private void readAndCacheValueFromEnvironment(String propKey) {
        final Properties env = System.getProperties();
        if (env.containsKey(propKey)) {
            systemPropertiesCache.put(propKey, Optional.of(env.getProperty(propKey)));
        } else {
            systemPropertiesCache.put(propKey, Optional.empty());
        }

    }

    private Optional<String> propValueFromCache(String propKey) {
        return systemPropertiesCache.get(propKey);
    }

    private boolean hadInCache(String propKey) {
        return systemPropertiesCache.containsKey(propKey);
    }
}
