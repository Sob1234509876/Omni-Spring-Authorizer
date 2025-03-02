package top.sob.auth.spring;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class AuthorizerServerImportSelector implements ImportSelector {
    @Override
    public @NotNull String @NotNull [] selectImports(@NotNull AnnotationMetadata importingClassMetadata) {
        return new String[]{"top.sob.auth.spring.controller.AuthorizerController"};
    }
}
