package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class PropertiesToolTest {

    private final static String TEST_KEY = "someKey";
    private final static String TEST_KEY_GHOST = "ghostKey";
    private final static String TEST_VAL = "someVAL";

    private Properties backup;

    @BeforeEach
    void backup() {
        backup = new Properties();
        backup.putAll(System.getProperties());
        System.setProperty(TEST_KEY, TEST_VAL);
    }

    @AfterEach
    void restore() {
        System.setProperties(backup);
    }

    @Test
    @DisplayName("Should read value from system env by given key")
    public void shouldReadKey() {
        PropertiesTool pt = new PropertiesTool();
        assertThat(pt.readProperty(TEST_KEY), is(equalTo(TEST_VAL)));
    }

    @Test
    @DisplayName("Should return null from system env by given ghost key")
    public void shouldReadNullVal() {
        PropertiesTool pt = new PropertiesTool();
        assertThat(pt.readProperty(TEST_KEY_GHOST), is(nullValue()));
    }

}