package org.studying.couchdb.couchdbdemo.annotations;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.couchbase.core.mapping.Expiry;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.data.couchbase.repository.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Scope
@Collection
@ScanConsistency
@Expiry
public @interface MyRepoAnnotation {
    @AliasFor(annotation = ScanConsistency.class, attribute = "query")
    QueryScanConsistency query() default QueryScanConsistency.NOT_BOUNDED;

    @AliasFor(annotation = Scope.class, attribute = "value")
    String scope() default "dev-test-scope";

    @AliasFor(annotation = Collection.class, attribute = "value")
    String collection() default "my-test-collection";

    @AliasFor(annotation = Expiry.class, attribute = "expiry")
    int expiry() default 0;

}
