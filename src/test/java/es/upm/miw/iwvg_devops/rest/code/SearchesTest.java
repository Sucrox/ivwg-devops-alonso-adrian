package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {

    @Test
    void testFindUserNameBySomeImproperFraction(){
        assertEquals(List.of("Ana"), new Searches().findUserNameBySomeImproperFraction()
              .collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdBySomeProperFraction(){
        assertEquals(List.of("2","3","5"), new Searches().findUserIdBySomeProperFraction()
                .collect(Collectors.toList()));
    }
}
