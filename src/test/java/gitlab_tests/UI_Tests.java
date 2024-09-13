package gitlab_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.Selenide.$x;

public class UI_Tests {

    @BeforeAll
    public static void setUp(){
        Configuration.headless = true;
        Configuration.pageLoadStrategy = String.valueOf(PageLoadStrategy.NONE);
    }

    @BeforeEach
    public void openPage(){
        Selenide.open("https://www.google.com/");
    }

    private void assertAnswer(String value){
        $x("//textarea[@name='q']").sendKeys(value+" = ", Keys.ENTER);
        String answer = $x("//span[@id='cwos']").getText();
        Assertions.assertEquals("4", answer);
    }

    @Test
    public void calcPlusTest(){assertAnswer("0 + 4");}

    @Test
    public void calcPlusTest2(){assertAnswer("1 + 3");}

    @Test
    public void calcPlusTest3(){assertAnswer("6 - 2");}

    @Test
    public void calcPlusTest4(){assertAnswer("4 * 1");}

    @Test
    public void calcPlusTest5(){assertAnswer("8 / 2");}
}
