package parallel;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


@CucumberOptions(

        plugin = {"pretty",
                "parallel.ApplicationHooks",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"

        },
        monochrome = true,
        glue = {"parallel"},
        tags = "@Smoke",
        features = {"src/test/resources/parallel/ui"}

)


public class RunUI extends AbstractTestNGCucumberTests {


    /**
     * ParallelRun.class.getName()  -> or input desired String
     */
    @AfterSuite
    public synchronized void setReporterName() throws IOException {
        String fileName = RunUI.class.getName() + new Date().toString().replaceAll(" ", "_").replaceAll(":", "-");
        Path sourceHtml = Paths.get("test-output/spark/index.html");
        Path sourcePdf = Paths.get("test-output/pdf/index.pdf");
        Files.move(sourceHtml, sourceHtml.resolveSibling(fileName + ".html"));
        Files.move(sourcePdf, sourcePdf.resolveSibling(fileName + ".pdf"));
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}