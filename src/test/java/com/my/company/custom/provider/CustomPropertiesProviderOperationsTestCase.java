package com.my.company.custom.provider;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;

public class CustomPropertiesProviderOperationsTestCase extends MuleArtifactFunctionalTestCase {

  /**
   * Specifies the mule config xml with the flows that are going to be executed in the tests, this file lives in the test
   * resources.
   */
  @Override
  protected String getConfigFile() {
    return "test-mule-config.xml";
  }

  @Inject
  @Named("testObject")
  private TestObject testObject;
  @Inject
  @Named("testObjectWithValueFromCache")
  private TestObject testObjectWithValueFromCache;

  @Test
  public void customPropertyProviderSuccessfullyConfigured() {
    assertThat(testObject.getValueFromProperty(), is("customPropertyAValue"));
    assertThat(testObjectWithValueFromCache.getValueFromProperty(), is("cachePropertyAValue"));
  }

}
