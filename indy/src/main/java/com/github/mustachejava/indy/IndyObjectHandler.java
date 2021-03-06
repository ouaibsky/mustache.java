package com.github.mustachejava.indy;

import com.github.mustachejava.codegen.CodegenObjectHandler;
import com.github.mustachejava.codegen.CodegenReflectionWrapper;
import com.github.mustachejava.util.Wrapper;

/**
 * Creates custom classes instead of using reflection for handling objects. Leverages
 * the ReflectionObjectHandler to create the original wrappers and converts them to
 * new versions.
 */
public class IndyObjectHandler extends CodegenObjectHandler {

  @Override
  public Wrapper find(String name, Object[] scopes) {
    Wrapper wrapper = super.find(name, scopes);
    if (wrapper instanceof CodegenReflectionWrapper) {
      CodegenReflectionWrapper rw = (CodegenReflectionWrapper) wrapper;
      return IndyWrapper.create(rw);
    } else {
      return wrapper;
    }
  }
}
