package com.comp62542.backend;

import com.comp62542.backend.patterns.iterators.Iterator;
import com.comp62542.backend.patterns.iterators.UnregisteredStudentsRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = BackendApplication.class)
public class PatternTest {

    @Autowired
    private UnregisteredStudentsRespository unregisteredStudentsRespository;

    @Test
    public void testIterator() {
        Iterator iter = unregisteredStudentsRespository.getIterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
