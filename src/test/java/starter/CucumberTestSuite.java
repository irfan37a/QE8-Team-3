package starter;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags="@GroupProject",
        plugin = {"pretty"},
        features = "classpath:features"
)
public class CucumberTestSuite {}

//sebelumnya :
//
//        package starter;
//
//
//        import io.cucumber.junit.CucumberOptions;
//        import net.serenitybdd.cucumber.CucumberWithSerenity;
//        import org.junit.runner.RunWith;
//
//@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(
//        <<<<<<< HEAD
//        tags="@GroupProject",
//        =======
//        tags="@CloseTask",
//        >>>>>>> f84b7a6cec5ab6cbdbe8c234d8a01eeaf89fac08
//        plugin = {"pretty"},
//        features = "classpath:features"
//)
//public class CucumberTestSuite {}
