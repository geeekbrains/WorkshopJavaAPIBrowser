import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClassTest {

    @Test
    public void testBrowser() {
        Browser.visit("https://openai.com");
        Browser.visit("https://github.com");
        assertEquals("Похоже что ошибка в методе 'visit()'","https://github.com", Browser.current());
        Browser.visit("https://google.com");
        assertEquals("Похоже что ошибка в методе 'visit()'", "https://google.com", Browser.current());
        Browser.back();
        assertEquals("Похоже что ошибка в методе 'back()'","https://github.com", Browser.current());
        Browser.forward();
        assertEquals("Похоже что ошибка в методе 'forward()'","https://google.com", Browser.current());

        List<String> visited = Browser.listAllVisited();
        List<String> expectedVisited = Arrays.asList("https://openai.com", "https://github.com", "https://google.com");
        assertEquals("Похоже что ошибка в методе 'listAllVisited()'",expectedVisited, visited);

        assertEquals("Похоже что ошибка в методе 'countVisits()'",1, Browser.countVisits("https://openai.com"));
        assertEquals("Похоже что ошибка в методе 'countVisits()'",1, Browser.countVisits("https://github.com"));
        assertEquals("Похоже что ошибка в методе 'countVisits()'",1, Browser.countVisits("https://google.com"));
        assertEquals("Похоже что ошибка в методе 'countVisits()'",0, Browser.countVisits("https://missing.com"));

        Browser.visit("https://openai.com");
        assertEquals("Похоже что ошибка в методе 'countVisits()'",2, Browser.countVisits("https://openai.com"));
    }
}

