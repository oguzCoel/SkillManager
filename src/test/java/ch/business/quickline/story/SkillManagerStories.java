package ch.business.quickline.story;

import java.text.SimpleDateFormat;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.config.JpaConfig;

public class SkillManagerStories extends JUnitStories {

  @Override
  public Configuration configuration() {
    Configuration configuration = new MostUsefulConfiguration();
    configuration.useStoryReporterBuilder(
        new StoryReporterBuilder()
        .withCodeLocation(CodeLocations.codeLocationFromClass(getClass()))
        .withDefaultFormats()
        .withFormats(Format.HTML, Format.XML))
        .useParameterConverters(
          new ParameterConverters().addConverters(
            new ParameterConverters.DateConverter( 
              new SimpleDateFormat("yyyy-MM-dd") ) ) );
     return configuration;
  }

  @Override
  public InjectableStepsFactory stepsFactory() {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
    					JpaConfig.class);
    context.scan("ch.hfict.esta.stories");

      return new SpringStepsFactory(configuration(), context);
  }

  @Override
  protected List<String> storyPaths() {
    return new StoryFinder().findPaths(
      CodeLocations.codeLocationFromClass(getClass()), "**/*.story", "");
  }
}    
