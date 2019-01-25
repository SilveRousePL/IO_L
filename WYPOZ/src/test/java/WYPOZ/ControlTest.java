package WYPOZ;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@Categories.SuiteClasses({TFacadeTest.class,TFactoryTest.class, FilmTest.class, KasetaTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(Test_Control.class)
public class ControlTest { }