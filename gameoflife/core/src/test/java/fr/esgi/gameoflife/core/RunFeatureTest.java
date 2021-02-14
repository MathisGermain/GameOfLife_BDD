package fr.esgi.gameoflife.core;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/fr/esgi/gameoflife/features"}
        ,glue = {"fr.esgi.gameoflife.core.features"}
        ,tags = "not @wip"
)
public class RunFeatureTest {
}
