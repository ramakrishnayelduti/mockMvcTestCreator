package arnzel.mockMvcTestGenerator.clazz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fixtures.controllers.MethodMappingController;
import fixtures.otherClasses.NonControllerClass;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;

class ClassParserTest {

  private ClassParser classParserUnderTest;

  @BeforeEach
  void setUp() {
    classParserUnderTest = new ClassParser();
  }

  @Test
  void classHasMethodWithAnnotation() {
    
    // Run the test
    final List<Method> result = classParserUnderTest.findAnnotatedMethods(
        MethodMappingController.class, RequestMapping.class);

    // Verify the results
    assertThat(result.size()).isEqualTo(1);
  }

  @Test
  void classHasNotMethodWithAnnotation() {

    // Run the test
    final List<Method> result = classParserUnderTest.findAnnotatedMethods(
        NonControllerClass.class, RequestMapping.class);

    // Verify the results
    assertThat(result.size()).isEqualTo(0);
  }
}
