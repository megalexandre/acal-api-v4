package br.com.acalappv4.application.web.components.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = TemporalReferenceConstraint.class)
@Documented
public @interface ValidReference {
  String message() default "{valid.reference}";
  Class<?>[] groups() default { };
  Class<? extends Payload>[] payload() default { };

}