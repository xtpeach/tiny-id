package com.xtpeach.tiny.id;

import com.xtpeach.tiny.id.utils.TinyId;
import org.junit.Test;

/**
 * @author xtpeach
 */

public class ClientTest {

    @Test
    public void testNextId() {
        for (int i = 0; i < 100; i++) {
            Long id = TinyId.nextId("test");
            System.out.println("current id is: " + id);
        }
    }
}
